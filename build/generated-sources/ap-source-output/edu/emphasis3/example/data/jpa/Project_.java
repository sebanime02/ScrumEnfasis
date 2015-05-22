package edu.emphasis3.example.data.jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-23T10:28:23")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, Integer> iduser;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, Integer> idproject;
    public static volatile SingularAttribute<Project, String> description;
    public static volatile SingularAttribute<Project, Date> end;
    public static volatile SingularAttribute<Project, Date> begin;

}