import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll

    static void beforeAll(){
        baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDrop(){
        //Запрограммируйте Drag&Drop с помощью Selenide.actions()

        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");

        //Перенесите прямоугольник А на место В
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
//
//        Point ptB = $("#column-b").getLocation(); // Узнаем координаты Блока B
//        int NumberXb=ptB.getX();
//        int NumberYb=ptB.getY();
//
//        Point ptA = $("#column-a").getLocation(); //Узнаем коодинаты Блока А
//        int NumberXa=ptA.getX();
//        int NumberYa=ptA.getY();
//
//
//        int x = NumberXb - NumberXa; // Вычисляем разницу
//        int y = NumberYb - NumberYa;


        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 200).release().perform();




        //Проверьте, что прямоугольники действительно поменялись

        //В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест,
                                                       // если использовать её вместо actions()

        //sleep(500);
    }
}
