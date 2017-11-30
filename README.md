# Challenge para postulantes a Agile Ingeniería y Consultoría

El challenge consiste en crear una aplicación WEB el cual a través de un Web Service se pueda realizar operaciones de persistencia y consulta de datos. La aplicación Web debe ser implementado en Spring Framework y su esquema base se encuentra disponible en Github desde el siguiente link:

https://github.com/agiledevcl/challenge2017

El challenge está compuesto por dos proyectos maven, llamados ch01 y ch02, en donde la única diferencia entre ambas consiste en que ch01 expone una API REST sin autenticación y el ch02 la API está protegida bajo el estándar OAuth2. 

## Objetivo principal

El objetivo principal es implementar en uno de ambos challenger (a elección del postulante) una interfaz Web que pueda consumir la API REST que expone la misma aplicación y pueda realizar operaciones de persistencia de datos y consultas en base de datos. 

## Requerimientos mínimos a cumplir

Los requerimientos mínimos para cumplir el challenge son:

* Utilizar uno de ambos challenge ch01 o ch02 construidos bajo Spring Boot.
* Utilizar GIT para el versionamiento del proyecto y utilizar GitHub como repositorio en la nube.
* En el back-end:
    * Utilizar como servidor de aplicaciones Apache Tomcat 8 o superior.
	* Utilizar una base de datos a elección (PostgreSQL, MySQL|MariaDB, Oracle, MongoDB, etc.).
	* Utilizar un ORM a elección (Hibernate, JPA, etc.).
	* Utilizar el modelo MVC de Spring Framework.
	* Crear un CRUD de datos en la API bajo el estándar REST.
* En el front-end:
	* Utilizar cualquier framework de estilos (Bootstrap, Material Design, etc).
	* En javascript utilizar el framework AngularJS para el manejo de los datos y consultas a la API REST del back-end.
* Documentar los métodos de la API REST (Postman, Apiary, etc.).
* Crear un README.md indicando:
    * Documentación de los métodos de la API REST.
    * Frameworks o motores utilizados en la aplicación Web (base de datos, ORM, framework de estilo, etc.).
    * Instrucciones o comentarios para levantar la aplicación.
	
## Entrega del challenge

Una vez que el postulante finalice el proyecto, este se debe enviar un mail a dev@agile.cl indicando lo siguiente:

* URI de GitHub del proyecto.
* El challenge realizado (ch01 o ch02).

Ante cualquier duda envíanos tus consultas a dev@agile.cl.
