package com.example.test.controller;


import com.example.test.entity.Department;
import com.example.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @DeleteMapping("remove/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteGivenDepartment(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> findDepartmentById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.findByDepartmentId(id),HttpStatus.FOUND);
    }

    @PostMapping("/saveDept")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department dept) {
        return new ResponseEntity<>(service.saveDepartment(dept), HttpStatus.ACCEPTED);
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Integer departmentId)
    {
        return service.updateDepartment(
                departmentId, department);
    }

}

