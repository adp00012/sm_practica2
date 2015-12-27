# sm_practica2
Practica 2 de Servicios Moviles

En la practica hemos realizado numerosas mejoras, ademas de en la practica 2 en si, tambien en lo que ya teniamos hecho de la practica 1:

-Eliminacion del imageButton de retroceso para ir al fragment anterior. Ya funciona con el boton fisico del dispositivo movil.
-Añadido un Scroll a todos los fragment para en caso de ejecutar la App en una pantalla demasiado pequeña, pueda desplazarse
sin perder nada de informacion que se muestra.
-Mejoras en el diseño de rotacion de pantalla
-Mantiene la informacion cuando se gira la pantalla

Con respecto a la practica 2:
-Comprobacion del estado de la red. En caso de no estar conectado a internet, se deshabilita el boton de login, no dejando utilizar
la app, ya que requiere de una coenxion a la red.
-Comprueba que la direccion IP y el puerto introducido, son "correctos". Es decir que no se introduzca como direccion algo que no
pueda ser valido (menos de 7 cifras, ya que como minimo 1.1.1.1 son 7 digitos) y el puerto debe ser superior a 0 digitos). En caso
de que pueda no ser valido, muestra una alerta al usuario, para que introduzca correctamente.
-Comprueba que el usuario y la contraseña estan registrados en la BD, de no ser asi, no da acceso al usuario.
-Una vez en el fragment de introduccion de vehiculos, comprueba que el numero de bastidor contiene 17 digitos (Es necesario que
contenga estrictamente 17 digitos, de no ser asi no deja registrar el vehiculo). De no ser correcto, actualiza el EditText dejandolo
en blanco para introducir otro numero.
-Si todo es correcto, el vehiculo se almacena en la base de datos, mostrando un Toast, indicando que se ha registrado correctamente.
En este caso actualiza el fragment para poder introducir otro vehiculo instantaneamente.

Se incluye el script de MySQL llamado matriculacion.sql en el que se incluyen las tablas de la BD, asi como dos usuarios registrados para poder probar la app.

Los usuarios son:  user: a.delgado pass: 123     y     user: c.maier pass: 987


Se ha actualizado el repositorio y hemos añadido a la aplicacion de android el manual de instrucciones que solicitaba el ejercio 3 de la asignatura.
Se han creado dos nuevos fragments uno para el manual en español y otro para el manual en ingles.
Para su acceso, se han colocado dos botones en el menu desplegable de la toolbar, llamados Ayuda (Instrucciones español) y 
Help (Instrucciones Ingles). El fragment incluye un WebView cada uno en el cual muestra la pagina web que hemos realizado.
La pagina web ha sido realizada con Responsive Design y con el patron Mobile First por lo que está bastante conseguida para
su visualizacion en el dispositivo Móvil. En el apartado de Recomendaciones de google play, incluimos un video del funcionamiento
de nuestra aplicación que hemos subido a youtube ya que el formato no era compatible con el reproductor de video que incorpora
html5.
