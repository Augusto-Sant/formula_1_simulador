import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pista implements Runnable {
    boolean safetyCarRodando = false;
    int distanciaTotal = 10000;
    List<String> ordemChegada = Collections.synchronizedList(new ArrayList<>());
    List<String> ordemQuebrada = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {
                    wait();
                    safetyCarRodando = true;
                    System.out.println("Safety car rodando");
                    Thread.sleep(5000);
                    safetyCarRodando = false;
                    System.out.println("Safety car saiu da pista");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void ativarSafetyCar() {
        notify();
    }

    public void adicionarCarroFinalizado(String identificacaoCarro) {
        ordemChegada.add(identificacaoCarro);
    }

    public void exibirOrdemChegada() {
        System.out.println("\n--- Ordem de chegada ---");
        for (int i = 0; i < ordemChegada.size(); i++) {
            System.out.println((i + 1) + "º lugar: " + ordemChegada.get(i));
        }
    }

    public void adicionarCarroQuebrado(String identificacaoCarro) {
        ordemQuebrada.add(identificacaoCarro);
    }

    public void exibirOrdemQuebrada() {
        System.out.println("\n--- Ordem de quebrada ---");
        for (int i = 0; i < ordemQuebrada.size(); i++) {
            System.out.println((i + 1) + "º a quebrar: " + ordemQuebrada.get(i));
        }
        System.out.println(ordemQuebrada);
    }
}