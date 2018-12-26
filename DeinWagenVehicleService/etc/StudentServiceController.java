package com.auma.deinwagen.etc;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();

	static {

		schooDB = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();

		Student std = new Student("Sajal", "Class IV");

		lst.add(std);

		std = new Student("Lokesh", "Class V");

		lst.add(std);

		schooDB.put("abcschool", lst);

		lst = new ArrayList<Student>();

		std = new Student("Kajal", "Class III");

		lst.add(std);

		std = new Student("Sukesh", "Class VI");

		lst.add(std);

		schooDB.put("xyzschool", lst);

	}

	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)

	public List<Student> getStudents(@PathVariable String schoolname) {

		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = schooDB.get(schoolname);

		if (studentList == null) {

			studentList = new ArrayList<Student>();

			Student std = new Student("Not Found", "N/A");

			studentList.add(std);

		}

		return studentList;

	}
	
	/*
	 * for test purpose
	 */
	/*private static Map<String, List<VehicleDetail>> vehicleDB = new HashMap<String, List<VehicleDetail>>();
	 
    static {
        vehicleDB = new HashMap<String, List<VehicleDetail>>();
 
        List<VehicleDetail> lst = new ArrayList<VehicleDetail>();
        VehicleDetail std = new VehicleDetail("BMW", "Class IV");
        lst.add(std);
        std = new VehicleDetail("Mercedes", "Class V");
        lst.add(std);
 
        vehicleDB.put("cars1", lst);
 
        lst = new ArrayList<VehicleDetail>();
        std = new VehicleDetail("VolksWagen", "Class III");
        lst.add(std);
        std = new VehicleDetail("Audi", "Class VI");
        lst.add(std);
 
        vehicleDB.put("cars2", lst);
        System.out.println("vehicleDB"+vehicleDB.size());
 
    }
 
    @RequestMapping(value = "/getcarlist/{carlist}", method = RequestMethod.GET)
    public List<VehicleDetail> getcars(@PathVariable String carlist) {
        System.out.println("Getting car details for " + carlist);
 
        List<VehicleDetail> vehicleList = vehicleDB.get(carlist);
        if (vehicleList == null) {
        	vehicleList = new ArrayList<VehicleDetail>();
            VehicleDetail std = new VehicleDetail("Not Found", "N/A");
            vehicleList.add(std);
        }
        return vehicleList;
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getcars() {
        System.out.println("Getting car details for****");
 
        return "Okay";
    }
    
    @RequestMapping(value = "/getModel", method = RequestMethod.GET)
    public List<VehicleDetail> getModel(@PathVariable String carlist) {
        System.out.println("Getting car details for " + carlist);
 
        List<VehicleDetail> vehicleList = vehicleDB.get(carlist);
        if (vehicleList == null) {
        	vehicleList = new ArrayList<VehicleDetail>();
            VehicleDetail std = new VehicleDetail("Not Found", "N/A");
            vehicleList.add(std);
        }
        return vehicleList;
    }
    */

}
