/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hugo Jové (sécurité)
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    private UtilisateurDAO utilisateur_dao;
    
    @Override
    public void init() throws ServletException {
        utilisateur_dao = new UtilisateurDAO();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

              
    }

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
   
            processRequest(request, response);
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
            
              Enumeration<String> params = request.getParameterNames();
                ArrayList<String[]> listeObjs = new ArrayList<>();
                ArrayList<JUtilisateurBean> listeBeans = new ArrayList<>();
                
                while(params.hasMoreElements()){

                    // Je récupère un param ex: "SSN"
                    String monParam = (String)params.nextElement();
                    // Je récupère toutes les valeurs qui ont l'attribut "SSN" (1,2,50...)
                    String[] valeurParams = request.getParameterValues(monParam);
                    listeObjs.add(valeurParams);
                }
               
                for (int i = 0; i < listeObjs.get(0).length; i++) {
                    JUtilisateurBean bean = new JUtilisateurBean();
                    
                    if( listeObjs.get(0)[i] != null && !listeObjs.get(0)[i].equals("") &&
                        listeObjs.get(1)[i] != null && !listeObjs.get(1)[i].equals("") &&
                        listeObjs.get(2)[i] != null && !listeObjs.get(2)[i].equals(""))
                    {
                        bean.setNom(listeObjs.get(0)[i]);
                        bean.setPrenom(listeObjs.get(1)[i]);
                        bean.setLogin(listeObjs.get(2)[i]);
                        
                        listeBeans.add(bean);
                        utilisateur_dao.create(bean);
                    }   
                }
                if(listeBeans.size() != 0)
                    request.setAttribute("lastUserAdded", listeBeans.get(listeBeans.size()-1));
                request.setAttribute("nb_users", utilisateur_dao.getNombreEnregistre());
                request.setAttribute("allUsers", utilisateur_dao.findAll());
                request.getRequestDispatcher("Resultats.jsp").forward(request, response);
                
                
                processRequest(request, response);
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
