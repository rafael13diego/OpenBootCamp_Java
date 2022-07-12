# JWT
### https://jwt.io

Es un estándar que permite transmitir información
entre 2 partes:

## Funcionamiento Session

1. Cliente envía una petición a un servidor (/api/login)
2. Servidor valida el username y pwd, si no son validos devolverá  401 unauth
3. Servidor valida el username y pwd, si son validos, genera token JWT utilizando una secret key

## Desventajas:

* La información de la session se almacena en el servidor, lo que consume recursos.

## Funcionamiento JWT

1. Cliente envia un request -> servidor (/api/login)
2. Servidor valida el username y pwd, si no son validos devolverá  401 unauth
3. Servidor valida el username y pwd, si son validos, genera token JWT utilizando una secret key
4. Servidor devuelve el token JWT al Cliente
5. Cliente envía peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras

### Ventajas:
* El token se almacena en el Cliente, de manera que consume menos recursos del servidor, lo cual permite esacalabilidad

### Desventajas:
* El token está en el browser, no se puede invalidar antes de la fecha de expiración asignada se creó.
* Lo que se realiza es dar la opción de logout, para quitar el token.

## Estructura de JWT

3 partes separadas por un punto "." y codificadas en b64 en cada una:

1. Header
```json
{
    "alg":"HS515",
    "typ": "JWT"
}
    
```
2. Payload (Información, datos del user, no sensibles)
```json
{
    "name":"aadd",
    "admin": true
}
    
```
3. Signatura (Algoritmo)
```
HACKSHA256(
base64UrlEnconde(header) + "." + base64UrlEnconde(payload), secret
)
```
Ejemplo del token generado:
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```
El User-Agent envia el token JWT en las cabeceras:
```
Authorization: Bearer {token}
```

## Configuracion Spring
Crear project Spring boot con:
* Spring security
* Spring web
* Spring boot DevTools
* Spring Data JPA
* PostgreSQL
* Dependendencia JWT (manual)
```xml
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>

```