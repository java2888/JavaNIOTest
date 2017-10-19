package nioclient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NIOClinet_2 {
    private final static String hostName="127.0.0.1";
    private final static int port=8080;
    
	public static void main(String[] args) {
		 try {
			Socket socket=new Socket(hostName,port);
			OutputStream ops=socket.getOutputStream();
			OutputStreamWriter opsw=new OutputStreamWriter(ops);
			BufferedWriter bw=new BufferedWriter(opsw);
			String str="hello\r\n\r\n";
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<10; i++){
				sb.append(i + " " + str);
				bw.write(sb.toString());
				bw.flush();	
				sb.setLength(0);
			}
			bw.close();
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
