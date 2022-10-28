package com.code.supplierinventoryservice.repository;

import com.code.supplierinventoryservice.entity.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SupplierRepository extends MongoRepository<Supplier,String> {



}
