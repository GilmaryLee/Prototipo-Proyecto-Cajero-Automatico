
package com.mycompany.prototipoproyecto;

public class Transferencia extends Transaccion {
    
    //Atributo define la cuenta de destino
    private String cuentaDestino;

    public Transferencia(double monto, String cuentaDestino) {
        super(monto);
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String getTipo() {
        return "Transferencia a " + cuentaDestino;
    }
    
}
