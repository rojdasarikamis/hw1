package edu.bim207;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @author ROJDA SARİKAMIŞ
 */
public class App {

    public static void main(String[] args) throws IOException {

        String url = args[0];

        System.out.println("Fetching: " + url);

        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("a[href]");


        for (Element element : elements)
        {
            String s = element.attr("abs:href").trim();

            if (s.startsWith("mailto:"))
                System.out.println(s.substring(7));
        }
    }
}
