import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.filechooser.FileSystemView;

public class loader {
    
    private String name;
    private Path path;
    private File directory;
    private ArrayList<String> content;
    
    public loader(){
        name = "";
        path = null;
        directory = null;
        content = new ArrayList<>();
    }
    
    public loader(String name) throws IOException{
        this.name = name;
        content = new ArrayList<>();
        setPathWithName(name);
        setDirectoryWithName(name);
        create();
        readContent();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    
    public void setPathWithName(String name){
        this.path = Paths.get(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/msHomework/" + name + ".txt");
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }
    
    public void setDirectoryWithName(String name){
        this.directory = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/msHomework/" + name + ".txt");
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }
    
    public void readContent() throws IOException{
        String[] temp = Files.lines(path).toArray(String[]::new);
        content.addAll(Arrays.asList(temp));
    }
    
    public void addContent(ArrayList<String> arr){
        arr.forEach((s) -> {
            content.add(s);
        });
    }
    
    public void removeContent(String target){
        for(int i=0; i<content.size(); i++){
            if(content.get(i).equals(target)){
                content.remove(i);
                content.remove(i);
                content.remove(i);
            }
        }
    }
    
    public void create() throws IOException{
        if(!directory.exists())
            directory.createNewFile();
    }
    
    public void remove(){
        directory.delete();
    }
    
    public void save() throws FileNotFoundException, IOException{
        remove();
        create();
        FileOutputStream fos = new FileOutputStream(directory);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))){
            for(String s : content){
                bw.write(s);
                bw.newLine();
            }
        }
    }
}
