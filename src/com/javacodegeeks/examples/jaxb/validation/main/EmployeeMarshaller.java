package com.javacodegeeks.examples.jaxb.validation.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.javacodegeeks.examples.jaxb.validation.entity.Address;
import com.javacodegeeks.examples.jaxb.validation.entity.Employee;

public class EmployeeMarshaller {
	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		new EmployeeMarshaller().runMarshaller();
	}

	private void runMarshaller() throws JAXBException, FileNotFoundException {
		Employee emp = createEmployee();
		
		JAXBContext context = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		FileOutputStream fileOutputStream = new FileOutputStream(new File("person.xml"));
		
		marshaller.marshal(emp, fileOutputStream);
	}

	private Employee createEmployee() {
		Address address = new Address("addressLine1", "addressLine2", "city", "state", "country", 99999);
		Employee emp = new Employee(1, "name", address, 100000.00);
		return emp;
	}
}
