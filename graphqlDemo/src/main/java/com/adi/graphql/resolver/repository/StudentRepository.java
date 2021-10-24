package com.adi.graphql.resolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.graphql.resolver.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
