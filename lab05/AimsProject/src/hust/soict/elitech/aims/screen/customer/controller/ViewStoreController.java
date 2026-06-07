package hust.soict.elitech.aims.screen.customer.controller;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    // Bổ sung thêm biến cart để lưu trữ giỏ hàng
    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart cart; // Biến để lưu trữ giỏ hàng
    // Constructor để nhận store và cart từ màn hình trước đó và truyền chúng sang màn hình giỏ hàng khi người dùng nhấn nút "View Cart"
    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    // Phương thức xử lý sự kiện khi người dùng nhấn nút "View Cart"
    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

            // Ép truyền cả store và cart sang màn hình giỏ hàng
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức initialize để hiển thị danh sách sản phẩm
    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for(int i=0; i<store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                ItemController itemController = new ItemController();
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i), cart);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

