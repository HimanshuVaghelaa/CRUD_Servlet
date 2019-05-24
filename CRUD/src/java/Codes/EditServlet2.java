package Codes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet 
{
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
         try (PrintWriter out = response.getWriter()) {
             String sid=request.getParameter("id");
             int id=Integer.parseInt(sid);
             String name=request.getParameter("name");
             String password=request.getParameter("password");
             String email=request.getParameter("email");
             String country=request.getParameter("country");
             
             Emp e=new Emp();
             e.setId(id);
             e.setName(name);
             e.setPassword(password);
             e.setEmail(email);
             e.setCountry(country);
             
             int status=EmpDao.update(e);
             if(status>0){
                 response.sendRedirect("ViewServlet");
             }else{
                 out.println("Sorry! unable to update record");
             }}  
    }
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
