package xmlOperations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLOperationsForNER {
	
	private List<NERElement> nerElements;
	private String fileName;
	private File xmlFile;
	private String rootElement;

	
	public String getRootElement() {
		return rootElement;
	}

	public void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}

	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;
	
	public XMLOperationsForNER(String fileName) throws ParserConfigurationException, SAXException, IOException {
		this.fileName = fileName;
		xmlFile = new File(fileName);
		initialiseTools();
	}

	public XMLOperationsForNER(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		this.xmlFile = xmlFile;
		initialiseTools();
	}
	
	private void initialiseTools() throws ParserConfigurationException, SAXException, IOException{
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		setRootElement(doc.getDocumentElement().getNodeName());
		
	}	
	
	/*
	 *	Hard-coded for the tag names as the hierarchy and tags are fixed for this xml file in NER  
	 */
	public List parseXml(){

		NodeList nList = doc.getElementsByTagName("token");
		
		nerElements = new ArrayList<NERElement>();
		
		for(int i = 0; i <nList.getLength(); i++){
			Node nNode =  nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				 
				Element eElement = (Element) nNode;
				String ner = eElement.getElementsByTagName("NER").item(0).getTextContent();
				if(ner.equals("O"))
					continue;
				else{
					String word = eElement.getElementsByTagName("word").item(0).getTextContent();
					NERElement element = new NERElement(word,ner);
					nerElements.add(element);
				}
			}
		}
		
		return nerElements;
	}
}
