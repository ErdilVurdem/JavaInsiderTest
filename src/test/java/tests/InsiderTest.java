package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UseInsiderCareersPage;
import pages.UseInsiderHomePage;
import pages.UseInsiderOpenPositionsPage;
import pages.UseInsiderQualityAssurancePage;
import utilities.*;

public class InsiderTest  extends TestBaseRapor {
    @Test
    public void careerPageTest(){
        Driver.getDriver().get(ConfigReader.getProperty("UseInsiderMainPage")); //Use Insider ana sayfasına erişim sağlanır

        UseInsiderHomePage useInsiderHomePage=new UseInsiderHomePage();
        useInsiderHomePage.rejectCookiesButton.click(); // Cookiler reddedilir
        useInsiderHomePage.companyDropdownButton.click(); // Company butonuna tıklanır
        useInsiderHomePage.careersButton.click(); // Careers butonuna tıklanır
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://useinsider.com/careers/");
                                                // Use Insider Careers sayfasında olunduğu doğrulanır
        UseInsiderCareersPage useInsiderCareersPage=new UseInsiderCareersPage();
        Assert.assertTrue(useInsiderCareersPage.findYourCallingSection.isDisplayed()); //Teamlerin göründüğü doğrulanır
        Assert.assertTrue(useInsiderCareersPage.ourLocationsSection.isDisplayed()); //Locationların göründüğü doğrulanır
        Assert.assertTrue(useInsiderCareersPage.lifeAtInsiderSection.isDisplayed()); // Life At Insider bölümünün
                                                                                    // göründüğü doğrulanır
    }

    @Test
    public  void qualityAssurancePageTest(){
        Driver.getDriver().get(ConfigReader.getProperty("UseInsiderQualityAssurancePage"));
        UseInsiderQualityAssurancePage useInsiderQualityAssurancePage=new UseInsiderQualityAssurancePage();
        useInsiderQualityAssurancePage.acceptCookiesButton.click();
        useInsiderQualityAssurancePage.seeAllQaJobsButton.click();
        UseInsiderOpenPositionsPage useInsiderOpenPositionsPage=new UseInsiderOpenPositionsPage();
        ReusableMethods.scrollPageCertainAmount(0,400);
        Select selectLocation = new Select(useInsiderOpenPositionsPage.filterByLocationDropdown);
        selectLocation.selectByVisibleText("Istanbul, Turkey");
        Select selectDepartment = new Select(useInsiderOpenPositionsPage.filterByDepartmentDropdown);
        selectDepartment.selectByVisibleText("Quality Assurance");

        ReusableMethods.wait(5);

        do {
            for (int i = 0; i < useInsiderOpenPositionsPage.browseOpenPositionsList.size(); i++) {
                Assert.assertTrue(useInsiderOpenPositionsPage.browseOpenPositionsList.get(i).isDisplayed());
                Assert.assertTrue(useInsiderOpenPositionsPage.positionTitleList.get(i).getText().contains("Quality Assurance"));
                Assert.assertTrue(useInsiderOpenPositionsPage.positionDepartmentList.get(i).getText().contains("Quality Assurance"));
                Assert.assertTrue(useInsiderOpenPositionsPage.positionLocationList.get(i).getText().contains("Istanbul, Turkey"));
            }
            ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.nextPageArrow);
            ReusableMethods.wait(2);
            if (useInsiderOpenPositionsPage.nextPageArrow.isEnabled()){
                ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.nextPageArrow);
                useInsiderOpenPositionsPage.nextPageArrow.click();
            }
        } while (useInsiderOpenPositionsPage.nextPageArrow.isEnabled());

        ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.firstRoleButton);
        useInsiderOpenPositionsPage.firstRoleButton.click();
        ReusableMethods.switchWindowWithTitle("Insider. - Account Director",Driver.getDriver());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://jobs.lever.co/"));

        Driver.quitDriver();
    }
}
