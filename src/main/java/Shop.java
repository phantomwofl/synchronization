import java.util.ArrayList;
import java.util.List;

public class Shop {
    final private int SHOP_LIMIT = 10;
    final int BUY_TIME = 1000;
    final int AMOUNT = 3;
    Manufacturer manufacturer = new Manufacturer(this);
    Client client = new Client(this);
    List<Car> cars = new ArrayList<>();

    public synchronized void sellCar () {
        try {
            for (int i = 1; i <= AMOUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                while (client.getShop().getCars().isEmpty()) {
                    System.out.println("Машин нет");
                    wait();
                }
                client.buyCar();
                Thread.sleep(BUY_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void acceptCar () {
        while (getCars().size() < SHOP_LIMIT) {
            manufacturer.createCar();
            notifyAll();
        }
    }

    List<Car> getCars() {
        return cars;
    }
}
