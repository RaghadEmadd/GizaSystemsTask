# GizaSystemsTask
This project is divided into two java projects
TestAutomationFrmework( for UI Automation)
RestAssuredProject(for API Automation)

Project Structure:
-For TestAutomationFramework the project is divided into Base Test(includes common methods to be used by all tests), Test Cases file(actual tests to be executed), property file(to read details from config files), config files(includes configurations that will be passed to the tests) and pom.xml(contains all dependencies). 
-For RestAssuredProject the project has the Test Cases( to be executed), pom.xml(dependencies of the project)


Steps to run TestAutomationFramework locally:
-Download the project on your local device and open it from eclipse IDE through clicking on "File" option and select "open files from file system" option then select "Directory" button
and select the location where the project is downloaded.
-To run the test cases, go to this path TestAutomationFrmework\testrunner\ and right click on testrunner.xml file and run as "TestNG suite"
-To access reports, go to this path TestAutomationFrmework\test-output\index.html and double click on index.html  or emailable-report.html file to view the run results on browser.

Steps to run RestAssuredFrmewrok locally:
-Download the project on your local device and open it from eclipse IDE through clicking on "File" option and select "open files from file system" option then select "Directory" button
and select the location where the project is downloaded.
-To run the test cases, go to this path RestAssuredProject\src\test\java\ and right click on Test01_GET.java file and run as "TestNG Test"
-To access reports, go to this path TestAutomationFrmework\test-output\ and double click on index.html or emailable-report.html file to view the run results on browser.
