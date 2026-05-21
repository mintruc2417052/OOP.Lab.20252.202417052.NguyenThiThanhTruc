package hust.soict.elitech.garbage;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestFile {
    public static void main(String[] args) {
        String filename = "test.exe";
        // tao file test.exe co kich thuoc 10MB
        byte[] content = new byte[10 * 1024 * 1024]; 
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(content);
            System.out.println("Đã tạo file test.exe thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
