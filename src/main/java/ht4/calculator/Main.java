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
* Main.java
* Clase principal que ejecuta el programa y maneja la interacción con el usuario.
* 
* Fecha: 16/02/2025
*******************************************************************************/

package ht4.calculator;

import java.io.IOException;
import java.util.Scanner;
import ht4.factory.StackFactory;

/**
 * Clase principal que coordina la ejecución del programa.
 * Maneja la interacción con el usuario y utiliza la calculadora.
 */
public class Main {
    
    /**
     * Método principal que ejecuta el programa.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar implementación de Stack al usuario
        System.out.println("CALCULADORA INFIX A POSTFIX");
        System.out.println("===========================");
        System.out.println("Seleccione la implementación de stack a utilizar:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        
        int stackChoice = getUserChoice(scanner, 1, 3);
        String stackImplementation = getStackImplementationName(stackChoice);
        
        // Si se seleccionó Lista, preguntar qué tipo de lista
        if (stackChoice == 3) {
            System.out.println("\nSeleccione el tipo de lista a utilizar:");
            System.out.println("1. Simplemente encadenada");
            System.out.println("2. Doblemente encadenada");
            
            int listChoice = getUserChoice(scanner, 1, 2);
            String listImplementation = getListImplementationName(listChoice);
            
            // Configurar el Factory para que use la implementación de lista seleccionada
            System.setProperty("list.implementation", listImplementation);
        }
        
        // Configurar la implementación de stack seleccionada
        System.setProperty("stack.implementation", stackImplementation);
        
        try {
            // Obtener instancia de la calculadora (Singleton)
            Calculator calc = Calculator.getInstance();
            
            // Leer expresión del archivo
            String infix = FileReader.readExpression();
            System.out.println("\nExpresión infix leída: " + infix);
            
            // Convertir a postfix
            String postfix = calc.convertToPostfix(infix);
            System.out.println("Expresión postfix: " + postfix);
            
            // Evaluar expresión
            double result = calc.evaluatePostfix(postfix);
            System.out.println("Resultado: " + result);
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Error en la evaluación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Obtiene una opción válida del usuario.
     * 
     * @param scanner el Scanner para leer la entrada
     * @param min valor mínimo aceptable
     * @param max valor máximo aceptable
     * @return la opción seleccionada por el usuario
     */
    private static int getUserChoice(Scanner scanner, int min, int max) {
        int choice = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Ingrese su opción: ");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    validInput = true;
                } else {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número.");
            }
        }
        
        return choice;
    }
    
    /**
     * Convierte la opción numérica en el nombre de la implementación de Stack.
     * 
     * @param choice opción seleccionada por el usuario
     * @return nombre de la implementación de Stack
     */
    private static String getStackImplementationName(int choice) {
        return switch (choice) {
            case 1 -> "arraylist";
            case 2 -> "vector";
            case 3 -> "list";
            default -> "arraylist"; // Default
        };
    }
    
    /**
     * Convierte la opción numérica en el nombre de la implementación de List.
     * 
     * @param choice opción seleccionada por el usuario
     * @return nombre de la implementación de List
     */
    private static String getListImplementationName(int choice) {
        return switch (choice) {
            case 1 -> "single";
            case 2 -> "double";
            default -> "single"; // Default
        };
    }
}