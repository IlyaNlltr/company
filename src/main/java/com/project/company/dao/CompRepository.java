package com.project.company.dao;


import com.project.company.model.Comp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompRepository extends CrudRepository<Comp, String> {

    @Query("select x from Comp x where x.name = :name")
    Comp findByName(@Param("name") String name);

}
