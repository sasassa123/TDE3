import java.util.concurrent.*;

public class CorridaSemControle {

    static int count = 0;

    public static void main(String[] args) throws Exception {
        final int T = 8;
        final int M = 250_000;

        ExecutorService pool = Executors.newFixedThreadPool(T);

        Runnable r = () -> {
            for (int i = 0; i < M; i++) {

                count++;
            }
        };

        long t0 = System.nanoTime();

        for (int i = 0; i < T; i++) {
            pool.submit(r);
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        long t1 = System.nanoTime();

        long esperado = (long) T * M;
        long obtido = count;
        double tempoSeg = (t1 - t0) / 1e9;

        System.out.printf("SEM CONTROLE -> Esperado=%d, Obtido=%d, Tempo=%.3fs%n",
                esperado, obtido, tempoSeg);
    }
}
