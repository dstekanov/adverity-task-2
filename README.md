TODOS app for adding you tasks and to not forget them.

### Tech stack
- programming language: Java 11 
- build automation tool: Gradle
- test runner: TestNG
- reporter: Allure

### Test Scripts
There are few automated tests (we can think of it like E2E tests) written in technical style.

### Run
- Run your tests through IDEA TestNG runner
- via CLI: `./gradlew clean test`

### Report
- Allure: `./gradlew allureServe`

#### My notes about testing strategy:

For me, it's important to learn and understand the product and business goal. 
What we are going to achieve and what users we will have. 
Be the quality leader based on the type of the team. 

Few words about last strategy I thought about:

Assume we have a microservice architecture. It's important for me to visualize architecture and draw the testing role in it.

First of all, we should aim for shift the testing left and the testing pyramid helps with it.

Developers are writing unit and integration tests, and we, QA team, must help them with it. I called it QA assist.

Integration tests are very important but they are run in isolation, so contract tests can help with it.

Also, I prefer to have UI Component tests for modern JS frameworks (e.g. Angular) and test UI components in isolation (like any forms, e.g. login form, with set of positive and negative tests).

On top of it, we can place E2E and Exploratory testing and ensure user scenarios.

Also, it's important to track and check quality attributes, like performance and security. 
