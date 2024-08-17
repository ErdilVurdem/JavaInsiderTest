package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UseInsiderOpenPositionsPage {

    public UseInsiderOpenPositionsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "filter-by-location")
    public WebElement filterByLocationDropdown;

    @FindBy (id = "filter-by-department")
    public WebElement filterByDepartmentDropdown;

    @FindBy (id = "resultCounter")
    public WebElement resultCounter;

    @FindBy (css = ".position-list-item-wrapper.bg-light")
    public List<WebElement> browseOpenPositionsList;

    @FindBy (css = ".position-title.font-weight-bold")
    public List<WebElement> positionTitleList;

    @FindBy (css = ".position-department.text-large.font-weight-600.text-primary")
    public List<WebElement> positionDepartmentList;

    @FindBy (css = ".position-location.text-large")
    public List<WebElement> positionLocationList;

    @FindBy (xpath = "(//*[@class='btn btn-yellow rounded has-icon page-button next pr-4'])[2]")
    public WebElement nextPageArrow;

    @FindBy (xpath = "(//*[@role='presentation'])[2]")
    public WebElement firstArrow;


    @FindBy (xpath = "(//*[@role='presentation'])[4]")
    public WebElement secondArrow;
}
