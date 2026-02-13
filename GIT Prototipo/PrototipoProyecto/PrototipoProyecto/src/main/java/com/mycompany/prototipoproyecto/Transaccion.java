
package com.mycompany.prototipoproyecto;
import java.time.LocalDateTime;

public abstract class Transaccion {
    
    //Atributos
    protected double monto;
    protected LocalDateTime fecha;
    
    //Constructor
    public Transaccion(double monto) {
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }
    
    public abstract String getTipo();

    @Override
    public String toString() {
        return fecha + " - " + getTipo() + " - $" + monto;
    }
}
