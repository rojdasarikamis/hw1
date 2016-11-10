package edu.bim207;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        String url = args[0];

        System.out.println("Fetching: " + url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");


        for (Element link : links) {
            String s = link.attr("abs:href").trim();

            if (s.startsWith("mailto:"))

                if (s.contains("cc") || s.contains("bcc")) {

                    String[] parts = s.split("\\?|&");
                    String part1 = parts[0];
                    String part2 = parts[1];
                    String part3 = parts[2];

                    System.out.println(part1.substring(7));
                    System.out.println(part2.substring(3));
                    System.out.println(part3.substring(4));


                } else if (s.contains("?")) {
                    String[] parts = s.split("\\?");
                    String part1 = parts[0];

                    System.out.println(part1.substring(7));


                } else {

                    System.out.println(s.substring(7));

                }
        }
    }
}