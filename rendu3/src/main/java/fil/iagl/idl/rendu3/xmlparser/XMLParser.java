package fil.iagl.idl.rendu3.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fil.iagl.idl.rendu3.entite.Resultat;

public class XMLParser {

	public static void readSurefireReport(File sureFireReportFolder, Resultat res)
			throws SAXException, IOException, ParserConfigurationException {
		Collection<File> reports = FileUtils.listFiles(sureFireReportFolder, new String[] { "xml" }, true);
		for (File report : reports) {
			Document sureFireDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(report);
			sureFireDoc.normalize();
			NodeList testsuiteNode = sureFireDoc.getElementsByTagName("testsuite");
			if (testsuiteNode.item(0).getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) testsuiteNode.item(0);
				String className = eElement.getAttribute("name");
				int nbTest = Integer.parseInt(eElement.getAttribute("tests"));
				int nbError = Integer.parseInt(eElement.getAttribute("errors"));
				int nbFailure = Integer.parseInt(eElement.getAttribute("failures"));
				int nbSkipped = Integer.parseInt(eElement.getAttribute("skipped"));
				int nbSuccess = nbTest - nbError - nbFailure - nbSkipped;
				System.out.printf("%s\tSuccess :%d\tFailure : %d\n", className, nbSuccess,
						nbError + nbFailure + nbSkipped);
				if (className.contains("Blackbox")) {
					res.setBlackFail(nbError + nbFailure + nbSkipped);
					res.setBlackSuccess(nbSuccess);
				} else {
					res.setWhiteFail(nbError + nbFailure + nbSkipped);
					res.setWhiteSuccess(nbSuccess);
				}
			}
		}
	}

}
