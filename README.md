# Sha256

## Background
This project is for first problem.Implemented both POST and GET methods.<br>
Apache Tomcat 9.0 is used in this project as server.

## Online Test
The service(named "sha") is deployed on GCP. The IP address for vm instance is [http://35.184.150.97](http://35.184.150.97). The sha service is in [http://35.184.150.97/sha](http://http://35.184.150.97/sha)
<br>

To test message function, for POST method, user can use following sh script:  

```sh
$ curl -X POST -H "Content-Type: application/json" -d '{"message": "foo"}' http://18.219.67.89/sha/messages
```

For GET method:

```sh
$ curl -I http://18.219.67.89/sha/messages/2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f9http://35.184.150.97/
```




## Local Test
There is a [sha.war](./war/sha.war) file located in the war folder. Users can copy this file to webapp folder under tomcat. Then restart the tomcat server. <br>

The end point of the test will be [http://localhost:8080/sha](http://localhost:8080/sha), where 8080 is the default tomcat port. Users may need to change port number if it is different from 8080.



## Analysis
This is single node service. The overwhelmed volume of requests could possibly lead  to server crash. The <code,messages> pair table can not be restored after restart of server, as there is no file or database system.<br>

To solve the problem and scale up the system, we can add more nodes to process the requests. For example, we may apply 26 machines to handle requests from 'a\*' to 'z\*' respectively. We also want to make this service stateless for concurrency safety.
