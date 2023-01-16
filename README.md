# Restful Spring Boot
Aplikasi ini digunakan untuk mengirim/menerima pesan secara anonymous.

## Installation
```
git clone https://github.com/daimus/UpskilledD10_RestfulSpingBoot

mvn spring-boot:run
or
gradle bootRun
```
## Docker
```dockerfile
docker build -t restful-springboot .
docker run -p 8080:8080 restful-springboot
```
## API Documentation
[http://**[HOST]**:**[PORT]**/swagger-ui.html](http://localhost:8080/swagger-ui.html)