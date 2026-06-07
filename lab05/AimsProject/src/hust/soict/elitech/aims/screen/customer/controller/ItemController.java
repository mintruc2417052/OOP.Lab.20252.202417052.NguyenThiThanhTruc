package hust.soict.elitech.aims.screen.customer.controller;
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.exception.DuplicateItemException;
import hust.soict.elitech.aims.media.Media;
import hust.soict.elitech.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import hust.soict.elitech.aims.exception.LimitExceededException;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    // Việc thêm media vào giỏ hàng sẽ được thực hiện trong hàm xử lý sự kiện của nút "Add to Cart"
    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException, DuplicateItemException {
        if (cart != null) {
            cart.addMedia(media);
            // In ra console cho vui nhà vui cửa, dễ biết là đã thêm thành công
            System.out.println("Đã thêm " + media.getTitle() + " vào giỏ hàng!");
        }
    }

    // Hàm xử lý sự kiện khi nhấn nút "Play"
    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            // Ép kiểu sang Playable và gọi hàm play() thực sự để test xem có lỗi không
            ((Playable) media).play();

            // Nếu không có lỗi, hiện hộp thoại báo đang phát
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText("Now Playing:");
            alert.setContentText(media.getTitle());
            alert.showAndWait();

        } catch (Exception e) {
            // Nếu tóm được lỗi (thời lượng <= 0), lập tức hiện hộp thoại cảnh báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Illegal Media Length");
            alert.setHeaderText("Error: Media Length is non-positive");
            alert.setContentText(e.getMessage()); // Lấy câu chữ báo lỗi từ PlayerException
            alert.showAndWait();
            e.printStackTrace(); // In chi tiết lỗi ra console
        }
    }

    // Thêm 2 biến instance để lưu lại thông tin media và cart được truyền vào
    private Media media;
    private Cart cart; // Biến này sẽ lưu lại giỏ hàng được truyền vào để sau này khi nhấn "Add to Cart" thì nó biết phải thêm vào giỏ hàng nào
    // Hàm này sẽ được gọi từ bên ngoài (có thể là từ controller của màn hình chính) để truyền thông tin media và cart vào đây, đồng thời cập nhật giao diện
    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart; // Lưu lại cart vào biến instance để sau này có thể sử dụng khi nhấn "Add to Cart"
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        // Kiểm tra nếu media là Playable thì hiển thị nút "Play", ngược lại ẩn nút "Play" và căn chỉnh lại nút "Add to Cart"
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
