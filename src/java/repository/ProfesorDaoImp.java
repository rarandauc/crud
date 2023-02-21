/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Conexion;

/**
 *
 *  * @author Rodrigo Aranda Fernandez
 */
public class ProfesorDaoImp implements IProfesorDao {

    private PreparedStatement pstmt = null;
    private Connection cnn = null;
    private ResultSet rs = null;

    public ProfesorDaoImp() {
        cnn = Conexion.getInstance();
    }

    /**
     * Este metodo permite insertar un nuevo registro profesor en la base de
     * datos
     *
     * @param newProfesor Un objeto que contiene los atributos de la entidad
     * Profesor
     * @return una cadena de confirmación de la acción realizada
     */
    @Override
    public String saveProfesor(Profesor newProfesor) {
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO profesores VALUES (null, ?, ?, ?)");
            pstmt.setString(1, newProfesor.getNombreCompleto());
            pstmt.setString(2, newProfesor.getCorreoElectronico());
            pstmt.setString(3, newProfesor.getUserName());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario a sido registrado exitosamente. " + resultado + "filas afectadas";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";
                throw new MyException("ha ocurrido un problema");
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } catch (MyException ex) {
            Logger.getLogger(ProfesorDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProfesorDaoImp.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;
    }

    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     * @return lista de objetos profesor
     * @throws repository.MyException
     */
    @Override
    public List<Profesor> getAllProfesor() throws MyException {
        LinkedList<Profesor> listaProfes = new LinkedList<Profesor>();
        try {

            String query = "SELECT  clave_profesor as id, nombre, correoElectronico, user "
                    + " FROM profesores ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Profesor newProfe = new Profesor();
                newProfe.setClaveProfesor(rs.getInt("id"));
                newProfe.setNombreCompleto(rs.getString("nombre"));
                newProfe.setCorreoElectronico(rs.getString("correoElectronico"));
                newProfe.setUserName(rs.getString("user"));
                listaProfes.add(newProfe);
            }
        } catch (SQLException ex) {
            throw new MyException("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProfesorDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaProfes;
    }

    @Override
    public String deleteProfesor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateProfesor(Profesor p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
