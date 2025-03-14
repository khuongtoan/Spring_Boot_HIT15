package model;

import org.springframework.stereotype.Component;

@Component
public class HealthyFoodOrder implements Order {

    @Override
    public void placeOrder() {
        System.out.println("Dat mon an lanh manh");
    }
    
}
