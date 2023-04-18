package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FindTransactionsPage extends BasePage{
    @FindBy(css = "#aa_description")
    @CacheLookup
    private WebElement descriptionInputBox;
    @FindBy(xpath = "//button")
    private WebElement findButton;
    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody//tr/td[2]")
    private List<WebElement> descriptions;
    @FindBy(css = "#aa_fromDate")
    public WebElement datesInputBox;
    @FindBy(css = "#aa_toDate")
    public  WebElement toDatesInputBox;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> datesColumn;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[3]")
    public List<WebElement> depositColumn;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[4]")
    public List<WebElement> withdrawalColumn;
    @FindBy(css = "#aa_type")
    public WebElement typeSelect;
    public void setTypeSelect(String selectName){
        Select select=new Select(typeSelect);
        select.selectByVisibleText(selectName);
        findButton.click();
    }
public void verifyDepositempty(){
    List<String> elementsText = BrowserUtils.getElementsText(depositColumn);
    boolean b = elementsText.stream().allMatch(n -> n.isEmpty());//allMatch:hepsi içeriyor mu//anyMatch:sadece bir tanesi içeriyor mu
    Assert.assertTrue(b);

}
public void verifyWithdrawalempty(){
    List<String> elementsText = BrowserUtils.getElementsText(withdrawalColumn);
    boolean b = elementsText.stream().allMatch(n->n.isEmpty());//allMatch:hepsi içeriyor mu//anyMatch:sadece bir tanesi içeriyor mu
    Assert.assertTrue(b);

}

    public void verifyDepositUnder(){
        List<String> elementsText = BrowserUtils.getElementsText(depositColumn);
        boolean b = elementsText.stream().anyMatch(n -> !n.isEmpty());//allMatch:hepsi içeriyor mu//anyMatch:sadece bir tanesi içeriyor mu
        Assert.assertTrue(b);


    }
    public void verifywithdrawalUnder(){
        List<String> elementsText = BrowserUtils.getElementsText(withdrawalColumn);
        boolean b = elementsText.stream().anyMatch(n -> !n.isEmpty());//allMatch:hepsi içeriyor mu//anyMatch:sadece bir tanesi içeriyor mu
        Assert.assertTrue(b);


    }
    public void fillDate(String d1,String d2){

        datesInputBox.sendKeys(d1);
        toDatesInputBox.sendKeys(d2);

    }
    public void verifyDatesOfRange(String fromDate,String toDate) throws ParseException {
        List<String> stringOfDates = BrowserUtils.getElementsText(datesColumn);
        List<Date> datesOfTransactions=new ArrayList<>();
        SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
        for (String stringOfDate : stringOfDates) {
            Date date = sdFormat.parse(stringOfDate);
            datesOfTransactions.add(date);
        }
        Date fromdate = sdFormat.parse(fromDate);
        Date todate = sdFormat.parse(toDate);
        for (Date datesOfTransaction : datesOfTransactions) {
         Assert.assertTrue( datesOfTransaction.compareTo(fromdate)>=0 && datesOfTransaction.compareTo(todate)<=0);
        }
    }
    public boolean isDatesSorted() throws ParseException {
        List<String> stringOfDates = BrowserUtils.getElementsText(datesColumn);
        List<Date> datesOfTransactions=new ArrayList<>();
        SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
        for (String stringOfDate : stringOfDates) {
            Date date = sdFormat.parse(stringOfDate);
            datesOfTransactions.add(date);
        }
        int n=datesOfTransactions.size();
        for (int i = 0; i <n ; i++) {
            for (int j =i+1; j < n; j++) {
                if(datesOfTransactions.get(i).compareTo(datesOfTransactions.get(j))<0){
                    return false;
                }

            }

        }
        return true;



    }


    public void verifyDate(String d1,String d2) throws ParseException {
        List<String> resultDate = BrowserUtils.getElementsText(datesColumn);
        for (String s : resultDate) {
            List<String> dateList=List.of(d1,s,d2);
            Assert.assertTrue(isDateOrdered(dateList));
        }




        }


    public boolean isDateOrdered(List<String> stringOfDates) throws ParseException {
        List<Date> dates = new ArrayList<>();

        for (String stringOfDate : stringOfDates) {
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdformat.parse(stringOfDate);
            dates.add(date);
        }
        for (int i = 0; i < dates.size(); i++) {
            for (int j = i + 1; j < dates.size(); j++) {
                if (dates.get(i).compareTo(dates.get(j)) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }






    public List<String>getAllTextsFromDescriptions(){
       return BrowserUtils.getElementsText(descriptions);

    }
    public void tabOnFindButton(){
        findButton.click();
    }

    public WebElement getDescriptionInputBox() {
        return descriptionInputBox;
    }
}
