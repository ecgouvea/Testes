package com.javacodegeeks.examples.jaxb.validation.main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.javacodegeeks.examples.jaxb.validation.entity.Employee;

public class EmployeeUnmarshaller {

	public static void main(String[] args) throws JAXBException, SAXException, UnsupportedEncodingException {
		new EmployeeUnmarshaller().runEmployeeUnmarshaller();
	}

	private void runEmployeeUnmarshaller() throws JAXBException, SAXException, UnsupportedEncodingException {
		JAXBContext context = JAXBContext.newInstance(Employee.class);
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		InputStream inputStream = 
			    getClass().getClassLoader().getResourceAsStream("WEB-INF/titulo.xsd");
		Source source = new StreamSource(inputStream);
        Schema schema = sf.newSchema(source);
        
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(new EmployeeValidationEventHandler());
		
        
        Employee request = null;

        // Converter JAXB Element em string ----------------------------------------------
        Marshaller m;
        StringWriter sw;
        String requestXmlString;

        context = JAXBContext.newInstance(request.getClass());
        m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);// To format XML

        sw = new StringWriter();
        m.marshal(request, sw);
        requestXmlString = sw.toString();
        // --------------------------------------------------------------------------------
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(requestXmlString.getBytes()), "UTF-8"));
        Employee employee = (Employee) unmarshaller.unmarshal(buf);
		
		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getAddress().getAddressLine1());
		System.out.println(employee.getAddress().getAddressLine2());
		System.out.println(employee.getAddress().getCity());
		System.out.println(employee.getAddress().getState());
		System.out.println(employee.getAddress().getCountry());
		System.out.println(employee.getAddress().getZipCode());
	}
}

class EmployeeValidationEventHandler implements ValidationEventHandler {
	@Override
	public boolean handleEvent(ValidationEvent event) {
		 System.out.println("\nEVENT");
	        System.out.println("SEVERITY:  " + event.getSeverity());
	        System.out.println("MESSAGE:  " + event.getMessage());
	        System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
	        System.out.println("LOCATOR");
	        System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
	        System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
	        System.out.println("    OFFSET:  " + event.getLocator().getOffset());
	        System.out.println("    OBJECT:  " + event.getLocator().getObject());
	        System.out.println("    NODE:  " + event.getLocator().getNode());
	        System.out.println("    URL:  " + event.getLocator().getURL());
	        return true;
	}
}
