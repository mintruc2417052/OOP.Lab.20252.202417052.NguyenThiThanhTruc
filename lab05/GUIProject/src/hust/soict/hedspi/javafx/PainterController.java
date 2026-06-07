package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;

public class PainterController {

    // Khai báo Pane từ Scene Builder
    @FXML
    private Pane drawingAreaPane;

    // Khai báo các RadioButton từ Scene Builder
    @FXML
    private RadioButton penRadio;

    // RadioButton này sẽ được sử dụng để xác định khi nào người dùng muốn xóa (eraser)
    @FXML
    private RadioButton eraserRadio;

    // Phương thức xử lý sự kiện khi nút Clear được nhấn
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    // Phương thức xử lý sự kiện khi chuột được kéo trên vùng vẽ
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Mặc định màu mực là đen
        Color inkColor = Color.BLACK;

        // Nếu RadioButton "Pen" được chọn, giữ nguyên màu đen
        if (eraserRadio.isSelected()) {
            inkColor = Color.WHITE;
        }

        // Tạo một hình tròn nhỏ tại vị trí chuột và thêm vào Pane
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}