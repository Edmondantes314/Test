import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Redactor {

    public static void main(String[] arg){
        ArrayList<String> locations = new ArrayList<>();

        String fileName = "/Users/MacbookPro/Documents/OnTrac/Text File.txt";

        try (Scanner scanner = new Scanner(new File(fileName))) {

            int i = 0;
            while (scanner.hasNext()){
                i++;
                if(scanner.nextLine().trim().length() == 0){
                    i=0;
                }
                if(i==4)
                locations.add(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //writing
      try(  BufferedWriter out = new BufferedWriter(new FileWriter("/Users/MacbookPro/Documents/OnTrac/redacted.txt")))
        {

            for (int i = 0; i < locations.size(); i++) {
                out.write(i+1 + ")" +locations.get(i));
                out.newLine();
            }

        }catch (IOException e) {
        e.printStackTrace();
    }
    }

}
