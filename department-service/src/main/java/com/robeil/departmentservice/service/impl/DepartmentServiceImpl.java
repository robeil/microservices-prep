//package com.robeil.departmentservice.service.impl;
//
//import com.robeil.departmentservice.model.Department;
//import com.robeil.departmentservice.repository.DepartmentRepository;
//import com.robeil.departmentservice.service.DepartmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DepartmentServiceImpl implements DepartmentService {
//
////    @Autowired
////    private DepartmentRepository departmentRepository;
//
//    @Override
//    public List<Department> findAllDepartments() {
//        return departmentRepository.findAll();
//    }
//
//    @Override
//    public Department findDepartmentById(Long id) {
//        return departmentRepository.findAll().stream()
//                .filter(department -> department.getId().equals(id))
//                .findFirst()
//                .orElseThrow();
//    }
//
//    @Override
//    public void addDepartment(Department department) {
//        departmentRepository.save(department);
//    }
//}
