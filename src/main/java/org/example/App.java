package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        String url = "https://www.foxnews.com/category/health/infectious-disease/coronavirus";
        Document doc = Jsoup.connect(url).get();
        FoxNewsHeadings foxHeadings = new FoxNewsHeadings();
        Elements articleContent = doc.select("div.article-list");

        for (Element articleElem: articleContent) {
            Elements articles = articleElem.select("article.article");

            for (Element articleMain : articles) {
                Elements divInfo = articleMain.select("div.info");
                for (Element div : divInfo) {
                    Elements headers = div.select("header.info-header");
                    for (Element header : headers) {
                        Elements headings = header.select("h4.title");
                        for (Element heading : headings) {
                            foxHeadings.addHeading(heading.text());

                        }
                    }

                }
            }

        }

        for (String heading : foxHeadings.getHeadings()) {
            System.out.println(heading);
        }
    }
}
