# hudlAssignment

**How to run a test**

To run a test through the command line:
1. Navigate to where the repo is stored in your terminal
2. Enter mvn test -Dgroups="[tagname]"
3. It will then run the test of the specified tag with default properties. Tags are found at the top of a feature file.
a. To change the enviroment url, add -Durl="[url]" to the end of the command otherwise it will run in the default environment.
b. To change if it runs in headless mode or not, add -Dheadless="false" to the end of the command
4. A report will be generated within hudlAssignment\target\cucumber-reports\ once all tests have run

Example command to use: 
	mvn test -Dgroups="login" -Dheadless="false"
This will run all the tests in the Login feature file in headed mode.

By default, tests will run in headless mode and in series. To run the tests in parallel, change the cucumber.execution.parallel.enabled  field to true within the resources/features/junit-platform.properties file.

**Code overview**

Data package:
* The Constants class is used to store variables that are used within the project

Pages package:
* The BasePage class contains elements or methods that are common across all the pages of the site
* All other elements that are not common should be stored in its own page class. The page class should have page elements or interactions with the page.

Utilities package:
* The BrowserUtilities class is used to create and close the page and sets up the browser information.
* Whenever a new page is created within the Pages package, a method within PageObjectManager class needs to be created that initialises the page so that the methods within the newly created page can be utilised within the StepDefs package.
* The ScenarioContext class is used to share test data between step definitions. Use the setters to store the data and the getters to then retrieve it.
* The TestContext class is used to manage the BrowserUtilities and PageObjectManager class

resources/features:
* The strucute of a test is written using Gherkin Syntax. At the top of each feature, you declare tags that identify this feature file. You then give a brief explanation of what the tests on that feature file are about using the "Feature" command. 
* The keywords to use when creating a test are either "Given, When or Then". "And" is used to extend the previous keyword command
* Given is used to set the test pre-condititions, When is used to indicate an action as part of the test and Then is used as a check to ensure the When action is done correctly.

StepDefs package:
* The Hooks.java class is used to determine what a test should do before and after it is run
* In the constructor, you should declare the page objects to be used within this class through PageObjectManager 
* Classes in here are used to link the Gherkin syntax within the feature file with the page objects found within the page class
* Above each method within the class is the gherkin syntax with a Given/When/Then command to start it off.
* (.*) is used to indicate a variable that is declared in the gkerin syntax and is to be used within the code.
* Asserts should be done on this page to ensure a test passes or not
* TestRunner.java class is where you set the file paths for the feature files that contains the gherkin syntax and the step definitions