package com.project.company.dao;

import com.project.company.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    @Query("select h from Client h where h.groups = :groups")
    Client findByGroups(@Param("groups") String groups);

}
