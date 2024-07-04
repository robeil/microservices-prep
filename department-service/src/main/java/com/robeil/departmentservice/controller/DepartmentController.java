package com.robeil.departmentservice.controller;

import com.robeil.departmentservice.client.EmployeeClient;
import com.robeil.departmentservice.model.Department;
import com.robeil.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository service;
    @Autowired
    private EmployeeClient employeeClient;


    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return service.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department findAll: {}");
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department findById: {}", id);
        return service.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department findAllWithEmployees: {}");
        List<Department> departments = service.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
        return  departments;
    }

}
