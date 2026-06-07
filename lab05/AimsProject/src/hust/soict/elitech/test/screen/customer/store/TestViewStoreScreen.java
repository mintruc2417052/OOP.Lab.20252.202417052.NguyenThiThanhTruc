package hust.soict.elitech.test.screen.customer.store;

// Import các lớp cần thiết từ các gói khác nhau
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.exception.DuplicateItemException;
import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.screen.customer.controller.ViewStoreController;
import hust.soict.elitech.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Lớp TestViewStoreScreen kế thừa từ Application để tạo giao diện người dùng bằng JavaFX
public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    // Phương thức start được gọi khi ứng dụng JavaFX bắt đầu, thiết lập giao diện người dùng
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Phương thức main là điểm bắt đầu của ứng dụng, nơi chúng ta khởi tạo cửa hàng và giỏ hàng, sau đó thêm một số sản phẩm mẫu vào cửa hàng
    public static void main(String[] args) throws DuplicateItemException {
        store = new Store();
        cart = new Cart();

        // --- BẮT ĐẦU THÊM SẢN PHẨM MẪU ---
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 28.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lord of the Rings: The Return of the King", "Fantasy", "Peter Jackson", 201, 31.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 20.99f);
        store.addMedia(dvd3);

        // --- KẾT THÚC THÊM SẢN PHẨM MẪU ---
        launch(args);
    }
}