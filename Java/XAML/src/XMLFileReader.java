/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Vincent
 */
public class XMLFileReader{
    private Document document;
    private XPath xpath;
     
    public XMLFileReader(String file, String path){
        SAXBuilder parser = new SAXBuilder();
        try{
            document = parser.build(file);
            xpath = XPath.newInstance(path);
        }catch(JDOMException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ioex){
            System.out.println(
                    "Please place the given file in the same directory as the application");
        }
    }
    
    public void changePath(String path){
        try{
            xpath = XPath.newInstance(path);
        }catch(JDOMException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Element selectElement(){
        try{
           final Element element = (Element) xpath.selectSingleNode(document);
           return element;
        }catch(JDOMException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Element> selectElements(){
        try{
            final List<Element> elements = xpath.selectNodes(document);
            return elements;
        }catch(JDOMException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String getPath(){
        return xpath.getXPath();
    }

}
