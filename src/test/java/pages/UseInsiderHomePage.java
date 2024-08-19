package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UseInsiderHomePage {

    public UseInsiderHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "wt-cli-reject-btn")
    public WebElement rejectCookiesButton; // Cookileri reddet butonu

    @FindBy (css = ".nav-item.dropdown:nth-of-type(6)")
    public WebElement companyDropdownButton; // Company dropdown butonu

    @FindBy (xpath = "(//*[@class='dropdown-sub'])[21]")
    public WebElement careersButton; // Company Dropdown içerisindeki Careers butonu




}
