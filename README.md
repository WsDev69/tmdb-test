#Test application 

###Features  implemented:

* API for add favorite actors for user
* API for delete favorite actors for user
* API for mark watched shows for user
* API for un marking watched shows for user
* API for getting unwatched tv shows with favorite actors for user
    
###Application use h2 DB
#### App db init sql
~~~h2 
CREATE TABLE account
(
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(250) DEFAULT NULL
);
~~~
~~~h2 
CREATE TABLE actor
(
    actor_id   INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50)
);
~~~
~~~h2 
CREATE TABLE movie
(
    movie_id    INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL
);
~~~
~~~h2 
CREATE TABLE watch_movie
(
    movie_id INT NOT NULL,
    user_id  INT NOT NULL
);
~~~
~~~h2 
CREATE TABLE favorite_actor
(
    actor_id INT NOT NULL,
    user_id  INT NOT NULL
);
~~~
~~~h2
ALTER TABLE watch_movie
    ADD FOREIGN KEY (movie_id)
        REFERENCES movie (movie_id);

ALTER TABLE watch_movie
    ADD FOREIGN KEY (user_id)
        REFERENCES account (account_id);

ALTER TABLE movie_actor
    ADD FOREIGN KEY (movie_id)
        REFERENCES movie (movie_id);

ALTER TABLE movie_actor
    ADD FOREIGN KEY (actor_id)
        REFERENCES actor (actor_id);
~~~

###Building the project
####Project base on
    spring framework 5.2 
    java 11
####Including tests
~~~bash
mvn clean package
~~~
####Exclude tests
~~~bash
mvn clean package -DskipTests
~~~

### Run project
After building run commands bellow
~~~bash
chmod u+x scripts/start.sh
./scripts/start.sh
~~~
Without building use command
~~~bash
mvn spring-boot:run
~~~

###Docker
####Build 
~~~bash
docker build -t tmdb:v1 . 
~~~
####Run
~~~bash
docker run -d -p 8080:8080  tmdb:v1
~~~

###For test API
Import ```scripts/tmdb_api.json``` into Postman
 





 
