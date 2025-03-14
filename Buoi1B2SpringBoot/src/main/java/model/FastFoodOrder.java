
package model;

import org.springframework.stereotype.Component;

@Component
public class FastFoodOrder implements Order {

    @Override
    public void placeOrder() {
        System.out.println("Dat mon an nhanh");
    }
    
}
