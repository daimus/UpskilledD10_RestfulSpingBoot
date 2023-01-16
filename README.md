# Restful Spring Boot
Aplikasi ini digunakan untuk mengirim/menerima pesan (kritik,saran,review dlsb) baik secara anonymous maupun terbuka.

## Installation
Clone repository
```
git clone https://github.com/daimus/UpskilledD10_RestfulSpingBoot
```
Running the app
```
./mvnw spring-boot:run
or
./gradlew bootRun
```
Build
```
./mvnw build
or
./gradlew build
```
## Docker
```dockerfile
docker build -t restful-springboot .
docker run -p 8080:8080 restful-springboot
```
## API Documentation
[http://**[HOST]**:**[PORT]**/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Demo
[http://103.30.194.137:8080/swagger-ui.html](https://api-rahasia.daimus.id/swagger-ui.html)