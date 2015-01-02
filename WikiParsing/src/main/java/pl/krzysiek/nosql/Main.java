package pl.krzysiek.nosql;

import pl.krzysiek.nosql.converison.SaxConverter;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){
        long currentTime = System.currentTimeMillis();
        try {
            SaxConverter c = new SaxConverter("/home/krzysiek/Desktop/wikiCleaned.xml","/home/krzysiek/Desktop/wikipedia.csv" );
        }catch (FileNotFoundException f){
            System.out.println("File not found: " + f.getMessage());
        }catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }

        long endTime = System.currentTimeMillis()-currentTime;
        System.out.println("Time taken to convert xml to CSV in milliseconds: " + endTime);
        System.out.println("Time taken to convert xml to CSV in seconds: " + endTime/1000);
        System.out.println("Time taken to convert xml to CSV in minutes: " + endTime/(1000*60));
    }
}
