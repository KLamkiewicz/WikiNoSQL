package pl.krzysiek.nosql.converison;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;


public class SaxHandler extends DefaultHandler {
    private StringBuilder buf;
    private boolean id;
    private boolean text;
    private Stack<String> elementsStack = new Stack<String>();
    private CSVFileWriter fileWriter;


    public SaxHandler(String fileName) throws Exception{
        fileWriter = new CSVFileWriter(fileName);
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        fileWriter.addHeaders("id,text");

    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        /*
            Pushing node names to stack so we can check if page id is in the right place
        */
        this.elementsStack.push(qName);

        buf = new StringBuilder();

        /*
            Marking matching nodes
         */
        if("id".equals(qName) && (!elementsStack.contains("revision")) ){
            id = true;
        }

        if("text".equals(qName)){
            text = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elementsStack.pop();

        /*
            Text is concatenated with the use of StringBuilder thus
            is outputted at the end of element as a whole
         */
        if(text){
            fileWriter.appendToFile(buf.toString(), true);
        }

        /*
            Marking xml nodes as false and clearing StringBuilder
         */
        if("text".equals(qName)) {
            text = false;
        }
        if("id".equals(qName)) {
            id = false;
        }

        buf.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (buf!=null) {
            for (int i=start; i<start+length; i++) {
                if(ch[i] != 34) {
                    buf.append(ch[i]);
                }
            }
        }

        if(id){
            fileWriter.appendToFile(buf.toString(), false);
        }

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        //super.ignorableWhitespace(ch, start, length);
    }
}
