# AWARDS UI Tests

This project contains the UI tests for AWARDS.

## Requirements

Latest versions of Chrome/Firefox must be installed locally

## Running Tests

### Browser options
- chrome
- firefox
- phantomjs
- browserstack

### Environment options
- local
- qa

### Test runner options (optional) 
- SmokeTestRunner

### Parallel test runners
- Specify the amount of parallel runners by changing the 'acceptance.test.parallel.count' property in the pom.xml

### Execution

To run a full regression using parallel execution run the following command:

- mvn clean verify -Dbrowser=chrome -Denv=local

To run a specific test runner run the following command:

- mvn clean verify -Dbrowser=chrome -Denv=local -Dit.test=SmokeTestRunner

To run the tests against a browser in browserstack run the following command specifying the target browser details:

- mvn clean verify -Dbrowser=browserstack -Dbrowser_name=ie -Dbrowser_version=11.0 -Dos_name=Windows -Dos_version=10 -Denv=qa

## Test Reports

The reports for the tests can be found in the following directory: 'target/cucumber-reports/overview-features.html'