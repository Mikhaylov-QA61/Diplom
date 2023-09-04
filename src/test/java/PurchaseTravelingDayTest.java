import data.DataHelper;
import page.StartPage;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class PurchaseTravelingDayTest {

    @BeforeEach
    void setup() {
        open("http://localhost:8080");

    }

    @Test
    void testForm(){
        StartPage start = new StartPage();

        start.startPage();
        var creditPage = start.buyInCredit();

//        creditPage.setCardNumber("111");
//        creditPage.setMonth(DataHelper.getInvalidPreviousMonth());
//        creditPage.setYear(DataHelper.getInvalidYearBelowRange());
//        creditPage.setHolder(DataHelper.getHolderOverFlowString());
        creditPage.setCVC(DataHelper.getValidCVCCode());
        creditPage.buttonContinueClick();


    }

}
