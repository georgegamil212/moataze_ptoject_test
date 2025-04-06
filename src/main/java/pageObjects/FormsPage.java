package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends AbstractComponent {

    private WebDriver driver;
    public FormsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="username")
    WebElement userName;
    @FindBy(id="email")
    WebElement email;
    @FindBy(id="password")
    WebElement password;
    @FindBy(css=".justify-center")
    WebElement signINButton;
    @FindBy(css="[data-test='username-error']")
    WebElement userNameError;
    @FindBy(css="[data-test='[data-test='email-error']")
    WebElement emailError;
    @FindBy(css="[data-test='password-error']")
    WebElement passwordError;


    public String enterUserName(String UN){
        userName.sendKeys(UN);
        return UN;

    }
    public void enterEmail(String E){
        email.sendKeys(E);

    }
    public void enterPassword(String P){
        password.sendKeys(P);

    }
    public void enterSignIn(){
        signINButton.click();

    }
    public String getUserNameErrorMessage(){
       return userNameError.getText();

    }
    public String getEmailErrorMessage(){
        return emailError.getText();
    }
    public String getPasswordErrorMessage(){
        return passwordError.getText();
    }
    public String getBrowsersBuiltInEmailValidationMessage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.getElementById('email').validationMessage;");

    }


}
