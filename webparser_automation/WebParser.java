import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebParser {
    
    private String url;
    private Map<String,ArrayList<String>> items = new HashMap<>();
    
    public static void main(String[] args) throws IOException{
        final long startTime = System.currentTimeMillis();
        JCParser jc = new JCParser();
        jc.parse();
        jc.writeToFile("items.txt");
        File file = new File("items.txt");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
    
    public WebParser(String url){
        this.url = url;
    }
    
    public void parse() throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        for (Element e : links) {
            String link = e.attr("abs:href");
            String text = e.text();
            if(!items.containsKey(link))
                items.put(link, new ArrayList<>());
            items.get(link).add(text);
        }
    }
    
    public void writeToFile(String filename) throws FileNotFoundException{
        PrintStream ps = new PrintStream(new File(filename));
        for(String s : items.keySet())
            ps.println(s + " | " + items.get(s).toString().toLowerCase());
    }
}