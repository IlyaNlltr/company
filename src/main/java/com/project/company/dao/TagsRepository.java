package com.project.company.dao;

import com.project.company.model.Tags;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends CrudRepository<Tags, String> {
    @Query("select p from Tags p where p.tag = :tag")
    Tags findByTags(@Param("tag") String tag);

}
