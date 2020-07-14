
package scanner;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
/**
 *
 * @author osve
 */
public class socket {
    public static void main(String[] args){
        try {
            
            Server server = new Server(9898);
            WebSocketHandler wsHandler = new WebSocketHandler() {
                @Override
                public void configure(WebSocketServletFactory wssf) {
                    wssf.register(service.class);
                }
            };
            
            server.setHandler(wsHandler);
            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println("Aqui paso algo");
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
