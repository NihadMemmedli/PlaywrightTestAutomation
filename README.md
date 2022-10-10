## Runner

To run project locally

```bash
  git clone https://github.com/NihadMemmedli/PlaywrightTestAutomation.git
  PLAYWRIGHT_JAVA_SRC=./src/test/java mvn clean test
```

Pre-requisite to run with selenium-grid: `SE_NODE_GRID_URL="http://<selenium-hub-ip>:4444/wd/hub"` 
environment variable pointing to the hub when running selenium node
Example can be found in the docker-compose.yml

To run selenium grid infrastructure on local:

```bash
  docker-compose up
```
To run project with selenium-grid
Template:
```bash
  PLAYWRIGHT_JAVA_SRC=./src/test/java SE_NODE_GRID_URL="<selenium-hub-ip>:4444/wd/hub" mvn clean test
```
Example:
```bash
  PLAYWRIGHT_JAVA_SRC=./src/test/java SE_NODE_GRID_URL="localhost:4444/wd/hub" mvn clean test
```

To run project with dockerized environment

```bash
  docker run -e PLAYWRIGHT_JAVA_SRC=./src/test/java --shm-size 2gb -v $PWD:/tests -w /tests --rm -it mcr.microsoft.com/playwright/java:v1.27.0-focal mvn test
```

## Reporter

Extent Report location: `build/TestExecutionReport.html`

## Trace Viewer

Playwright Trace Viewer is a GUI tool that lets you explore recorded Playwright traces of your tests meaning you can go back and forward though each action of your test and visually see what was happening during each action.

To open tracer, use below command:

```bash
  mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="show-trace trace.zip"
```


