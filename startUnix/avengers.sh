#!/bin/sh
#Mongo connection.
sudo service mongod start

cd..

#Maven con path
mvn spring-boot:run

#Maven sin path
#/home/gvalencia/Descargas/apache-maven-3.6.0/bin/mvn spring-boot:run
