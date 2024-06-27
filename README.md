Language version: Java 21
Builder: Maven 3.9.7
Spring Boot: 3.3.0
Database: Postgres 16.3
ORM (Hibernate): 5.6.15.Final
Additional: Spring Data JPA, PostgreSQL Driver

Project divides into "controllers" that (work with web)
and "common" that define entities

Requests:

    Add:

        host:port/(tarrifs, users, filials)

    Find:
    Uses object fields like filters for search
    (null fields will be ignored, instead of it use string "null")

        host:port/(tarrifs, users, filials)/find