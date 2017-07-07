package org.exampleapps.greatbig.repository;

import org.exampleapps.greatbig.domain.Tag;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the Tag entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

    // @Query("select author from Author author left join fetch author.followers left join fetch author.favorites where author.id =:id")
    Tag findOneByName(@Param("name") String name);
}
