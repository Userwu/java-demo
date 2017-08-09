package site.zido.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8009);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress()+"进入连接");

        InputStream in = s.getInputStream();
        BufferedReader brin = new BufferedReader(new InputStreamReader(in));

        BufferedWriter brout = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        while((line = brin.readLine()) != null){
            System.out.println("client:"+line);
            brout.write(line.toUpperCase());
            brout.newLine();
            brout.flush();
        }
        s.close();
        ss.close();
    }
}
