# HT4 - Calculadora Infix/Postfix

Implementación de una calculadora que convierte expresiones infix a postfix y las evalúa utilizando diferentes estructuras de datos y patrones de diseño.

## Diagrama de clases

![image](https://github.com/user-attachments/assets/97c2d75b-9fe0-4728-b7fb-05e2fee186de)





## Integrantes
- **Emilio** - Estructuras Base
- **Fatima Navarro 24044** - Lógica Principal
- **Arturo** - Listas Enlazadas

## Estructura y Responsabilidades

### Emilio (Estructuras Base)
- `src/main/java/ht4/stack/`
  - IStack.java
  - AbstractStack.java
  - ArrayListStack.java
  - VectorStack.java
  - ListStack.java
- Pruebas unitarias para Stack

### Fatima (Lógica Principal)
- `src/main/java/ht4/calculator/`
  - Calculator.java (Singleton)
  - Main.java
  - FileReader.java
- Pruebas unitarias para Calculator

### Arturo (Listas Enlazadas)
- `src/main/java/ht4/list/`
  - IList.java
  - AbstractList.java
  - SingleLinkedList.java
  - DoubleLinkedList.java
- Pruebas unitarias para List

### Compartido
- `src/main/java/ht4/factory/`
  - StackFactory.java
  - ListFactory.java
- `src/main/java/ht4/utils/`
  - Operator.java

## Patrones de Diseño Utilizados
- **Singleton**: Asegura una única instancia de Calculator
- **Factory**: Crea implementaciones de Stack y List según se requiera
- **Abstract Class**: Define comportamiento base para Stack y List

## Ejemplo de Uso
```java
// Obtener instancia de Calculator
Calculator calc = Calculator.getInstance();

// Leer expresión del archivo
String infix = FileReader.readExpression();

// Convertir a postfix y evaluar
String postfix = calc.convertToPostfix(infix);
double result = calc.evaluatePostfix(postfix);
```

## Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── ht4/
│   │       ├── calculator/     [FATIMA]
│   │       ├── stack/         [EMILIO]
│   │       ├── list/          [ARTURO]
│   │       ├── factory/       [COMPARTIDO]
│   │       └── utils/         [COMPARTIDO]
│   └── resources/
│       └── datos.txt
└── test/
    └── java/                  [CADA UNO SUS PRUEBAS]
```


