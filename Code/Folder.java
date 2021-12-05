
/**
 * Assignment 5
 * Sehaj Mundi
 * 3117464
 */
import java.util.ArrayList;
import java.util.List;

public class Folder extends FileComponent {
    private List<FileComponent> contents;
    int size=0;
    String filePath = "";

    public Folder(String n){
        name = n;
        contents = new ArrayList<>();
    }

    public void addFileComponent(FileComponent fc){
        contents.add(fc);
        fc.setParent(this);
    }

    public List<FileComponent> getContents(){
        return contents;
    }

    public String getPath(){
        filePath=this.name;
        FileComponent parentName = this.getParent();
        while(parentName!= null)
        {
            String path = parentName.getName();
            parentName = parentName.getParent();
            filePath = path+"/"+filePath;
        }
        return filePath;
    }

    public int getSize(){

        for(FileComponent fileComponent: contents){
            int fileSize = fileComponent.getSize();
            size = size + fileSize;
        }
        return size;
    }

    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "Folder: "+name);
        for(FileComponent fileComponent: contents){
            fileComponent.display(indent);
        }
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString(){
        return name;
    }
}