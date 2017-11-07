package nioclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIONonBlockingClient_Polling {
	private static String hostName = "127.0.0.1";
	private static final int port = 8080;

	public static void main(String[] args) throws InterruptedException {
		SocketChannel sc = null;
		int i=0;
		try {
			sc = SocketChannel.open();
			sc.configureBlocking(false);
			sc.connect(new InetSocketAddress(hostName, port));
			while (true) {
				if (sc.finishConnect()) {
					System.out.println("[Client]connected...");
					ByteBuffer src = ByteBuffer.allocate(50);
					String result = "Hello, world."+"["+i++ +"]";
					System.out.println("[result]"+result);
					src.put(result.getBytes("UTF-8"));
					src.flip();
					sc.write(src);
					Thread.sleep(1000);
					if(i==10){
						break;
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
