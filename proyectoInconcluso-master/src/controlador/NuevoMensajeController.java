/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MensajeDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.BandejaEntrada;
import vista.NuevoMensaje;

/**
 *
 * @author Usuario
 */
public class NuevoMensajeController implements ActionListener {

    private NuevoMensaje vNm;
    
    public NuevoMensajeController(NuevoMensaje vNm){
        this.vNm=vNm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("enviar")){
            
            
            String contenido= vNm.getCuerpoMensajeTA().getText(); //contenido obtenido
            
            MensajeDAO mDAO = new MensajeDAO();
            
//            ArrayList<Usuario>usuariosBD = uDAO.getUsuarios();
//            boolean nombreExisteEnBD=false; 
//            int id=-1;
//            for(int i = 0; i < usuariosBD.size(); i++) {
//                
//               if(usuariosBD.get(i).getNombre().equals(nombre)){
//                 nombreExisteEnBD=true;
//                 id=usuariosBD.get(i).getId_usuario();
//                 break;
//               } 
//               
//            }
//            
//            if(nombreExisteEnBD){
//                BandejaEntrada bandejaVentana= new BandejaEntrada(id);//sería el Id del usuario logueado
//                bandejaVentana.setVisible(true);
//  
//            }else{
//                JOptionPane.showMessageDialog(vLogin, "Error el usuariono existe en la BD", "ERROR", JOptionPane.ERROR);
//            }
        }
        
    } 
    
    
    
}
