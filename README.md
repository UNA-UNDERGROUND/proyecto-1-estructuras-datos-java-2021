# Proyecto 1 estructuras de datos Java
implementacion de una matriz en Java

## Diseño del proyecto

### sistema del proyecto

El proyecto usa como sistema de proyecto maven, debido a la simplesa al trabajar con varios IDEs o editores de texto.

Por ejemplo se pueden usar VSCode o Intellij IDEA e incluso eclipse,
mientras netbeans sigue usandolo sin agregar archivos adicionales,
permitiendo el nivel de compatibilidad ideal en el proyecto.

### JDK del proyecto

En cuanto al JDK se usa su version 16, ya que el JDK 8 esta declarado como obsoleto y los IDEs suelen proveer versiones mas nuevas.

### implementacion de pruebas

En cuanto a las pruebas se decidio realizar a diferencia de las pruebas clasicas en una
clase principal o en una interfaz grafica de manera manual optar por una alternativa mas 
automatizada, en este caso el uso de pruebas unitarias con pruebas que aislan los componentes principales.

Para esto se usa JUnit, a pesar de que existen otros frameworks de pruebas unitarias este
es el usado por defecto en la mayoría de proyectos Java, sumado a su simplicidad permite mas sencillo probar el funcionamiento correcto del proyecto.

### observaciones adicionales

Para aprovechar mas el uso de maven se utiliza JavaDoc y Junit integrados en el.

## Analisis de resultados

### estructura interna

La implementacion se realiza usando listas enlazadas debido a la especificacion
del proyecto,
sin embargo pueden existir estructuras mas optimas segun el caso de uso, por ejemplo un arreglo.

### optimizaciones fuera del alcance

Por otra parte la mayoría de la implementacion es un tiempo optimo el cual puede ser
mejorado mucho mas si se dispone de un acceso interno a las estructuras contenedoras,
por ejemplo si se pueden crear varios nodos para evitar navegar mas de lo necesario la
lista.

### Acceso a la memoria y arquitectura

Por ejemplo el tiempo de acceso de una lista enlazada a un elemento es O(n) mientras que un arreglo es O(1), en varias arquitecturas modernas estas implementan un cache para acelerar la velocidad de los datos, la cual la lista enlazada no garantiza tal continuidad por lo que la velocidad de esta suele ser inferior conforme crecen los datos, y estas operaciones de lectura suelen ser bastante intensivas por lo que es un posible punto de optimizacion prioritario el cual exede el objetivo de este proyecto.

### operaciones algebraicas

En cuanto a las operaciones todas ellas realizan copias como resultados, sin embargo
durante las operaciones se evitan varias copias de datos gracias a que java es un 
lenguaje con recolector de basura y trabaja de manera implicita punteros a las listas,
la mayoría de estas operaciones usan operaciones matematicas comunes y no tienen
optimizaciones para matrices específicas, (por ejemplo matrices nulas) para evitar
operaciones innecesarias, esto se debe a que no es una meta del proyecto sin embargo fue 
observado durante la creacion de este.

### Serializacion

Nuevamente hay varios posibles puntos de optimizacion, por ejemplo si se conociera el
tamaño previo de la lista o si los elementos de estos en el XML se encuentran organizados
se puede usar un arreglo y realizar la generacion de la matriz en un tiempo lineal

### Tipos Genericos

Para procesar correctamente el tipo generico se opta por la creacion de una clase estatica
con metodos para el manejo de tipos numericos, sin embargo esta castea internamente un 0
al tipo especifico, lo cual puede representar una pequeña penalizacion al rendimiento,
si existe una tecnica mejor para deducir el tipo a manejar se puede mejorar ligeramente
el rendimiento en secciones donde se hace uso de este

### Documentacion tecnica

JavaDoc permite el acceso interno a los comentarios del codigo para generar la documentacion, maven dispone de un target para generarla,
el cual es el siguente
> mvn javadoc:javadoc
