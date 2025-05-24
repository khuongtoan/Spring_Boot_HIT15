package my_computer.springsecurity.exception;

public class UsernameExistsEx extends RuntimeException {
    public UsernameExistsEx(String msg) {
        super(msg);
    }
}
