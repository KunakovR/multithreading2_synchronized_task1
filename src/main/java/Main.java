public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int threads = 3;
        final int time = 12000;
        final Dealership dealership = new Dealership();

        new Thread(null, dealership::acceptToyota, "Производитель Toyota").start();

        for (int i = 1; i <= dealership.countCars/threads; i++){
            for (int j = 1; j <= threads; j++) {
                new Thread(null, dealership::sellToyota, "Покупатель " + (j)).start();
            }
            Thread.sleep(time);
        }
        for (int l = 1; l <= dealership.countCars%threads; l++) {
            new Thread(null, dealership::sellToyota, "Покупатель " + (l)).start();
        }


    }
}
