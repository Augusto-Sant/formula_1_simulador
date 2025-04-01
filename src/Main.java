public class Main {
    public static void main(String[] args) {
        Pista pista = new Pista();

        new Thread(pista).start();

        Carro carro1 = new Carro("carrinho-1", pista);
        Thread thread1 = new Thread(carro1);
        thread1.start();

        Carro carro2 = new Carro("carrinho-2", pista);
        Thread thread2 = new Thread(carro2);
        thread2.start();

        Carro carro3 = new Carro("carrinho-3", pista);
        Thread thread3 = new Thread(carro3);
        thread3.start();

        Carro carro4 = new Carro("carrinho-4", pista);
        Thread thread4 = new Thread(carro4);
        thread4.start();

        Carro carro5 = new Carro("carrinho-5", pista);
        Thread thread5 = new Thread(carro5);
        thread5.start();

        Carro carro6 = new Carro("carrinho-6", pista);
        Thread thread6 = new Thread(carro6);
        thread6.start();

        Carro carro7 = new Carro("carrinho-7", pista);
        Thread thread7 = new Thread(carro7);
        thread7.start();

        Carro carro8 = new Carro("carrinho-8", pista);
        Thread thread8 = new Thread(carro8);
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        pista.exibirOrdemChegada();
        pista.exibirOrdemQuebrada();
    }
}