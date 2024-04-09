```
  docker run --name pg1 -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydb -d postgres:15-alpine
```