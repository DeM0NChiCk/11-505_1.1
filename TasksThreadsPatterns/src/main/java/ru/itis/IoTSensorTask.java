package ru.itis;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
ЗАДАЧА 2: Прикладная IO (Сенсоры умного дома и Producer-Consumer)
ТЗ:
Нам пришел гигантский дамп CSV-файла с показаниями температурных датчиков (формат id_датчика,температура). Файл огромный, считывать его в список List<String> целиком нельзя — закончится оперативная память (OOM).
Создай класс SensorQueue на основе паттерна Производитель-Потребитель. Используй wait() и notifyAll().
Один поток-Producer читает CSV построчно и кладет в очередь.
Потоки-Consumers забирают строки, парсят их и, если температура > 50.0 (аномалия), добавляют в AtomicLong. Парсинг строки и валидация — затратны.
Добавь маркер окончания "EOF".
 */

public class IoTSensorTask {
    private static final String FILE_NAME = "sensor_data.csv";
    private static final String POISON_PILL = "EOF";

    // Тяжелый анализ показаний (эмуляция сложных правил)
    private boolean isAnomaly(String csvLine) {
        String[] parts = csvLine.split(",");
        double temp = Double.parseDouble(parts[1]);
        double result = temp;
        for (int i = 0; i < 200; i++) {
            result = Math.sin(result) + Math.cos(result);
        }
        return temp > 50.0 && result != -999.0;
    }

    // ГЕНЕРАТОР ДАННЫХ
    public void generateCsv(int linesCount) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 1; i <= linesCount; i++) {
                if (i % 50 == 0) bw.write("sensor_" + i + ",85.5\n"); // Аномалия
                else bw.write("sensor_" + i + ",22.4\n");             // Норма
            }
        }
    }

    static class SensorQueue {
        private final Queue<String> queue = new LinkedList<>();
        private final int limit = 500;

        public synchronized void put(String s) throws InterruptedException {
            while (queue.size() == limit) wait();
            queue.add(s);
            notifyAll();
        }

        public synchronized String take() throws InterruptedException {
            while (queue.isEmpty()) wait();
            String s = queue.poll();
            notifyAll();
            return s;
        }
    }

    public long analyzeSingleThread() throws IOException {
        long count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isAnomaly(line)) count++;
            }
        }
        return count;
    }

    public long analyzeMultiThread(int consumerCount) throws Exception {
        SensorQueue queue = new SensorQueue();
        AtomicLong anomaliesCount = new AtomicLong(0);

        Thread producer = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = br.readLine()) != null) queue.put(line);
                queue.put(POISON_PILL);
            } catch (Exception e) { throw new RuntimeException(e); }
        });

        Thread[] consumers = new Thread[consumerCount];
        for (int i = 0; i < consumerCount; i++) {
            consumers[i] = new Thread(() -> {
                try {
                    while (true) {
                        String line = queue.take();
                        if (POISON_PILL.equals(line)) {
                            queue.put(POISON_PILL);
                            break;
                        }
                        if (isAnomaly(line)) anomaliesCount.incrementAndGet();
                    }
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
            consumers[i].start();
        }

        producer.start();
        producer.join();
        for (Thread c : consumers) c.join();

        return anomaliesCount.get();

    }

    // АВТОТЕСТ
    @Test
    void testIoTProcessing() throws Exception {
        int totalLines = 10_500_000;
        generateCsv(totalLines);
        int expectedAnomalies = totalLines / 50;

        long startSingle = System.currentTimeMillis();
        long singleResult = analyzeSingleThread();
        long timeSingle = System.currentTimeMillis() - startSingle;

        long startMulti = System.currentTimeMillis();
        long multiResult = analyzeMultiThread(25);
        long timeMulti = System.currentTimeMillis() - startMulti;

        System.out.println("IoT Single: " + timeSingle + " ms, Multi: " + timeMulti + " ms");
        new File(FILE_NAME).delete();

        assertEquals(expectedAnomalies, singleResult, "Однопоточный алгоритм неверен!");
        assertEquals(singleResult, multiResult, "Гонка данных в многопоточке или утеряны строки!");
        assertTrue(timeMulti < timeSingle, "Многопоточный парсинг должен быть быстрее!");
    }
}
