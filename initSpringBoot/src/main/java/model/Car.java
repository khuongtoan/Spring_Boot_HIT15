package model;

import org.springframework.stereotype.Component;

@Component
public class Car  implements Vehicle {

    @Override
    public void speed() {
        System.out.println("100 km/h ");
    }
    
}
