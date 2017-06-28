package ChatServer;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class ChatServer {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.setHostname("localhost");
		config.setPort(9092);
		final SocketIOServer server=new SocketIOServer(config);
		server.addEventListener("chathelo", Message.class, new DataListener<Message>() {

			public void onData(SocketIOClient arg0, Message arg1, AckRequest arg2) throws Exception {
				System.out.println(arg1);
				server.getBroadcastOperations().sendEvent("chathelo", arg1);
			}
		});
		server.start();
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.stop();
	}
}
