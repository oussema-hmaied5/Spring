package com.esprit.pidevahmed.Services;

import com.esprit.pidevahmed.Repository.InvestmentRepository;
import com.esprit.pidevahmed.model.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;


import java.util.List;

@Service
public class InvestmentService {
   @Autowired
   private InvestmentRepository investmentRepository;

   public Investment addInvestment(Investment investment) {
      return investmentRepository.save(investment);
   }

   public List<Investment> getAllInvestments() {
      return (List<Investment>) investmentRepository.findAll();
   }

   public Investment getInvestmentById(Long id) {
      return investmentRepository.findById(id)
              .orElseThrow(() -> new InvestmentNotFoundException(id));
   }

   public Investment updateInvestment(Long id, Investment investmentDetails) {
      Investment investment = getInvestmentById(id);
      BeanUtils.copyProperties(investmentDetails, investment, "idInv");
      return investmentRepository.save(investment);
   }

   public void deleteInvestment(Long id) {
      Investment investment = getInvestmentById(id);
      investmentRepository.delete(investment);
   }
   public class InvestmentNotFoundException extends RuntimeException {
      public InvestmentNotFoundException(Long id) {
         super("Investment not found with id: " + id);
      }
   }

}