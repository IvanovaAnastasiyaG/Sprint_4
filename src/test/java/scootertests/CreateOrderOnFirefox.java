package scootertests;

import org.junit.Test;
import ru.yandex.practickum.MainPage;

import static org.junit.Assert.assertTrue;

public class CreateOrderOnFirefox extends TestBaseOnFirefox{

    @Test
    public void checkCreateOrderButtonTop(){
        boolean isCreateOrder =
                new MainPage(driverFirefox)
                    .open()
                    .clickAgreeCookie()
                    .clickNewOrderButtonTop()
                    .fillClientInfo("Артур","Давлетшин","Смольная 7","8(956)89-12-597","Черкизовская")
                    .clickNextButton()
                    .fillRentalInfo("23.02.2023","шестеро суток","grey","Позвоните мне за час до доставки.")
                    .clickFinishOrderButton()
                    .clickConfirmOrderButton()
                    .checkSuccessCreateOrder(SUCCESS_MESSAGE_CREATE_ORDER);
        assertTrue(isCreateOrder);
    }
    @Test
    public void checkCreateOrderButtonMiddle(){
        boolean isCreateOrder =
                new MainPage(driverFirefox)
                    .open()
                    .clickAgreeCookie()
                    .clickNewOrderButtonMiddle()
                    .fillClientInfo("Дмитрий","Маликов","Цветочная 8","+79118952217","Комсомольская")
                    .clickNextButton()
                    .fillRentalInfo("08/01/2023","пятеро суток","black","Позвоните за 30 минут")
                    .clickFinishOrderButton()
                    .clickConfirmOrderButton()
                    .checkSuccessCreateOrder(SUCCESS_MESSAGE_CREATE_ORDER);
        assertTrue(isCreateOrder);
    }
}
