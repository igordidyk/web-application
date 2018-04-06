# Web-application
***
### Description
This web application is test project with several tasks. 
Tasks  (each  task has endpoint): 
* Create basic CRUD (create/read/update/delete) for all tables 
    * Show authors which are older 55 years old and sort them by `born` column 
    * Return books whose author has more than 1 written books 
    * Find out author which has most books 
    * Calculate number of books by genre
#### Pre-requirements:
* Java 8
* MySQL
* Hibernate/JPA
* Spring MVC
#### Data structure:
* Books (id, name, published, genre, rating)
* Authors (id, name, gender, born)
* Book-Author (id, book-id,  author-id)

#### How to start up ?
    1. git clone
    2. create database:
        CREATE DATABASE testDb
          DEFAULT CHARACTER SET utf8
          DEFAULT COLLATE utf8_general_ci;
#### After that you can start project in IDE:
    3. build project with maven:
        mvn package
    4. deploy war file on server (Apache Tomcat)
        






