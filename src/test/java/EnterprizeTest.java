import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterprizeTest {

    @BeforeAll
    static void beforeAll(){
        baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openEnterprize(){
       //1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        open("/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(".header-menu-wrapper").$(byTagAndText("a", "Enterprise")).click();

        //2. Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $(byText("Build like the best")).shouldBe(Condition.visible);


    }
}
