package com.esprit.pidevahmed.Services;


import com.esprit.pidevahmed.Repository.ReturnRepository;
import com.esprit.pidevahmed.model.Returns;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnService {


    @Autowired private ReturnRepository returnRepository;


    @Transactional
    public Returns addReturn(Returns returnEntry) {
        return returnRepository.save(returnEntry);
    }

    @Transactional()
    public List<Returns> getAllReturns() {
        return (List<Returns>) returnRepository.findAll();
    }

    @Transactional()
    public Returns getReturnById(Long id) {
        return returnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Return not found with id " + id));
    }

    @Transactional
    public Returns updateReturn(Long id, Returns returnDetails) {
        Returns returnEntry = returnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Return not found with id " + id));

        returnEntry.setAmount(returnDetails.getAmount());
        returnEntry.setReturnRate(returnDetails.getReturnRate());
        returnEntry.setDateR(returnDetails.getDateR());

        return returnRepository.save(returnEntry);
    }

    @Transactional
    public void deleteReturn(Long id) {
        Returns returnEntry = returnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Return not found with id " + id));
        returnRepository.delete(returnEntry);
    }
}
