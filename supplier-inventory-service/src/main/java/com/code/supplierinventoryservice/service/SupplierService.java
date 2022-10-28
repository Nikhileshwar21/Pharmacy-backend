package com.code.supplierinventoryservice.service;

import com.code.supplierinventoryservice.entity.Supplier;
import com.code.supplierinventoryservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;



    public Supplier addSupplier(Supplier supplier ) {

        return supplierRepository.insert(supplier);
    }


    public Supplier updateSupplier(Supplier supplier )  {
        Optional< Supplier > op = this.supplierRepository.findById(supplier.getId());
        if (op.isPresent()) {
            Supplier supplier1 = op.get();
            supplierRepository.save(supplier);
            return supplier;
        } else {
            return null;
        }
    }


    public List< Supplier > getAllSuppliers() {

        return this.supplierRepository.findAll();
    }




    public String deleteSupplier(String id)  {
        Optional < Supplier > op = this.supplierRepository.findById(id);

        if (op.isPresent()) {
             this.supplierRepository.delete(op.get());


        }

        return null;


    }
}

