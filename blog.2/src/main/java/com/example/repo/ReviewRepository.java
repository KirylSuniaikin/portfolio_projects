package com.example.repo;

import com.example.models.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Reviews, Long> {//extends  добавляет все необходимые операции с таблицей Reviews



}
