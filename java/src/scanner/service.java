
package scanner;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.eclipse.jetty.websocket.api.Session;

import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import uk.co.mmscomputing.device.scanner.Scanner;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
@WebSocket
public class service {
    Session session;
    String path = "C:\\borrame";
    Scan_ scan;
    String[] sr = null;
    
   @OnWebSocketClose
    public void onClose(int statusCode,String reason){
        System.out.println("Close=" + statusCode+ " , reason=" + reason);
    }
    @OnWebSocketError
    public void onError(Throwable t){
        System.out.println("Error=" + t.getMessage());
    }
    
    @OnWebSocketConnect
    public void onConnect(Session s){
         session = s;
         int i=0;
         String devices = "[";
         String seleccionado= "";        
        try {
            System.out.println("Connect: " + session.getRemoteAddress().getAddress());
            scan = new Scan_();
            sr = scan.listarDispositivos();
            for(i=0;i<sr.length;i++){
               System.out.println("Device " + i + " " + sr[i]); 
               devices += "{\"device\":\""+sr[i]+"\"},";
            }
            
            System.out.println(devices.substring(0,devices.length()-1)); 
            if(devices.length()>1){
                devices= devices.substring(0,devices.length()-1);
            }
            devices+="]";
            seleccionado = scan.seleccionado();
            //session.getRemote().sendString("Habilitado");
            scan=null;
            session.getRemote().sendString("{\"type\":\"success\",\"text\":\"Conexion establecida\",\"dispositivos\":"+ devices +",\"seleccionado\":\"" + seleccionado + "\"}");
                                   
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            //System.out.println(""+Service.class.getName()).log(Level.SEVERE);
            //Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
    }
    
    @OnWebSocketMessage
    public void onMessage(String m) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException{
        String rs="";
        System.out.println("Escuchando " + m);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(m);
            JSONObject jsonObject = (JSONObject) obj;

            String accion = (String)jsonObject.get("accion");
            
            System.out.println("Accion: " + accion);
            
            if (accion.equals("digitalizar")){
                String dispositivo = (String)jsonObject.get("dispositivo");
                scan = new Scan_();
                rs = scan.iniciar(dispositivo);
                scan=null;
                session.getRemote().sendString("{\"type\":\"digitalizar\",\"text\":\""+rs+"\" }");
            }else if(accion.equals("seleccionar")){
                String dispositivo = (String)jsonObject.get("dispositivo");
                System.out.println("Dispositivo: " + dispositivo);
                scan = new Scan_();
                scan.SelectDispositivo(dispositivo );
                scan=null;
                 session.getRemote().sendString("{\"type\":\"seleccionar\",\"text\":\"El dispositivo se selecciono de forma correcta\" }");
            }else if(accion.equals("borrar")){
                System.out.println("Se va borrar la imagen seleccionada");
            }   
        }catch(Exception e){
            System.err.println(e.getMessage());
        }   
    }  
}
