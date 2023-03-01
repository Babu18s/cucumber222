package Steps;
import CompendiumdevPage.ContactPage;
import org.junit.After;
import org.junit.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
Steps for feature file

*/
public class ContactSteps {
    public  WebDriver driver;
    ContactPage contactPage;

    @Before
    public void initializeBrowsers(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void killTheSession(){
        driver.quit();
    }
    @Given("user on Home Page")
    public void user_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
    driver.get("https://compendiumdev.co.uk/");
    }
    @When("click on the Contact")
    public void click_on_the_contact() {
        contactPage=new ContactPage(driver);
        // Write code here that turns the phrase above into concrete actions
        contactPage.clickOnContact();

    }
    @Then("fill the Form")
    public void fill_the_form() throws Exception {
        Thread.sleep(3000);
        contactPage=new ContactPage(driver);

        // Write code here that turns the phrase above into concrete actions
        contactPage.fillingForm();

    }
    @Then("verify Form Submitted successfully")
    public void verify_form_submitted_successfully() {
        contactPage=new ContactPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(32));
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(contactPage.verifyMessage().isDisplayed());

    }

}
