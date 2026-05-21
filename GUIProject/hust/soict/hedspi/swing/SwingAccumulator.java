package lab04.GUIProject.hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Tạo một ứng dụng Swing để nhập vào một số nguyên
// cộng dồn vào tổng và hiển thị kết quả mỗi khi người dùng nhấn Enter trong trường nhập liệu.
public class SwingAccumulator extends JFrame {
    private JTextField tfInput; // Trường nhập liệu cho số nguyên
    private JTextField tfOutput; // Trường hiển thị tổng cộng dồn (không cho phép chỉnh sửa)
    private int sum = 0; // Biến để lưu tổng cộng dồn, khởi tạo bằng 0

    // Constructor để thiết lập giao diện người dùng
    public SwingAccumulator() {
        Container cp = getContentPane(); // Lấy container của JFrame để thêm các thành phần vào
        cp.setLayout(new GridLayout(2, 2)); // Sử dụng GridLayout để sắp xếp các thành phần trong 2 hàng và 2 cột

        cp.add(new JLabel("Enter an Integer: ")); // Thêm một JLabel để hướng dẫn người dùng nhập số nguyên

        tfInput = new JTextField(10); // Tạo một JTextField để người dùng nhập số nguyên, với độ rộng 10 cột
        cp.add(tfInput); // Thêm JTextField vào container
        tfInput.addActionListener(new TFInputListener()); // Thêm ActionListener cho JTextField để xử lý sự kiện khi người dùng nhấn Enter

        cp.add(new JLabel("The Accumulated Sum is: ")); // Thêm một JLabel để hiển thị hướng dẫn cho trường hiển thị tổng cộng dồn

        tfOutput = new JTextField(10); // Tạo một JTextField để hiển thị tổng cộng dồn, với độ rộng 10 cột
        tfOutput.setEditable(false); // Đặt trường hiển thị tổng cộng dồn không cho phép chỉnh sửa để người dùng chỉ có thể xem kết quả
        cp.add(tfOutput); // Thêm JTextField vào container

        setTitle("Swing Accumulator"); // Đặt tiêu đề cho JFrame
        setSize(350, 120); // Đặt kích thước cho JFrame (chiều rộng 350 pixel và chiều cao 120 pixel) 
        setVisible(true); // Hiển thị
    }

    // Phương thức main để khởi chạy ứng dụng
    public static void main(String[] args) {
        new SwingAccumulator();
    }

    // Lớp nội bộ để xử lý sự kiện khi người dùng nhấn Enter trong trường nhập liệu
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText()); // Chuyển đổi chuỗi nhập vào thành số nguyên
            sum += numberIn; // Cộng số nguyên vừa nhập vào với tổng cộng dồn hiện tại
            tfInput.setText(""); // Xóa trường nhập liệu sau khi đã lấy giá trị
            tfOutput.setText(sum + ""); // Cập nhật trường hiển thị tổng cộng dồn với giá trị mới, chuyển đổi số nguyên thành chuỗi để hiển thị
        }
    }
}
