# JavaSocketsExample

Ejemplo en Java de envío de una imagen `BufferedImage` a través de sockets.

Consiste de dos aplicaciones: Un servidor en `Server.java` y cliente en `Client.java`.

El servidor muestra una ventana (un `JFrame`) vacía al arrancar, abre un socket en el puerto `7777`.

El cliente abre el archivo `monalisa.jpeg` y lo envía por sockets al servidor.

El servidor muestra la imagen `monalista.jpeg` al recibirla.

## ¿Cómo ejecutar localmente?

1. Clona el repositorio localmente:

  `git clone git@github.com:gankbanger/JavaSocketsExample.git`

2. Compila el código:

  `javac *.java`

3. Ejecuta el servidor (`Server.java`) primero.

  `java Server`

4. Después de ver la ventana vacía en pantalla, ejecuta el cliente (`Client.java`)

  `java Client`
  
  pocos momentos después, la imagen `monalisa.jpeg` debe aparecer en la ventana abierta por el servidor.
