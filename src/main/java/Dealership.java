import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private final int countCars = 10;
    private final Seller seller = new Seller(this);
    private final List<Toyota> cars = new ArrayList<>();
    private final List<Toyota> soldCars = new ArrayList<>();

    public List<Toyota> getCars() {
        return cars;
    }

    public List<Toyota> getSoldCars() {
        return soldCars;
    }

    public void sellToyota() {
        seller.sellToyota();
    }

    public void acceptToyota() {
        seller.receiveToyota();
    }

    public int getCountCars() {
        return countCars;
    }


}
