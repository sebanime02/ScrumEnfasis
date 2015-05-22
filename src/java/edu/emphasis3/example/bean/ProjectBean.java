package edu.emphasis3.example.bean;

import edu.emphasis3.example.data.jpa.Project;
import edu.emphasis3.example.data.jpa.ProjectJpaController;
import edu.emphasis3.example.data.jpa.exceptions.RollbackFailureException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author javhur
 */
@ManagedBean
@ViewScoped
public class ProjectBean {
    private List<Project> list;
    private Project selected = new Project();
    private Project project = new Project();

    public ProjectBean() {
    }

    public Project getSelected() {
        return selected;
    }

    public void setSelected(Project selected) {
        this.selected = selected;
    }
    
    public List<Project> getList() {
        //Usando JPA controller se carga 'list'
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploJsfPU");
        //ProjectJpaController pjc = new ProjectJpaController(emf);
        //list = pjc.findProjectEntities();

        //Usando JPA Query se carga 'list'
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Project.findAll");
         //Query q = em.createNamedQuery("Project.findByIdproject");
        list = q.getResultList();
                
        return list;
    }

    public void setList(List<Project> list) {
        this.list = list;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public void newProject() {
        project = new Project();
    }
    
    public void createProject() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploJsfPU");
        ProjectJpaController pjc = new ProjectJpaController(emf);
        
        try {
            //project.set
            //pjc.create(project);
            FacesContext context = FacesContext.getCurrentInstance();
            Integer id = ((SessionBean)(context.getApplication().evaluateExpressionGet(
                    context, "#{sessionBean}", Object.class))).getUser().getIduser();
            project.setIduser(id);
            pjc.create(project);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}

