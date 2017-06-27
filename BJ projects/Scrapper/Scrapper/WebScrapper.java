import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebScrapper {
    
    public WebDriver driver = null;
    
    public void InitWebScrapper(){
        System.out.println("we are in constructor of webscrapper");
        System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox-bin");
        this.driver = new FirefoxDriver();
        System.out.println("created firefox done");
        //driver = new FirefoxDriver("//Firefox.app/Contents/MacOS/firefox-bin");
        //  public WebDriver driver = new FirefoxDriver(new FirefoxBinary(new File("//Firefox.app/Contents/MacOS/firefox-bin")), profile);
    
        //Firefox.app/Contents/MacOS/firefox-bin
    }

    /**
     * Open the test website.
     */
    public void openTestSite() {
        if(this.driver == null ){
            System.out.println("the driver is null");
            InitWebScrapper();
        }
        else
            System.out.println("the driver is not null");
        System.out.println("Let's go to testing .pro");
        this.driver.navigate().to("http://testing-ground.scraping.pro/login");
        
    }

    /**
     * 
     * @param username
     * @param Password
     * 
     *            Logins into the website, by entering provided username and
     *            password
     */
    public void login(String username, String Password) {

        WebElement userName_editbox = this.driver.findElement(By.id("usr"));
        WebElement password_editbox = this.driver.findElement(By.id("pwd"));
        WebElement submit_button = this.driver.findElement(By.xpath("//input[@value='Login']"));

        userName_editbox.sendKeys(username);
        password_editbox.sendKeys(Password);
        submit_button.click();

    }

    /**
     * grabs the status text and saves that into status.txt file
     * 
     * @throws IOException
     */
    public void getText() throws IOException {
        System.out.println("We are getting text");
        String text = this.driver.findElement(By.xpath("//div[@id='case_login']/h3")).getText();
        System.out.println("the text is " + text );
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
        writer.write(text);
        writer.close();

    }

    /**
     * Saves the screenshot
     * 
     * @throws IOException
     */
    public void saveScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) (this.driver)).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshot.png"));
    }

    public void closeBrowser() {
        driver.close();
    }

        public static void main(String[] args) throws IOException {
            
            WebScrapper webSrcapper = new WebScrapper();
            webSrcapper.openTestSite();
            webSrcapper.login("admin", "12345");
            webSrcapper.getText();
            webSrcapper.saveScreenshot();
            webSrcapper.closeBrowser();
            
    
    }
}
