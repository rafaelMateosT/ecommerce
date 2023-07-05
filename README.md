# ecommerce

Servicio eccomerce con el siguiente enunciado:
LEER resources/TestJava2020.txt

## Ejecutar el servicio

### Puerto de arranque
Este servicio correra en el puerto 8080

### CURL EJEMPLO

```
curl --location 'http://localhost:8080/product/price' \
--header 'Content-Type: application/json' \
--data '{
    "brandId": 1,
    "productId": 35455,
    "currentDate": "2020-06-14T10:00:00"
}'
```
### Requisitos
- Java 17
- Maven

### INTELLIJ
Este proyecto ha sido desarrollado con INTELLIJ. Puedes abrir el proyecto con intellij y ejecutarlo sin problema.
Debes tener instalado Java 17.


### Ejecutar desde Maven
mvn spring-boot:run

### Test desde Maven
mvn test

## Documentacion Swagger
Puedes acceder a la documentación generada con swagger en http://localhost:8080/swagger-ui.html

## TEST POSTMAN
He generado una coleccion de postman que puede ser importada en la herramienta con los 5 casos de uso definidos en la prueba técnica.
Se encuentra en resources/postman/ECOMMERCE.postman_collection.js
