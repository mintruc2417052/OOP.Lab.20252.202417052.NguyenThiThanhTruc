package hust.soict.elitech.aims.exception;

// Tạo một lớp ngoại lệ tùy chỉnh để xử lý lỗi liên quan đến Player
public class PlayerException extends Exception {

    // Các constructor để tạo đối tượng ngoại lệ với các thông tin khác nhau
    public PlayerException() {
        super();
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }
}