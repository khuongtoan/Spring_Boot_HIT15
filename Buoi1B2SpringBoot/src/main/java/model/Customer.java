package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Customer {

private Order order;
private PaymentMethod paymentMethod;

@Autowired
public Customer(@Qualifier("fastFoodOrder") Order order, @Qualifier("payPalPayment") PaymentMethod paymentMethod) {
    this.order = order;
    this.paymentMethod = paymentMethod;
}

public void eatAndDrink(){
    order.placeOrder();
    paymentMethod.pay();
}

}
