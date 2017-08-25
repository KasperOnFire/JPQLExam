package entity;

import entity.Student;
import entity.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-25T11:24:30")
@StaticMetamodel(Semester.class)
public class Semester_ { 

    public static volatile SingularAttribute<Semester, String> name;
    public static volatile ListAttribute<Semester, Student> studentList;
    public static volatile SingularAttribute<Semester, String> description;
    public static volatile ListAttribute<Semester, Teacher> teacherList;
    public static volatile SingularAttribute<Semester, Long> id;

}