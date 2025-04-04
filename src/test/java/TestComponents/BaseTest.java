package TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public LandingPage landingPage;
    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties prop=new Properties();
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData\\GlobalData.properties");

        prop.load(file);
        String browserName= System.getProperty("browser")!=null ?System.getProperty("browser"):prop.getProperty("browser");

        if(browserName.contains("chrome")){
            ChromeOptions options=new ChromeOptions();
            if(browserName.contains("headless")){
            options.addArguments("headless");
            }
            driver=new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));

        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("internetexplorer")) {
            driver=new InternetExplorerDriver();

        } else if (browserName.equalsIgnoreCase("safari")) {
            driver=new SafariDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;


    }



    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to String
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        //file to hashMap with Jackson Databind

        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;

    }


    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
//        TakesScreenshot ts =(TakesScreenshot) driver;
//        File source =ts.getScreenshotAs(OutputType.FILE);
//        File file=new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".png");
//        FileUtils.copyFile(source,file);
//        return System.getProperty("user.dir")+"/reports/"+testCaseName+".png";


        String screenshotPath = null;

        try {

            //take screenshot and save it in a file

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path

            File destinationFile = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");

            FileHandler.copy(sourceFile, destinationFile);

            String[] relativePath = destinationFile.toString().split("reports");

            screenshotPath = ".\\" + relativePath[1];

        } catch (Exception e) {

            System.out.println("Failure to take screenshot " + e);

        }

        return screenshotPath;
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String filePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + testCaseName + ".png";
//        File file = new File(filePath);
//        FileUtils.copyFile(source, file);
//        return filePath;



    }


    @BeforeMethod(alwaysRun = true)
    public void launchAppLocation() throws IOException {
        driver=initializeDriver();
        landingPage=new LandingPage(driver);
        landingPage.goTo("https://moatazeldebsy.github.io/test-automation-practices/");
        //return landingPage;

    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.close();

    }




}
