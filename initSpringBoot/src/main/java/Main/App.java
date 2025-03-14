package Main;

import model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "model") 

public class App {
     public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        Person person = context.getBean(Person.class);
        person.travel();    
    }
}