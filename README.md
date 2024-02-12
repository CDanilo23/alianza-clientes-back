## Tencnologías:
- Java version: 1.8
- Gradle version: 6.8.3
- Spring Boot version: 2.2.1.RELEASE

## Especificaciones técnicas
1. La base de datos esta en memoria, en el archivo application.properties se encuentra la configuración del motor H2.
2. La aplicacion corre por el puerto 8000

## Especificaciones funcionales

1. Al levantar la aplicacion ya estan precargados 3 clientes.

## API

1. Los endPoints expuestos son:
## POST http://localhost:8000/client
## GET http://localhost:8000/client

* Datos de prueba para el POST
  
{
  "id": "4",
  "sharedKey":"cordonez",
  "name": "cristian",
  "lastName": "ordonez",
  "email": "cris@hotmail.com",
  "phone":"657827261",
  "startDate": "2023-12-20",
  "endDate": "2024-03-20"
}

## TEST

* Las pruebas estan en el directorio: src/test/java/
