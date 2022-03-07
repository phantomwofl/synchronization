public class Main {
    public static void main(String[] args) {

        final Shop shop = new Shop();



        ThreadGroup group = new ThreadGroup("group");

        new Thread(group, shop::sellCar, "Покупатель 1").start();

        new Thread(group, shop::sellCar, "Покупатель 2").start();

        new Thread(group, shop::sellCar, "Покупатель 3").start();


        new Thread(null, shop::acceptCar, "Продавец").start();

    }
}