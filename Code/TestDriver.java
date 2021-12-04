 
/**
 * ACS-3913 - Assignment 5
 */

import java.util.Scanner;

public class TestDriver{
    public static void main(String[] args){
        FileComponent courses = new Folder("Courses");
        FileComponent acs3913 = new Folder("ACS-3913 Software Des & Arch");
        FileComponent acs3916 = new Folder("ACS-3916 HCI");
        courses.addFileComponent(acs3913);
        courses.addFileComponent(acs3916);

        acs3913.addFileComponent(new File("Assignment1.txt",
                "Design patterns: Strategy; Diagrams, class, object, sequence; ducks", 
                54));
        acs3913.addFileComponent(new File("Assignment2.txt",
                "Design patterns: Decorator, Observer, Adapter;  Diagrams: class;  game, ham", 
                1033));   
        acs3913.addFileComponent(new File("Assignment3.txt",
                "Design patterns: State, Facade, Factory Method, Abstract Factory;  Diagrams: state, class, sequence, object; gumball, mortgage, Mario", 
                310));         
        acs3913.addFileComponent(new File("Assignment4.txt",
                "Design patterns: Command, Singleton, Template Method;  Diagrams: class, sequence;  remote, undo/redo, configuration, logger", 
                645)); 
        acs3913.addFileComponent(new File("Assignment5.txt",
                "Design patterns: Composite, Visitor;  Diagrams: class, object, sequence;  file, backup, search", 
                153));   
                
        acs3916.addFileComponent(new File("Assignment1.txt",
                "Good/bad design, design principles, usability goals, prototyping tools", 
                453));
        acs3916.addFileComponent(new File("Assignment2.txt",
                "More prototyping, interviews, design, mental model", 
                645));

        FileComponent project = new Folder("Project");
        acs3916.addFileComponent(project);
        
        project.addFileComponent(new File("Proposal.txt",
                "Project proposal, participants, scope, ethics protocol", 
                10));
        project.addFileComponent(new File("MilestoneI.txt",
                "Research methods, interviews, questionnaires, quantitative qualitative analysis, scenarios, personas", 
                1576));
        project.addFileComponent(new File("MilestoneII.txt",
                "Brainstorming, sketching, paper prototype, heuristic evaluation, cognitive walkthrough, medium-fi digital prototype", 
                1487));

        FileComponent projectFinal = new Folder("ProjectFinal"); 
        project.addFileComponent(projectFinal);
        
        projectFinal.addFileComponent(new File("FinalReport.txt", 
                "Vertical prototype, usability testing, medium-high fidelity prototype, reflection", 
                1265));
        File pres = new File("Presentation.txt", 
                "Group presentation slide deck", 
                154);                
        projectFinal.addFileComponent(pres);

        courses.display(" ");
        
        // testing size
        System.out.println(courses.getSize());  // folder
        System.out.println(pres.getSize());     // file
        
        // testing file path
        System.out.println("\n" + pres.getPath() + "\n");

        // testing backup
        
        Visitor backup = new BackupVisitor();
        courses.accept(backup);
        
        // testing search
        SearchVisitor search = new SearchVisitor();
        System.out.println("\nEnter the search keyword:");
        Scanner kb = new Scanner(System.in);
        String keyword = kb.next();
        search.setSearchTerm(keyword);
        courses.accept(search);     // try "sequence", "prototype"        
    }
}
