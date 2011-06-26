package org.smop.webdriver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import cuke4duke.ScalaDsl
import org.openqa.selenium.chrome.{ChromeDriverService, ChromeDriver}
import java.io.File
import java.util.concurrent.TimeUnit

trait WebTests {
  self: ScalaDsl =>

  var chrome: WebDriver = _
  var firefox: WebDriver = _

  def webdriver: WebDriver = Seq(Option(firefox), Option(chrome)).flatten.head

  Before("@firefox") {
    firefox = new FirefoxDriver
    //firefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
  }

  After("@firefox") {
    firefox.quit()
    firefox = null
  }

  Before("@chrome") {
    chrome = new ChromeDriver(new ChromeDriverService.Builder()
        .usingChromeDriverExecutable(new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"))
        .usingAnyFreePort()
        .build())
  }

  After("@chrome") {
    chrome.quit()
    chrome = null
  }
}
