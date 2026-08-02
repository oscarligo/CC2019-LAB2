# Teoría de la Computación - Laboratorio No. 2

## Problema No. 2 - Algoritmo para balancear expresiones infix

Programa en Java que verifica si las expresiones de un archivo de texto están balanceadas.

## Funciones del problema 2

- Lee y procesa el archivo línea por línea.
- Valida paréntesis `()`, corchetes `[]` y llaves `{}`.
- Usa una pila para respetar el orden de apertura y cierre.
- Muestra cada operación de la pila: `push`, `pop` o `mismatch`.
- Indica si cada expresión está bien formada.
- Ignora espacios en blanco.

Por defecto se procesa `input.txt`. También se puede indicar otro archivo:

## Formato de entrada

Cada línea debe contener una expresión independiente:

```text
(a+b)*(c-d)
([a+b]*{c-d})
(a+b]
```

Las dos primeras expresiones están balanceadas, la última no lo está.

## Problema No. 3 - Algoritmo Shunting Yard

### Investigación

El algoritmo **Shunting Yard** fue propuesto por Edsger W. Dijkstra durante
el desarrollo de un traductor para ALGOL 60. Su objetivo es transformar una
expresión infix, donde los operadores aparecen entre operandos, en una
expresión postfix, donde cada operador aparece después de sus operandos
(Dijkstra, 1961).

El algoritmo recorre la expresión una sola vez y utiliza dos estructuras:

1. Una lista de salida, que recibe los operandos inmediatamente.
2. Una pila, que guarda temporalmente operadores y paréntesis.

Cuando se encuentra un operador, se retiran primero los operadores de mayor
o igual precedencia que ya están en la pila. Un paréntesis de apertura se
apila; uno de cierre mueve operadores a la salida hasta encontrar su apertura.
Al terminar la entrada, los operadores restantes pasan a la salida.

Para expresiones regulares, `*`, `+` y `?` son operadores postfix; la
concatenación tiene la siguiente precedencia y `|` tiene la menor. `R+`
significa una o más repeticiones y se convierte en `RR*`; `R?` significa cero
o una repetición y se convierte en `R|ε` (Oracle, s. f.-a). Los caracteres
precedidos por `\` se procesan como un solo operando escapado
(Oracle, s. f.-b).

La implementación usa `·` para mostrar la concatenación que agrega
automáticamente. El carácter `.` escrito en el archivo se conserva como parte
de la expresión.

### Funciones del problema 3

- Lee una expresión regular por cada línea de `regex.txt`.
- Convierte la expresión de infix a postfix con Shunting Yard.
- Muestra, para cada token, la salida y el estado de la pila.
- Procesa literales, `ε`, grupos, alternancia y clases como `[ae]`.
- Inserta concatenaciones implícitas usando `·`.
- Convierte `+` y `?` a operaciones básicas con `*`, `|` y `ε`.
- Reconoce caracteres escapados y rechaza un `\` incompleto.
- Reporta paréntesis, clases y operadores inválidos sin detener las demás líneas.

### Ejecución del problema 3

```bash
javac Main.java InfixBalancer.java ShuntingYard.java
java Main postfix regex.txt
```

El archivo es opcional; sin argumento se utiliza `regex.txt`:

```bash
java Main postfix
```

La comprobación mínima se ejecuta desde el mismo `Main`:

```bash
java Main test
```

### Precedencia utilizada

| Prioridad | Operadores | Función |
| --- | --- | --- |
| 1, mayor | `*`, `+`, `?` | Repetición u opción postfix |
| 2 | `·` | Concatenación insertada automáticamente |
| 3, menor | `|` | Alternancia |

## Referencias

Dijkstra, E. W. (1961). *Algol 60 translation: An Algol 60 translator for
the X1 and making a translator for Algol 60* (Reporte No. 35). Mathematisch
Centrum. https://www.cs.utexas.edu/~EWD/MCReps/MR35.PDF

Oracle. (s. f.-a). *Pattern (Java Platform SE 8).* Java Platform, Standard
Edition 8 API Specification. Recuperado el 2 de agosto de 2026, de
https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

Oracle. (s. f.-b). *String literals.* The Java Tutorials. Recuperado el 2 de
agosto de 2026, de
https://docs.oracle.com/javase/tutorial/essential/regex/literals.html
