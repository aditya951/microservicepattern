package com.adi.graphql.resolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.graphql.resolver.entity.Subject;



@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
