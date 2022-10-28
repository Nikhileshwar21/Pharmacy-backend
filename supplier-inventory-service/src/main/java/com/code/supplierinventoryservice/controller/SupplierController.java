package com.code.supplierinventoryservice.controller;

import com.code.supplierinventoryservice.entity.Supplier;
import com.code.supplierinventoryservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins="http://localhost:3000")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity< Object > addSupplier(@RequestBody Supplier supplier )
    {
        try {
            return ResponseEntity.ok().body(supplierService.addSupplier(supplier));
        }
        catch(Exception e) {
            return new ResponseEntity<Object>("Cannot add supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity <List<Supplier>> getAllSuppliers() {

        return ResponseEntity.ok().body(supplierService.getAllSuppliers());
    }





    @PutMapping("/update/{id}")
    public ResponseEntity < Object > updateSupplier(@PathVariable String id, @RequestBody Supplier supplier) {
        try {
            supplier.setId(id);
            return ResponseEntity.ok().body(supplierService.updateSupplier(supplier));
        }
        catch(Exception e)
        {
            return new ResponseEntity<Object>("Supplier not found with id"+id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSupplier(@PathVariable String id)  {
        try {
            this.supplierService.deleteSupplier(id);
            return new ResponseEntity<String>("Deleted",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<String>("Supplier not found with id"+id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
