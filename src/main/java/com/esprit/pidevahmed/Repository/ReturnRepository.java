package com.esprit.pidevahmed.Repository;

import com.esprit.pidevahmed.model.Returns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReturnRepository extends CrudRepository <Returns,Long> {
}
