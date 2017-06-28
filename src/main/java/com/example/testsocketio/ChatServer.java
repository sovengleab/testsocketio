package com.example.testsocketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class ChatServer {
	public static void main(String[] args) throws InterruptedException {
		Configuration config=new Configuration();
		config.setHostname("localhost");
		config.setPort(9092);
		
		final SocketIOServer server=new SocketIOServer(config);
		server.addEventListener("Hrd_sr", ChatObject.class, new DataListener<ChatObject>() {
			public void onData(SocketIOClient arg0, ChatObject arg1, AckRequest arg2) throws Exception {
				arg1.setName("Admin");
				server.getBroadcastOperations().sendEvent("Reply", arg1);
			}
		});
		
		server.start();
		Thread.sleep(Integer.MAX_VALUE);
		server.stop();
	}
}
