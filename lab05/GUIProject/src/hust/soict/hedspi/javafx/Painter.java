package hust.soict.hedspi.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Tải giao diện từ file FXML
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/hedspi/javafx/Painter.fxml"));

        // Tạo scene và hiển thị stage
        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    // Phương thức main để khởi chạy ứng dụng JavaFX
    public static void main(String[] args) {
        launch(args);
    }
}