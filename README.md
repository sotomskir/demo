# Demo

## uruchomienie aplikacji
`mvn spring-boot:run`

## przykładowe requesty
```
curl http://localhost:8080/api
curl http://localhost:8080/api?operator=sum
curl http://localhost:8080/api?operator=sub
curl http://localhost:8080/api?operator=sum&repositories=java-random,random.org
```
