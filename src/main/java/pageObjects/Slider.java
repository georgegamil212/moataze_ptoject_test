package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slider extends AbstractComponent {
    private WebDriver driver;


    public Slider(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "input[type='range']")
    WebElement slider;

    @FindBy(css = "[data-test='slider-value']")
    WebElement sliderValueElement;



    public String moveSlider(int value){
//        ((JavascriptExecutor)driver).executeScript(
//                "arguments[0].value = '"+value+"';", slider);

        waitForWebElementToAppear(slider);
        Actions actions=new Actions(driver);

        if(value>0&&value<50+1){
            actions.clickAndHold(slider).build().perform();
            for (int i=0;i< value;i++){
                actions.keyDown(Keys.ARROW_RIGHT).build().perform();



            }




        } else if (value<0&&(value*-1)<50+1) {
            actions.clickAndHold(slider).build().perform();
            for (int i=0;i<(value*-1);i++){
                actions.keyDown(Keys.ARROW_LEFT).build().perform();

            }

        }

        else {

            actions.release(slider).build().perform();
        }

        return getSliderValue();




    }
    public String getSliderValue(){
       String[] s =sliderValueElement.getText().split(":");
       String string= s[1].trim();
       return string;


    }



}
