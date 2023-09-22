# Selenium Test Automation Project README

## Overview
This repository contains a Selenium test automation project using Java and TestNG to test the functionality of the ParaBank website. The project includes test cases for the following scenarios:

## Prerequisites
Before running the tests, make sure you have the following prerequisites installed:

- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- JSON library for Java (for reading the JSON input file)

## Running the Tests
To run the tests, follow these steps:

1. Clone this repository to your local machine:

git clone https://github.com/yourusername/selenium-parabank-tests.git

2. Navigate to the project directory:

cd selenium-parabank-tests

3. Configure the necessary dependencies and set up your Selenium WebDriver.

4. Create a JSON input file with test cases as mentioned in the 'Transfer Funds' section.

5. Update the test suite or class to read and execute the test cases from the JSON file.

6. Execute the tests using TestNG.

7. Review the test results and reports.

## Example JSON Input File (testCases.json)
```json
[
{
 "testCaseNumber": 1,
 "amount": 50,
 "debitAccount": 12345,
 "creditAccount": 67890
},
{
 "testCaseNumber": 2,
 "amount": 30,
 "debitAccount": 67890,
 "creditAccount": 12345
},
{
 "testCaseNumber": 3,
 "amount": 70,
 "debitAccount": 12345,
 "creditAccount": 67890
}
]

Make sure to update the JSON file and test suite/class as needed for your specific test cases.