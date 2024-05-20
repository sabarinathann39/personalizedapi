# personalizedapi
Kindly follow the below steps to start the application

1. Navigate and go inside the Root folder of the "presonalizedservice" application  <br />
2.execute 'mvn clean package skip test' to create a jar file for the application  <br />
3.execute 'docker compose up' to start the dependent services(postgres,redis)  <br />
4.To start the personalized service application, we have two ways  <br />
  a) execute  'java -jar target/personalizedservice-0.0.1-SNAPSHOT.jar' to start the application  <br />
  or  <br />
  b) can also build the docker image and start as an application  <br />



#End points  <br />
A)To save the meta data  <br />
POST http://localhost:8080/internal/v1/product/metadata  <br />
B)To save  shopper product  <br />
POST http://localhost:8080/internal/v1/shopper/product  <br />
C)To Get Shopper Product  <br />
http://localhost:8080/external/v1/{$shopperid}/product?brand={$brandname}&category={$categoryname}&offset={$offset}&limit={$limit}  <br />

#Performance consideration:  <br />

1.using Ratelimiter to make sure the application does not egt overwhelmed by too many request  <br />
2. reading from redis cache if the requested data is already available(more performant)  <br />



