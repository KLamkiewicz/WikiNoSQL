package pl.krzysiek.nosql.converison;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by krzysiek on 02.01.15.
 */
public class CSVFileWriter extends FileWriter{

    public CSVFileWriter(String fileName) throws IOException {
        super(fileName, true);
    }

    public void appendToFile(String record, Boolean end){
        try{
            if(end){
                this.append("\"" + record + "\"" + "\n");
            }else{
                this.append(record+",");
            }

        }catch (Exception ex){
            System.out.println("Appending exception " + ex.getMessage());
        }
    }

    public void addHeaders(String headers){
        try {
            this.append(headers+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
