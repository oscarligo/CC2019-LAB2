# Teoría de la Computación - Laboratorio No. 2

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
significa una o más repeticiones y `R?` significa cero o una repetición
(Oracle, s. f.-a). Los caracteres
precedidos por `\` se procesan como un solo operando escapado
(Oracle, s. f.-b).

La implementación usa `·` para mostrar la concatenación que agrega
automáticamente. El carácter `.` escrito en el archivo se conserva como parte
de la expresión.

### Funciones del problema 3

- Lee una expresión regular por cada línea de `regex.txt`.
- Convierte la expresión de infix a postfix con Shunting Yard.
- Muestra, para cada token, la salida y el estado de la pila.
- Expande clases como `[ae]` a `(a|e)` antes de convertirlas.
- Inserta concatenaciones implícitas usando `·`.
- Conserva `*`, `+` y `?` como operadores postfix.
- Reconoce caracteres escapados y rechaza un `\` incompleto.
- Reporta paréntesis, clases y operadores inválidos sin detener las demás líneas.

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
