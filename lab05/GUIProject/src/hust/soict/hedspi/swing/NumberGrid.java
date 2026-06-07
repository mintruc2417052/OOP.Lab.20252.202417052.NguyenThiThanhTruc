package lab04.GUIProject.hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // Mảng chứa các nút số từ 0 đến 9
    private JButton btnDelete, btnReset; // Nút DEL và C
    private JTextField tfDisplay; // TextField để hiển thị số đã nhập

    // Constructor để thiết lập giao diện
    public NumberGrid() {
        tfDisplay = new JTextField(); // Tạo TextField để hiển thị số đã nhập
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Đặt hướng hiển thị từ phải sang trái

        JPanel panelButtons = new JPanel(new GridLayout(4, 3)); // Tạo panel chứa các nút với bố cục lưới 4 hàng và 3 cột
        addButtons(panelButtons); // Gọi phương thức để thêm các nút vào panel

        Container cp = getContentPane(); // Lấy container của JFrame để thêm các thành phần vào
        cp.setLayout(new BorderLayout()); // Đặt bố cục cho container là BorderLayout
        cp.add(tfDisplay, BorderLayout.NORTH); // Thêm TextField vào phần trên của BorderLayout
        cp.add(panelButtons, BorderLayout.CENTER); // Thêm panel chứa các nút vào phần giữa của BorderLayout

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đặt hành vi khi đóng cửa sổ
        setTitle("Number Grid"); // Đặt tiêu đề cho cửa sổ
        setSize(200, 200); // Đặt kích thước cho cửa sổ
        setVisible(true); // Hiển thị cửa sổ
    }
    
    // Phương thức để thêm các nút vào panel
    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener(); // Tạo một ActionListener để xử lý sự kiện khi các nút được nhấn
        
        // Tạo các nút từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Nút DEL
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Nút số 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Nút Reset (C)
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    // Lớp nội bộ để xử lý sự kiện khi các nút được nhấn
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand(); // Lấy tên của nút được nhấn
            
            // Trường hợp 1: Nhấn nút số (0-9)
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            } 
            // Trường hợp 2: Nhấn nút DEL (Xóa ký tự cuối cùng)
            else if (button.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    // Xóa ký tự cuối cùng của chuỗi hiện tại trong TextField
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } 
            // Trường hợp 3: Nhấn nút Reset (C) để xóa toàn bộ nội dung
            else {
                tfDisplay.setText("");
            }
        }
    }

    // Phương thức main để chạy ứng dụng
    public static void main(String[] args) {
        new NumberGrid();
    }
}
