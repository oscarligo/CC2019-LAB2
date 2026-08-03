# Teoría de la Computación - Laboratorio No. 2

## Problema No. 2 - Algoritmo para balancear expresiones infix

Programa en Java que verifica si las expresiones de un archivo de texto están balanceadas.

## Funciones

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
