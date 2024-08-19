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
    public WebElement filterByLocationDropdown; // Filter by Location butonu

    @FindBy (id = "filter-by-department")
    public WebElement filterByDepartmentDropdown; // Filter by Department butonu

    @FindBy (css = ".position-list-item-wrapper.bg-light")
    public List<WebElement> browseOpenPositionsList; // Browse open positions listesindeki her bir elemanın listesi

    @FindBy (css = ".position-title.font-weight-bold")
    public List<WebElement> positionTitleList; // Browse open positions listesindeki her bir elemanın title'ının listesi

    @FindBy (css = ".position-department.text-large.font-weight-600.text-primary")
    public List<WebElement> positionDepartmentList; //Browse open positions listesindeki her bir elemanın
                                                    // department'ının listesi

    @FindBy (css = ".position-location.text-large")
    public List<WebElement> positionLocationList; //Browse open positions listesindeki her bir elemanın
                                                  // location'ının listesi

    @FindBy (xpath = "(//*[@class='btn btn-yellow rounded has-icon page-button next pr-4'])[2]")
    public WebElement nextPageArrow; // Bir sonraki sayfaya geç butonu

    @FindBy (xpath = "(//*[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[1]")
    public WebElement firstRoleButton; // Browse open positions listesindeki ilk elemana ait View Role butonu

}
