package nioclient;

import java.io.*;
import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class NIOClient_5 {
	private static String hostName = "127.0.0.1";
	private static final int port = 8080;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				Socket socket = new Socket(hostName, port);
				Thread myThread = new Thread(new Runnable() {
					public void run() {
						handle(socket, socket.toString());
					}
				});
                myThread.start();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void handle(Socket socket, String strThreadName) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String strOutput = strThreadName + ": " + socket.getClass().toString();
			bw.write(strOutput + "\r\n");
			bw.flush();
			String strInput = null;
			while ((strInput = br.readLine()) != null) {
				System.out.println(strThreadName + ": " + strInput);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
