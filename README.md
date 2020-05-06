# Bus Signalization System
Bus Signalize Project

## Services
* [Line Service](#line-service)
* [Station Service](#station-service)
* [Garage Service](#station-service)
* [Rule Service](#rule-service)
* [Vehicle Service](#vehicle-service)
* [Vehicle Auth Service](#vehicle-auth-service)
* [User Auth Service](#user-auth-service)


### Line Service

This service for manager and organizer for top of signalization service. 

### Station Service

This service for take passenger count,density from physical station and send the vehicle data to physical station. So it means digital twin of physical station.

### Garage Service

This service for manage and extract the vehicle from physical garage. It can be monitor from line managers.

### Rule Service

This service for dynamic line management. With this service signalization system can make decisions for vehicle extraction and resolve station density problems.

### Vehicle Service

This service contains immutable vehicle data like seat count, brand, model, production year etc.

### Vehicle Auth Service

This service for authenticate the vehicle that connect to signalization service.

### User Auth Service

This service for authenticate user who manage and monitor line service


## About Architecture

* Controller : Service endpoints includes.
* Service : Base logical operations doing this place.
* Delegate Service : Communicate with inter services.
* Repository : Just database operations (create/update/delete) doing in this place.
* Model
    * Entity : Database objects.
    * Request : Endpoint request body objects.
    * Response : Service response body objects about operations.
    * Value : Inner service data transfer object. It does not use for request or response.
    
    
    
### MQTT Requests

#### Vehicle

* Retrieve data from vehicle

| Type      | Topic | Id           | Result URI
| --------- | ----- | ------------ | ------------------
| subscribe | vhc   | navigationId | /vhc/:navigationId


* Send road data to vehicle

| Type    | Topic | Id           | Result URI         |
| ------- | ----- | ------------ | ------------------ |
| publish | vhc   | navigationId | /vhc/:navigationId |

Request Body

```json
{
	"speed":50,
	"state":"CREATED | ON_FAILURE | ON_STATION | ON_WAIT | ON_ROAD",
	"time":"2020-01-01T10:10:01.100101",
	"latitude":39.586472,
	"longitude":26.808359
}
```

#### Station

```in-progress```