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
* ListFactory.java
* Factory para crear diferentes implementaciones de IList.
* 
* Fecha: 16/02/2025
*******************************************************************************/

package ht4.factory;
import ht4.list.SingleLinkedList;
import ht4.list.DoubleLinkedList;
import ht4.list.*;

/**
 * Factory para crear diferentes implementaciones de IList.
 * Implementa el patrón de diseño Factory.
 */
public class ListFactory {
    
    /**
     * Crea una instancia de IList según el tipo especificado.
     * Precondición: El tipo debe ser válido.
     * Postcondición: Retorna una nueva instancia del tipo especificado.
     * 
     * @param <T> tipo de elementos que almacenará la lista
     * @param type tipo de implementación ("single", "double")
     * @return nueva instancia de IList del tipo especificado
     * @throws IllegalArgumentException si el tipo no es válido
     */
    public static <T> IList<T> createList(String type) {
        // Seleccionar la implementación según el tipo
        return switch (type.toLowerCase()) {
            case "single" -> new SingleLinkedList<>();
            case "double" -> new DoubleLinkedList<>();
            default -> throw new IllegalArgumentException("Tipo de lista no válido: " + type);
        };
    }
}