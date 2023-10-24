import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScoreHandler {
    ArrayList<String> records;
    public void readCSV(){
        records = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))) {
            String current;
            while((current = reader.readLine()) != null){
                String[] currentArray = current.split(",");
                for(String c: currentArray) {
                    records.add(c);
                }
            }   

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public int highScore(){
        int highestScore = 0;
        for(String s: records) {
            if(Integer.valueOf(s) > highestScore) {
                highestScore = Integer.valueOf(s);
            }
        }
        System.out.println("High Score: " + highestScore);
        return highestScore;
    }

    public void writeCSV(int lastTurn){
        try {
            String data = "";
            FileWriter writer = new FileWriter("scores.txt");
            records.add(String.valueOf(lastTurn));

            for (String r: records) {
                data += r;
                data += ",";
            }
            System.out.println(data);
            writer.write(data);
            writer.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
