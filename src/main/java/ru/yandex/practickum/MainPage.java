package ru.yandex.practickum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final By newOrderButtonTop = By.className("Button_Button__ra12g");//кнопка Заказать в верху страницы
    private final By newOrderButtonMiddle = By.className("Button_Middle__1CSJM");//кнопка Заказать в середине страницы
    private final By questionsFaq = By.className("accordion__button");//ЧаВО вопросы
    private final By answersFaq = By.className("accordion__panel");//ЧаВО ответы
    private final By agreeCookie = By.className("App_CookieButton__3cvqF");// Кнопка принятия куки
    private final int STANDARD_TIMEOUT = 5;

    public MainPage open(String Url){
        webDriver.get(Url);
        return this;
    }

    public NewOrderPage clickNewOrderButtonTop(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(newOrderButtonTop)).click();
        return new NewOrderPage(webDriver);
    }

    public NewOrderPage clickNewOrderButtonMiddle(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(newOrderButtonMiddle)).click();
        return new NewOrderPage(webDriver);
    }

    public MainPage clickAgreeCookie(){
        webDriver.findElement(agreeCookie).click();
        return this;
   }

    public String checkQuestionFaq(int NumberAnswer){
        List<WebElement> listOfQuestions = webDriver.findElements(questionsFaq);
        List<WebElement> listOfAnswers = webDriver.findElements(answersFaq);
        String AnswerText;
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", listOfQuestions.get(NumberAnswer));
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(listOfQuestions.get(NumberAnswer))).click();
        AnswerText = new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.visibilityOf(listOfAnswers.get(NumberAnswer))).getText();
        return AnswerText;
    }
}
