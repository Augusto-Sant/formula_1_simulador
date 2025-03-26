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
            if (this.pista.safetyCarRodando){
                this.velocidade = 60;
            } else {
                this.velocidade = gerarVelocidade();
            }

            this.distanciaPercorrida += this.velocidade;
            if (this.distanciaPercorrida >= pista.distanciaTotal){
                System.out.println("> "+ identificacaoCarro + " finalizou corrida");
                break;
            }

            if (random.nextInt(0,1) == 0) {
                this.vezesSemPassarBox = 0;
            }

            if (this.vezesSemPassarBox > 2) {
                System.out.println("> " + identificacaoCarro + " quebrou!");
                // avisar pista que safety car vai rodar
                pista.notify();
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
        return this.random.nextInt(100,360);
    }
}
