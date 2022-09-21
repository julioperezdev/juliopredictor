# juliopredictor

go to juliopredictor directory

execute script docker-compose up -d .

try to execute this script to connect to database using 

docker exec -it juliopredictorcom_juliopredictor-database_1 psql -U juliopredictor

if has error message similar like 

psql: error: connection to server on socket "/var/run/postgresql/.s.PGSQL.5432" failed: FATAL:  database "juliopredictor" does not exist

try to re execute 1 minute them, the reason is that docker database container is starting and has don't been completed the process

when the container has ready, you can see that can use the postgres console like this

juliopredictor=#

now, to use the application we need insert a user role because Juliopredictor use JWT as security method

please, write this query

INSERT INTO USER_ROL (ID,DESCRIPTION) VALUES (1,'USER');

and them only need exit the console using this command

\q    or  exit

now, you are ready to use juliopredictor



if you want to use SQL client you can connect with 
user: juliopredictor
password: openSourcePassword
