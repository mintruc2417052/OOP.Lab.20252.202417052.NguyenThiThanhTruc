public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) System.out.println("The cart is almost full");
        } else System.out.println("The cart is full");
    }
    // 14.1.1: them bang mang
    /*
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
       for (DigitalVideoDisc disc : dvdList) {
           if (qtyOrdered < MAX_NUMBERS_ORDERED) {
               itemsOrdered[qtyOrdered++] = disc;
               System.out.println("The disc \"" + disc.getTitle() + "\" has been added");
           } else {
               System.out.println("The cart is full. Cannot add: " + disc.getTitle());
               break;
           }
       }
    }
    */

    // 14.1.2: them voi so luong tuy y --> su dung Varargs, no se tu dong tao mang va truyen vao ham, code o main se sach hon
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            addDigitalVideoDisc(disc); // Gọi lại hàm thêm 1 đĩa đã có để tái sử dụng code
        }
    }

    // 14.2: them 2 dia cung luc
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) itemsOrdered[j] = itemsOrdered[j+1]; // xóa 1 ptu cần đẩy hết các ptu phía sau lên
                itemsOrdered[--qtyOrdered] = null; // remove đc rồi
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("Not found");
    }
    

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) total += itemsOrdered[i].getCost();
        return total;
    }

    public void printCart() {
    for (int i = 0; i < qtyOrdered; i++) {
        System.out.printf("%-5d %-20s %-10.2f $%n", (i + 1), itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
    }
    System.out.printf("      %-20s %-10.2f $%n", "Total Cost", totalCost());
}
}

