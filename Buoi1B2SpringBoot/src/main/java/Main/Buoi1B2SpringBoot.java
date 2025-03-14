package Main;

import model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "model") 

public class Buoi1B2SpringBoot {

    public static void main(String[] args) {
        ApplicationContext contex = SpringApplication.run(Buoi1B2SpringBoot.class, args);
        Customer customer = contex.getBean(Customer.class);
        customer.eatAndDrink();
    }
}
