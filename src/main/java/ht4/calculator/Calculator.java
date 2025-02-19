/*******************************************************************************
* @author Fatima Navarro 24044
* 
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Sección: 10
* 
* HT4 - Clases y Objetos con Java
* Calculadora Infix/Postfix
* 
* Calculator.java
* Esta clase implementa el patrón Singleton y se encarga de la conversión
* y evaluación de expresiones matemáticas.
* 
* Fecha: 16/02/2025
*******************************************************************************/

package ht4.calculator;

import ht4.stack.IStack;
import ht4.factory.StackFactory;

/**
 * Implementación de una calculadora que convierte expresiones infix a postfix
 * y las evalúa. Utiliza el patrón Singleton para asegurar una única instancia.
 */
public class Calculator {
    // Instancia única (Singleton)
    private static Calculator instance;
    
    // Pilas para la evaluación de expresiones
    private final IStack<Double> numberStack;
    private final IStack<Character> operatorStack;
    
    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa las pilas necesarias para los cálculos.
     */
    private Calculator() {
        // Se utilizan implementaciones de ArrayList por defecto
        numberStack = StackFactory.createStack("arraylist");
        operatorStack = StackFactory.createStack("arraylist");
    }
    
    /**
     * Obtiene la única instancia de Calculator.
     * 
     * @return la única instancia de Calculator
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
    
    /**
     * Determina si un caracter es un operador matemático.
     * 
     * @param c caracter a evaluar
     * @return true si es operador, false en caso contrario
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
    /**
     * Obtiene la precedencia de un operador matemático.
     * Mayor valor indica mayor precedencia.
     * 
     * @param operator operador a evaluar
     * @return nivel de precedencia (1-3) o 0 si no es operador
     */
    private int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }
    
    /**
     * Convierte una expresión matemática de notación infix a postfix.
     * Precondición: La expresión infix debe ser válida sintácticamente.
     * Postcondición: Retorna una expresión postfix equivalente.
     * 
     * @param infix expresión en formato infix
     * @return expresión equivalente en formato postfix
     */
    public String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        IStack<Character> stack = StackFactory.createStack("arraylist");
        
        // Iniciar con un carácter especial en la pila
        stack.push('#');
        
        // Procesar cada caracter de la expresión infix
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // Si es un espacio, ignorarlo
            if (c == ' ') continue;
            
            // Si es un dígito o parte de un número
            if (Character.isDigit(c)) {
                // Capturar el número completo (puede tener múltiples dígitos)
                StringBuilder number = new StringBuilder();
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    number.append(infix.charAt(i++));
                }
                i--; // Ajustar el índice
                
                postfix.append(number).append(" ");
            }
            // Si es un paréntesis de apertura
            else if (c == '(') {
                stack.push(c);
            }
            // Si es un paréntesis de cierre
            else if (c == ')') {
                // Desapilar hasta encontrar el paréntesis de apertura
                while (stack.peek() != '#' && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                
                // Eliminar el paréntesis de apertura
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
            // Si es un operador
            else if (isOperator(c)) {
                // Desapilar operadores con mayor o igual precedencia
                while (stack.peek() != '#' && stack.peek() != '(' && 
                       getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                
                // Apilar el operador actual
                stack.push(c);
            }
        }
        
        // Desapilar los operadores restantes
        while (stack.peek() != '#') {
            if (stack.peek() == '(') {
                stack.pop();
            } else {
                postfix.append(stack.pop()).append(" ");
            }
        }
        
        return postfix.toString().trim();
    }
    
    /**
     * Evalúa una expresión en notación postfix y retorna su resultado.
     * Precondición: La expresión postfix debe ser válida sintácticamente.
     * Postcondición: Retorna el resultado numérico de la expresión.
     * 
     * @param postfix expresión en formato postfix
     * @return resultado de la evaluación
     * @throws ArithmeticException si ocurre un error durante la evaluación
     */
    public double evaluatePostfix(String postfix) {
        IStack<Double> stack = StackFactory.createStack("arraylist");
        String[] tokens = postfix.split("\\s+");
        
        for (String token : tokens) {
            // Si es un número
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            }
            // Si es un operador
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                // Se necesitan al menos dos operandos
                if (stack.size() < 2) {
                    throw new ArithmeticException("Expresión postfix inválida: insuficientes operandos");
                }
                
                double b = stack.pop();
                double a = stack.pop();
                
                // Realizar la operación según el operador
                double result = switch (token.charAt(0)) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> {
                        if (b == 0) throw new ArithmeticException("División por cero");
                        yield a / b;
                    }
                    case '^' -> Math.pow(a, b);
                    default -> throw new ArithmeticException("Operador no soportado: " + token);
                };
                
                stack.push(result);
            }
            else if (!token.isEmpty()) {
                throw new ArithmeticException("Token no reconocido: " + token);
            }
        }
        
        // El resultado final debe ser el único elemento en la pila
        if (stack.size() != 1) {
            throw new ArithmeticException("Expresión postfix inválida: operandos sobrantes");
        }
        
        return stack.pop();
    }
}