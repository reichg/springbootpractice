package com.evolutionaryeyes.springpractice.controller;

import com.evolutionaryeyes.springpractice.entity.Department;
import com.evolutionaryeyes.springpractice.error.DepartmentNotFoundException;
import com.evolutionaryeyes.springpractice.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


/*
- @RestController for spring
- API controller for GET, POST, PUT, and DELETE
- Implement the service via injection or autowiring
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = Logger.getLogger(String.valueOf(DepartmentController.class));

    /*
     * @PostMapping("/departments")
     * @RequestBody (jsonObject)
     */

    @GetMapping("/departments")
    public List<Department> getDepartments() {

        logger.info("Fetching all departments");
        return departmentService.fetchDepartmentList();
    }

    /*
    - need the @PathVariable param when dynamically mapping in the URL
     */
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Saving department");
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment( @PathVariable("id") Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
        return "department deleted: " + id;
    }
}
