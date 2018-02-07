import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    public static void main(String[] unused) {
        System.out.println("Running...");
        String urlInput = "http://erdani.com/tdpl/hamlet.txt";
        System.out.println(urlToString(urlInput));
        String[] wordsFromUrl = urlToString(urlInput).split(" ");
        int wordCount = wordsFromUrl.length;
        System.out.println("Word Count: " + wordCount);
        String wordToCount = "thou".toLowerCase();

        int wordInstance = 0;
        for (int i = 0; i < wordsFromUrl.length - 1; i++ ) {
            if (wordToCount.equals(wordsFromUrl[i].toLowerCase())) {
                wordInstance += 1;
            }
        }
        System.out.println("The word " + wordToCount + " appeared " + wordInstance + " times in the text.");
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }



}

