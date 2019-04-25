package source.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.MGenre;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MGenreRepository extends JpaRepository<MGenre, Integer> {
}
