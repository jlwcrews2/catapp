package no.jlwcrews.catapp.playdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaydateRepo extends JpaRepository<Playdate, Long> {
}
