# github-automation

Base automation framework for [GitHub](https://github.com/).

## Getting started
### Environment requirements
* Java Oracle JDK or OpenJDK version 11 installed (JAVA_HOME environment variable setup properly in PATH).
* Google Chrome or Firefox browser installed.
* Optional: IntelliJ IDEA or another Java IDE with support for Cucumber-JVM. 
### Run automated tests
You can set configuration parameters in `gradle.properties` file.

Currently, Google Chrome and Firefox (Google Chrome set as default) browsers are supported for automated tests execution, web driver type and version can be configured in `gradle.properties` config file in the root directory of the project or set the parameters in the command execution as JVM arguments.

Configuration example: 
```shell script
systemProp.browser=CHROME
systemProp.driverVersion=84.0.4147.30
```
Note: If the `driverVersion` is not specified the latest version will be used. You can check Chrome drivers version compatibility [here](https://chromedriver.chromium.org/downloads).


You can use the following command to execute the automated tests:
##### For Microsoft Windows (PowerShell)
```shell script
.\gradlew.bat clean executeTests -Dbrowser="CHROME"
```
##### For GNU/Linux or Unix based systems (need execution permissions for gradlew)
```shell script
./gradlew clean executeTests -Dbrowser="CHROME"
```
### Run automated tests by tag
In order to execute the automated tests by tag you need to configure the `cucumberTags` parameter in `gradle.properties` file or using a JVM argument.

Command examples to execute tests with the `@functional` tag:
##### For Microsoft Windows (PowerShell)
```shell script
.\gradlew.bat clean executeTests -Dbrowser="CHROME" -DcucumberTags="@functional"
```
##### For GNU/Linux or Unix based systems (need execution permissions for gradlew)
```shell script
./gradlew clean executeTests -Dbrowser="CHROME" -DcucumberTags="@functional"
```
### Visualize execution report
The HTML execution report can be found in:
```shell script
build/allure-report
```
In order to serve the report and visualize it in a browser you need to execute:
##### For Microsoft Windows (PowerShell)
```shell script
.\gradlew.bat allureServe
```
##### For GNU/Linux or Unix based systems (need execution permissions for gradlew)
```shell script
./gradlew allureServe
```
### Static code analysis tools
This project has been configured with two basic static code analysis tools: Checkstyle and PMD. You can run the analysis using the following task:
##### For Microsoft Windows (PowerShell)
```shell script
.\gradlew.bat clean check
```
##### For GNU/Linux or Unix based systems (need execution permissions for gradlew)
```shell script
./gradlew clean check
```
