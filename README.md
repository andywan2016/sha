# Sha256

## Background
This project is for first problem.Implemented both POST and GET methods.<br>
Apache Tomcat 9.0 is used in this project as server.

## Online Test
The service(named "sha") is deployed on AWS ec2. The IP address for ec2 instance is [18.219.67.89](http://18.219.67.89). The sha service is in [18.219.67.89/sha](http://18.219.67.89/sha)
<br>
To test message function, for POST method, user can use following sh script:  

```sh
$ curl -X POST -H "Content-Type: application/json" -d '{"message": "foo"}' http://18.219.67.89/sha/messages
```




## Local Test
There is a [sha.war](./war/sha.war) file located in the war folder. Users can copy this file to webapp folder under tomcat. Then restart the tomcat server <br>

The end point of test will be [http://localhost:8080/sha](http://localhost:8080/sha). Where 8080 is the default tomcat port.User may need to change port number if it is different from 8080.



## Analysis
