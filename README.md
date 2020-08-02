## If you run via IntelliJ (or any IDE)

Install Lombok plugin. This is not required if you use maven to build and test.

## Build and run all unit tests

 - Install Maven
 - Run
 
```
 mvn clean package
```

## Run custom input instructions and set custom expected output

 - Update `instructions_from_exercise_description` file to set any input instructions.
 - Update `expected_output_from_exercise_description` to set any expected results.
 - Run the specific unit test via maven
 
```
mvn -Dtest=ProcessingAStreamOfCommands test
```