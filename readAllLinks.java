import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import static java.lang.Thread.sleep;

public class readAllLinks {

    public static Set<String> uniqueURL = new HashSet<String>();
    public static String my_site;


    public static void main(String[] args) {

        readAllLinks obj = new readAllLinks();
        my_site = "https://www.megazip.ru/";
        obj.get_links("https://www.megazip.ru/");
    }

    private void get_links(String url) {
        try {

            pause(550);
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a");

            if (links.isEmpty()) {
                return;
            }

            links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
                boolean add = uniqueURL.add(this_url);
                if (add && this_url.contains(my_site)) {
                    System.out.println(this_url);


                    System.out.println( uniqueURL.size() );

                    get_links(this_url);
                }
            });

        } catch (IOException ex) {

        }

    }

    private static boolean pause(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            return true;
        }
        return false;
    }

}