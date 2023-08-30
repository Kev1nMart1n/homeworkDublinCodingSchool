import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class XyzBank {

    public static void main(String[] args) throws InterruptedException {

// 1. Open https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login website
        System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe"); // Path to my WebDriver exe

        WebDriver driver = new ChromeDriver(); //Open Google Chrome
        driver.manage().window().maximize(); //Maximize the window of the webpage

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); //Go to this website
        Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login", driver.getCurrentUrl());
        String urlPage = driver.getCurrentUrl();
        System.out.println(urlPage);

        By customerLoginButtonClick = By.xpath("//button[@ng-click='customer()']");
        By loginButtonClick = By.xpath("//button[@type='submit']");
        By selectName = By.id("userSelect");
        By getCurrency = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[3]");
        By depositButtonClick = By.xpath("//button[@ng-click='deposit()']");
        By enterAmountInput = By.xpath("//input[@ng-model='amount']");
        By depositSubmitButtonClick = By.xpath("//button[@type='submit']");
        By successMessage = By.xpath("//span[@ng-show='message']");
        By transactionButtonClick = By.xpath("//button[@ng-click='transactions()']");
        By getamountColumn = By.xpath("//table/tbody/tr/td[2]");
        By transactionColumn = By.xpath("//table/tbody/tr/td[3]");
        By backButtonClick = By.xpath("//button[@ng-click='back()']");
        By withdrawButtonClick = By.xpath("//button[@ng-click='withdrawl()']");
        By writeAmount = By.xpath("//input[@ng-model='amount']");
        By withdrawSubmit = By.xpath("//button[@type='submit']");
        By transactionSuccessfulMessage = By.xpath("//span[@ng-show='message']");
        By newTransactionRow = By.xpath("//table/tbody/tr[2]/td[3]");

// 2. Confirm the Title of the page is XYZ Bank
            String titlePage = driver.getTitle(); // Get the title of the page
            Assert.assertEquals(titlePage, "XYZ Bank"); // Check if it's equal to XYZ
            System.out.println(titlePage); // Print out the title of the webpage

// 3. Click on Customer Login
            Thread.sleep(2000);
            WebElement customerLoginButton = driver.findElement(customerLoginButtonClick); // Find the element
            customerLoginButton.click(); // Click on the button

// 4. Choose any Name from the Your Name drop down
            Thread.sleep(2000);
            WebElement dropDownSelectName = driver.findElement(selectName); // Find the dropdown
            dropDownSelectName.click();
            Select select = new Select(dropDownSelectName);
            select.selectByVisibleText("Harry Potter");

// 5. Click on Login
            WebElement loginButton = driver.findElement(loginButtonClick); // Find the element
            loginButton.click(); // Click on the login button

// 6. Write an assertion to confirm the Name selected in Step 4 is displayed after Welcome
            WebElement welcomeNameSelected = driver.findElement(selectName); // Find the element
            String welcomeText = welcomeNameSelected.getText();
            Assert.assertTrue(welcomeText.contains("Harry Potter"));

// 7. Confirm the Currency is Dollar (Use Assertion)
            Thread.sleep(2000);
            WebElement currencyText = driver.findElement(getCurrency); // Find the element
            Assert.assertEquals(currencyText.getText(), "Dollar");

// 8. Click on Deposit
            Thread.sleep(2000);
            WebElement depositButton = driver.findElement(depositButtonClick); // Find the element
            depositButton.click(); // Click on the deposit button

// 9. Enter the amount in Amount to be Deposited textbox
            Thread.sleep(2000);
            WebElement amountInput = driver.findElement(enterAmountInput); // Find the element
            amountInput.sendKeys("100"); // Write 100

// 10. Click on Deposit
            Thread.sleep(2000);
            WebElement depositSubmitButton = driver.findElement(depositSubmitButtonClick); // Find the element
            depositSubmitButton.click(); // Click on the submit button

// 11. Confirm "Deposit Successful" is displayed
            Thread.sleep(2000);
            WebElement depositSuccessMessage = driver.findElement(successMessage); // Find the element
            Assert.assertEquals(depositSuccessMessage.getText(), "Deposit Successful");

// 12. Click on Transactions
            WebElement transactionsButton = driver.findElement(transactionButtonClick); // Find the element
            transactionsButton.click(); // Click on the transaction button

// 13. Confirm the amount entered in Step 9 is displayed under Amount column
            Thread.sleep(2000);
            WebElement amountColumn = driver.findElement(getamountColumn); // Find the element
            Assert.assertEquals(amountColumn.getText(), "100");

// 14. Confirm the Transaction Type is credit
            WebElement transactionTypeColumn = driver.findElement(transactionColumn); // Find the element
            Assert.assertEquals(transactionTypeColumn.getText(), "Credit");

// 15. Click on Back button
            WebElement backButton = driver.findElement(backButtonClick); // Find the element
            backButton.click(); // Click on the back button

// 16. Click on Withdraw
            Thread.sleep(2000);
            WebElement withdrawButton = driver.findElement(withdrawButtonClick); // Find the element
            withdrawButton.click(); // Click on the withdraw button

// 17. Enter the same amount you deposited
            Thread.sleep(2000);
            WebElement withdrawAmountInput = driver.findElement(writeAmount); // Find the element
            withdrawAmountInput.sendKeys("100"); // Write 100

// 18. Click on Withdraw
            Thread.sleep(2000);
            WebElement withdrawSubmitButton = driver.findElement(withdrawSubmit); // Find the element
            withdrawSubmitButton.click(); // Click on the submit button

// 19. Confirm "Transaction Successful" is displayed
            Thread.sleep(2000);
            WebElement withdrawSuccessMessage = driver.findElement(transactionSuccessfulMessage); // Find the element
            Assert.assertEquals(withdrawSuccessMessage.getText(), "Transaction successful");

// 20. Click on Transactions
            Thread.sleep(2000);
            driver.findElement(transactionButtonClick).click(); // Click on the transaction button

// 21. Confirm there is one more row with Transaction Type is debit
            WebElement newTransactionTypeColumn = driver.findElement(newTransactionRow); // Find the element
            Assert.assertEquals(newTransactionTypeColumn.getText(), "Debit");

// 22. Exit the browser
            driver.close(); // Close the tab
            driver.quit(); // close the browser

    }
}
