
package model;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine {

    @Override
    public void name() {
        System.out.println("name of egine is electricEngine");
    }
    
}
