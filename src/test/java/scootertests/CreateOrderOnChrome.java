package scootertests;

import org.junit.Test;
import ru.yandex.practickum.MainPage;

import static org.junit.Assert.assertTrue;

public class CreateOrderOnChrome extends TestBaseOnChrome {
    @Test
    public void checkCreateOrderButtonTop(){
        boolean isCreateOrder =
                new MainPage(driverChrome)
                    .open(MAIN_PAGE_URL)
                    .clickAgreeCookie()
                    .clickNewOrderButtonTop()
                    .fillClientInfo("Эвелина","Тамински","Левитана 80","89568912597","Черкизовская")
                    .clickNextButton()
                    .fillRentalInfo("01.02.2023","двое суток","grey","Позвоните за 30 мин. до доставки.")
                    .clickFinishOrderButton()
                    .clickConfirmOrderButton()
                    .checkSuccessCreateOrder(SUCCESS_MESSAGE_CREATE_ORDER);
        assertTrue(isCreateOrder);

    }
    @Test
    public void checkCreateOrderButtonMiddle(){
        boolean isCreateOrder =
                new MainPage(driverChrome)
                    .open(MAIN_PAGE_URL)
                    .clickAgreeCookie()
                    .clickNewOrderButtonMiddle()
                    .fillClientInfo("Татьяна","Давлатова","Чайковского 35 корп. 2","+79008552217","Охотный Ряд")
                    .clickNextButton()
                    .fillRentalInfo("15.01.2023","трое суток","black","Позвоните мне за 15 минут")
                    .clickFinishOrderButton()
                    .clickConfirmOrderButton()
                    .checkSuccessCreateOrder(SUCCESS_MESSAGE_CREATE_ORDER);
        assertTrue(isCreateOrder);
    }
}
