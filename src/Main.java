import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * A simple program to calculate how many miles achieved and how many calories burn during exercises.
 * @author Youmin Zheng
 * September 12, 2016
 */
public class Main {

    public static void main(String[] args) throws IOException {
        float totalMiles = 0;                               //total number of miles
        float totalCals = 0;                                //total number of calories
        String inputFile = "txt/log.txt";                   //file location

        readFile(inputFile , totalMiles , totalCals);       //calls the readFile method
    }

    /**
     * readFile method will take the inputfile and read it line by line until there is nothing left.
     * It will tokenize each line with the " " and add them to the appropriate totalMiles and totalCals.
     *
     * @param inputFile location of the database file
     * @param totalMiles total number of miles
     * @param totalCals total number of calories burned
     * @throws IOException
     */
    public static void readFile(String inputFile, float totalMiles, float totalCals) throws IOException{
        String line = null;                                 //holds a line of strings from text file
        String[] field = null;                              //holds values from lines of text from text file
        int counter = 0;                                    //counter for number of workouts

        FileReader fileReader = new FileReader(inputFile);  //filereader reads a line from the text file and sends it to buffer reader
        BufferedReader bufferedReader = new BufferedReader(fileReader); //buffer reader holds a line sent from filereader and we set line = it

        while( (line = bufferedReader.readLine()) != null){
            field = line.split(" ");                        //tokenize array of a line from the text
            if(Float.valueOf(field[0]) >= 0.0 && Float.valueOf(field[1]) >= 0.0){
                counter++;
                totalMiles += Float.valueOf(field[0]);
                totalCals += Float.valueOf(field[1]);
            }
            else{
                counter++;
                System.out.println("Negative value detected on line " + counter + " of the text file.");
            }
        }//end while loop

        System.out.println("Your total workout data is: " + rounding(totalMiles)+ " Miles | " + rounding(totalCals) + " Calories | " + counter + " Number of Workouts.");
        System.out.println("The average per day is: " + rounding(totalMiles/counter) + " miles | " + rounding(totalCals/counter) + " calories.");

        bufferedReader.close();                             //closes the buffer reader
    }

    public static double rounding(float n){
        double rounded = Math.round(n*100.0)/100.0;
        return rounded;
    }//end rounding utility
}


