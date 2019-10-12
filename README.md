Git: https://git-scm.com/download/win
Docker: https://docs.docker.com/docker-for-windows/install/ (needs account)
Java: https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html (needs account)
IntelliJ: https://www.jetbrains.com/idea/

In command line start db: docker-compose up
Database: localhost:5432/postgres postgres/postgres

SQL:
CREATE TABLE customer (
                          CUST_ID Bigserial PRIMARY KEY NOT NULL,
                          NAME varchar(100) NOT NULL,
                          AGE smallint NOT NULL
);

Add
curl -X POST "localhost:8080/customers?name=john&age=30"

Query all
curl "localhost:8080/customers"
