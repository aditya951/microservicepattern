package com.adi.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.graphql.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
