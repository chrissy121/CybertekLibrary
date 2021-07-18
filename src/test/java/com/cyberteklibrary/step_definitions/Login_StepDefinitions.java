package com.cyberteklibrary.step_definitions;

import com.cyberteklibrary.pages.LoginPage;
import com.cyberteklibrary.utilities.ConfigurationReader;
import com.cyberteklibrary.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
       Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
       String userName = ConfigurationReader.getProperty("lib22_user");
       String password = ConfigurationReader.getProperty("lib22_pass");

        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.SignInBtn.click();

    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected = "dashboard";

        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();

    }

    @When("I login as a student")
    public void i_login_as_a_student() {

        String studentUserName = ConfigurationReader.getProperty("student95_user");
        String studentPassword = ConfigurationReader.getProperty("student95_pass");
        loginPage.userName.sendKeys(studentUserName);
        loginPage.password.sendKeys(studentPassword);
        loginPage.SignInBtn.click();
    }


    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expected = "books";

        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();
    }

    @When("I enter username {string}")
    public void i_enter_username(String string) {
        loginPage.userName.sendKeys(string);
    }
    @When("I enter password {string}")
    public void i_enter_password(String string) {
        loginPage.password.sendKeys(string);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
       loginPage.SignInBtn.click();
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String arg0, String arg1) {
        loginPage.userName.sendKeys(arg0);
        loginPage.password.sendKeys(arg1);
        loginPage.SignInBtn.click();
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int arg0) {
       int expectedUserNumber = arg0;
       wait.until(ExpectedConditions.visibilityOf(loginPage.users));

       String expected = String.valueOf(expectedUserNumber);
       String actual = loginPage.userName.getText();

       Assert.assertEquals("Actual user number is not as expected!", actual, expected);
    }
}






