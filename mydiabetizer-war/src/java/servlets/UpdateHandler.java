/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Rock n Roll
 */
public class UpdateHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject result = factory.createObjectBuilder()
                .add("result", 1).build();
        try (PrintWriter out = response.getWriter()) {
             out.println(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject result = factory.createObjectBuilder()
                .add("result", 1).build();
        try (PrintWriter out = response.getWriter()) {
             out.println(result);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}