package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicElementsPage extends AbstractComponent {


    private WebDriver driver;
    public DynamicElementsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(css = "data-test='load-time-slider'")
    WebElement slider;

    @FindBy(css = "[data-test='reload-button']")
    WebElement reloadButton;

    @FindBy(css = "[data-test='dynamic-item-0']")
    WebElement dynamicContentOne;

    @FindBy(css = "[data-test='dynamic-item-1']")
    WebElement dynamicContentTwo;

    @FindBy(css = "[data-test='dynamic-item-2']")
    WebElement dynamicContentThree;

    @FindBy(css = "[data-test='toggle-hidden-button']")
    WebElement hiddenContentButton;

    @FindBy(css = "..bg-yellow-100")
    WebElement hiddenText;

    public String getDynamicContentOne(){
        waitForWebElementToAppear(dynamicContentOne);
        return dynamicContentOne.getText();
    }

    public String getDynamicContentTwo(){
        waitForWebElementToAppear(dynamicContentTwo);
        return dynamicContentTwo.getText();
    }

    public String getDynamicContentThree(){
        waitForWebElementToAppear(dynamicContentThree);
        return dynamicContentThree.getText();
    }

    public String getHiddenContent(){
        hiddenContentButton.click();
        return hiddenText.getText();

    }










}
