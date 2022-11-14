public class Seller {

    private final int timeSell = 3000;
    private final int timeReceive = 1000;
    private final Dealership dealership;

    public Seller(Dealership dealership) {
        this.dealership = dealership;
    }

    public synchronized void sellToyota() {
        try {
            System.out.println(Thread.currentThread().getName() + "  зашел в автосалон");
            System.out.println("Машин нет");
            while (dealership.getCars().size() == 0) {
                wait();
            }
            Thread.sleep(timeSell);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        dealership.getCars().remove(0);
        dealership.getSoldCars().add(new Toyota());
        notifyAll();
    }

    public synchronized void receiveToyota() {
        while (dealership.getSoldCars().size() < dealership.getCountCars()) {
            try {
                Thread.sleep(timeReceive);
                dealership.getCars().add(new Toyota());
                System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
                notifyAll();
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}



