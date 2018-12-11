package ma.tetouan.factoryrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.tetouan.factoryrest.model.TableUsine;
import ma.tetouan.factoryrest.repository.TableUsineRepository;

@Service
@Transactional
public class TableUsineService {
	
	@Autowired
	TableUsineRepository tableUsineRepository;
	
	public List<TableUsine> findAll() {
		return tableUsineRepository.findAll();
	}
	
	public TableUsine createTableUsine(TableUsine tableUsine) {
		return tableUsineRepository.save(tableUsine);
	}
	
	public void deleteTableUsine(Integer tableUsineId) {
		TableUsine tableUsine = tableUsineRepository.findById(tableUsineId).orElse(null);
		if (tableUsine != null) {
			tableUsineRepository.delete(tableUsine);
		}
	}
	
	public TableUsine findById(Integer tableUsineId) {
		return tableUsineRepository.findById(tableUsineId).orElse(null);
	}
}
