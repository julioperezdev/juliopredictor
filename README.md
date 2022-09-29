# Juliopredictor: Hola Mundo Challenge

## What is this? Why?

Juliopredictor is a Web Application by [@Julioperez.dev](https://www.instagram.com/julioperez.dev) with the original intentions to develop DDD Architechture using Java with Spring Boot for the Backend, also use ReactJS with Typescript to the Frontend and use PostgreSQL to the Database, each environment we use Docker to build a containers to make a easy steps to test Juliopredictor in a local environment. At the same time, make something that could be shared and used to share knowledge about programming.  

This Webapp predicts cryptocurrency trends using a own algorithm explained in the **predictor algorithm section**. 

## Project status
This project is in DEVELOPMENT currently undergoing tests.

## Instructions

### Requirements

Before to use Juliopredictor in your local environment a PC need to have the following installations:

* Git
* Docker
* Docker Compose
* Web Browser (Google Chrome, Safari, Mozilla, etc)
* The Ports 8080, 5432, 3000 must be free to use (if dont know how kill ports, please use this script in the terminal) 

```
kill $(lsof -t -i:8080)
kill $(lsof -t -i:5432)
kill $(lsof -t -i:3000)
```

### After to clone project

**1 -** Go to **Juliopredictor** root directory

**2 -** Execute the following script:

```
docker-compose up -d
```
**3 -** Execute the following script to connect to database:

```
docker exec -it juliopredictorcom-juliopredictor-database-1 psql -U juliopredictor
```

*Observation: if has error message similar like:*

```
psql: error: connection to server on socket "/var/run/postgresql/.s.PGSQL.5432" failed: FATAL: database "juliopredictor" does not exist
```

*try to run them again in 1 minute, the reason is that the docker database container is starting up and the process has not been completed*

**4 -** When the container has ready, you will see that you can use the postgres console like this:

```
juliopredictor=#
```

**5 -** Now, to use the application we need insert a user role because Juliopredictor use JWT as security method, please write the following query:

```
INSERT INTO USER_ROL (ID,DESCRIPTION) VALUES (1,'USER');
```
*Observation: Juliopredictor use ORM that have configuration that build tables by default from the Models of Backend*

**6 -** Them to execute the query only need exit of the console using the following command:

```
\q
```
or

```
exit
```

**... Now, you are ready to use Juliopredictor**

**7 -** Go to http://localhost:3000 using any web navigator to use Juliopredictor


## Additional information

- If you want to use SQL client, you can connect with the following credentials

	```
	user: juliopredictor 
	password: openSourcePassword
	```
- The credentials to SMTP protocol was bougth with knowledge that everyone can see the data, this email accound will be deleted the first day of 2023, so if you want to use email functionality in Juliopredictor you need to use your own email with SMTP protocol. 
password: openSourcePassword
