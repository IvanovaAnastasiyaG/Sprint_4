package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practickum.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckFaqOnChrome extends TestBaseOnChrome {

    private final String AnswerFaq;
    private final int NumberAnswerFaq;

    public CheckFaqOnChrome(String AnswerFaq,int NumberAnswerFaq){
        this.AnswerFaq = AnswerFaq;
        this.NumberAnswerFaq = NumberAnswerFaq;

    }

    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][] {
                {LIST_OF_ANSWERS_FAQ.get(0), 0},
                {LIST_OF_ANSWERS_FAQ.get(1), 1},
                {LIST_OF_ANSWERS_FAQ.get(2), 2},
                {LIST_OF_ANSWERS_FAQ.get(3), 3},
                {LIST_OF_ANSWERS_FAQ.get(4), 4},
                {LIST_OF_ANSWERS_FAQ.get(5), 5},
                {LIST_OF_ANSWERS_FAQ.get(6), 6},
                {LIST_OF_ANSWERS_FAQ.get(7), 7},
        };
    }

    @Test
    public void checkVisibilityTextInFaq(){
        String AnswerFaqOnPage =
                new MainPage(driverChrome)
                        .open(MAIN_PAGE_URL)
                        .clickAgreeCookie()
                        .checkQuestionFaq(NumberAnswerFaq);
        assertEquals(AnswerFaqOnPage,AnswerFaq);
    }

}


