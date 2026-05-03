package ru.itis;

import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CryptoMinerTask {

    // Имитация тяжелого криптографического алгоритма
    public static boolean isValidNonce(long nonce) {
        long hash = nonce;
        // Нагружаем процессор битовыми сдвигами (Xorshift)
        for (int i = 0; i < 200; i++) {
            hash ^= (hash << 21);
            hash ^= (hash >>> 14);
            hash ^= (hash << 4);
        }
        // Условие "валидности" блока (примерно 1 из 1000)
        return Math.abs(hash % 1000) == 0;
    }

    public long mineSingleThread(long maxNonce) {
        long count = 0;
        for (long i = 1; i <= maxNonce; i++) {
            if (isValidNonce(i)) count++;
        }
        return count;
    }

    public long mineMultiThread(long maxNonce, int threadsCount) throws InterruptedException {
        AtomicLong totalFound = new AtomicLong(0);
        Thread[] threads = new Thread[threadsCount];
        long chunk = maxNonce / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            final long start = i * chunk + 1;
            final long end = (i == threadsCount - 1) ? maxNonce : (i + 1) * chunk;

            threads[i] = new Thread(() -> {
                long localCount = 0;
                for (long j = start; j <= end; j++) {
                    if (isValidNonce(j)) localCount++;
                }
                totalFound.addAndGet(localCount);
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        return totalFound.get();
    }

    @Test
    void testMiningPerformance() throws InterruptedException {
        long maxNonce = 100_000_000;
        int threads = 20;

        long startSingle = System.currentTimeMillis();
        long singleResult = mineSingleThread(maxNonce);
        long timeSingle = System.currentTimeMillis() - startSingle;

        long startMulti = System.currentTimeMillis();
        long multiResult = mineMultiThread(maxNonce, threads);
        long timeMulti = System.currentTimeMillis() - startMulti;

        System.out.println("Miner Single: " + timeSingle + " ms, Multi: " + timeMulti + " ms");

        assertEquals(singleResult, multiResult, "Количество валидных блоков не совпадает!");
        assertTrue(multiResult > 0, "Не найдено ни одного блока, алгоритм сломан!");
        assertTrue(timeMulti < timeSingle, "Многопоточный майнер должен работать быстрее!");
    }
}