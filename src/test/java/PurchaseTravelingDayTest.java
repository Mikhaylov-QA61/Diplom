import data.DataHelper;
import data.SQLHelper;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import page.StartPage;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTravelingDayTest {

    @BeforeEach
    void setup() {
        open("http://localhost:8080");

    }


    @Test
    @Order(1)
    @DisplayName("All fields are filled with valid data(PaymentPage, RUS)")
    void paymentFormShouldHaveAllValidFieldRUS(){
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderRus());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.notificationGood();
        String actual= SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected,actual);
    }
    @Test
    @Order(2)
    @DisplayName("All fields are filled with valid data(CreditPage, RUS)")
    void creditFormShouldHaveAllValidFieldRUS(){
        StartPage start = new StartPage();
        start.startPage();
        var CreditPage = start.buyInCredit();

        CreditPage.setCardNumber(DataHelper.getValidWorkCard());
        CreditPage.setMonth(DataHelper.getValidMonth());
        CreditPage.setYear(DataHelper.getValidYear());
        CreditPage.setHolder(DataHelper.getValidHolderRus());
        CreditPage.setCVC(DataHelper.getValidCVCCode());
        CreditPage.buttonContinueClick();
        CreditPage.notificationGood();
        String actual= SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected,actual);
    }

    @Test
    @Order(3)
    @DisplayName("All fields are filled with valid data(PaymentPage, ENG)")
    void paymentFormShouldHaveAllValidFieldENG(){
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.notificationGood();
        String actual= SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected,actual);
    }
    @Test
    @Order(4)
    @DisplayName("All fields are filled with valid data(CreditPage, ENG)")
    void creditFormShouldHaveAllValidFieldENG(){
        StartPage start = new StartPage();
        start.startPage();
        var CreditPage = start.buyInCredit();

        CreditPage.setCardNumber(DataHelper.getValidWorkCard());
        CreditPage.setMonth(DataHelper.getValidMonth());
        CreditPage.setYear(DataHelper.getValidYear());
        CreditPage.setHolder(DataHelper.getValidHolderENG());
        CreditPage.setCVC(DataHelper.getValidCVCCode());
        CreditPage.buttonContinueClick();
        CreditPage.notificationGood();
        String actual= SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected,actual);
    }

    @Test
    @Order(5)
    @DisplayName("All fields are filled with valid data and blocked card(PaymentPage, RUS)")
    void paymentFormShouldHaveAllValidFieldBlockedCardRUS(){
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidBlockedCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderRus());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.notificationGood();
        String actual= SQLHelper.getPaymentStatus();
        String expected = "DECLINED";
        assertEquals(expected,actual);
    }
//    @Test
//    @Order(4)
//    @DisplayName("All fields are filled with valid data(CreditPage, ENG)")
//    void creditFormShouldHaveAllValidFieldENG(){
//        StartPage start = new StartPage();
//        start.startPage();
//        var CreditPage = start.buyInCredit();
//
//        CreditPage.setCardNumber(DataHelper.getValidWorkCard());
//        CreditPage.setMonth(DataHelper.getValidMonth());
//        CreditPage.setYear(DataHelper.getValidYear());
//        CreditPage.setHolder(DataHelper.getValidHolderENG());
//        CreditPage.setCVC(DataHelper.getValidCVCCode());
//        CreditPage.buttonContinueClick();
//        CreditPage.notificationGood();
//        String actual= SQLHelper.getPaymentStatus();
//        String expected = "APPROVED";
//        assertEquals(expected,actual);
//    }
}
