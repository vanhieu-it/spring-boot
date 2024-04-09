# Docker – Running PostgreSQL as a container

1. PostgreSQL as a container
The below command starts PostgreSQL as a container.
```
docker run --name pg-container-name -p 8888:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydb -d postgres
```

The command breakdown:

- docker run – Create and run the container.
- --name pg-container-name – Set the container’s name.
- -p 8888:5432 – Set the port mapping. PostgreSQL database defaults expose port 5432, and this command maps the local port 8888 to the container port 5432 (inside Docker).
- -e – Set the environment variables.
- -e POSTGRES_USER=admin – Set the username for the PostgreSQL superuser.
- -e POSTGRES_PASSWORD=password – Set the password for the PostgreSQL superuser.
- -e POSTGRES_DB=mydb – Set the name of the database.
- -d – Run the container in a detached mode, which means it runs container in the background.
- postgres – This is the image name we want to pull from the Docker Hub (default). By default, the latest tag is used, which will get the latest version of PostgreSQL.

2. Specify the PostgreSQL version

```
docker run --name pg-container-name -p 8888:5432 -e POSTGRES_USER=mkyong -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydb -d postgres:12
```
3. Access the PostgreSQL Container

- docker exec and psql

```
docker exec -it pg-container-name psql -U admin -d mydb

psql (15.4 (Debian 15.4-1.pgdg120+1))
Type "help" for help.

mydb=#
```

4. PostgreSQL Container and Volume

For databases like PostgreSQL, it is essential to ensure data isn’t lost when the container is stopped or removed. Using Docker volumes, we can store data outside the container, ensuring it persists even if the container is removed.

4.1 Create a volume named postgres-volumn.

```
docker volume inspect postgres-volumn
```
```
[
    {
        "CreatedAt": "2023-09-06T02:27:59Z",
        "Driver": "local",
        "Labels": null,
        "Mountpoint": "/var/lib/docker/volumes/postgres-volumn/_data",
        "Name": "postgres-volumn",
        "Options": null,
        "Scope": "local"
    }
]
```
4.2 We can use -v to mount a volume to a directory inside the container.
```
 docker run -v postgres-volumn:/path/in/container my-image  
```

5. Access the PostgreSQL container log
```
  docker logs pg-container-name
```
6. Stop the PostgreSQL Container
```
  docker stop pg-container-name
```
7. Start the PostgreSQL Container again
```
  docker start pg-container-name
```
8. Removing the PostgreSQL Container
```
  docker rm pg-container-name
```