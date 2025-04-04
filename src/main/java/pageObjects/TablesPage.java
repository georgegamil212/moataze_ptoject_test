package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TablesPage extends AbstractComponent {


    private WebDriver driver;
    public TablesPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="[data-test='dynamic-table']")
    WebElement table;

    public void sortByID(){
        table.findElement(By.cssSelector(".mr-1")).click();

    }

    public List<WebElement> getIDs(){

         return driver.findElements(By.cssSelector("[data-test*='table-cell-id']"));

    }
    public List<String> convertIdsToString(){
        return getIDs().stream().map(WebElement::getText).collect(Collectors.toList());

    }
    public List<String> sortIds(){
        return convertIdsToString().stream().sorted().collect(Collectors.toList());

    }










}
