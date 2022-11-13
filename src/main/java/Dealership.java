import java.util.ArrayList;
import java.util.List;

public class Dealership {

    final int timeSell = 1000;
    final int timeReceive = 3000;
    final int countCars = 10;
    List<Toyota> cars = new ArrayList<>(15);

    public synchronized Toyota sellToyota(){
        try {
            System.out.println(Thread.currentThread().getName() + "  зашел в автосалон");
            while (cars.size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(timeSell);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        return cars.remove(0);
    }

    public void acceptToyota(){
        for (int i = 0; i < countCars; i++) {
            try {
                Thread.sleep(timeReceive);
                cars.add(new Toyota());
                System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
                synchronized (this) {
                    notify();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
