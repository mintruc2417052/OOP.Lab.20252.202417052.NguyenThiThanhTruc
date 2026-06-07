package hust.soict.elitech.test.screen.customer.cart;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.exception.DuplicateItemException;
import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.screen.customer.controller.CartController;
import hust.soict.elitech.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import hust.soict.elitech.aims.exception.LimitExceededException;

public class TestCartScreen extends Application {
    private static Cart cart;
    private static Store store;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Đường dẫn đến file FXML của CartScreen
        final String CART_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

        // Tạo instance của CartController và truyền store, cart vào constructor
        CartController cartController = new CartController(store, cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Hàm main để khởi chạy ứng dụng JavaFX
    public static void main(String[] args) throws LimitExceededException, DuplicateItemException {
        cart = new Cart();

        // --- THÊM DỮ LIỆU VÀO STORE ---

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "Spirited Away (2001)", "Hayao Miyazaki", 125, 5.0f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Drama", "The Shawshank Redemption (1994)", "Frank Darabont", 142, 4.9f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Crime", "The Godfather (1972)", "Francis Ford Coppola", 175, 4.8f);
        cart.addMedia(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Action", "John Wick (2014)", "Chad Stahelski", 101, 4.4f);
        cart.addMedia(dvd4);

        // --- KẾT THÚC THÊM DỮ LIỆU ---
        launch(args);
    }
}