package com.project.company.dao;

import com.project.company.model.Staff;
import com.project.company.model.Tags;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {

    @Query("select a from Staff a where a.name = :name")
    Staff findByName(@Param("name") String name);

    @Query("select b from Staff b where b.surname = :surname")
    Staff findBySurname(@Param("surname") String surname);

    @Query("select c from Staff c where c.patronymic = :patronymic")
    Staff findByPatronymic(@Param("patronymic") String patronymic);

    @Query("select d from Staff d where d.position = :position")
    Staff findByPosition(@Param("position") String position);

    @Query("select f from Staff f where f.gender = :gender")
    Staff findByGender(@Param("gender") String gender);

    @Query("select e from Staff e where e.name = :name and e.surname = :surname and e.patronymic = :patronymic and e.position = :position")
    Staff findPersonByFullName(
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("patronymic") String patronymic);
}
