# Running the tests

You can run the tests using the following command

**mvn compile test** or **mvn test**

By default, the tests will spin up a selenium grid setup in your local instance and run the tests using RemoteWebDriver
To use your local browser instead, in your application_test.properties file, set the browser property to "**chrome_local**"

**Running the login and register new user tests**

For login tests, you will have to create a new user via the UI and store the credentials in

1. Export the data to system environment variables and use it in the tests (recommended)
2. _getValidUserData_ data provider in the LoginTests.java file (do not check in this file with test credentials to avoid security issues)

For register new users test, the test will generate a random email id every time the test is run, with the same password. If needed, you can pull the password from external sources
