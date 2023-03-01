package CompendiumdevPage;

import CommonFunctions.CommonActionsClass;
import JsonReader.ReadingDataFromJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;
    CommonActionsClass commonActionsClass;
    ReadingDataFromJson readingDataFromJson;
    public ContactPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        commonActionsClass=new CommonActionsClass(driver);
        readingDataFromJson=new ReadingDataFromJson();
    }
    @FindBy(xpath = "//div[@id='cssmenu']//descendant::a[text()='Contact']") WebElement contactButton;
    @FindBy(xpath = "//div[@ class='thumbCellSplit']//child::script/following-sibling::iframe") WebElement frameElement;
    @FindBy(xpath = "//input[@class='TextBox' and @name='name']") WebElement inputName;
    @FindBy(xpath = "//input[@class='TextBox' and @name='email']") WebElement inputEmail;
    @FindBy(xpath = "//textarea[ @name='message']") WebElement inputMessage;
    @FindBy(xpath = "//div[@id='contactFooter']//descendant::div[@class='buttonIcon']") WebElement sendButton;
    @FindBy(xpath = "//div[@ class='SuccessMessage']") WebElement successMessage;
    public void clickOnContact(){
        commonActionsClass.clickOnElement(contactButton);
    }
    public void fillingForm() throws Exception {
        driver.switchTo().frame(frameElement);
        commonActionsClass.EnterValueOnTextField(inputName,readingDataFromJson.readFile("Name"));
        commonActionsClass.EnterValueOnTextField(inputEmail,readingDataFromJson.readFile("Email"));
        commonActionsClass.EnterValueOnTextField(inputMessage,readingDataFromJson.readFile("Message"));
        commonActionsClass.clickOnElement(sendButton);
    }
    public WebElement verifyMessage(){
        return successMessage;
    }
}
