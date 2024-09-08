package pl.jarrobots.battleshipfx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Connector {
    InetAddress addr;
    int port;
    Socket socket;
    DataOutputStream outputStream;
    DataInputStream inputStream;

    public Connector(String adres, String port) throws IOException {
            this.addr = InetAddress.getByName(adres);
            this.port = Integer.parseInt(port);
            this.socket = new Socket(this.addr,this.port);
    }

    public int sendInitialArray(int[][] arr) throws IOException {
        String str = arrayToString(arr);
        outputStream.writeChars(str);
        return 0;
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

    private String arrayToString(int[][] arr){
        IntStream stream = Arrays.stream(arr).flatMapToInt(Arrays::stream);
        return stream.mapToObj(String::valueOf).collect(Collectors.joining());
    }

}
