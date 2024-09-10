# Term Deposit Calculator

- [Introduction](#introduction)
- [Install](#install)
  - [Prerequisites](#prerequisites)
  - [Build](#build)
  - [Run](#run)
- [Assumptions](#assumptions)
- [Tradeoffs](#tradeoffs)
- [Packages](#packages)
- [Extensions](#extensions)

# Introduction

A simple term deposit calculator. This was a fun project to spend some time on especially as I don't
often start projects from scratch in my current role.

A high level overview, I've used Java 21 and Maven. 

With this project I've tried to illustrate skills and engineering principals I value while balancing 
the time constraints. 

Looking forward to the review and chat :)

# Install

### Prerequisites

These are required to build and run the project.

Java 21: Java 21 SDK installed on you system

Maven: Apache Maven, package management tool

Docs: https://maven.apache.org/

**Assumptions**

These instructions assume you are running commands from a bash shell.

### Build 

**When referring to the root of the project, this is the directory with the pom.xml file in it.
Steps with Maven**

1. With your java version set to 21, from the root of the project
2. Run the command: `$mvn clean install`
   1. This will pull and install the dependencies
   2. Compile the source code to the `/target` directory

## Tests

In order to run the tests, post compiling the code run the following command:`$mvn test`

Alternatively your IDE might support running tests from the editor. I am using intelliJ
and this IDE supports running tests from within the test class. The first method form the command line
is more reliable.

## Package

To create ane executable that can be provided arguments to calculate the total amount, follow these steps

1. Run the maven clean package command: `$mvn clean package`
2. This will generate packaged executable called: `term-deposit-calculator-1.0-SNAPSHOT.jar`

The executable is bow available within the target directory

### Run

The executable is called: `term-deposit-calculator-1.0-SNAPSHOT.jar`

To run the program from the root of the project execute the following command:
```
 java -jar target/term-deposit-calculator-1.0-SNAPSHOT.jar <principal> <rate> <time in months>
```

Example:

```
java -jar target/term-deposit-calculator-1.0-SNAPSHOT.jar 10000 1.10 9
```


# Assumptions

Several assumptions were made to simplify the solution:
1. Using a simple function for calculating interest
2. Assuming mostly correct usage / simple error handling
3. No pipeline / deployment set up 
4. Not exhaustive tests, simple unit tests

# Tradeoffs

In the interest of time a number of choices were made to
simplify the solution. 
1. Only implementing a simple interest calculator
   1. Only specifies time in months
   2. Assume interest is paid every month
2. I have created some simple unit tests, if this was production code I would also create integration / component tests that test the dependencies are wired together as expected
3. Using some dependency injection to show usage and mocking in tests. 
   1. Not using dependency injection in the main function, just instantiating new versions to simplify the interactions with the static method

# Packages 

In this solution I have used a number of dependencies.

Lombok: This dependency is used to reduce a lot of boilerplate in java. Especially with annotations such
as @Get and @Set to generate getters and setters, etc. When starting writing I assumed I would use it more heavily
but in the context of this project only really used the property of access chaining. 

Guice: 
This is a lightweight dependency injection framework. In this project it is overkill but am using it to highlight the 
principals of mocking in tests and how using dependency injection can reduce coupling in clases.

Mockito:
A library to help with unit testsing and provide a lot if unit testing funcitonaility. Especially helpful with mocking 
and isolating functionality and output.

# Extensions 

If I were to extend this solution I would look to:

### Feature enhancements

1. Accept a range for the input arguments, such as a time range and calculate the amount at specified steps
   1.So that users don't need to repeatedly run the program to get information
2. Implement a more complicated method for calculating interest
3. Allow the user to specify what intervals interest is calculated at. Current assumption is monthly

### Technical 

1. Extend the testing
   1. An integration test that takes CSV input (inputs and expected values) to allow easy testing of the entire program
   2. unit testing each class more comprehensively
3. Leverage the dependency injection framework properly
4. Setup a build (and deployment) pipeline - automate testing, building, deployment


