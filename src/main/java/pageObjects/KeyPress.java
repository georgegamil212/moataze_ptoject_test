package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KeyPress extends AbstractComponent {
    private WebDriver driver;
    public KeyPress(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "[data-test='last-key-pressed']")
    WebElement lastKeyPressed;

    @FindBy(css = ".bg-gray-50")
    List<WebElement> keysPressed;

    @FindBy(css = "[data-test='key-0']")
    WebElement lastKeyPressedFromFive;


    public String pressKey(String key){
        Actions actions=new Actions(driver);
        actions.sendKeys(key).build().perform();
        return key.substring(key.length()-1);


    }
    public String pressSpecialKeys(String key){
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.valueOf(key.toUpperCase())).build().perform();
        return key.toUpperCase();

    }

    public String getLastKeyPressed(){
        return lastKeyPressed.getText();

    }
    public String getLastKeyPressedFromFive(){
        return lastKeyPressedFromFive.getText();

    }










}
