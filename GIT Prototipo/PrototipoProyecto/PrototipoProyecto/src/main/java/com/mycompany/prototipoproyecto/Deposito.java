
package com.mycompany.prototipoproyecto;

public class Deposito extends Transaccion {
    
    public Deposito(double monto) {
        super(monto);
    }

    @Override
    public String getTipo() {
        return "Deposito";
    }
    
}
