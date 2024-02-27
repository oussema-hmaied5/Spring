package com.esprit.pidevahmed.Controller;

import com.esprit.pidevahmed.Services.InvestmentService;
import com.esprit.pidevahmed.model.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/investments")
public class InvestmentController {
   @Autowired
   private InvestmentService investmentService;

   @PostMapping("/addI")
   public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
      Investment newInvestment = investmentService.addInvestment(investment);
      return new ResponseEntity<>(newInvestment, HttpStatus.CREATED);
   }

   @GetMapping("/allI")
   public ResponseEntity<List<Investment>> getAllInvestments() {
      List<Investment> investments = investmentService.getAllInvestments();
      return new ResponseEntity<>(investments, HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) {
      Investment investment = investmentService.getInvestmentById(id);
      return new ResponseEntity<>(investment, HttpStatus.OK);
   }

   @PutMapping("/upadeteI/{id}")
   public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investment) {
      Investment updatedInvestment = investmentService.updateInvestment(id, investment);
      return new ResponseEntity<>(updatedInvestment, HttpStatus.OK);
   }

   @DeleteMapping("/deleteI/{id}")
   public void deleteInvestment(@PathVariable Long id) {
      investmentService.deleteInvestment(id);
      ResponseEntity.ok().build();
   }
}
