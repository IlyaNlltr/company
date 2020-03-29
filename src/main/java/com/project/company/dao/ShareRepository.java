package com.project.company.dao;

import com.project.company.model.Share;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRepository extends CrudRepository<Share, String> {

    @Query("select o from Share o where o.phone = :phone")
    Share findShareByPhone(@Param("phone") String phone);

}
