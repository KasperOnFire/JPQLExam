package entity;

import entity.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-25T11:24:30")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> firstname;
    public static volatile SingularAttribute<Teacher, Long> id;
    public static volatile ListAttribute<Teacher, Semester> semesterList;
    public static volatile SingularAttribute<Teacher, String> lastname;

}