/**
 * ACS-3913 - Assignment 5
 */

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileComponent {
    private List<FileComponent> contents;

    public Folder(String n){
        name = n;
        contents = new ArrayList<>();
    }
    
    public void addFileComponent(FileComponent fc){
        contents.add(fc);
        fc.setParent(this);
    }
    
    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "Folder: "+name);
        for(FileComponent fileComponent: contents){
            fileComponent.display(indent);
        }
    }

    public String toString(){
        return name;
    }
}