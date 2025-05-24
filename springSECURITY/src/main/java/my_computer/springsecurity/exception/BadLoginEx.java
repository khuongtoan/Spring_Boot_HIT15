package my_computer.springsecurity.exception;

public class BadLoginEx extends RuntimeException {
    public BadLoginEx(String msg) {
        super(msg);
    }
}
