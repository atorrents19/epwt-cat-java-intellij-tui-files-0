import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {

    public static void main(String[] args) throws Exception {

        File fichero = new File("testfile.html");
        //el nom del fitxer serà testfile.html


        String str = urlReader("http://inslaguineueta.cat");

        saveToFile(str, fichero, true);


        System.out.println(readFromFile(fichero));
        //per pantalla.
    }

    static String readFromFile(File file) throws IOException {
        FileReader filereader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(filereader);
        StringBuilder stringbuilder = new StringBuilder();
        String linia;
        while((linia = bufferedReader.readLine()) != null){
            stringbuilder.append(linia);
        }
        bufferedReader.close();
        return stringbuilder.toString();
    }

    static void saveToFile(String str, File file, boolean append) throws IOException {
        FileWriter filewriter = new FileWriter(file, true);
        BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
        bufferedwriter.write(str);
        bufferedwriter.close();
    }

    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

