package xmlOperations;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class NERDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		TryNER obj = new TryNER();
		obj.setFileName("inputXml.xml");
		obj.execute();
	}

}
