
/**
 * Assignment 5
 * Sehaj Mundi
 * 3117464
 */
public class SearchVisitor implements Visitor
{
    String searchTerm;
    public void setSearchTerm(String searchTerm)
    {
        this.searchTerm = searchTerm ;
    }
    
    public void visit(Folder folder)
    {
        String name = folder.getName();
        if(name.toLowerCase().contains(searchTerm))
        {
            System.out.println(folder.getPath());
        }
        for(FileComponent component: folder.getContents())
        {
            component.accept(this);
        }
    }
    
    public void visit(File file)
    {
        String name = file.getName();
        String data = file.getData();
        if(name.toLowerCase().contains(searchTerm))
        {
            System.out.println(file.getPath());
        }
        if(data.toLowerCase().contains(searchTerm))
        {
            System.out.println(file.getPath());
        }
    }
}
