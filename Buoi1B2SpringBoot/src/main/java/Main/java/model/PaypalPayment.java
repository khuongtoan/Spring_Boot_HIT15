
package model;

import org.springframework.stereotype.Component;

@Component
public class PaypalPayment  implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("thanh toan qua Paypal");
    }
    
}
