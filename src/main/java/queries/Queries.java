package queries;

import entity.Semester;
import entity.Student;
import entity.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Queries {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jqpl-exam");
    private EntityManager em;
    
    private void emInit() {
        em = emf.createEntityManager();
    }
    
    public List<Student> findAllStudents() {
        emInit();
        try {
            Query q = em.createNamedQuery("Student.findAll");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Student> findAnders() {
        emInit();
        try {
            Query q = em.createNamedQuery("Student.findByFirstname");
            q.setParameter("firstname", "Anders");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public Student createStudent(Student s) {
        emInit();
        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
            return s;
        } finally {
            em.close();
        }
        
    }
    
    public void assignToSemester(String stu, String semName) {
        emInit();
        try {
            Query q = em.createNamedQuery("Semester.findByName");
            q.setParameter("name", semName);
            Query q2 = em.createNamedQuery("Student.findByFirstname");
            q2.setParameter("firstname", stu);
            
            List<Semester> sems = q.getResultList();
            Semester actualSem = sems.get(0);
            List<Student> students = q2.getResultList();
            Student actualStudent = students.get(0);
            
            actualSem.getStudentList().add(actualStudent);
            actualStudent.setCurrentsemesterId(actualSem);
            em.getTransaction().begin();
            em.persist(actualSem);
            em.persist(actualStudent);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public List<Student> findAnd() {
        emInit();
        try {
            Query q = em.createNamedQuery("Student.findByLastname");
            q.setParameter("lastname", "And");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public int sumStudentsForSemester(String semName) {
        emInit();
        List<Semester> sem;
        int sum = 0;
        try {
            Query q = em.createNamedQuery("Semester.findByName");
            q.setParameter("name", semName);
            sem = q.getResultList();
            Semester sem1 = sem.get(0);
            sum = sem1.getStudentList().size();
        } finally {
            em.close();
        }
        return sum;
    }
    
    public int sumStudentsAllSemesters() {
        emInit();
        List<Semester> sem;
        int sum = 0;
        try {
            Query q = em.createNamedQuery("Semester.findAll");
            sem = q.getResultList();
            for (Semester semester : sem) {
                sum += semester.getStudentList().size();
            }
        } finally {
            em.close();
        }
        return sum;
    }
    
    public Teacher teacherMostActive() {
        emInit();
        List<Teacher> teachers;
        List<Semester> l1 = new ArrayList();
        Teacher bestTeacher = new Teacher();
        bestTeacher.setSemesterList(l1);
        try {
            Query q = em.createNamedQuery("Teacher.findAll");
            teachers = q.getResultList();
            for (Teacher teacher : teachers) {
                if (teacher.getSemesterList().size() > bestTeacher.getSemesterList().size()) {
                    bestTeacher = teacher;
                }
            }
        } finally {
            em.close();
        }
        return bestTeacher;
    }
    
}
