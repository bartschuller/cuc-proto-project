package steps

import scala.collection.JavaConverters._
import cuke4duke.{EN, ScalaDsl}
import org.specs2.matcher.JUnitShouldMatchers
import org.smop.webdriver.WebTests
import org.openqa.selenium.By

class WebStuff extends ScalaDsl with EN with JUnitShouldMatchers with WebTests {
  private var site: String = _

  Given("""^the website at (\S+)$""") { s: String =>
    site = s
    webdriver.get(site)
  }

  When("I search for (.+)$") { q: String =>
    val element = webdriver.findElement(By.id("searchquery"))
    element.sendKeys(q)
    element.submit()
  }

  Then("the results should include (.+)$") {string: String =>
    val elements = webdriver.findElements(By.cssSelector("a"))
    elements.asScala.find(_.getText == string) should beSome
  }
}
