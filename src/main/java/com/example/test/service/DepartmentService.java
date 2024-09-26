package com.example.test.service;

import com.example.test.entity.Department;
import com.example.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public void deleteDepartment(Department department) {
        repository.delete(department);
    }

    public void deleteGivenDepartment(Integer departmentId) {
        Optional<Department> exists = repository.findById(departmentId);
        if (exists.isPresent()){
            repository.deleteById(departmentId);
        }
    }

    public Iterable<Department> findAllDepartments() {
        return repository.findAll();
    }

    public Optional<Department> findByDepartmentId(Integer id) {
       return repository.findById(id);
    }

    public Department saveDepartment(Department department)
    {
        return repository.save(department);
    }

    public Department updateDepartment(Integer id, Department dept) {
        Department department = repository.findById(id).orElseThrow();
        department.setCode(dept.getCode());
        department.setName(dept.getName());
        department.setDescription(dept.getDescription());

        return repository.save(department);
    }
}
