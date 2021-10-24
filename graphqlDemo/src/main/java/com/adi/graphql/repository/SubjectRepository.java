package com.adi.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.graphql.entity.Subject;



@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
