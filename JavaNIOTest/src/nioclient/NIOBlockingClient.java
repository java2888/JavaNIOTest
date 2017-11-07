package nioclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOBlockingClient {
	private static String hostName="127.0.0.1";
	private static final int port=8080;
	
	public static void main(String[] args) {
		SocketChannel sc=null;
		try {
			sc=SocketChannel.open();
			sc.connect(new InetSocketAddress(hostName, port));
			ByteBuffer src=ByteBuffer.allocate(50);
			String str="Hello";
			src.put(str.getBytes("UTF-8"));
			src.flip();
			sc.write(src);
			
		} catch (IOException e) {			 
			e.printStackTrace();
		}
	

	}

}
