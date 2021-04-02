/* TODO
Imports will be filling up as you need them. */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class WebPage {
    public List<String> dom; // this actually has the html document model.

    public WebPage(){
        dom = /* TODO
Initialize this to some kind of List */ new LinkedList<>();
    }

    public void addTitle(String title){
        /* TODO
Add a title to the DOM*/
        dom.add("<h1>".concat(title).concat("</h1>"));
    }

    /* TODO
implement addParagraph that receives a String and puts it in the dom
surrounded by <p> and </p>*/
    public void addParagraph(String paragraph) {
        dom.add("<p>".concat(paragraph).concat("</p>"));
    }
    public String toString(){
        String html = "<html>\n<head>\n</head>\n<body>";
        /* TODO
Loop through the elemments of the dom and append them to html */
        for (String domElem : dom) {
            html += domElem;
        }
        return html+"</body>\n</html>";
    }

    public void save(String filename){
        /* TODO
Save a string representation of this webpage to the filename provided.*/

        File file = new File(filename);
        try {
            Files.write(Paths.get(file.getPath()), filename.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
