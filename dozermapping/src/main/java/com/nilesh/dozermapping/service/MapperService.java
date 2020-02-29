package com.nilesh.dozermapping.service;

import com.nilesh.dozermapping.Employee;
import com.nilesh.dozermapping.EmployeeDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    public String getDozerData()
    {

        Employee employee = new Employee();
        employee.setId(1000);
        employee.setName("Nilesh");
        employee.setSalary(10000.129);

        Mapper mapper = new DozerBeanMapper();
        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);

        return "Name--"+ employeeDTO.getEmpName() + " Id --" + employeeDTO.getId() + " Salary --" + employeeDTO.getSalary();
        // DozerBeanMapper does not work if the field names are different but works if types are different
        // Does not need to have mapping.xml file
    }
    public String getDozerDataUsingSinggletonMapper()
    {
        // Needs to have dozerBeanMapping.xml
        Employee employee = new Employee();
        employee.setId(1000);
        employee.setName("Nilesh");
        employee.setSalary(10000.129);

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
        return "Name--"+ employeeDTO.getEmpName() + " Id --" + employeeDTO.getId() + " Salary --" + employeeDTO.getSalary();

        /*<mapping>
        <class-a>com.nilesh.dozermapping.Employee</class-a>
        <class-b>com.nilesh.dozermapping.EmployeeDTO</class-b>
            <field>
                <a>name</a>
                <b>empName</b>
            </field>
        </mapping>*/
        // Maps all fields if has different name and type if wildcard is true or wildcard field not provided
    }
    public String getDozerDataUsingAutowiredMapper(Mapper mapper)
    {
        // Needs to have dozerBeanMapping.xml and autowired Mapper
        Employee employee = new Employee();
        employee.setId(1000);
        employee.setName("Nilesh");
        employee.setSalary(10000.129);

        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);

        return "Name -- "+ employeeDTO.getEmpName() + " Id --" + employeeDTO.getId() + " Salary --" + employeeDTO.getSalary();

        /*<mapping wildcard="true">
        <class-a>com.nilesh.dozermapping.Employee</class-a>
        <class-b>com.nilesh.dozermapping.EmployeeDTO</class-b>
            <field>
                <a>name</a>
                <b>empName</b>
            </field>
        </mapping>*/

        // gives us all fields if wildcard is true and only mentioned fields in mapping.xml if wildcard set to false
    }
}
