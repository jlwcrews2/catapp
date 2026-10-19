package no.jlwcrews.catapp.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {

    @Query("SELECT o FROM Owner o WHERE SIZE(o.cats) > :minCats")
    List<Owner> findOwnersWithMoreThanXCats(@Param("minCats") int minCats);
}
