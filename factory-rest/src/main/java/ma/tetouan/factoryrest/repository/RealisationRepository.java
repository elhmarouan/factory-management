package ma.tetouan.factoryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.tetouan.factoryrest.model.Realisation;

@Repository
public interface RealisationRepository extends JpaRepository<Realisation, Integer> {

}
