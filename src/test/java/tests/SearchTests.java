package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void returnToHome() {
        app.search().returnToHome();
    }


    @Test
    public void searchCurrentMonth() {
        app.search().searchCurrentMonth("Tel Aviv", "7/25/2022", "7/31/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne1.png");
    }

    @Test
    public void searchNextMonth() {
        app.search().searchNextMonth("Tel Aviv", "8/20/2022", "8/31/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne2.png");
    }

    @Test
    public void searchCurrentYear() {
        app.search().searchCurrentYear("Haifa", "8/10/2022", "8/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne3.png");
    }

    @Test
    public void searchCurrentYear1() {
        app.search().searchCurrentYear("Haifa", "8/10/2022", "10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne3.png");
    }

    @Test
    public void searchCurrentYearLocalDate() {
        app.search().searchCurrentYearLocalDate("Haifa", "8/10/2022", "10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne4.png");

    }

    @Test(groups = {"web"})
    public void searchAnyPeriodYearLocalDate() {
        app.search().searchAnyPeriodYearLocalDate("Tel Aviv", "8/10/2022", "3/20/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne5.png");

    }

    @Test
    public void searchAnyPeriodYearLocalDate2() {
        app.search().searchAnyPeriodYearLocalDate2("Ashkelon", "8/10/2022", "3/20/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
        app.search().takeScreenShots("src/test/screenshots/screne6.png");

    }

    @Test
    public void searchPastPeriod() {
        app.search().searchPastPeriod("Rehovot", "2/10/2022", "3/15/2022");
        app.search().submitWithoutWait();
        Assert.assertTrue(app.search().isYallaButtonNotActive());
        app.search().isPeriodInPast();

    }

   /* @AfterMethod
    public void returnToHome() {
        app.search().returnToHome();
    }*/

}
