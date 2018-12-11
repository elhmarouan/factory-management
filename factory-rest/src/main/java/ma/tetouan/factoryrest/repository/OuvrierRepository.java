package ma.tetouan.factoryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.tetouan.factoryrest.model.Ouvrier;

@Repository
public interface OuvrierRepository extends JpaRepository<Ouvrier, Integer> {

}
