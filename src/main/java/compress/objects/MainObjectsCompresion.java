package compress.objects;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by soporte on 3/28/17.
 */
public class MainObjectsCompresion {

    public static void main(String[] args) {

        try {
            StringBuilder txt = new StringBuilder().append("ñlkasjd32654651651651651651651616516165161651651651651616165326546516516516516516516165161651616516516516516161653265465165")
                .append("6516516165161651616516516516516161653265465165165165165165161651616516165165165165161616532654651651651651651651616516165161");

            System.out.println("FUENTE:"+txt.length());
            MyObjectHeavy obj = new MyObjectHeavy(txt);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            byte[] bytesWithoutGzip = baos.toByteArray();

            System.out.println("Bytes sin Comprimir: "+bytesWithoutGzip.length);

            byte[] bytes = compressObject(obj);

            System.out.println("Bytes Comprimido: "+bytes.length);

            MyObjectHeavy result = (MyObjectHeavy) uncompressObject(bytes);
            System.out.println("Result: "+result.getField1().length()+" == "+txt.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object uncompressObject(byte[] bytes) throws Exception{
        long t1 = new Date().getTime();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        GZIPInputStream gzipIn = new GZIPInputStream(bais);
        ObjectInputStream objectIn = new ObjectInputStream(gzipIn);
        Object obj =  objectIn.readObject();
        objectIn.close();
        long t2 = new Date().getTime();
        System.out.println("Descomprimiendo: "+(t2-t1) +" ms");
        return obj;

    }

    public static byte[] compressObject(Object obj) throws IOException {
        long t1 = new Date().getTime();
        ByteArrayOutputStream baosG = new ByteArrayOutputStream();
        GZIPOutputStream gzipOut = new GZIPOutputStream(baosG);
        ObjectOutputStream objectOut = new ObjectOutputStream(gzipOut);
        objectOut.writeObject(obj);
        objectOut.flush();
        objectOut.close();
        byte[] bytes = baosG.toByteArray();
        long t2 = new Date().getTime();
        System.out.println("Comprimiendo: "+(t2-t1) +" ms");
        return bytes;
    }

}
