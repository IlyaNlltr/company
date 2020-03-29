package com.project.company.dao;

import com.project.company.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    @Query("select d from Address d where d.country = :country and d.city = :city and d.street = :street and d.house = :house")
    Address findAddressByFullName(
                    @Param("country") String country,
                    @Param("city") String city,
                    @Param("street") String street,
                    @Param("house") String house
            );

}
