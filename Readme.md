# In Memory Key Pair Store By Sajal
## About
This is a Springboot application, running on tomcat server
It is running on Java 8.

With the application you can store key(String) Value(Integer) using the Rest APIs
Currently 3 Apis are available
-   Get - http://localhost:8080/api/v1/get/value/{Key}
-   GET - http://localhost:8080/api/v1/get/average
-   POST - http://localhost:8080/api/v1/create


## Features

-The Lifetime of a keyvalue in memory is configurable, by setting the desired value on application.properties file.
-Currently it can hold 1000 key value pairs, but it is configurable as well.
-Currenlty it can hold a key value for a max of 1 hour, but that is configurable as well using the cache.ccf file.

## API (Example)
POST
http://localhost:8080/api/v1/create/
{
  "key": "sajal",
  "value": 1994
}


GET
http://localhost:8080/api/v1/get/value/sajal
Response
{
"objectCreatingTime": 1626748978593,
"value": 1994
}