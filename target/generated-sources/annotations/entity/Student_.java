package entity;

import entity.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-25T11:24:30")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Semester> currentsemesterId;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, String> lastname;

}