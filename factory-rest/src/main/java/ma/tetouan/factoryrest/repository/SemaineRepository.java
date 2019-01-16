package ma.tetouan.factoryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.tetouan.factoryrest.model.Semaine;

@Repository
public interface SemaineRepository extends JpaRepository<Semaine, Integer> {

}

