package steps

import cuke4duke.{EN, ScalaDsl}
import org.specs2.matcher.JUnitShouldMatchers

class SimpleScalaTest extends ScalaDsl with EN with JUnitShouldMatchers {
  private var a: Int = _
  private var b: Int = _
  private var whenCalled = false

  Given("""^the two numbers (\d+) and (\d+)$""") { (x: Int, y: Int) =>
    a = x
    b = y
  }

  When("^I multiply them$") {
    whenCalled = true
  }

  Then("""^the answer should be (\d+)$""") { z: Int =>
    whenCalled should beTrue
    a*b should be_==(z)
  }
}
