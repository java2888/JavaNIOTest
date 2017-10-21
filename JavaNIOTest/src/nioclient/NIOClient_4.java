package nioclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NIOClient_4 {
	private static String hostName = "127.0.0.1";
	private static int port = 8080;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(hostName, port);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader br_SystemIn = new BufferedReader(new InputStreamReader(System.in));
			String strInput;
			while ((strInput = br_SystemIn.readLine()) != null) {
				System.out.println(strInput);
				bw.write(strInput+"\r\n");
				bw.flush();
				if (strInput.equals("bye")) {
					System.exit(0);
				}
			}
			/*
			 * for(int i=0; i<5; i++){ bw.write("From client: "+ i + " \r\n");
			 * bw.flush(); }
			 */
			String str;

			while ((str = br.readLine()) != null) {
				System.out.println(str);
				if (str.equals("bye")) {
					break;
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
