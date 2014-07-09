/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ece658.ejb;

import ece658.ejb.Tester;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wanfeiliu, b27lu
 */
@Stateless
public class SearchEmployee {
    
    @PersistenceContext
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Tester> getAllTester(){
        return (List<Tester>)em.createNamedQuery("Tester.findAll").getResultList();
    }
    
    public List<Tester> getById(int id){
        return (List<Tester>)em.createNamedQuery("Tester.findById", Tester.class).setParameter("id", id).getResultList();
    }
    
    public List<Tester> getByName(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findByName", Tester.class).setParameter("name", str).getResultList();
    }    

    public List<Tester> getByDept(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findByDept", Tester.class).setParameter("dept", str).getResultList();
    }
    
    public List<Tester> getByAge(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findByAge", Tester.class).setParameter("age", str).getResultList();
    }  
    
    public List<Tester> getByEmail(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findByEmail", Tester.class).setParameter("email", str).getResultList();
    }
    
    public List<Tester> getByPhone(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findByPhone", Tester.class).setParameter("phone", str).getResultList();
    }  
    
   /** public List<Tester> getBySalary(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findBySalary", Tester.class).setParameter("salary", str).getResultList();
    }  **/
    
    public List<Tester> getByStatus(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findByStatus", Tester.class).setParameter("status", str).getResultList();
    }
    
    public List<Tester> getBySkype(String str){
        return (List<Tester>)em.createNamedQuery("Tester.findBySkype", Tester.class).setParameter("skype", str).getResultList();
    }
    
    public void addEmployee(int id, String name, String dept, int age, String email, String phone, String status, String skype){
        Tester newEmployee = new Tester();
        newEmployee.setId(id);
        newEmployee.setName(name);
        newEmployee.setDept(dept);
        newEmployee.setAge(age);
        newEmployee.setEmail(email);
        newEmployee.setPhone(phone);
        //newEmployee.setSalary(salary);
        newEmployee.setStatus(status);
        newEmployee.setSkype(skype);
        em.persist(newEmployee);
        em.flush();
    }
    
    public void deleteEmployee(int id){
        Tester toBeDeletedEmployee = (Tester)em.find(Tester.class,id);
        em.remove(toBeDeletedEmployee);
        em.flush();
        
    }    
}