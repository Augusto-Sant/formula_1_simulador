import java.util.Random;

import static java.lang.Thread.sleep;

public class Carro implements Runnable{
    String identificacaoCarro;
    int velocidade = 0;
    boolean terminouCorrida = false;
    int vezesSemPassarBox = 0;
    int distanciaPercorrida = 0;
    Random random = new Random();
    // status global pista
    Pista pista;


    public Carro(String identificacaoCarro, Pista pista) {
        this.identificacaoCarro = identificacaoCarro;
        this.pista = pista;
    }

    @Override
    public void run() {
        while (!terminouCorrida) {

            if (random.nextInt(0,3) == 0) {
                velocidade = random.nextInt(40, 120);
                vezesSemPassarBox = 0;
                System.out.println(identificacaoCarro + " passou no pitstop");
                if (velocidade > 100) {
                    System.out.println(identificacaoCarro + " ultrapassou o limite de velocidade no pitstop! Penalidade aplicada.");
                    try {
                        sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (pista.safetyCarRodando){
                    velocidade = 60;
                } else {
                    velocidade = gerarVelocidade();
                }
                System.out.println("> "+ identificacaoCarro + " km/h="+ velocidade);
                vezesSemPassarBox++;
            }

            distanciaPercorrida += velocidade;
            if (distanciaPercorrida >= pista.distanciaTotal){
                System.out.println(identificacaoCarro + " finalizou corrida");
                pista.adicionarCarroFinalizado(identificacaoCarro);
                break;
            }

            if (vezesSemPassarBox > 9) {
                System.out.println("> " + identificacaoCarro + " quebrou!");
                pista.adicionarCarroQuebrado(identificacaoCarro);

                // avisar pista que safety car vai rodar
                synchronized (pista) {
                    pista.ativarSafetyCar();
                }
                break;
            }

            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //correr (mudar velocidade)
        //parar por problemas tecnicos
        //passar no box
        //ultrapassou limite de velocidade do box
        //limite de velocidade por safety car
    }

    public int gerarVelocidade() {
        return random.nextInt(100,360);
    }
}
