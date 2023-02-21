/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import model.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.ProfesorDaoImp;
import utilidades.MiExcepcion;

/**
 *
 * @author admin
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MiExcepcion {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Primero validamos el evento desde el formulario revisando que se haya punsado el boton.
            // si es un acceso desde otro lugar, entonces rechazamos la petición
            //El campo oculto es para dar seguridad al evento
            if(request.getParameter("btnRegistrarProfe")!=null && request.getParameter("rProfesor")!=null){
               
                // recogemos los datos del formulario mediante el objeto request y los asignamos al objeto dto
                //Recordar que si hay enteros toca hacer cast primero porque por defecto todos los campos del formulario
                //legan como texto
                Profesor nuevoProfesor = new Profesor();
                nuevoProfesor.setNombreCompleto(request.getParameter("txtNombre"));
                nuevoProfesor.setCorreoElectronico(request.getParameter("txtCorreo"));
                nuevoProfesor.setUserName(request.getParameter("txtUserName"));
                
                //Luego de tener el objeto dto creado y "cargado" con los datos del formulario, creamos el DAO
                // y llamamos el metodo para registrar un nuevo profesor. recordar que ese metodo devuelve una cadena
                ProfesorDaoImp pdao = new ProfesorDaoImp();
                String mensaje = pdao.saveProfesor(nuevoProfesor);                
                
                //Una vez recibido el mensaje el siguiente paso es reenviarlo al usuario en la interfaz
                
               response.sendRedirect("index.jsp?msg="+mensaje);  // lo pasamos como atributo usando el metodo get
                
                
            }else{
                
                out.println("esta intentando acceder de forma fraudulenta");
            }
            
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Controlador</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MiExcepcion ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MiExcepcion ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
