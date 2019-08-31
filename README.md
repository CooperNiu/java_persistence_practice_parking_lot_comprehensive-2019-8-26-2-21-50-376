## Requirement

- Please forked this repo for practice
- Read Stories and finish follow requirements
- Design your API list and put it to root folder - `API.text`, including the JSON data format, HTTP METHOD, URI as well as status code. You can try https://editor.swagger.io for API design
- Design your E-R diagram and put it to root folder `E-R.jpg`
- Complement the stories by following 3 layers architecture (controller-service-repository) 
- Write API testing via MockMVC
- Write `Repository` via mybatis testing starter (There is an example for repository, feel free to replace them with your testing)
- Write other unit testing if needed
- Your commit message MUST follow the semantic message rule

### Stores

#### Story 1

As a manager, I want to create and list all parking boys. So that I can find someone to park cars for the customer.

AC1. I should be able to create parking boy to the system. The parking boy contains the following information:
employeeID: The parkingBoy employeeID is a non-empty String representing the unique ID for a parking boy.

AC2. I should be able to list ALL the parking boys in the system. Each parking boy should include his employeeID.

#### Story 2

As a manager, I want to create and list all parking lots so that that parking boys can park cars into them.

AC1. I should be able to create a parking lot in the system. The parking lot contains the following information:
parkingLotID: The parking lot employeeID is a non-empty String representing the unique ID for a parking lot.
capacity: The capacity of the parking lot. It is an integer from 1 - 100.

AC2. I should be able to list ALL parking lots in the system. Each parking lot should contain its parkingLotID, availablePositionCount and capacity of each parking lot.

#### Story 3

As a manager, I would like to associate parking lots to parking boys so that the parking boy can park cars in parking lots.

AC1. I should be able to associate one or more parking lots to a parking boy. Note that each parking lot can only be associated with one parking boy.

AC2. I should be able to display the parking boy and his/her managed parking lots. The parking boy should contain his/her employeeID and the associated parking lots should include their parkingLotID.
 
##  Practice Output & Submit

- submit your git repo url to field `answer`

## Hint

- create `Entity` to present your data structure
- create `Repository` for MyBatis integration 
- create `Mapper` under resources package 
- write sql statements 
- use `Repository` for your business to access to database

## How to write semantic commit message 

```text
feat: add hat wobble
^--^  ^------------^
|     |
|     +-> Summary in present tense.
|
+-------> Type: chore, docs, feat, fix, refactor, style, or test.
```

## How to use H2

- `schema.sql` will be loaded and init database when application is starting
- navigate to web console`http://localhost:8080/h2-console`
- put `jdbc:h2:mem:tws_persistence_db` in `JDBC URL` field
