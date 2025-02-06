# NthMaxFinder  

## How to Run 

### Launch from cmd
* Clone this repository 
* Open cmd, go to the project folder
* Enter "mvn exec:java -Dexec.mainClass="com.NthMaxFinder.NThMaximumFinderApplication"

### Launch from ide
* Clone this repository
* Open Idea 
* Сomplete maven compile and run

## Use cases

### Swagger
* Open http://localhost:8080/swagger-ui/
* Select an available endpoint 
* Edit filePath and n variables 
* Execute

### Postman
* Create new POST request
* Add http://localhost:8080/api/maxNumber/fetch
* Add raw body like 
```
{
    "filePath": "G:/Downloads/NNN.xlsx",
    "n": 1
}
```


