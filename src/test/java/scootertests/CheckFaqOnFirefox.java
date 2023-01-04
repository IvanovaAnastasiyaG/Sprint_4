package scootertests;

import org.junit.Test;
import ru.yandex.practickum.MainPage;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CheckFaqOnFirefox extends TestBaseOnFirefox {

    @Test
    public void checkVisibilityTextInFaq(){
        List<String> listOfAnswersOnPage =
                new MainPage(driverFirefox)
                        .open()
                        .clickAgreeCookie()
                        .checkQuestionsFaq();
        for (int i = 0; i < LIST_OF_ANSWERS_FAQ.size(); i++ ) {
            assertEquals(listOfAnswersOnPage.get(i),LIST_OF_ANSWERS_FAQ.get(i));
        }
    }
}


