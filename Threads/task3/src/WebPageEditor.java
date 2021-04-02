/* TODO 
Imports. Fill them up as you need them.*/

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class WebPageEditor {
    public  String temp; // holds the last webpage saved.
    public  WebPage wp; // the webpage you are working on
    public  String filename; // the filename to save this webpage

    public WebPageEditor(String filename){
/* TODO
Initialize wp to an empty webpage, and filename to the value passed. */
        wp = new WebPage();
        this.filename = filename;
    }

    public void start(){

        ScheduledExecutorService service = /* TODO
Using Executors, instantiate a new SingleThreadedScheduledExecutor */ Executors.newSingleThreadScheduledExecutor();
        /* TODO
Schedule at a fixed rate a runnable that executes checkSave. if checkSave is true it will print "Saved", This has to be schdule to start in 10 seconds and repeat every 10 seconds.  */

        // use a scanner to read every line the user writes
        Scanner kbd  = new Scanner(System.in);
        boolean finish = false;
        while(!finish){
/* TODO
If the user types "quit" the loop ends. If the input starts with t: you add a title to the webpage. If not, you add a paragraph.*/
            String input = kbd.next();
            if (input.equals("quit")) {
                finish = true;
            } else if (input.startsWith("t:")) {
                String title = input.replaceAll("t:", "");
                wp.addTitle(title);
            } else {
                wp.addParagraph(input);
            }
        }
        service./* TODO
Shutdown the threads NOW*/shutdownNow(); // when the loop finishes, threads are stopped
    }

    public  boolean checkSave(){
        /* TODO
If the text of the wp (String representation) is equal to the last String reperesentation (stored in tmp) returns false. Otherwise, it saves the webpage to the given filenam, tmp updates to the most current string representation of this webpage, and the funtion returns true.*/
        String currentWebPage = wp.toString();
        if (currentWebPage.equals(temp)) {
            return false;
        }

        wp.save("index.html");
        temp = wp.toString();
        return true;
    }
}
