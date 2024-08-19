package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UseInsiderQualityAssurancePage {

    public UseInsiderQualityAssurancePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "wt-cli-accept-all-btn")
    public WebElement acceptCookiesButton;  // Cookileri kabul et butonu

    @FindBy (css = ".btn.btn-outline-secondary.rounded.text-medium.mt-2.py-3.px-lg-5.w-100.w-md-50")
    public WebElement seeAllQaJobsButton;   // See All QA Jobs butonu
}
