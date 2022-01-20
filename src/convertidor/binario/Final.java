/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidor.binario;

/**
 *
 * @author Admin
 */
import javax.swing.JOptionPane;

public class Final {

    public static void main(String[] args) {
        boolean salir = false;
        JOptionPane.showMessageDialog(null, "Codigo echo por: \n"
                + "Carbajal Rodriguez William\n"
                + "Azpeitia Castillo Ignacio\n"
                + "Martinez Guzman Nahin Alberto\n");
        while (!salir) {
            int op = Integer.parseInt(JOptionPane.showInputDialog("\n1. Binario a octal\n"
                    + "2. Binario a decimal\n"
                    + "3. Binario a hexadecimal\n"
                    + "4. Octal a binario\n"
                    + "5. Decimal a binario\n"
                    + "6. Hexadecimal a binario\n"
                    + "7. Salir\n"
                    + "Escribe la opercion a realizar: "));
            switch (op) {
                case 1:
                    int binario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número binario:"));
                    if (!validarBinario(binario)) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                        return;
                    }
                    int decimal = binarioADecimal(binario);
                    String octalResultante = decimalAOctal(decimal);
                    JOptionPane.showMessageDialog(null, "El octal es " + octalResultante);
                    break;
                case 2:
                    binario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número binario:"));
                    if (!validarBinario(binario)) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                        return;
                    }
                    decimal = binarioADecimal(binario);
                    JOptionPane.showMessageDialog(null, "El decimal es " + decimal);
                    break;

                case 3:
                    binario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número binario:"));
                    if (!validarBinario(binario)) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                        return;
                    }
                    decimal = binarioADecimal(binario);
                    String hexadecimal = decimalAHexadecimal(decimal);
                    JOptionPane.showMessageDialog(null, "El hexadecimal es " + hexadecimal);
                    break;
                case 4:
                    int octal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número octal:"));
                    if (!validarOctal(octal)) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                        return;
                    }
                    decimal = octalADecimal(octal);
                    String binarioResultante = decimalABinario(decimal);
                    JOptionPane.showMessageDialog(null, "El binario es " + binarioResultante);
                    break;
                case 5:
                    decimal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número decimal:"));
                    if (!validarDecimal(decimal)) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                        return;
                    }
                    binarioResultante = decimalABinario(decimal);
                    JOptionPane.showMessageDialog(null, "El binario es " + binarioResultante);
                    break;
                case 6:
                    hexadecimal = JOptionPane.showInputDialog("Ingrese número hexadecimal:");
                    if (!validarHexadecimal(hexadecimal)) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                        return;
                    }
                    decimal = hexadecimalADecimal(hexadecimal);
                    binarioResultante = decimalABinario(decimal);
                    JOptionPane.showMessageDialog(null, "El binario es " + binarioResultante);
                    break;
                case 7:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por visitarnos");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Solo números entre 1 y 7");
            }
        }
    }

    public static boolean validarDecimal(int decimal) {
        return true;
    }

    public static boolean validarBinario(int binario) {
        String binarioComoCadena = String.valueOf(binario);
        for (int i = 0; i < binarioComoCadena.length(); i++) {
            char caracter = binarioComoCadena.charAt(i);
            if (caracter != '0' && caracter != '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean validarOctal(int octal) {
        String octalComoCadena = String.valueOf(octal);
        String caracteresOctales = "01234567";
        for (int i = 0; i < octalComoCadena.length(); i++) {
            char caracter = octalComoCadena.charAt(i);
            if (caracteresOctales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarHexadecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            if (caracteresHexadecimales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String decimalABinario(int decimal) {
        String binario = "";
        while (decimal > 0) {
            binario = decimal % 2 + binario;
            decimal = decimal / 2;
        }
        return binario;
    }

    public static String decimalAOctal(int decimal) {
        int residuo;
        String octal = "";
        char[] caracteresOctales = {'0', '1', '2', '3', '4', '5', '6', '7'};
        while (decimal > 0) {
            residuo = decimal % 8;
            char caracter = caracteresOctales[residuo];
            octal = caracter + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    public static String decimalAHexadecimal(int decimal) {
        int residuo;
        String hexadecimal = "";
        char[] caracteresHexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            residuo = decimal % 16;
            char caracterHexadecimal = caracteresHexadecimales[residuo];
            hexadecimal = caracterHexadecimal + hexadecimal;
            decimal = decimal / 16;
        }
        return hexadecimal;
    }

    public static int binarioADecimal(int binario) {
        int decimal = 0;
        int potencia = 0;
        while (true) {
            if (binario == 0) {
                break;
            } else {
                int temp = binario % 10;
                decimal += temp * Math.pow(2, potencia);
                binario = binario / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public static int octalADecimal(int octal) {
        int decimal = 0;
        int potencia = 0;
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, potencia);
                octal = octal / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public static int hexadecimalADecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            int posicionEnCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionEnCaracteres;
        }
        return decimal;
    }

}
