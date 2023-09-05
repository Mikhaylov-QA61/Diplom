import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTravelingDayTest {

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        SQLHelper.clearDB();

    }


    // Positive scenarios

    @Test
    @Order(1)
    @DisplayName("All fields are filled with valid data(PaymentPage, RUS)")
    void paymentFormShouldHaveAllValidFieldRUS() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderRus());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationGood();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    @DisplayName("All fields are filled with valid data(CreditPage, RUS)")
    void creditFormShouldHaveAllValidFieldRUS() {
        StartPage start = new StartPage();
        start.startPage();
        var CreditPage = start.buyInCredit();

        CreditPage.setCardNumber(DataHelper.getValidWorkCard());
        CreditPage.setMonth(DataHelper.getValidMonth());
        CreditPage.setYear(DataHelper.getValidYear());
        CreditPage.setHolder(DataHelper.getValidHolderRus());
        CreditPage.setCVC(DataHelper.getValidCVCCode());
        CreditPage.buttonContinueClick();
        CreditPage.checkNotificationGood();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    @DisplayName("All fields are filled with valid data(PaymentPage, ENG)")
    void paymentFormShouldHaveAllValidFieldENG() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationGood();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    @DisplayName("All fields are filled with valid data(CreditPage, ENG)")
    void creditFormShouldHaveAllValidFieldENG() {
        StartPage start = new StartPage();
        start.startPage();
        var CreditPage = start.buyInCredit();

        CreditPage.setCardNumber(DataHelper.getValidWorkCard());
        CreditPage.setMonth(DataHelper.getValidMonth());
        CreditPage.setYear(DataHelper.getValidYear());
        CreditPage.setHolder(DataHelper.getValidHolderENG());
        CreditPage.setCVC(DataHelper.getValidCVCCode());
        CreditPage.buttonContinueClick();
        CreditPage.checkNotificationGood();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test // БАГ
    @Order(5)
    @DisplayName("All fields are filled with valid data and blocked card(PaymentPage, RUS)")
    void paymentFormShouldHaveAllValidFieldBlockedCardRUS() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidBlockedCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderRus());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationError();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "DECLINED";
        assertEquals(expected, actual);
    }

    @Test // БАГ
    @Order(6)
    @DisplayName("All fields are filled with valid data and blocked card(CreditPage, RUS)")
    void creditFormShouldHaveAllValidFieldBlockedCardRUS() {
        StartPage start = new StartPage();
        start.startPage();
        var CreditPage = start.buyInCredit();

        CreditPage.setCardNumber(DataHelper.getValidBlockedCard());
        CreditPage.setMonth(DataHelper.getValidMonth());
        CreditPage.setYear(DataHelper.getValidYear());
        CreditPage.setHolder(DataHelper.getValidHolderRus());
        CreditPage.setCVC(DataHelper.getValidCVCCode());
        CreditPage.buttonContinueClick();
        CreditPage.checkNotificationError();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "DECLINED";
        assertEquals(expected, actual);
    }

    @Test // БАГ
    @Order(7)
    @DisplayName("All fields are filled with valid data and blocked card(PaymentPage, ENG)")
    void paymentFormShouldHaveAllValidFieldBlockedCardENG() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidBlockedCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationError();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "DECLINED";
        assertEquals(expected, actual);
    }

    @Test // БАГ
    @Order(8)
    @DisplayName("All fields are filled with valid data and blocked card(CreditPage, ENG)")
    void creditFormShouldHaveAllValidFieldBlockedCardENG() {
        StartPage start = new StartPage();
        start.startPage();
        var CreditPage = start.buyInCredit();

        CreditPage.setCardNumber(DataHelper.getValidBlockedCard());
        CreditPage.setMonth(DataHelper.getValidMonth());
        CreditPage.setYear(DataHelper.getValidYear());
        CreditPage.setHolder(DataHelper.getValidHolderENG());
        CreditPage.setCVC(DataHelper.getValidCVCCode());
        CreditPage.buttonContinueClick();
        CreditPage.checkNotificationError();
        String actual = SQLHelper.getPaymentStatus();
        String expected = "DECLINED";
        assertEquals(expected, actual);
    }


    // Negative scenarios

    @Test
    @Order(9)
    @DisplayName("All fields are empty(PaymentPage)")
    void paymentFormShouldHaveAllEmptyField() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationInvalidFormat();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(10)
    @DisplayName("All fields are empty(CreditPage)")
    void CreditFormShouldHaveAllEmptyField() {
        StartPage start = new StartPage();
        start.startPage();
        var creditPage = start.buyInCredit();

        creditPage.buttonContinueClick();
        creditPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(11)
    @DisplayName("Number card empty,rest fields are filled with valid data(PaymentPage)")
    void paymentFormShouldHaveEmptyNumberCardRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();


        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(12)
    @DisplayName("Number card empty,rest fields are filled with valid data(CreditPage)")
    void CreditFormShouldHaveEmptyNumberCardRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var creditPage = start.buyInCredit();

        creditPage.setMonth(DataHelper.getValidMonth());
        creditPage.setYear(DataHelper.getValidYear());
        creditPage.setHolder(DataHelper.getValidHolderENG());
        creditPage.setCVC(DataHelper.getValidCVCCode());
        creditPage.buttonContinueClick();
        creditPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(13)
    @DisplayName("Month empty,rest fields are filled with valid data(PaymentPage)")
    void paymentFormShouldHaveEmptyMonthRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();


        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(14)
    @DisplayName("Month empty,rest fields are filled with valid data(CreditPage)")
    void CreditFormShouldHaveEmptyMonthRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var creditPage = start.buyInCredit();

        creditPage.setCardNumber(DataHelper.getValidWorkCard());
        creditPage.setYear(DataHelper.getValidYear());
        creditPage.setHolder(DataHelper.getValidHolderENG());
        creditPage.setCVC(DataHelper.getValidCVCCode());
        creditPage.buttonContinueClick();
        creditPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(15)
    @DisplayName("Year empty,rest fields are filled with valid data(PaymentPage)")
    void paymentFormShouldHaveEmptyYearRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(16)
    @DisplayName("Year empty,rest fields are filled with valid data(CreditPage)")
    void CreditFormShouldHaveEmptyYearRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var creditPage = start.buyInCredit();

        creditPage.setCardNumber(DataHelper.getValidWorkCard());
        creditPage.setMonth(DataHelper.getValidMonth());
        creditPage.setHolder(DataHelper.getValidHolderENG());
        creditPage.setCVC(DataHelper.getValidCVCCode());
        creditPage.buttonContinueClick();
        creditPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test
    @Order(17)
    @DisplayName("Holder empty,rest fields are filled with valid data(PaymentPage)")
    void paymentFormShouldHaveEmptyHolderRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setCVC(DataHelper.getValidCVCCode());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test
    @Order(18)
    @DisplayName("Holder empty,rest fields are filled with valid data(CreditPage)")
    void CreditFormShouldHaveEmptyHolderRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var creditPage = start.buyInCredit();

        creditPage.setCardNumber(DataHelper.getValidWorkCard());
        creditPage.setMonth(DataHelper.getValidMonth());
        creditPage.setYear(DataHelper.getValidYear());
        creditPage.setCVC(DataHelper.getValidCVCCode());
        creditPage.buttonContinueClick();
        creditPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }


    @Test // БАГ
    @Order(19)
    @DisplayName("CVC empty,rest fields are filled with valid data(PaymentPage)")
    void paymentFormShouldHaveEmptyCVCRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var paymentPage = start.buy();

        paymentPage.setCardNumber(DataHelper.getValidWorkCard());
        paymentPage.setMonth(DataHelper.getValidMonth());
        paymentPage.setYear(DataHelper.getValidYear());
        paymentPage.setHolder(DataHelper.getValidHolderENG());
        paymentPage.buttonContinueClick();
        paymentPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }

    @Test // БАГ
    @Order(20)
    @DisplayName("CVC empty,rest fields are filled with valid data(CreditPage)")
    void CreditFormShouldHaveEmptyCVCRestFieldValid() {
        StartPage start = new StartPage();
        start.startPage();
        var creditPage = start.buyInCredit();

        creditPage.setCardNumber(DataHelper.getValidWorkCard());
        creditPage.setMonth(DataHelper.getValidMonth());
        creditPage.setYear(DataHelper.getValidYear());
        creditPage.setHolder(DataHelper.getValidHolderENG());
        creditPage.buttonContinueClick();
        creditPage.checkNotificationRequiredField();
        String actual = SQLHelper.getPaymentStatus();
        assertEquals(null, actual);
    }


}
