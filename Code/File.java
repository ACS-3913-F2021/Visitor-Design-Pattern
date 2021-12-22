
/**
 * Assignment 5
 * Sehaj Mundi
 * 3117464
 */
public class File extends FileComponent{
    private String data;    // file contents
    private int size;       // file size
    public File(String name, String data, int size){
        this.name = name;
        this.data = data; 
        this.size = size;
    }

    public String getData() {
        return data;
    }
    
    public int getSize(){
        return size;
    }
    
    public String getPath()
    {
       FileComponent parent = this.getParent();
       String parentPath= parent.getPath();
       String path = parentPath+"/"+this.name;
       return path;
    }
        
    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "File: " + name);
    }  
    
    public String toString(){
        return name;
    }
    
    public void accept(Visitor v) {
           v.visit(this);
    }

}
