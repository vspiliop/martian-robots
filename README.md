## If you run via IntelliJ (or an IDE)

Install Lombok plugin. This is not required if you use maven to build and test.

## Build and run all unit tests

 - Install Maven
 - Run
 
```
 mvn clean package
```

## Run custom input and expect custom output

 - Update instructions_from_exercise_description file to have any input instructions.
 - Update expected_output_from_exercise_description to any expected results.
 - Run the specific unit test via maven
 
```
mvn -Dtest=ProcessingAStreamOfCommands test
```