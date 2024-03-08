# Proyecto-1: Grafos con relaciones de amistad en una red social
Grupo conformado por Maria Daniela Cuervo, Anabella Jaua y Alexandra Lecuna

Contexto preliminar:

En el siguiente proyecto, usted tendrá que realizar una investigación documental que le permita obtener información sobre el contexto del problema. En tal sentido, se sugiere que comience por realizar la siguiente lectura relativa a grafos, pero tome en cuenta que es solo un recurso inicial que debe ser complementado con la búsqueda autónoma de información por parte de los integrantes del equipo de trabajo:
https://drive.google.com/file/d/1Q65Rh-Tx6qwJODUlsmWVfw_-bzqttwiI/view?usp=sharing

Problema:

En el ámbito de los grafos, puede usted conseguirse con el término “Isla”, el cual indica la presencia de nodos que están agrupados, es decir, enlazados entre sí, pero aislados de otros conglomerados de nodos. Pueden entonces existir varias islas en un conjunto de datos que representan un grafo, es decir, al ser construida una representación visual de los datos, se pueden identificar sub grafos que, entre sí, no están conectados. La figura 1 es un ejemplo de lo antes mencionado. El concepto anterior puede ser utilizado para el análisis de datos en las redes sociales. Si cada usuario es representado por un nodo y la relación de amistad entre los usuarios es representada por un arco (camino de un nodo a otro), entonces un investigador puede identificar grupos de usuarios que forman islas (subgrupos o comunidades). Su equipo de trabajo deberá desarrollar una aplicación en Java que reciba del usuario un conjunto de datos relativos a una red social y generar, tras su procesamiento, información relativa a los distintos grupos existentes, si los hubiera. 

Requerimientos funcionales

- Cargar archivo: El usuario puede seleccionar a través de JFileChooser un archivo txt (archivo de texto plano) para ser cargado en el sistema, el cual contará con la información necesaria para la creación del grafo,  es decir: usuarios y relaciones de amistad. Cuando el usuario cargue un nuevo archivo, el sistema debe enviar un mensaje de alerta indicando al usuario la necesidad de guardar los datos actualmente cargados en memoria. La estructura del archivo de datos (archivo de texto plano) se indicará posteriormente.

- Actualizar repositorio:  Esta función permitirá que la información cargada en memoria, referente a los usuarios y sus relaciones de amistad, sea actualizada en el repositorio. Es decir, los cambios realizados en cualquiera de estos deben actualizarse en el archivo texto de tal forma que cuando se vuelva a cargar ese archivo contenga  todos los cambios realizados. Al iniciarse el programa por primera vez debe cargarse el archivo de texto dado al final del enunciado (debe de mantener el mismo formato).

- Mostrar grafo: El sistema deberá mostrar una representación visual del grafo según la información contenida en la memoria, es decir, las relaciones entre los usuarios y su información. Si existen islas, entonces deberá mostrar tales islas de manera gráfica, mostrando los valores de los nodos y de los arcos.

- Mostrar la cantidad de Islas: que se obtendrá mediante el recorrido en anchura (BFS) o el recorrido de profundidad (DFS). El usuario podrá seleccionar entre los dos métodos. 

- Identificación de puentes: un arco es un puente si al ser removido del grafo original, aumenta la cantidad de componentes (islas) desconectados. Esta función debe indicar en pantalla una lista de los puentes presentes en el grafo general. En el caso que nos atañe, Esta funcionalidad equivale a identificar a aquellos usuarios que son enlaces entre subgrupos o subcomunidades.

- Modificar grafo:  el usuario podrá seleccionar usuarios para ser eliminados. De igual forma, el usuario podrá agregar un nuevo usuario, indicando la relación que tenga con otros usuarios dentro del grafo.


Requerimientos técnicos

- La solución debe ser implementada con base en un grafo, que a su vez puede ser implementado mediante una matriz de adyacencia o una lista de adyacencia.
- Puede utilizar cualquier otra estructura auxiliar de ser necesario. Sin embargo, NO podrá utilizar librerías para la implementación del tipo de dato abstracto, solo podrá utilizar librerías para lo relativo a la representación gráfica del grafo.
- El programa debe poder representar el grafo correspondiente de manera gráfica. 
- La aplicación debe ofrecer una interfaz gráfica al usuario.
- El programa debe poder cargar un archivo de texto para la lectura de datos. Para ello, es requerido el uso del componente JFileChooser.
- Debe documentar el proyecto con Javadoc.
- Junto al programa, cada equipo deberá presentar un Diagrama de clases (arquitectura detallada) que explique la solución obtenida.  
- La estructura de los archivos es la siguiente: para la sección de los usuarios, el primer campo es el ID, el segundo es el usuario. Para la sección de relaciones (de amistad), los campos son usuario1, usuario2, tiempo de amistad. El grafo no es dirigido.


Se muestra a continuación un ejemplo de la estructura del archivo de texto plano que deberá cargar el programa. 
Archivo de texto
Usuarios
121, @Pepe_Gónzales
254, @StephaniaCominos
365, @AndreaStanislao
412, @Josefina_La_Sifrina
512, @RosaMosa
231, @EduardoPetardo
123, @EnriqueManrique
129, @casanova23
870, @venepositivo
758, @yosoylatorre
578, @pitiypo
909, @obiwan123
893, @caribu_sol
467, @trapos232
788, @bandido121
239, @justiciero11
443, @fuerza_bruta
907, @Presentesiempre
Relaciones
121, 254, 7
121, 909, 8
254,909,5
909, 893, 5
254, 893, 1
893, 129, 3
129, 512, 10
512, 412, 2
893, 412, 4
231, 870, 5
231, 123, 1
123, 870, 15
123, 467, 6
788, 239, 7
788, 443, 11
239, 443, 6
239, 907, 3
443, 907, 9
788, 412, 7
870, 578, 7
870, 758, 1
758, 365, 9
578, 365, 4
