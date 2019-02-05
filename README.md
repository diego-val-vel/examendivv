# examendivv
Solución propuesta al examen APIMarvel por Diego Iván Valencia Velázquez.

#Tecnologías
- Java 8.
- Spring Boot.
- Maven (Debe estar integrado al PATH).
- MongoDB.

#Instrucciones
0. Situarse en la carpeta "startUnix" o "startWindows" dependiendo del sistema operativo.
1. Ejecutar el archivo batch "assemble".
2. Ejecutar el archivo batch "avengers".
3. Ingresar a alguna de las siguientes URL para probar los servicios:

	- http://localhost:8080/marvel/colaborators/ironman
	- http://localhost:8080/marvel/colaborators/capamerica
	- http://localhost:8080/marvel/characters/ironman
	- http://localhost:8080/marvel/characters/capamerica

4. El desarrollo tiene incorporado un mecanismo de seguridad provisto por "Spring Security".
   En la consola de maven aparecerá la clave de acceso al API con una cadena de texto similar a
   "Using generated security password: 859de41c-c9b1-4c8f-b4d8-ed5ec2ee2003".

	- Usser: user
	- Password: la generada por spring security y que se muestra a través de la consola de maven.

#Notas
1. El sistema operativo donde se ejecute debe estar basado en Unix o Windows.
2. Si Maven no está integrado al PATH, se debe descargar de la página oficial y modificar en los archivos "assemble" y "avengers" la ruta de la carpeta "bin".
