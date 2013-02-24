/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.htmlunit.HtmlUnitDriver

// disabling javascript this way doesnt work :(
// need to use htmlunitdriver insted
//def caps = new DesiredCapabilities(["javascriptEnabled": Boolean.TRUE.equals(Boolean.valueOf(System.getProperty("geb.disableJavascript"))) ? false : true,
//        "takeScreenshot": true])

def caps = new DesiredCapabilities([
        "javascriptEnabled": true,
        "takeScreenshot": true])

driver = { new FirefoxDriver(caps) }

environments {

    chrome {
        driver = { new ChromeDriver(caps) }
    }

    remote {
        driver = {
            def driverUrl = System.getProperty("geb.driverUrl")
            new RemoteWebDriver(new URL(driverUrl), caps)
        }
    }

    htmlunit {
        driver = {
            // no caps here, because htmlunitdriver does not support javascript
            new HtmlUnitDriver()
        }
    }


}