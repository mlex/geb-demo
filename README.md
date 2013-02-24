Demo for Geb - Groovy Browser Automation
========================================

This project contains the demos used in my presentation on Geb. The [full presentation is available on
youtube](https://www.youtube.com/watch?v=_rHScwxaxO0). Geb is a browser automation solution written in Groovy based on
WebDriver. See my [introductory blog post on
Geb](http://blog.codecentric.de/en/2013/02/browser-automation-and-acceptance-testing-with-geb/) for more information. 

The example are using an adapted version of Tobias Flohre`s [moviedatabase project](https://github.com/mlex/movie-database), which he built as an example for [a real ROCA using Bootstrap, jQuery, Thymeleaf, Spring HATEOAS and Spring MVC](http://blog.codecentric.de/en/2013/01/a-real-roca-using-bootstrap-jquery-thymeleaf-spring-hateoas-and-spring-mvc/). Thanks Tobias, for letting me shamelessly use your project ;-)

The geb-demo consists of three parts:
* The "basic-testing" folder contains the examples of the presentation (one simple test-case and one test-case using page objects).
* The "advanced-page-objects" folder contains some more tests using page objects and asynchronous assertions (Geb's waitFor feature).
* In the folder "cucumber-demo", you can find a demonstration, how to integrate Geb with cucumber-jvm.


The execution is the same for all examples. They are all maven projects. See the following instructions.


## Test Execution

Before you can execute the tests, you have to download and start the moviedatabase:

    git clone https://github.com/mlex/movie-database.git
    cd movie-database
    mvn jetty:run

Then the tests can be executed with:

    mvn test

By default, the acceptance-tests are using the FirefoxDriver. You can configure this (among others) by setting one of the following configuration options.


## Configuration

The tests are configured via system properties. When using maven, you can set them via the "-D" option (e.g. `-Dgeb.env=phantomjs`). The following configuration options are available:
* **geb.build.baseUrl**: The base url where the tests expect a running moviedatabase application. Default:
   `http://localhost:8080/movies`
* **geb.build.reports**: Geb tries to take a screenshots of the browser, whenever a test fails (this is not possible with
   all drivers). The screenshots and the html of the failing page are saved in the directory defined by this property. Default: 
   ``target/geb-reports``
* **geb.env**: The geb environment property determines, which configuration is used for the tests. The configurations are
   defined in `src/test/resources/GebConfig.groovy`. The most important thing about configurations is, that they
   determine the WebDriver driver to use! Available configurations are:
   * *firefox* (default): Use the selenium firefox driver. Make sure, that you have a firefox binary installed.
   * *chrome*: Use the chrome driver. Unfortunately I couldn't get this one to work on my machine. I left it there
     nonetheless.
   * *phantomjs*: Use phantomjs together with [GhostDriver](https://github.com/detro/ghostdriver). This configuration
     will start its own phantomjs instance. Make sure to have phantomjs installed.
   * *htmlunit*: Use HtmlUnit driver. This is especially useful, if you want to check how the application behaves
       without javascript.
   * *remote*: This configuration uses a RemoteWebDriver to connect to a (already running) WebDriver server. The
     address is determined by the `geb.driverUrl` property.
* **geb.driverUrl**: Only used with `geb.env=remote`. Determines the url of the WebDriver server to use. Default:
   ``http://localhost:8910/``

## Running with a remote phantomjs server

The possibility to use a already running phantomjs instance to run the tests is especially tempting during development,
because most time you simply wait for the firefox (chrome, phantomjs) to start. To start a phantomjs server, simply use 
the `--webdriver` option

    # start a phantomjs server listening on port 8910
    phantomjs --webdriver=8910

    # sometimes debug-output can be quite helpful
    phantomjs --webdriver=8910 --debug=yes

Then you can run the tests using a RemoteWebDriver

    mvn -Dgeb.env=remote -Dgeb.driverUrl=http://localhost:8910 test

## HTML report generation

[Damage Control Report](https://github.com/damage-control/report) is a report generation tool for the spock framework. After successful (or unsuccessful) acceptance-tests, the result is automatically saved in xml-files in the `target/surefire-reports`. To generate more nice-looking html reports, simply run

    mvn damage-control:report

The html report will be saved in `target/damage-control-reports`.
