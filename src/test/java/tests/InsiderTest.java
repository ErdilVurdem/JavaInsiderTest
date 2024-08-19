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
        Driver.getDriver().get(ConfigReader.getProperty("UseInsiderMainPage"));
                                                                        //Use Insider ana sayfasına erişim sağlanır

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

    /*
        NOT: qualityAssurancePageTest iki ayrı şekilde hazırlanmıştır. Normalde 2 numaralı testin daha geniş kapsamlı ve
             her durumu değerlendirebilen bir test olması sebebiyle koşulması daha sağlıklıdır. Fakat 2 numaralı testin
             koşumunda bilgisayardan bilgisayara değişen tepkiler verildiği (next page butonunun aktif olmaması
             gerektiği halde aktif olması gibi) görülmesi sebebiyle daha basit yapıda olan 1 numaralı test de yazılmak
             durumunda kalınmıştır.
     */

    // TEST 1
    @Test
    public void qualityAssurancePageTest1(){
        Driver.getDriver().get(ConfigReader.getProperty("UseInsiderQualityAssurancePage"));
                            // Use Insider Quality Assurance sayfasına erişim sağlanır

        UseInsiderQualityAssurancePage useInsiderQualityAssurancePage=new UseInsiderQualityAssurancePage();
        useInsiderQualityAssurancePage.acceptCookiesButton.click(); // Cookiler kabul edilir
        useInsiderQualityAssurancePage.seeAllQaJobsButton.click(); // See All QA Jobs butonuna tıklanır

        UseInsiderOpenPositionsPage useInsiderOpenPositionsPage=new UseInsiderOpenPositionsPage();
        ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.filterByLocationDropdown);
                            // Sayfa filtrelerin olduğu kısma kadar kaydırılır
        Select selectLocation = new Select(useInsiderOpenPositionsPage.filterByLocationDropdown);
        selectLocation.selectByVisibleText("Istanbul, Turkey");
                            // Filter by Location kısmına Istanbul, Turkey girilir
        Select selectDepartment = new Select(useInsiderOpenPositionsPage.filterByDepartmentDropdown);
        selectDepartment.selectByVisibleText("Quality Assurance");
                            // Filter by Department kısmına Quality Assurance girilir

        ReusableMethods.wait(2); // Filtreleme işleminin yapılması için 2 saniye beklenilir

        for (int i = 0; i < useInsiderOpenPositionsPage.browseOpenPositionsList.size(); i++) {
            Assert.assertTrue(useInsiderOpenPositionsPage.browseOpenPositionsList.get(i).isDisplayed());
                             // Sayfada listelenen tüm ilanların göründüğü doğrulanır
            Assert.assertTrue(useInsiderOpenPositionsPage.positionTitleList
                                                .get(i).getText().contains("Quality Assurance"));
                            // Sayfada listelenen tüm ilanların Title kısmında Quality Assurance geçtiği doğrulanır
            Assert.assertTrue(useInsiderOpenPositionsPage.positionDepartmentList
                                                .get(i).getText().contains("Quality Assurance"));
                            // Sayfada listelenen tüm ilanların Department kısmında Quality Assurance geçtiği doğrulanır
            Assert.assertTrue(useInsiderOpenPositionsPage.positionLocationList.get(i)
                                                .getText().contains("Istanbul, Turkey"));
                            // Sayfada listelenen tüm ilanların Location kısmında Istanbul, Turkey geçtiği doğrulanır
        }

        ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.firstRoleButton);
                            // Listelenen ilk elemanın View Role butonuna kadar ekran kaydırılır
        useInsiderOpenPositionsPage.firstRoleButton.click();
                            // Listelenen ilk elemanın View Role butonuna tıklanır

        ReusableMethods.switchWindowWithTitle("Insider. - Account Director",Driver.getDriver());
                            // Açılan yeni sekmedeki sayfaya sayfa title'ı ile geçiş sağlanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://jobs.lever.co/"));
                            // Açılan sayfanın Lever Application form page sayfası olduğu doğrulanır

        Driver.quitDriver(); // Sayfa kapatılır
    }


    // TEST 2
    @Test
    public  void qualityAssurancePageTest2(){
        Driver.getDriver().get(ConfigReader.getProperty("UseInsiderQualityAssurancePage"));
                            // Use Insider Quality Assurance sayfasına erişim sağlanır

        UseInsiderQualityAssurancePage useInsiderQualityAssurancePage=new UseInsiderQualityAssurancePage();
        useInsiderQualityAssurancePage.acceptCookiesButton.click(); // Cookiler kabul edilir
        useInsiderQualityAssurancePage.seeAllQaJobsButton.click(); // See All QA Jobs butonuna tıklanır

        UseInsiderOpenPositionsPage useInsiderOpenPositionsPage=new UseInsiderOpenPositionsPage();
        ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.filterByLocationDropdown);
                            // Sayfa filtrelerin olduğu kısma kadar kaydırılır
        Select selectLocation = new Select(useInsiderOpenPositionsPage.filterByLocationDropdown);
        selectLocation.selectByVisibleText("Istanbul, Turkey");
                            // Filter by Location kısmına Istanbul, Turkey girilir
        Select selectDepartment = new Select(useInsiderOpenPositionsPage.filterByDepartmentDropdown);
        selectDepartment.selectByVisibleText("Quality Assurance");
                            // Filter by Department kısmına Quality Assurance girilir

        ReusableMethods.wait(2); // Filtreleme işleminin yapılması için 2 saniye beklenilir

        do {
            for (int i = 0; i < useInsiderOpenPositionsPage.browseOpenPositionsList.size(); i++) {
                Assert.assertTrue(useInsiderOpenPositionsPage.browseOpenPositionsList.get(i).isDisplayed());
                        // Sayfada listelenen tüm ilanların göründüğü doğrulanır
                Assert.assertTrue(useInsiderOpenPositionsPage.positionTitleList
                        .get(i).getText().contains("Quality Assurance"));
                        // Sayfada listelenen tüm ilanların Title kısmında Quality Assurance geçtiği doğrulanır
                Assert.assertTrue(useInsiderOpenPositionsPage.positionDepartmentList
                        .get(i).getText().contains("Quality Assurance"));
                        // Sayfada listelenen tüm ilanların Department kısmında Quality Assurance geçtiği doğrulanır
                Assert.assertTrue(useInsiderOpenPositionsPage.positionLocationList.get(i)
                        .getText().contains("Istanbul, Turkey"));
                        // Sayfada listelenen tüm ilanların Location kısmında Istanbul, Turkey geçtiği doğrulanır
            }
            ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.nextPageArrow);
                        // Next page okuna kadar ekran kaydırılır
            ReusableMethods.wait(2); // İki saniye beklenir
            if (useInsiderOpenPositionsPage.nextPageArrow.isEnabled()){ // Eğer next page oku tıklanabilir durumdaysa...
                useInsiderOpenPositionsPage.nextPageArrow.click(); // Next page okuna tıklanır
            }
        } while (useInsiderOpenPositionsPage.nextPageArrow.isEnabled());
                        // yukarıdaki do bir kez çalışır ve buradaki while next page arrow'unun tıklanabilir olduğu
                        // her durumda do'nun içini bir kez daha çalıştırılacağını belirtir

        ReusableMethods.scrollToElement(useInsiderOpenPositionsPage.firstRoleButton);
                        // Listelenen ilk elemanın View Role butonuna kadar ekran kaydırılır
        useInsiderOpenPositionsPage.firstRoleButton.click();
                        // Listelenen ilk elemanın View Role butonuna tıklanır
        ReusableMethods.switchWindowWithTitle("Insider. - Account Director",Driver.getDriver());
                        // Açılan yeni sekmedeki sayfaya sayfa title'ı ile geçiş sağlanır
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://jobs.lever.co/"));
                        // Açılan sayfanın Lever Application form page sayfası olduğu doğrulanır

        Driver.quitDriver(); // Sayfa kapatılır
    }
}
