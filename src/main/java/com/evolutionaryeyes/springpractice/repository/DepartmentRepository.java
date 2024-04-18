package com.evolutionaryeyes.springpractice.repository;

import com.evolutionaryeyes.springpractice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
- @Repository for spting
- repository that interacts with the database
- extends JpaRepository<Entity, @Id<Type>>
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
