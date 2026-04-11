package tests;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestReport implements Serializable {
    public List<TestResult> results = new ArrayList<>();

    public void printReport() {
        System.out.println("\n %%%% ОТЧЁТ О ТЕСТИРОВНИИ %%%%");
        results.forEach(System.out::println);
    }

    public static TestReport loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            TestReport report = (TestReport) ois.readObject();
            System.out.println("[!] Отчёт загружен из " + filename);
            return report;
        } catch (Exception e) {
            System.err.println("[!] Ошибка при загрузке отчёта: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void printDetailedReport() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("               📋 ОТЧЁТ О ТЕСТИРОВАНИИ");
        System.out.println("=".repeat(60));

        results.forEach(r -> {
            String status = r.passed ? "✅ OK" : "❌ FAIL";
            System.out.printf("%-6s | %-15s | Аргументы: %-30s | Ошибка: %s%n",
                    status, r.method, r.args, r.passed ? "—" : r.errorMsg);
        });

        printStatistics();
    }

    private void printStatistics() {
        long total = results.size();
        long passed = results.stream().filter(r -> r.passed).count();
        long failed = total - passed;
        double rate = total == 0 ? 0 : (double) passed / total * 100;
        long totalTime = results.stream().mapToLong(r -> r.timeMs).sum();
        long maxTime = results.stream().mapToLong(r -> r.timeMs).max().orElse(0);

        System.out.println("\n📊 СТАТИСТИКА:");
        System.out.printf("🔹 Всего тестов: %d%n", total);
        System.out.printf("✅ Пройдено: %d | ❌ Провалено: %d | 📈 Успешность: %.1f%%%n", passed, failed, rate);
        System.out.printf("⏱️  Время: общее %d мс | максимум %d мс%n", totalTime, maxTime);
        System.out.println("=".repeat(60));
    }

    // Только проваленные тесты
    public void printFailedOnly() {
        System.out.println("\n❌ ПРОВАЛЕННЫЕ ТЕСТЫ:");
        results.stream()
                .filter(r -> !r.passed)
                .forEach(System.out::println);
    }

    // Медленные тесты (больше заданного порога в мс)
    public void printSlowTests(long thresholdMs) {
        System.out.printf("\n🐌 МЕДЛЕННЫЕ ТЕСТЫ (> %d мс):%n", thresholdMs);
        results.stream()
                .filter(r -> r.timeMs > thresholdMs)
                .sorted((a, b) -> Long.compare(b.timeMs, a.timeMs)) // по убыванию
                .forEach(r -> System.out.printf("[%d мс] %s(%s)%n", r.timeMs, r.method, r.args));
    }

    // Группировка по методу
    public void printGroupedByMethod() {
        System.out.println("\n📁 РЕЗУЛЬТАТЫ ПО МЕТОДАМ:");
        results.stream()
                .collect(java.util.stream.Collectors.groupingBy(r -> r.method))
                .forEach((method, list) -> {
                    long pass = list.stream().filter(r -> r.passed).count();
                    System.out.printf("🔸 %s: %d/%d пройдено%n", method, pass, list.size());
                });
    }

    // Экспорт в CSV (откроется в Excel)
    public void exportToCSV(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("Метод;Аргументы;Статус;Ошибка;Время(мс)");
            for (TestResult r : results) {
                pw.printf("%s;%s;%s;%s;%d%n",
                        r.method, r.args, r.passed ? "PASS" : "FAIL", r.errorMsg, r.timeMs);
            }
            System.out.println("[!] CSV отчёт сохранён: " + filename);
        } catch (IOException e) {
            System.err.println("[!] Ошибка экспорта CSV: " + e.getMessage());
        }
    }

    // Экспорт в JSON (ручная сериализация без библиотек)
    public void exportToJSON(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("[");
            for (int i = 0; i < results.size(); i++) {
                TestResult r = results.get(i);
                pw.printf("  {\"method\":\"%s\", \"args\":\"%s\", \"passed\":%b, \"error\":\"%s\", \"timeMs\":%d}%s%n",
                        r.method, r.args, r.passed, r.errorMsg.replace("\"", "\\\""), r.timeMs,
                        (i < results.size() - 1) ? "," : "");
            }
            pw.println("]");
            System.out.println("[!] JSON отчёт сохранён: " + filename);
        } catch (IOException e) {
            System.err.println("[!] Ошибка экспорта JSON: " + e.getMessage());
        }
    }
}
