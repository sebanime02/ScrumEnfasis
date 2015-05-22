package edu.emphasis3.example.bean;

import edu.emphasis3.example.data.jpa.Project;
import edu.emphasis3.example.data.jpa.ProjectJpaController;
import edu.emphasis3.example.data.jpa.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
    private String login;
    private String password;
    private boolean validation = false;
    private User user;

    

    public SessionBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public String validate() {
        String page;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploJsfPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("User.findByLogin");
        q.setParameter("login", login);
        List res = q.getResultList();
        
        if (!res.isEmpty()) {
            user = (User)res.get(0);
            if (password.equals(user.getPassword())) {
                validation = true;
                
                page = "listProjects";
            } else {
                validation = false;
                page = "error";
            }
        } else {
            validation = false;
            page = "error";
        }
        return page+"?faces-redirect=true";
    }
    
}
