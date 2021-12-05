
/**
 * Assignment 5
 * Sehaj Mundi
 * 3117464
 */
public class BackupVisitor implements Visitor
{
    public void visit(Folder folder)
    {
        System.out.println("Backing up folder "+folder.getName()+" contents:");
        for(FileComponent component: folder.getContents())
        {
            component.accept(this);
        }
    }
    
    public void visit(File file)
    {
        System.out.println("Backing up file "+file.getName()+" ...");
    }
}
