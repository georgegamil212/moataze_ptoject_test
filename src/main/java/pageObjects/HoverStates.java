package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverStates extends AbstractComponent {

    private WebDriver driver;
    public HoverStates(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "[alt='Figure 1']")
    WebElement firstPic;

    @FindBy(css = "[alt='Figure 2']")
    WebElement secondPic;

    @FindBy(css = "[alt='Figure 3']")
    WebElement thirdPic;

    public void hoverOverFirstPic(){
        Actions actions=new Actions(driver);
        waitForWebElementToAppear(firstPic);
        actions.moveToElement(firstPic).build().perform();
    }
    public void hoverOverSecondPic(){
        Actions actions=new Actions(driver);
        waitForWebElementToAppear(secondPic);
        actions.moveToElement(secondPic).build().perform();
    }

    public void hoverOverThirdPic(){
        Actions actions=new Actions(driver);
        waitForWebElementToAppear(thirdPic);
        actions.moveToElement(thirdPic).build().perform();
    }







}
