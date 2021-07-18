package com.cyberteklibrary.pages;

import com.cyberteklibrary.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="inputEmail")
    public WebElement userName;

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement SignInBtn;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement number;

    @FindBy(id = "user_count")
    public WebElement users;

}
