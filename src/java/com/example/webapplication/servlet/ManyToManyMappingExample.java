/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webapplication.servlet;

import com.example.webapplication.model.Actors;
import com.example.webapplication.model.Movies;
import com.example.webapplication.util.HibernateUtil;
import java.io.IOException;
import java.util.ArrayList;
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
public class ManyToManyMappingExample extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actors actor1 = new Actors("HRX");
//        Actors actor2 = new Actors("salman");
//        Movies movie1 = new Movies("moviehere");
//        Movies movie2 = new Movies("moviesnow");
//        movie1.setActors(new ArrayList<Actors>(){{add(actor1);add(actor2);}});
//        movie2.setActors(new ArrayList<Actors>(){{add(actor1);}});
        
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx  = sess.getTransaction();
        tx.begin();
        sess.save(actor1);
//        sess.save(movie2);
        tx.commit();
        sess.close();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
