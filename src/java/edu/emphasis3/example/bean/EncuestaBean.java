package edu.emphasis3.example.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Ejemplo
 * @author javhur
 */
@ManagedBean
@SessionScoped
public class EncuestaBean {
    private int response1;
    private String response2;

    public EncuestaBean() {
    }

    public int getResponse1() {
        return response1;
    }

    public void setResponse1(int response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String registrarDatos() {
        return "result";
    }
}
