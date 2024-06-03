package com.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetDataFromXml {

	private static boolean String;

	public String getXMLData(String datafor) {
		String nodevalue = null;
		try {

			String sourceXML = "TestData.xml";
			// creating a constructor of file class and parsing an XML file
			File file = new File(sourceXML);
			// an instance of factory that gives a document builder
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			// an instance of builder to parse the specified xml file

			Document document = documentBuilder.parse(file);

			nodevalue = document.getElementsByTagName(datafor).item(0).getTextContent();
		}

		catch (Exception e) {
			nodevalue = null;
		}
		return nodevalue;
	}

	public static void main(String args[]) {
		GetDataFromXml getDataFromXml = new GetDataFromXml();
		// Return String -- fetch value using tag name 
		String value = getDataFromXml.getXMLData("url");
		
		// Return Xml data in String array without loop -- have to pass the array size in getXMLDataStringArray method 
		String[] xmlvalue = getDataFromXml.getXMLDataStringArray();
		System.out.println(xmlvalue[0] + " " + xmlvalue[1] + " " + xmlvalue[2]);
		
		//  Return Xml data in String array using loop
		String[] xmlvalueloop = getDataFromXml.getXMLDataStringArraywithLoop();
		//
		for (String text1 : xmlvalueloop){
			System.out.println(text1);
		}
		

	}

	public String[] getXMLDataStringArray() {
		// need to declare the size of the array 
		String[] nodevalue1 = new String[3];
		try {

			String sourceXML = "TestData.xml";
			// creating a constructor of file class and parsing an XML file
			File file1 = new File(sourceXML);
			// an instance of factory that gives a document builder
			DocumentBuilderFactory documentBuilderFactory1 = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder2 = documentBuilderFactory1.newDocumentBuilder();
			// an instance of builder to parse the specified xml file

			Document document = documentBuilder2.parse(file1);

			nodevalue1[0] = document.getElementsByTagName("url").item(0).getTextContent();
			nodevalue1[1] = document.getElementsByTagName("username").item(0).getTextContent();
			nodevalue1[2] = document.getElementsByTagName("password").item(0).getTextContent();

		}

		catch (Exception e) {
			nodevalue1 = null;
		}
		return nodevalue1;
	}
	
	public String[] getXMLDataStringArraywithLoop() {
		String[] stringArray = null;
		
		try {

			String sourceXML = "TestData.xml";
			// creating a constructor of file class and parsing an XML file
			File file1 = new File(sourceXML);
			// an instance of factory that gives a document builder
			DocumentBuilderFactory documentBuilderFactory1 = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder2 = documentBuilderFactory1.newDocumentBuilder();
			// an instance of builder to parse the specified xml file

			Document document = documentBuilder2.parse(file1);
			

			   // Get the root element
	           Element rootElement = document.getDocumentElement();

	           // Get the list of elements you want to extract data from
	           NodeList nodeList = rootElement.getElementsByTagName("SeleniumTestData");

	           // Create a List to store the extracted strings
	           List<String> stringList = new ArrayList<>();

	           // Iterate over the elements and extract the data
	           for (int i = 0; i < nodeList.getLength(); i++) {
	               Element element = (Element) nodeList.item(i);

	               // Get the text content of the element and add it to the list
	               String elementText = element.getTextContent();
	               stringList.add(elementText);
	           }

	           // Convert the List to a String array
	           stringArray = stringList.toArray(new String[0]);

		}

		catch (Exception e) {
		
		}
		return stringArray;
	}

}
