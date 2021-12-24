# EVALUACIÓN INICIAL - CURSO 2021/22

Posible solución a la prueba de Evaluación Inicial para el módulo Desarrollo Web en Entorno Servidor perteneciente al CFGS Desarrollo de Aplicaciones Web del [IES Alixar](www.iesalixar.org).


Se pide al alumnado que, repasando los conceptos vistos en el módulo de Programación realice una aplicación Java de consola que:

* Acceda a una base de datos.
* Use el Patrón [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern) para la conexión a la base de datos.
* Use el Patrón [DAO](https://en.wikipedia.org/wiki/Data_access_object), con alguna operación elegida por el alumno, para trabajar con la base de datos.

Se recomienda usar Docker para la puesta en marcha del servidor de base de datos (mysql o mariabdb) y se propone el [siguiente archivo](mysqlsampledatabase.sql) para la creación de una base de datos rellena.

El profesor usará el cliente [mycli](https://www.mycli.net/) pero el alumnado puede elegir el cliente de base de datos que prefiera.

Si usamos docker el lanzamiento del servicio se realizará con una orden similar a la siguiente:

```sh
docker run -d -it --name bbdd -p 3336:3306 -e MYSQL_ROOT_PASSWORD=XXXXX mariadb
```


