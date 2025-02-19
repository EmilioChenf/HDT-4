/*******************************************************************************
* @author Fatima Navarro 24044, Emilio, Arturo
* 
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Sección: 10
* 
* HT4 - Clases y Objetos con Java
* Calculadora Infix/Postfix
* 
* Operator.java
* Clase de utilidad para operaciones matemáticas.
* 
* Fecha: 16/02/2025
*******************************************************************************/

package ht4.utils;

/**
 * Clase utilitaria para manejar operadores matemáticos.
 * Proporciona métodos para verificar y trabajar con operadores.
 */
public class Operator {
    
    /**
     * Verifica si un caracter es un operador matemático.
     * Precondición: Ninguna.
     * Postcondición: Retorna true si es un operador, false en caso contrario.
     * 
     * @param c caracter a verificar
     * @return true si es un operador, false en caso contrario
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
    /**
     * Obtiene la precedencia de un operador matemático.
     * Precondición: El caracter debe ser un operador válido.
     * Postcondición: Retorna un valor numérico que representa la precedencia.
     * 
     * @param operator operador a evaluar
     * @return nivel de precedencia (1-3) o 0 si no es un operador válido
     */
    public static int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }
    
    /**
     * Aplica la operación especificada a dos operandos.
     * Precondición: La operación debe ser válida y los operandos adecuados.
     * Postcondición: Retorna el resultado de la operación.
     * 
     * @param operator operador a aplicar
     * @param a primer operando
     * @param b segundo operando
     * @return resultado de la operación
     * @throws ArithmeticException si ocurre un error en la operación
     */
    public static double applyOperation(char operator, double a, double b) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("División por cero");
                yield a / b;
            }
            case '^' -> Math.pow(a, b);
            default -> throw new ArithmeticException("Operador no soportado: " + operator);
        };
    }
}