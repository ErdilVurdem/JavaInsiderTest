package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UseInsiderCareersPage {

    public UseInsiderCareersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "career-find-our-calling")
    public WebElement findYourCallingSection; // Find Your Calling bölümü

    @FindBy (id = "career-our-location")
    public WebElement ourLocationsSection; // Our Locations bölümü

    @FindBy (css = ".elementor-container.elementor-column-gap-default")
    public WebElement lifeAtInsiderSection; // Life At Insider bölümü
}
