package Tests;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DragAndDropPage;
import pageObjects.DynamicElementsPage;
import pageObjects.TablesPage;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class test1 extends BaseTest {



    @Test
    public void test(){

       DynamicElementsPage dynamicElementsPage = landingPage.goToDynamicElements();
       Assert.assertEquals(dynamicElementsPage.getDynamicContentOne(),"Dynamic Content 1");





    }



//    public static void main(String[] args) {
//        WebDriver driver1 = new ChromeDriver();
//        driver1.get("https://moatazeldebsy.github.io/test-automation-practices/#/tables");
//        driver1.manage().window().maximize();
//        List<WebElement> list = driver1.findElements(By.cssSelector("[data-test*='table-cell-id']"));
//        List<String> ss = list.stream().map(WebElement::getText).collect(Collectors.toList());
//        System.out.println(ss);
//        List<String> news=ss.stream().sorted().collect(Collectors.toList());
//        System.out.println(news);
//
//
//    }
}