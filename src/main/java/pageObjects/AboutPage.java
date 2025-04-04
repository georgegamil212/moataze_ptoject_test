package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends AbstractComponent {

    private WebDriver driver;
    public AboutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css=".text-2xl")
    WebElement aboutMessage;

    public String getMessage(){
        return aboutMessage.getText();

    }
}
