public class Manufacturer {

    private Shop shop;
    final int CREATE = 3000;
    final int TIME = 2500;

    public Manufacturer(Shop shop) {
        this.shop = shop;
    }

    public synchronized void createCar() {
        try {
            Thread.sleep(CREATE);
            shop.getCars().add(new Car());
            System.out.println("Производитель Toyota выпустил 1 авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car buyCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shop.getCars().remove(0);
    }
}
