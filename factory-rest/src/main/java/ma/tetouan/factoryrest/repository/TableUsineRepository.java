package ma.tetouan.factoryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.tetouan.factoryrest.model.TableUsine;

@Repository
public interface TableUsineRepository extends JpaRepository<TableUsine, Integer>{

}
