public class Main {
    public static void main(String[] args) {
        Pista pista = new Pista();

        Carro carro1 = new Carro("carrinho-1", pista);
        new Thread(carro1).start();
        Carro carro2 = new Carro("carrinho-2", pista);
        new Thread(carro2).start();
    }
}