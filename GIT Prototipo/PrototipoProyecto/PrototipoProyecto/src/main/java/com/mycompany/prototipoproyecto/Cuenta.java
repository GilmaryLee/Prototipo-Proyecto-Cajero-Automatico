
package com.mycompany.prototipoproyecto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cuenta {
    
    //Atributos
    private String numeroCuenta;
    private String titular;
    private String pin;
    private double saldo;
    private ArrayList<Transaccion> historial = new ArrayList<>();
    
    //Constructor
    public Cuenta(String numeroCuenta, String titular, String pin, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.pin = pin;
        this.saldo = saldo;
    }
    
    //Metodo para validar pin
    public boolean validarPin(String pin) {
        return this.pin.equals(pin);
    }
    
    //Metodo para retirar dinero
    public void retirar(double monto) {
        if (monto > saldo) {
            return;
        }
        saldo -= monto;
        historial.add(new Retiro(monto));
        JOptionPane.showMessageDialog(null, "Retiro exitoso");
    }
    
    //Metodo para depositar dinero
    public void depositar(double monto) {
        saldo += monto;
        historial.add(new Deposito(monto));
        JOptionPane.showMessageDialog(null, "Deposito exitoso");
    }
    
    //Metodo para transferir dinero
    public void transferir(double monto, Cuenta destino) {
        if (monto > saldo) {
            return;
        }
        saldo -= monto;
        destino.saldo += monto;
        historial.add(new Transferencia(monto, destino.getNumeroCuenta()));
        JOptionPane.showMessageDialog(null, "Transferencia exitosa");
    }
    
    //Metodo para ver historial
    public String verHistorial() {
        String texto = "";
        for (Transaccion t : historial) {
            texto += t.toString() + "\n";
        }
        return texto;
    }
    
    //Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}
