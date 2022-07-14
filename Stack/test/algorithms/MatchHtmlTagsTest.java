package algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

public class MatchHtmlTagsTest {
    MatchHtmlTags htmlTags;

    @Before
    public void setup() {
        htmlTags = new MatchHtmlTags();
    }

    @Test
    public void stripTag() {
        assertEquals("html", htmlTags.stripTag("<html>"));
    }

    @Test
    public void isOpeningTag() {
        assertFalse(htmlTags.isOpeningTag(htmlTags.stripTag("</html>")));
    }

    @Test
    public void areMatchingTags() {
        String htmlTag_open = htmlTags.stripTag("<html>");
        String htmlTag_close = htmlTags.stripTag("</html>");
        assertTrue(htmlTags.areMatchingTags(htmlTag_open, htmlTag_close));
    }

    @Test
    public void isHTMLMatched() {


        String html =
                """
                        <html>
                            <head>
                            </head>
                            
                            <body>
                                <h1>Page Title</h1>
                                <p>Some lorem paragraph here.</p>
                            </body>
                        </html>
                        """;
        String[] tags = new String[1000];
        Scanner scanner = new Scanner(html);
        int count = 0;
        String token;
        tags[0] = "1";
        while (scanner.hasNextLine()) {
            while ((token = scanner.findInLine("<[^>]*>")) != null){
                tags[count] = htmlTags.stripTag(token);
                System.out.println(count + " " + tags[count]);
                count++;

            }


            scanner.nextLine();
        }

        if (htmlTags.isHTMLMatched(tags)) {
            System.out.println("The tags are matched HTML!");
        } else {
            System.out.println("the tags are not matched HTML!");
        }
    }
}