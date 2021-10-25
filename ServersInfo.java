import java.net.*;

import javax.xml.crypto.Data;

import java.io.*;


public class ServersInfo {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public ServersInfo(Socket socket) throws IOException{
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public DataInputStream doRead(){
        return in;
    }

    public DataOutputStream doWrite(){
        return out;
    }


    
}
