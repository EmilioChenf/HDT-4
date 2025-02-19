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
* CalculatorTest.java
* Pruebas unitarias para la clase Calculator.
* 
* Fecha: 16/02/2025
*******************************************************************************/
// package ht4.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ht4.calculator.Calculator;

/**
 * Pruebas unitarias para la clase Calculator.
 */
public class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = Calculator.getInstance();
    }
    
    @Test
    @DisplayName("Test Singleton Pattern")
    public void testSingletonPattern() {
        Calculator calc1 = Calculator.getInstance();
        Calculator calc2 = Calculator.getInstance();
        
        // Verificar que ambas referencias apuntan a la misma instancia
        assertSame(calc1, calc2, "Calculator debe implementar Singleton correctamente");
    }
    
    @Test
    @DisplayName("Test convertToPostfix simple expression")
    public void testConvertToPostfixSimple() {
        String infix = "1+2";
        String expected = "1 2 +";
        String postfix = calculator.convertToPostfix(infix);
        
        assertEquals(expected, postfix, "La conversión de una expresión simple debe ser correcta");
    }
    
    @Test
    @DisplayName("Test convertToPostfix with parentheses")
    public void testConvertToPostfixWithParentheses() {
        String infix = "(1+2)*3";
        String expected = "1 2 + 3 *";
        String postfix = calculator.convertToPostfix(infix);
        
        assertEquals(expected, postfix, "La conversión con paréntesis debe ser correcta");
    }
    
    @Test
    @DisplayName("Test convertToPostfix with multiple operations")
    public void testConvertToPostfixMultipleOperations() {
        String infix = "10+20*30";
        String expected = "10 20 30 * +";
        String postfix = calculator.convertToPostfix(infix);
        
        assertEquals(expected, postfix, "La conversión con múltiples operaciones debe respetar precedencia");
    }
    
    @Test
    @DisplayName("Test convertToPostfix complex expression")
    public void testConvertToPostfixComplex() {
        String infix = "(10+20)*9";
        String expected = "10 20 + 9 *";
        String postfix = calculator.convertToPostfix(infix);
        
        assertEquals(expected, postfix, "La conversión de expresión compleja debe ser correcta");
    }
    
    @Test
    @DisplayName("Test evaluatePostfix simple expression")
    public void testEvaluatePostfixSimple() {
        String postfix = "1 2 +";
        double expected = 3.0;
        double result = calculator.evaluatePostfix(postfix);
        
        assertEquals(expected, result, 0.001, "La evaluación de una expresión simple debe ser correcta");
    }
    
    @Test
    @DisplayName("Test evaluatePostfix complex expression")
    public void testEvaluatePostfixComplex() {
        String postfix = "10 20 + 9 *";
        double expected = 270.0;
        double result = calculator.evaluatePostfix(postfix);
        
        assertEquals(expected, result, 0.001, "La evaluación de una expresión compleja debe ser correcta");
    }
    
    @Test
    @DisplayName("Test evaluatePostfix with division")
    public void testEvaluatePostfixDivision() {
        String postfix = "100 5 /";
        double expected = 20.0;
        double result = calculator.evaluatePostfix(postfix);
        
        assertEquals(expected, result, 0.001, "La división debe funcionar correctamente");
    }
    
    @Test
    @DisplayName("Test evaluatePostfix with invalid expression")
    public void testEvaluatePostfixInvalid() {
        String postfix = "1 2 + +";
        
        assertThrows(ArithmeticException.class, () -> {
            calculator.evaluatePostfix(postfix);
        }, "Debe lanzar excepción con expresión postfix inválida");
    }
    
    @Test
    @DisplayName("Test division by zero")
    public void testDivisionByZero() {
        String postfix = "10 0 /";
        
        assertThrows(ArithmeticException.class, () -> {
            calculator.evaluatePostfix(postfix);
        }, "Debe lanzar excepción en división por cero");
    }
    
    @Test
    @DisplayName("Test complete flow with sample expression")
    public void testCompleteFlow() {
        String infix = "(10+20)*9";
        String postfix = calculator.convertToPostfix(infix);
        double result = calculator.evaluatePostfix(postfix);
        
        assertEquals(270.0, result, 0.001, 
                "El flujo completo de conversión y evaluación debe funcionar correctamente");
    }
}