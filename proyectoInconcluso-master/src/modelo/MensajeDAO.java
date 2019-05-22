
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MensajeDAO {
    Conexion con;

    public MensajeDAO() {
       this.con=new Conexion();
    }
    
    public ArrayList<Mensaje> getMensajes() throws SQLException{
        ArrayList<Mensaje> mensajes = new ArrayList();
        Connection accesoBD = con.getConexion();
        
        try{
            String sql ="SELECT * FROM mensaje";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while(resultados.next()){
                int id_mensaje=Integer.parseInt(resultados.getString("id_mensaje"));
                String contenido =resultados.getString("contenido");
                int id_usr_emisor =Integer.parseInt(resultados.getString("id_usr_emisor"));
                int id_usr_receptor =Integer.parseInt(resultados.getString("id_usr_receptor"));
                
                //obtengo los mensajes recibidos por cada usuario
                String sqlReceptor = "SELECT * FROM usuario WHERE id = "+id_usr_receptor;
                Statement st2 = accesoBD.createStatement();
            
                try{
                    ResultSet resReceptor = st2.executeQuery(sqlReceptor);
                    while(resReceptor.next()){
                        int id_usuarioBD = Integer.parseInt(resReceptor.getString("id_usuario"));
                        String nombre = resultados.getString("nombre");
                        
                        Usuario uR = new Usuario(id_usuarioBD, nombre); 
                        
                        String sqlEmisor = "SELECT * FROM usuario WHERE id = "+id_usr_emisor;
                        Statement st3 = accesoBD.createStatement();
                        try{
                            ResultSet resEmisor = st3.executeQuery(sqlEmisor);
                        while(resEmisor.next()){
                            int id_emisorBD = Integer.parseInt(resEmisor.getString("id_usuario"));
                            String nombreE = resEmisor.getString("nombre");

                            Usuario uE = new Usuario(id_usuarioBD, nombre); 
                            
                            mensajes.add(new Mensaje(id_mensaje, uR, uE, contenido));
                            

                        }
                     
                }catch(Exception ex2){
                    System.out.println("Error al obtener los mensajes recibidos del usuario");
                }
                        
                    }
                     
                }catch(Exception ex2){
                    System.out.println("Error al obtener los mensajes recibidos del usuario");
                }
            }
            accesoBD.close();
            return mensajes;
            
        }catch (Exception e){
            System.out.println("Error al obtener");
             accesoBD.close();
            return null;
        }
        
    }
    
    
}
