# Automated Testing README

This document provides instructions for automated testing using Java, Selenium, and TestNG for the given test cases.

## Test Matrix

Here is a test matrix with test case numbers and their corresponding descriptions:

| Test Case Number | Description             |
| -----------------|-------------------------|
| 1                | Register                |
| 2                | Open a New Account      |
| 3                | Transfer Funds          |

## Test Cases

### 1. Register

#### Description
- Register a new account.
- Select the default account to debit the new funds.
- Verify the success message.
- Get the new account number.
- Navigate to 'Accounts Overview' and confirm that the new account is present on the list.
- Verify if the available amount matches with $100.

### 2. Open a New Account

#### Description
- Open a new account.
- Select the default account to debit the new funds.
- Verify the success message.
- Get the new account number.
- Navigate to 'Accounts Overview' and confirm that the new account is present on the list.
- Verify if the available amount matches with $100.

### 3. Transfer Funds

#### Description
- Parameterized test case with JSON input.
- Transfer funds between accounts.
- Verify the success message.
- Navigate to 'Accounts Overview' and check the new balance for both accounts.

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

7. Review the test results.

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
