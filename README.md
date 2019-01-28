# examendivv
Solución propuesta al examen APIMarvel por Diego Iván Valencia Velázquez.

#Tecnologías
- Java 8.
- Spring Boot.
- Maven (Debe estar integrado al PATH).
- MongoDB.

#Instrucciones
1. Ejecutar el archivo assemble.sh
2. Ejecutar el archivo avengers.sh (levantará mongo como servicio).
3. Ingresar a
    http://localhost:8080/marvel/colaborators/ironman
    http://localhost:8080/marvel/colaborators/capamerica
    http://localhost:8080/marvel/characters/ironman
    http://localhost:8080/marvel/characters/capamerica

4. El desarrollo tiene incorporado un mecanismo de seguridad provisto por "Spring Security".
En la consola de maven aparecerá la clave de acceso al API con una cadena de texto similar a
"Using generated security password: 859de41c-c9b1-4c8f-b4d8-ed5ec2ee2003".

U: user
P: la generada por spring security y que se muestra a través de la consola de maven.

#Notas
1. El sistema operativo donde se ejecute debe estar basado en Unix.
2. Si Maven no está integrado al PATH, se debe descargar de la página oficial y modificar en los archivos "assemble.sh" y "avengers.sh" la ruta en donde está contenida la carpeta "bin".
