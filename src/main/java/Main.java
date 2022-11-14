public class Main {

    private static final int time = 5000;

    public static void main(String[] args) throws InterruptedException {

        final Dealership dealership = new Dealership();

        new Thread(null, dealership::sellToyota, "Покупатель1").start();
        new Thread(null, dealership::sellToyota, "Покупатель2").start();
        new Thread(null, dealership::sellToyota, "Покупатель3").start();
        new Thread(null, dealership::acceptToyota, "Производитель Toyota").start();
        Thread.sleep(time);
        for (int i = 1; i < 8; i++) {
            new Thread(null, dealership::sellToyota, "Покупатель " + (i)).start();
        }
    }
}
