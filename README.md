# How to initially run this application

## Step 1: Sync dependencies from gradle
Run this command from the project root directory:
````
./gradlew dependencies
````

## Step 2: Run docker database container
From the project root directory, run:
````
docker compose up -d
````

## Step 3: Run application
From the project root directory, run:
````
./gradlew bootRun
````

## Step 4: Verify database schema
Once you finish all steps above, locate to `DataBastTest.java` at [test](src/test)
to run test. Make sure that 2 initial tests are all pass.
````
./gradlew bootRun
````


