package noturno.chat;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatWebSocket {
	
	@OnMessage
	public void enviar(String mensagem, Session session) throws IOException{
		
		System.out.println(mensagem);
		
		for(Session client : session.getOpenSessions()){
			client.getBasicRemote().sendText(mensagem);
		}
		
	}
	
}
