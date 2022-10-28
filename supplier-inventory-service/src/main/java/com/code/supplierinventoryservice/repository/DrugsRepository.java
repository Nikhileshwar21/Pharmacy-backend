package com.code.supplierinventoryservice.repository;

import com.code.supplierinventoryservice.entity.Drugs;
import com.code.supplierinventoryservice.entity.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugsRepository extends MongoRepository<Drugs,String> {

    @Query("{'supplierName':?0}")
    List<Drugs> findBySupplier(String supplier);

    @Query("{'drugName':?0}")
    List<Drugs> findByDrugName(String drugName);
    
}
