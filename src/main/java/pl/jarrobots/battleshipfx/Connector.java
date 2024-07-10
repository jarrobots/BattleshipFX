package pl.jarrobots.battleshipfx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
    InetAddress addr;
    int port;
    Socket socket;
    DataOutputStream outputStream;
    DataInputStream inputStream;

    public Connector(String adres, int port, String array) throws IOException {
            addr = InetAddress.getByName(adres);
            this.port = port;
            socket = new Socket(addr,port);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream.writeChars(array);
    }

    public int send(int x, int y)  {
        try {
            outputStream.writeByte(x);
            outputStream.writeByte(y);
            return 0;
            //return inputStream.readByte(); //get feedback about target
        }
        catch (IOException e){
            return -1;
        }


    }
    public int getYourCoords() throws IOException {
        return inputStream.readByte();
    }
}
