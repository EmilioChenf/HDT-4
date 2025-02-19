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
* StackFactory.java
* Factory para crear diferentes implementaciones de IStack.
* 
* Fecha: 16/02/2025
*******************************************************************************/

package ht4.factory;

import ht4.stack.*;
import ht4.list.IList;

/**
 * Factory para crear diferentes implementaciones de IStack.
 * Implementa el patrón de diseño Factory.
 */
public class StackFactory {
    
    /**
     * Crea una instancia de IStack según el tipo especificado.
     * Precondición: El tipo debe ser válido.
     * Postcondición: Retorna una nueva instancia del tipo especificado.
     * 
     * @param <T> tipo de elementos que almacenará la pila
     * @param type tipo de implementación ("arraylist", "vector", "list")
     * @return nueva instancia de IStack del tipo especificado
     * @throws IllegalArgumentException si el tipo no es válido
     */
    public static <T> IStack<T> createStack(String type) {
        // Obtener la implementación configurada en el sistema o usar la especificada
        String stackType = System.getProperty("stack.implementation", type);
        
        // Seleccionar la implementación según el tipo
        return switch (stackType.toLowerCase()) {
            case "arraylist" -> new ArrayListStack<>();
            case "vector" -> new VectorStack<>();
            case "list" -> {
                // Obtener el tipo de lista configurado o usar simple por defecto
                String listType = System.getProperty("list.implementation", "single");
                IList<T> list = ListFactory.createList(listType);
                yield new ListStack<>(list);
            }
            default -> throw new IllegalArgumentException("Tipo de stack no válido: " + type);
        };
    }
}