package site.zido.tcp;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1,建立tcp客户端socket，确定要连接的服务器ip和端口
        Socket s = new Socket("127.0.0.1",8009);
        //获取键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OutputStream out = s.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        //获取服务端返回的数据
        //读取服务端发过来的信息InputStreamReader()

        BufferedReader brin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = null;

        while ((line = br.readLine()) != null){
            if(line.equals("over"))
                break;
            bw.write(line);
            bw.newLine();
            bw.flush();
            String str = brin.readLine();
            System.out.println("server:"+str);
        }
        br.close();
        s.close();

    }
}
