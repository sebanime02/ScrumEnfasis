package edu.emphasis3.example.bean;

import edu.emphasis3.example.data.Project;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {
    private String login;
    private String password;
    private boolean validation = false;
    private ArrayList<Project> list;

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

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public ArrayList<Project> getList() {
        return list;
    }

    public void setList(ArrayList<Project> list) {
        this.list = list;
    }
    
    public String validate() {
        String page;
        if (login.equals("javhur")) {
            if (password.equals("123")) {
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
        return page;
    }
    
}
