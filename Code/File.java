/**
 * ACS-3913 - Assignment 5
 */

public class File extends FileComponent{
    private String data;    // file contents
    private int size;       // file size

    public File(String name, String data, int size){
        this.name = name;
        this.data = data;
    }

    public String getData() {
        return data;
    }
    
    public int getSize(){
        return size;
    }

    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "File: " + name);
    }  
    
    public String toString(){
        return name;
    }
}
