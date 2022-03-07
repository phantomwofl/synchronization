import java.util.ArrayList;
import java.util.List;

public class Shop {
    final private int SHOP_LIMIT = 10;
    final int BUY_TIME = 1000;
    final int AMOUNT = 3;
    Manufacturer manufacturer = new Manufacturer(this);
    Client client = new Client(this);
    List<Car> cars = new ArrayList<>();

    public void sellCar() {
        try {
            for (int i = 1; i <= AMOUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                synchronized (cars) {
                    while (cars.isEmpty()) {
                        System.out.println("Машин нет");
                        cars.wait();
                    }
                    client.buyCar();
                    Thread.sleep(BUY_TIME);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void acceptCar() {
        for (int i = 0; i < SHOP_LIMIT; i++) {
            synchronized (cars) {
                manufacturer.createCar();
                if (!getCars().isEmpty()) {
                    cars.notifyAll();
                }
            }
        }
    }

    List<Car> getCars() {
        return cars;
    }
}