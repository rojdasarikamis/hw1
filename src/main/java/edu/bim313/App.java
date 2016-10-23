package edu.bim313;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {

        Document doc;
        try {

            // insaat.anadolu.edu.tr/OgretimElemanlari
            doc = Jsoup.connect("http://www.insaat.anadolu.edu.tr/OgretimElemanlari.aspx").get();


            // get mail links
            Elements links = doc.select("div").select("a");

            for (Element link : links) {
                String s = link.attr("href").trim();

                if (s.startsWith("mailto:"))
                    System.out.println(s.substring(7));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

