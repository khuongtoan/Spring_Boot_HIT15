package model;

import org.springframework.stereotype.Component;

@Component
public class CreaditCardPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Thanh toan bang the tin dung.");
    }
    
}
