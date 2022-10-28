package com.code.supplierinventoryservice.service;

import com.code.supplierinventoryservice.entity.Drugs;
import com.code.supplierinventoryservice.repository.DrugsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class DrugsService {
    @Autowired
    DrugsRepository drugsRepository;

    public Drugs addDrug(Drugs drug)
    {
        return drugsRepository.save(drug);
    }

    public Drugs updateDrug(Drugs drug) throws Exception {
        Optional<Drugs> op=drugsRepository.findById(drug.getId());
        if(op.isPresent())
        {
            Drugs drug1=op.get();
            drugsRepository.save(drug);
            return drug;
        }
        else {
            throw new Exception();
        }
    }


    public List<Drugs> getAllDrugs(){

        return drugsRepository.findAll();
    }



    public void deleteDrug(String id)  {
        Optional<Drugs> op=drugsRepository.findById(id);
        if(op.isPresent()){
            drugsRepository.delete(op.get());
            }
        }



}
