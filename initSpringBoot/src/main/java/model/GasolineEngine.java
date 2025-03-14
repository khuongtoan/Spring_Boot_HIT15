package model;

import org.springframework.stereotype.Component;

@Component
public class GasolineEngine implements Engine {

     @Override
    public void name() {
        System.out.println("name of egine is gasolineEngine");
    }
    
}
