package hust.soict.elitech.aims.screen.customer.controller;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.exception.ItemNotFoundException;
import hust.soict.elitech.aims.media.Media;
import hust.soict.elitech.aims.media.Playable;
import hust.soict.elitech.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    // Khai báo các thành phần giao diện mà chúng ta sẽ tương tác
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    // Danh sách đã được lọc để hiển thị trong TableView, sẽ được cập nhật mỗi khi người dùng gõ vào thanh tìm kiếm
    private FilteredList<Media> filteredList;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Kiểm tra xem giỏ hàng có sản phẩm nào không trước khi đặt hàng
        if (cart.getItemsOrdered().size() > 0) {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Order Notification");
            alert.setHeaderText("Order Placed Successfully!");
            alert.setContentText("Your total is " + cart.totalCost() + " $. \nThe cart will be cleared.");
            alert.showAndWait();

            // Sau khi đặt hàng thành công, xóa tất cả sản phẩm trong giỏ hàng
            cart.getItemsOrdered().clear();
        } else {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
            alert.setTitle("Order Notification");
            alert.setHeaderText("Cart is empty!");
            alert.setContentText("Please add some media to your cart before placing an order.");
            alert.showAndWait();
        }
    }
    // Sự kiện khi người dùng nhấn nút "Play" để phát một sản phẩm media (CD, DVD)
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText("Now Playing:");
                alert.setContentText(media.getTitle());
                alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal Media Length");
                alert.setHeaderText("Error: Media Length is non-positive");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }
    private Store store; // Biến này sẽ được truyền vào từ màn hình Store để chúng ta có thể truy cập lại cửa hàng khi cần thiết
    private Cart cart;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    // Sự kiện khi người dùng nhấn nút "View Store" để quay lại màn hình cửa hàng chính
    @FXML
    void btnViewStorePressed(ActionEvent event) {

        try {
            // Định nghĩa đường dẫn đến file FXML của
            final String STORE_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

            // Truyền Store và Cart hiện tại vào StoreController để khi quay lại
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();

            // Chuyển sang giao diện Store
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Sự kiện khi người dùng nhấn nút "Remove" để xóa một sản phẩm đã chọn khỏi giỏ hàng
    @FXML
    void btnRemovePressed(ActionEvent event) throws ItemNotFoundException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    // Phương thức này sẽ được tự động gọi sau khi FXML được load xong, chúng ta sẽ thiết lập các giá trị ban đầu cho bảng và các thành phần giao diện khác tại đây
    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        // Khởi tạo FilteredList với danh sách sản phẩm trong giỏ hàng, ban đầu hiển thị tất cả sản phẩm
        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        // Lắng nghe sự thay đổi của thanh tìm kiếm để tự động cập nhật lại danh sách sản phẩm hiển thị trong bảng
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
        // Ban đầu khi chưa có sản phẩm nào được chọn, 2 nút "Play" và "Remove" sẽ bị ẩn đi
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự thay đổi của lựa chọn trong TableView để cập nhật lại trạng thái hiển thị của 2 nút "Play" và "Remove" tương ứng với sản phẩm được chọn
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        updateButtonBar(newValue);
                    }
                }
        );
        // 1. Hiển thị tổng giá tiền của giỏ hàng ngay khi màn hình được load lên
        costLabel.setText(cart.totalCost() + " $");

        // 2. Lắng nghe sự thay đổi của danh sách sản phẩm trong giỏ hàng để tự động cập nhật lại tổng giá tiền hiển thị trên costLabel mỗi khi có sản phẩm được thêm vào hoặc xóa khỏi giỏ hàng
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            costLabel.setText(cart.totalCost() + " $");
        });
    }
    void showFilteredMedia(String filter) {
        filteredList.setPredicate(media -> {
            // Nếu filter rỗng hoặc null thì hiển thị tất cả sản phẩm
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            // Chuyển filter về chữ thường để so sánh không phân biệt hoa thường
            String lowerCaseFilter = filter.toLowerCase();

            // Nếu người dùng đang chọn lọc theo ID
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            }
            // Nếu người dùng đang chọn lọc theo Title
            else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }

            return false;
        });
    }

    // Phương thức này sẽ được gọi mỗi khi người dùng chọn một sản phẩm trong TableView, nó sẽ kiểm tra xem sản phẩm đó có phải là một đối tượng Playable (CD hoặc DVD) hay không để quyết định hiển thị nút "Play" và luôn hiển thị nút "Remove"
    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            // Nếu sản phẩm được chọn là một đối tượng Playable (CD hoặc DVD) thì hiển thị nút "Play", ngược lại nếu là Book thì ẩn nút "Play" đi
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }
}

