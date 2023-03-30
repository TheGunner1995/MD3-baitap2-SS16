import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            String PATH_FILE = "D:\\MD3 demo\\MD3-baitap2-SS16\\src\\countries.csv";
            br = new BufferedReader(new FileReader(PATH_FILE));
            while ((line = br.readLine()) != null){
                printCountry(parseCsvLine(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine){
    List<String> result = new ArrayList<>();
    if (csvLine != null){
        String[] splipData = csvLine.split(",");
        for (int i = 0; i < splipData.length; i++) {
            result.add(splipData[i]);
        }
    }
    return result;
    }
    private static void printCountry(List<String> country) {
        System.out.println(
                "Country [id= "
                        + country.get(0)
                        + ", code= " + country.get(1)
                        + " , name=" + country.get(2)
                        + "]");
    }
}