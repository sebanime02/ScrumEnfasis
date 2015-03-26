package edu.emphasis3.example.data;

import java.io.Serializable;

/**
 *
 * @author javhur
 */
public class Project implements Serializable {
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
