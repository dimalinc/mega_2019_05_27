import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static String startingPageUrl = "https://www.megazip.ru/";

    public static void main(String[] args) {
        Document doc;
        try {
            //восстановление страницы html google
            doc = Jsoup.connect("https://www.megazip.ru/").get();
            String name = doc.title(); //извлекаем title страницы
            System.out.println("Name of page html: "+name);

            Elements urls = doc.select("a"); //парсим маяк "а"
            for(Element url : urls){ //перебираем все ссылки
                //... и вытаскиваем их название...
                System.out.println("\nhref Mayak <a> "+url.attr("href"));
//              System.out.println("\ntext Mayak <a> "+url.text());

            }
        } catch (IOException e) {
        }


    }
}