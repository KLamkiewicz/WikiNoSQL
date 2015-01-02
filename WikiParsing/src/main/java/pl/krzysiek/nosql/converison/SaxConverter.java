package pl.krzysiek.nosql.converison;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class SaxConverter {
    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private SAXParser saxParser;
    private InputStream inputStream;
    private DefaultHandler handler;

    public SaxConverter(String fileName, String fileToWrite) throws Exception{
        inputStream = new FileInputStream(fileName);
        saxParser = factory.newSAXParser();
        handler = new SaxHandler(fileToWrite);
        saxParser.parse(inputStream, handler);
    }

    public SAXParserFactory getFactory() {
        return factory;
    }

    public SAXParser getSaxParser() {
        return saxParser;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public DefaultHandler getHandler() {
        return handler;
    }
}
