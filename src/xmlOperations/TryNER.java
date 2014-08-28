package xmlOperations;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TryNER {
	
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void execute() throws ParserConfigurationException, SAXException, IOException{
		XMLOperationsForNER xmlOperations = new XMLOperationsForNER(fileName);
		List<NERElement>nerElements = xmlOperations.parseXml();
		if(!nerElements.isEmpty()){
			for(NERElement node : nerElements){
				System.out.println(node.getWord()+ " : "+node.getNer());
			}
		}
	}
}
