package lab04.GUIProject.hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Biến để lưu tổng cộng dồn của các số đã nhập

    // Constructor để thiết lập giao diện người dùng
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); // Sử dụng GridLayout để sắp xếp các thành phần trong Frame

        add(new Label("Enter an Integer: ")); // Thêm Label hướng dẫn nhập liệu

        tfInput = new TextField(10); // Tạo ô nhập liệu với độ rộng 10 ký tự
        add(tfInput);               // Thêm ô nhập liệu vào Frame
        tfInput.addActionListener(new TFInputListener()); // Thêm ActionListener để xử lý sự kiện khi người dùng nhấn Enter

        add(new Label("The Accumulated Sum is: ")); // Thêm Label hướng dẫn hiển thị kết quả

        tfOutput = new TextField(10); // Tạo ô kết quả với độ rộng 10 ký tự
        tfOutput.setEditable(false);  // Đặt ô kết quả không cho phép chỉnh sửa để người dùng chỉ có thể xem tổng cộng dồn
        add(tfOutput);                // Thêm ô kết quả vào Frame

        setTitle("AWT Accumulator"); // Đặt tiêu đề cho cửa sổ
        setSize(350, 120);   // Đặt kích thước cho cửa sổ
        setVisible(true);            // Hiển thị cửa sổ
    }

    public static void main(String[] args) {
        new AWTAccumulator(); // Tạo một instance của AWTAccumulator để chạy ứng dụng
    }

    // Lớp nội bộ để xử lý sự kiện khi người dùng nhập số và nhấn Enter
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy số nguyên từ ô nhập liệu, cộng vào tổng và cập nhật kết quả
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            
            tfInput.setText("");         // Xóa ô nhập liệu sau khi đã lấy số để người dùng có thể nhập số tiếp theo
            tfOutput.setText(sum + "");     // Cập nhật ô kết quả với tổng cộng dồn mới sau khi cộng số vừa nhập vào
        }
    }
}
