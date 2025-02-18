# HT4 - Calculadora Infix/Postfix

Implementación de una calculadora que convierte expresiones infix a postfix y las evalúa.

## Integrantes y Responsabilidades

- **Emilio**: Estructuras Base
  - Interfaz y clase abstracta de Stack
  - Implementación con ArrayList
  - Implementación con Vector

- **Fatima Navarro**: Lógica Principal
  - Calculadora (Singleton)
  - Conversión Infix a Postfix
  - Evaluación de expresiones
  - FileReader

- **Arturo**: Listas Enlazadas
  - Interfaz y clase abstracta de List 
  - Lista Simple
  - Lista Doble
  - Implementación de Stack usando List

## Estructura del Proyecto

src/
├── main/
│   ├── java/
│   │   └── ht4/
│   │       ├── calculator/          [FATIMA]
│   │       │   ├── Calculator.java
│   │       │   ├── Main.java
│   │       │   └── FileReader.java
│   │       │
│   │       ├── stack/              [EMILIO]
│   │       │   ├── IStack.java
│   │       │   ├── AbstractStack.java
│   │       │   ├── ArrayListStack.java
│   │       │   ├── VectorStack.java
│   │       │   └── ListStack.java
│   │       │
│   │       ├── list/               [ARTURO]
│   │       │   ├── IList.java
│   │       │   ├── AbstractList.java
│   │       │   ├── SingleLinkedList.java
│   │       │   └── DoubleLinkedList.java
│   │       │
│   │       ├── factory/            [COMPARTIDO]
│   │       │   ├── StackFactory.java
│   │       │   └── ListFactory.java
│   │       │
│   │       └── utils/              [COMPARTIDO]
│   │           └── Operator.java
│   │
│   └── resources/
│       └── datos.txt
└── test/
    └── java/                       [CADA UNO SUS PRUEBAS]
        ├── CalculatorTest.java     [FATIMA]
        ├── StackTest.java          [EMILIO]
        └── ListTest.java           [ARTURO]
