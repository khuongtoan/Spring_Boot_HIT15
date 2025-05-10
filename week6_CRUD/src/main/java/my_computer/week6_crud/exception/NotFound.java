package my_computer.week6_crud.exception;

public class NotFound extends RuntimeException{

    public NotFound(String message) {
        super(message);
    }
}
