package ma.tetouan.factoryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.tetouan.factoryrest.model.Statut;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Integer> {

}
