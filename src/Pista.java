public class Pista implements Runnable {
    boolean safetyCarRodando = false;
    int distanciaTotal = 10000;

    @Override
    public void run() {
        while (true) {
            try {
                wait();
                safetyCarRodando = true;
                Thread.sleep(5000);
                safetyCarRodando = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
