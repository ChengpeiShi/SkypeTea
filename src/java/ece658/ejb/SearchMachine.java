/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ece658.ejb;

import javax.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author wanfeiliu, b27lu
 */
@Stateless
public class SearchMachine {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
          private String url = "jdbc:derby://localhost:1527/";
          private String dbName = "Test";
          private String driver = "org.apache.derby.jdbc.ClientDriver";//com.mysql.jdbc.Driver";
          private String userName = "root"; 
          private String password = "19Lwf84s";
          
          //private String sqlQuery= null;
          //private String employeeTye = null;
          Connection con = null;
          Statement st = null;
          ResultSet rs = null;
          
          @PersistenceContext
          EntityManager em;
          public List<Machine> getAllMachine(){
        return (List<Machine>)em.createNamedQuery("Machine.findAll", Machine.class).getResultList();
    }
    
    public List<Machine> getByid(int id){
        return (List<Machine>)em.createNamedQuery("Machine.findById", Machine.class).setParameter("id", id).getResultList();
    }
    
    public List<Machine> getByPlatform(String str){
        return (List<Machine>)em.createNamedQuery("Machine.findByPlatform", Machine.class).setParameter("platform", str).getResultList();
    }
    
    public List<Machine> getByPowerstate(String str){
        return (List<Machine>)em.createNamedQuery("Machine.findByPowerstate", Machine.class).setParameter("powerstate", str).getResultList();
    }    
    
    public List<Machine> getByOwner(String str){
        return (List<Machine>)em.createNamedQuery("Machine.findByOwner", Machine.class).setParameter("owner", str).getResultList();
    }    
    
//    public void addMachine(int id, String platform, String powerstate){
//        em.createNamedQuery("Machine.addMachine", Machine.class).setParameter("id", id)
//                                                                .setParameter("platform", platform)
//                                                                .setParameter("powerstate", powerstate)
//                                                                .getResultList();
//    }
    
    
    public void addMachine(int id, String platform, String powerstate, String owner){
        Machine newMachine = new Machine();
        newMachine.setId(id);
        newMachine.setPlatform(platform);
        newMachine.setPowerstate(powerstate);
        newMachine.setOwner(owner);
        em.persist(newMachine);
        em.flush();
    }
    
    public void deleteMachine(int id){
        Machine toBeDeletedMachine = (Machine)em.find(Machine.class,id);
        em.remove(toBeDeletedMachine);
        em.flush();
        
    }
         
}  
        
