package com.example.webapplication.servlet;

import com.example.webapplication.model.Employee;
import com.example.webapplication.model.EmployeeStatus;
import com.example.webapplication.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nilambar
 */
public class EnumMappingExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee employee1 = new Employee("Ramesh", EmployeeStatus.FULL_TIME);
        Employee employee2 = new Employee("Mahesh", EmployeeStatus.PART_TIME);
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();
        try{
            sess.save(employee1);
            sess.save(employee2);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            sess.close();
        }
    }
}
