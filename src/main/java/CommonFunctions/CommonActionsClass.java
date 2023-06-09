package CommonFunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CommonActionsClass {

        WebDriver driver;
        CommonWaitsClass seleniumWaits;

        public CommonActionsClass(WebDriver driver) {
            this.driver= driver;
            seleniumWaits = new CommonWaitsClass(driver);
        }

        public boolean clickOnElement(WebElement element) {
            boolean flag = false;

            try {
                element.click();
                flag = true;
            }
            catch(NoSuchElementException nse) {
                System.out.println(nse.toString());
                flag = false;
            }
            catch (StaleElementReferenceException ser) {

                System.out.println(ser.toString());
                flag = false;
            }
            catch (ElementNotInteractableException eni) {

                System.out.println(eni.toString());
                flag = false;
            }
            return flag;
        }

        public boolean EnterValueOnTextField(WebElement element , String value) {

            boolean flag = false;

            try {
                element.sendKeys(value);
            }
            catch (NoSuchElementException nse) {

                System.out.println(nse.toString());
                flag = false;
            }
            catch (StaleElementReferenceException Ser) {

                System.out.println(Ser.toString());
            }
            catch (ElementNotInteractableException eni) {

                System.out.println(eni.toString());
                flag = false;
            }
            return flag;

        }

        public boolean WaitandClickElement(WebElement element) {
            try {
                seleniumWaits.waitForElementTobeClickable(element).click();
                return true;
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        }

        public boolean selectValueFromDropDown(WebElement element, String data, String typeSelect){
            try{
                Select select = new Select(element);
                switch (typeSelect){
                    case "index":
                        select.selectByIndex(Integer.parseInt(data));
                        break;
                    case "value":
                        select.selectByValue(data);
                        break;
                    case "text":
                        select.selectByVisibleText(data);
                        break;
                }
                return true;
            }catch (Exception e){

                return false;
            }
        }
    }


