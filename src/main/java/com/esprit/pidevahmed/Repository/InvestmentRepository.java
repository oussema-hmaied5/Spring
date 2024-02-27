package com.esprit.pidevahmed.Repository;

import com.esprit.pidevahmed.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {
}