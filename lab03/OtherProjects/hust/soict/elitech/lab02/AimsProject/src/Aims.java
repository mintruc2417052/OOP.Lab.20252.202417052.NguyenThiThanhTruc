public class Aims {
    public static void main(String[] args) {
       Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3); // B14
        
        System.out.println("--- Cart before removal ---");
        anOrder.printCart();
        
         System.out.println("--- Remove 'Star Wars' ---"); // test remove
        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("--- Cart after removal ---");
        anOrder.printCart();
    }
}
