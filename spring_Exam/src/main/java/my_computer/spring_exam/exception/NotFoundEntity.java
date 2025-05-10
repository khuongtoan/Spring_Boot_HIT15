package my_computer.spring_exam.exception;

public class NotFoundEntity extends RuntimeException{

    public NotFoundEntity(String message){
        super(message);
    }

}
