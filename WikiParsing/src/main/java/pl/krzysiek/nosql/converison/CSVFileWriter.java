package pl.krzysiek.nosql.converison;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.ws.util.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import  org.apache.commons.lang3.*;

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
                String cleaned = record.replaceAll("[^a-zA-Z0-9żźćńółęąśŻŹĆĄŚĘŁÓŃ]", " ");
                this.append("\"" + cleaned + "\"" + "\n");
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
