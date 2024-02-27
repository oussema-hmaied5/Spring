package com.esprit.pidevahmed.Controller;


import com.esprit.pidevahmed.Services.ReturnService;
import com.esprit.pidevahmed.model.Returns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returns")
public class ReturnController {

    @Autowired private ReturnService returnService;

    @PostMapping("/addR")
    public ResponseEntity<Returns> addReturn(@RequestBody Returns returnEntry) {
        Returns newReturn = returnService.addReturn(returnEntry);
        return new ResponseEntity<>(newReturn, HttpStatus.CREATED);
    }

    @GetMapping("/afficheallR")
    public List<Returns> getAllReturns() {
        return returnService.getAllReturns();
    }

    @GetMapping("/affichebyIDR/{id}")
    public ResponseEntity<Returns> getReturnById(@PathVariable Long id) {
        Returns returnEntry = returnService.getReturnById(id);
        return new ResponseEntity<>(returnEntry, HttpStatus.OK);
    }

    @PutMapping("/upadateR/{id}")
    public ResponseEntity<Returns> updateReturn(@PathVariable Long id, @RequestBody Returns returnDetails) {
        Returns updatedReturn = returnService.updateReturn(id, returnDetails);
        return new ResponseEntity<>(updatedReturn, HttpStatus.OK);
    }

    @DeleteMapping("/deleteR/{id}")
    public ResponseEntity<Void> deleteReturn(@PathVariable Long id) {
        returnService.deleteReturn(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
