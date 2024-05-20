# personalizedapi
Kindly follow the below steps to start the application

1. Navigate and go inside the Root folder of the "presonalizedservice" application
2.execute 'mvn clean package skip test' to create a jar file for the application
3.execute 'docker compose up' to start the dependent services(postgres,redis)
4.To start the personalized service application, we have two ways
  a) execute  'java -jar target/personalizedservice-0.0.1-SNAPSHOT.jar' to start the application
  or
  b) can also build the docker image and start as an application


#Performance consideration:

1.using Ratelimiter to make sure the application does not egt overwhelmed by too many request
2. reading from redis cache if the requested data is already available(more performant)



