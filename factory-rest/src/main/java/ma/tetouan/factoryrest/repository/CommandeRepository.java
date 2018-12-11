package ma.tetouan.factoryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.tetouan.factoryrest.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
