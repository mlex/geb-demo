/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

// disabling javascript this way doesnt work :(
// need to use htmlunitdriver insted
//def caps = new DesiredCapabilities(["javascriptEnabled": Boolean.TRUE.equals(Boolean.valueOf(System.getProperty("geb.disableJavascript"))) ? false : true,
//        "takeScreenshot": true])

def caps = new DesiredCapabilities([
        "javascriptEnabled": true,
        "takeScreenshot": true])

// The default driver if no geb.env system property is defined
driver = { new FirefoxDriver(caps) }

environments {

    chrome { driver = { new ChromeDriver(caps) } }

    remote {
        driver = {
            // read driver url from system property
            def driverUrl = System.getProperty("geb.driverUrl")
            new RemoteWebDriver(new URL(driverUrl), caps)
        }
    }

    htmlunit { driver = { new HtmlUnitDriver() } }

}