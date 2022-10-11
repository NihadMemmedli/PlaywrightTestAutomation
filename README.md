## Capabilities
Framework includes: Java, Maven, TestNG, Playwright, Extent Report
- ThreadSafe - ThreadLocal logic used to handle browsers, actions. Can be found under `/factory/PlaywrightFactory`
- Extent Report - Configuration can be find under `/listeners/ExtentReportListener`
- Runner: local, docker or selenium grid. TestRunner configuration can be find under `resources/testrunners/testng_regressions.xml`, browser parameter can be updated chrome, firefox, edge, chromium
- Trace Viewer - generated `trace.zip` after run
## Runner

To run project locally

```bash
  git clone https://github.com/NihadMemmedli/PlaywrightTestAutomation.git
  PLAYWRIGHT_JAVA_SRC=./src/test/java mvn test
```

Pre-requisite to run with selenium-grid: `SE_NODE_GRID_URL="http://<selenium-hub-ip>:4444/wd/hub"` 
environment variable pointing to the hub when running selenium node
Example can be found in the `docker-compose.yml` file

To run selenium grid infrastructure and run tests on parallel chrome and chromium:

```bash
  docker-compose up
```

To run project with dockerized environment
Chromium is supported to run in docker
```bash
docker run -e PLAYWRIGHT_JAVA_SRC=./src/test/java --shm-size 2gb -v $PWD:/tests -w /tests --rm -it mcr.microsoft.com/playwright/java:v1.27.0-focal mvn test
```

## Reporter

Extent Report location: `build/TestExecutionReport.html`

## Trace Viewer
[Documentation](https://playwright.dev/java/docs/trace-viewer-intro)
Playwright Trace Viewer is a GUI tool that lets you explore recorded Playwright traces of your tests meaning you can go back and forward though each action of your test and visually see what was happening during each action.

To open tracer, use below command:

```bash
  mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="show-trace trace.zip"
```


