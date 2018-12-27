package ma.tetouan.factoryrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.tetouan.factoryrest.model.Statut;
import ma.tetouan.factoryrest.repository.StatutRepository;

@Service
@Transactional
public class StatutService {

	@Autowired
	StatutRepository statutRepository;
	
	public List<Statut> findAll() {
		return statutRepository.findAll();
	}
}
