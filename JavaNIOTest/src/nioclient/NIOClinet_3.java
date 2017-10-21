package nioclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NIOClinet_3 {
	private  static String hostName ="127.0.0.1"; // "www.ifeng.com";
	private final static int port = 8080; //80;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(hostName, port);
			handle_out_2(socket);
			handle_in_2(socket);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void handle_out_2(Socket socket) {
		OutputStream ops = null;
		try {
			ops = socket.getOutputStream();
			OutputStreamWriter opsw = new OutputStreamWriter(ops);
			BufferedWriter bw = new BufferedWriter(opsw);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<10; i++){
				sb.append("From client: " + i + " ok\r\n");
				bw.write(sb.toString());
				bw.flush();
				sb.setLength(0);				
			}

			// bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void handle_out(Socket socket) {
		OutputStream ops = null;
		try {
			ops = socket.getOutputStream();
			OutputStreamWriter opsw = new OutputStreamWriter(ops);
			BufferedWriter bw = new BufferedWriter(opsw);
			StringBuilder sb = new StringBuilder();
			sb.append("GET / HTTP/1.1\r\n" + "Host: www.ifeng.com \r\n\r\n");
			bw.write(sb.toString());
			bw.flush();
			sb.setLength(0);
			
			
			// bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void handle_in_2(Socket socket) {
		InputStream ips = null;
		try {
			ips = socket.getInputStream();
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String s = "";
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void handle_in(Socket socket) {
		InputStream ips = null;
		try {
			ips = socket.getInputStream();
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String s = "";
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
