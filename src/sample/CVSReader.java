package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CVSReader {
    public static List<App> readAppsFromCSV(String fileName) {
        List<App> Apps = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            line = br.readLine();


            while (line != null)
            {
                String[] attributes = line.split(",");
                App App = createApp(attributes);
                Apps.add(App);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return Apps;
    }

    public static App createApp(String[] metadata) {
        String status = metadata[3];
        String dd = metadata[7];
        String de = metadata[8];
        String mc = metadata[9];
        return new App(status, dd, de, mc);
    }
}