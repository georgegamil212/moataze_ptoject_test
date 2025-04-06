package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LandingPage extends AbstractComponent {

    private WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css=".mb-1")
    List<WebElement> testCards;


    public void goTo(String URL){
        driver.get(URL);

    }
    public void goToAbout(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("About")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToForms(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Forms")).collect(Collectors.toList());
        about.get(0).click();

    }
    public TablesPage goToTables(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Tables")).collect(Collectors.toList());
        about.get(0).click();
        return new TablesPage(driver);

    }
    public DragAndDropPage goToDragAndDrop(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Drag & Drop")).collect(Collectors.toList());
        about.get(0).click();
        return new DragAndDropPage(driver);

    }
    public DynamicElementsPage goToDynamicElements(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Dynamic Elements")).collect(Collectors.toList());
        about.get(0).click();
        return new DynamicElementsPage(driver);

    }
    public HoverStates goToHoverStates(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Hover States")).collect(Collectors.toList());
        about.get(0).click();
        return new HoverStates(driver);

    }
    public KeyPress goToKeyPress(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Key Press")).collect(Collectors.toList());
        about.get(0).click();
        return new KeyPress(driver);

    }
    public Slider goToSlider(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Slider")).collect(Collectors.toList());
        about.get(0).click();
        return new Slider(driver);

    }
    public void goToFileUpload(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("File Upload")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToFileDownload(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("File Download")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToIframes(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Iframes")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToBrokenImages(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Broken Images")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToShadowDOM(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Shadow DOM")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToContextMenu(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Context Menu")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToNotifications(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Notifications")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToABTesting(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("A/B Testing")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToAuthentication(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Authentication")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToCheckboxes(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Checkboxes")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToExitIntent(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Exit Intent")).collect(Collectors.toList());
        about.get(0).click();

    }
    public void goToAlerts(){
        List<WebElement> about=testCards.stream().filter(card->card.getText().equalsIgnoreCase("Alerts")).collect(Collectors.toList());
        about.get(0).click();

    }













}
