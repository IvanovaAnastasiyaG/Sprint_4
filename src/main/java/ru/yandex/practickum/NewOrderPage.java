package ru.yandex.practickum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewOrderPage {
    private final WebDriver webDriver;

    public NewOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //имя
    private final By firstName = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    //фамилия
    private final By lastName = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    //адрес
    private final By address = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    //телефон
    private final By phoneNumber = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");
    //выпадающее меню с названиями метро
    private final By metroSelect = By.className("select-search__input");
    //список названий метро
    private final By metroRows = By.className("Order_Text__2broi");
    //кнопка Далее
    private final By nextButton = By.className("Button_Middle__1CSJM");
    //Элемент с выбором даты доставки
    private final By dateDelivery = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");
    //выпадающее меню с списком периодов аренды
    private final By rentalPeriodSelect = By.className("Dropdown-root");
    //список периодов аренды
    private final By rentalPeriodRows = By.xpath(".//div[@class='Dropdown-option']");
    //черный цвет самоката
    private final By colorBlack = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and @for='black']");
    //серый цвет самоката
    private final By colorGrey = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and @for='grey']");
    //комментарий
    private final By comment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    //кнопка Заказать
    private final By finishOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    //кнопка подтерждения заказа
    private final By confirmOrderButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    //сообщение об успешном создании заказа
    private final By successCreateOrder = By.className("Order_ModalHeader__3FDaJ");
    private final int STANDARD_TIMEOUT = 5;

    public NewOrderPage fillClientInfo(String newFirstName,String newLastName,String newAddress,String newPhoneNumber,String newMetro){
        webDriver.findElement(firstName).sendKeys(newFirstName);
        webDriver.findElement(lastName).sendKeys(newLastName);
        webDriver.findElement(address).sendKeys(newAddress);
        webDriver.findElement(phoneNumber).sendKeys(newPhoneNumber);
        webDriver.findElement(metroSelect).click();
        List<WebElement> listOfMetro = webDriver.findElements(metroRows);
        int metroNumber = -1;
        for (int i = 0; i < listOfMetro.size(); i++){
            if (newMetro.equals(listOfMetro.get(i).getText())) {
                metroNumber = i;
                break;
            }
        }
        listOfMetro.get(metroNumber).click();
        return this;
    }

    public NewOrderPage fillRentalInfo(String newDateDelivery,String newRentalPeriod, String newColor, String newComment) {
        webDriver.findElement(rentalPeriodSelect).click();
        List<WebElement> listOfRentalPeriodRows = webDriver.findElements(rentalPeriodRows);
        int numberRentalPeriodRows = -1;
        for (int i = 0; i < listOfRentalPeriodRows.size(); i++){
            if (newRentalPeriod.equals(listOfRentalPeriodRows.get(i).getText())) {
                numberRentalPeriodRows = i;
                break;
            }
        }
        listOfRentalPeriodRows.get(numberRentalPeriodRows).click();
        if (newColor.equals("grey")) {
            new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(colorGrey)).click();
        }
        if (newColor.equals("black")) {
            new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(colorBlack)).click();
        }
        webDriver.findElement(comment).sendKeys(newComment);
        webDriver.findElement(dateDelivery).sendKeys(newDateDelivery);
        return this;
    }

    public NewOrderPage clickNextButton(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        return this;
    }

    public NewOrderPage clickFinishOrderButton(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(finishOrderButton)).click();
        return this;
    }

    public NewOrderPage clickConfirmOrderButton(){
        new WebDriverWait(webDriver, STANDARD_TIMEOUT).until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
        return this;
    }

    public boolean checkSuccessCreateOrder(String successMessage){
        return webDriver.findElement(successCreateOrder).getText().contains(successMessage);
    }

}


