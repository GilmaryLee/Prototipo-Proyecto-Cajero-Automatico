
package com.mycompany.prototipoproyecto;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
        
        Banco banco = new Banco("FideBank");
        
        // Cuenta de prueba
        banco.crearCuenta("Pedro", "1234", 1000); //# de cuenta es 1. PIN:1234 
        
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "=== FideBank ===\n" +
                    "1. Ingresar\n" +
                    "2. Crear Cuenta\n" +
                    "3. Salir");
            
            if (opcion == null || opcion.equals("3")) {
                break;
            }
            
            switch (opcion) {
                case "1":
                    String numero = JOptionPane.showInputDialog("Numero de Cuenta:");
                    String pin = JOptionPane.showInputDialog("PIN:");
                    
                    Cuenta cuenta = banco.autenticar(numero, pin);
                    
                    if (cuenta != null) {
                        menuCuenta(banco, cuenta);
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                    }
                    break;
                    
                case "2":
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String nuevoPin = JOptionPane.showInputDialog("PIN:");
                    banco.crearCuenta(nombre, nuevoPin, 0);
                    JOptionPane.showMessageDialog(null, "Cuenta creada correctamente");
                    break;
                    
                }
            }
        }
    
        private static void menuCuenta(Banco banco, Cuenta cuenta) {
            
            while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "=== Cuenta: " + cuenta.getNumeroCuenta() + " ===\n" +
                    "Saldo: $" + cuenta.getSaldo() + "\n\n" +
                    "1. Retiro\n" +
                    "2. Deposito\n" +
                    "3. Transferencia\n" +
                    "4. Ver Historial\n" +
                    "5. Salir");
            
            if (opcion == null || opcion.equals("5")) break;
            
            switch (opcion) {
                case "1":
                    double montoRetiro = Double.parseDouble(
                            JOptionPane.showInputDialog("Monto a retirar:"));
                    cuenta.retirar(montoRetiro);
                    break;
                    
            case "2":
                    double montoDeposito = Double.parseDouble(
                            JOptionPane.showInputDialog("Monto a depositar:"));
                    cuenta.depositar(montoDeposito);
                    break;
                    
            case "3":
                    String destino = JOptionPane.showInputDialog("Cuenta destino:");
                    double montoTransferencia = Double.parseDouble(
                            JOptionPane.showInputDialog("Monto a transferir:"));
                    
                    Cuenta cuentaDestino = banco.buscarCuenta(destino);
                    
                    if (cuentaDestino != null) {
                        cuenta.transferir(montoTransferencia, cuentaDestino);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta destino no existe");
                    }
                    break;
                    
                    case "4":
                    JOptionPane.showMessageDialog(null, cuenta.verHistorial());
                    break;
                }
            }                     
    }
}
