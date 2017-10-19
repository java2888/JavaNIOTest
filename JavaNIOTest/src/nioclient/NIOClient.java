package nioclient;
//package javaNIOTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NIOClient {
	private static final int port = 8080;
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", port);
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter opsw=new OutputStreamWriter(out);
			BufferedWriter bw=new BufferedWriter(opsw);
			bw.write("hello world\r\n\r\n");
			bw.flush();
/*			for (char i = 0; i < 10; i++) {
				out.write(i);
				out.flush();
			}*/
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
