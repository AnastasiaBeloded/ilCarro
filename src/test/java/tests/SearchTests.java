package tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test(enabled = false)
    public void searchCurrentMonth(){

        app.search().searchCurrentMonth("Tel Aviv","7/20/2022","7/31/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
    @Test(enabled = false)
    public void searchNextMonth(){

        app.search().searchNextMonth("Tel Aviv","8/20/2022","8/31/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test(enabled = false)
    public void searchCurrentYear(){
        app.search().searchCurrentYear("Haifa","8/10/2022","8/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }
    @Test(enabled = false)
    public void searchCurrentYear1(){
        app.search().searchCurrentYear("Haifa","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }

    @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalDate("Haifa","8/10/2022","10/20/2022");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }
    @Test
    public void searchAnyPeriodYearLocalDate(){
        app.search().searchAnyPeriodYearLocalDate("Tel Aviv","8/10/2022","3/20/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());
    }
    @Test
    public void searchAnyPeriodYearLocalDate2(){
        app.search().searchAnyPeriodYearLocalDate2("Ashkelon","8/10/2022","3/20/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        Assert.assertTrue(app.search().isPageResultAppeared());

    }

    @Test(enabled = false)
    public void searchPastPeriod(){

    }

    @AfterMethod
    public void returnToHome(){
        app.search().returnToHome();
    }

}
