package model;

import org.springframework.stereotype.Component;


@Component
public class Motorbike implements Vehicle{

    @Override
    public void speed() {
        System.out.println("30 km/h ");
    }
    
}
