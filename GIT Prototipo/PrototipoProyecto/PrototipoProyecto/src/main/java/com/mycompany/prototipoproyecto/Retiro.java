
package com.mycompany.prototipoproyecto;

public class Retiro extends Transaccion {
    
    public Retiro(double monto) {
        super(monto);
    }

    @Override
    public String getTipo() {
        return "Retiro";
    }
    
}
