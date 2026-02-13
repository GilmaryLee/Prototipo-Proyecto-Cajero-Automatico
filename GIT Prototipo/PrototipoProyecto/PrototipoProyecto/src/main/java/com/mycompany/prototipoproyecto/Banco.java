
package com.mycompany.prototipoproyecto;
import java.util.ArrayList;

public class Banco {
    
    //Atributos
    private String nombre;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private int contador = 1;
    
    //Constructor
    public Banco(String nombre) {
        this.nombre = nombre;
    }
    
    //Metodo para crear cuenta 
    public void crearCuenta(String titular, String pin, double saldoInicial) {
        String numeroCuenta = String.valueOf(contador++); //La primera cuenta es 1, la segunda sera 2...
        cuentas.add(new Cuenta(numeroCuenta, titular, pin, saldoInicial));
    }
    
    //Metodo para autenticar cuenta
    public Cuenta autenticar(String numero, String pin) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(numero) && c.validarPin(pin)) {
                return c;
            }
        }
        return null;
    }
    
    //Metodo para buscar cuenta
    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(numero)) {
                return c;
            }
        }
        return null;
    }
}
