package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends AbstractComponent {

    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(css = "[data-test='drag-handle-Item 1']")
    WebElement itemOne;
    @FindBy(css = "[data-test='drag-handle-Item 2']")
    WebElement itemTwo;
    @FindBy(css = "[data-test='drag-handle-Item 3']")
    WebElement itemThree;
    @FindBy(css = "[data-test='drag-handle-Item 4']")
    WebElement itemFour;
    @FindBy(css = "[data-test='drag-handle-Item 5']")
    WebElement itemFive;


    public void dragAndDropItemOne(int source, int destination) {
        Actions actions = new Actions(driver);
        switch (source) {
            case 1: {
                switch (destination) {
                    case 1:
                        actions.dragAndDrop(itemOne, itemOne).build().perform();
                        break;

                    case 2:
                        actions.dragAndDrop(itemOne, itemTwo).build().perform();
                        break;

                    case 3:
                        actions.dragAndDrop(itemOne, itemThree).build().perform();
                        break;

                    case 4:
                        actions.dragAndDrop(itemOne, itemFour).build().perform();
                        break;

                    case 5:
                        actions.dragAndDrop(itemOne, itemFive).build().perform();
                        break;

                    default:break;


                }
                break;


            }
            case 2: {
                switch (destination) {
                    case 1:
                        actions.dragAndDrop(itemTwo, itemOne).build().perform();
                        break;

                    case 2:
                        break;

                    case 3:
                        actions.dragAndDrop(itemTwo, itemThree).build().perform();
                        break;

                    case 4:
                        actions.dragAndDrop(itemTwo, itemFour).build().perform();
                        break;

                    case 5:
                        actions.dragAndDrop(itemTwo, itemFive).build().perform();
                        break;

                    default:break;

                }



            }
            break;



            case 3: {
                switch (destination) {
                    case 1:
                        actions.dragAndDrop(itemThree, itemOne).build().perform();
                        break;

                    case 2:
                        actions.dragAndDrop(itemThree, itemTwo).build().perform();
                        break;

                    case 3:
                        break;

                    case 4:
                        actions.dragAndDrop(itemThree, itemFour).build().perform();
                        break;

                    case 5:
                        actions.dragAndDrop(itemThree, itemFive).build().perform();
                        break;

                    default:break;


                }



            }
            break;



            case 4: {
                switch (destination) {
                    case 1:
                        actions.dragAndDrop(itemFour, itemOne).build().perform();
                        break;

                    case 2:
                        actions.dragAndDrop(itemFour, itemTwo).build().perform();
                        break;

                    case 3:
                        actions.dragAndDrop(itemFour, itemThree).build().perform();
                        break;

                    case 4:
                        break;

                    case 5:
                        actions.dragAndDrop(itemFour, itemFive).build().perform();
                        break;

                    default:break;


                }


            }
            break;
            case 5: {
                switch (destination) {
                    case 1:
                        actions.dragAndDrop(itemFive, itemOne).build().perform();
                        break;

                    case 2:
                        actions.dragAndDrop(itemFive, itemTwo).build().perform();
                        break;

                    case 3:
                        actions.dragAndDrop(itemFive, itemThree).build().perform();
                        break;

                    case 4:
                        actions.dragAndDrop(itemFive, itemFour).build().perform();
                        break;

                    case 5:
                        break;


                    default:break;


                }


            }
            break;

            default:break;


        }
    }
}