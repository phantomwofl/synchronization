public class Client {

    private Shop shop;
    final int TIME = 1000;

    public Client(Shop shop) {
        this.shop = shop;
    }

//    public synchronized Car buyCar() {
//        try {
//            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
//            while (shop.getCars().size() == 0) {
//                System.out.println("Машин нет");
//                wait();
//            }
//            Thread.sleep(TIME);
//            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return shop.getCars().remove(0);
//    }
}
