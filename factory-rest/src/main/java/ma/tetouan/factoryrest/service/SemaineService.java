package ma.tetouan.factoryrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.tetouan.factoryrest.model.Semaine;
import ma.tetouan.factoryrest.repository.SemaineRepository;

@Service
@Transactional
public class SemaineService {

	@Autowired
	SemaineRepository semaineRepository;
	
	public List<Semaine> findAll() {
		return semaineRepository.findAll();
	}
}
