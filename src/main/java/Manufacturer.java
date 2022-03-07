public class Manufacturer {

    private Shop shop;
    final private int CREATE_TIME = 3000;

    public Manufacturer(Shop shop) {
        this.shop = shop;
    }

    public void createCar() {
        try {
            Thread.sleep(CREATE_TIME);
            shop.getCars().add(new Car());
            System.out.println("Производитель Toyota выпустил 1 авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
