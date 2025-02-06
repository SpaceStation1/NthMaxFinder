# NthMaxFinder  

## How to Run 

* Clone this repository 
* Open cmd, go to the project folder
* Enter "mvn exec:java -Dexec.mainClass="com.NthMaxFinder.NThMaximumFinderApplication"

### Launch from ide
* Clone this repository
* Open Idea 
* Сomplete maven compile and run

## Use cases

### Swagger
* open http://localhost:8080/swagger-ui/
* select an available endpoint 
* edit filePath and n variables 
* execute

### Postman
* create new POST request
* add http://localhost:8080/api/maxNumber/fetch
* add raw body like 
'''
{
    "filePath": "G:/Downloads/NNN.xlsx",
    "n": 1
}
'''


