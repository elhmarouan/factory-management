package ma.tetouan.factoryrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.tetouan.factoryrest.model.Ouvrier;
import ma.tetouan.factoryrest.repository.OuvrierRepository;

@Service
@Transactional
public class OuvrierService {

	@Autowired
	OuvrierRepository ouvrierRepository;
	
	public List<Ouvrier> findAll() {
		return ouvrierRepository.findAll();
	}
	
	public Ouvrier createOuvrier(Ouvrier ouvrier) {
		return ouvrierRepository.save(ouvrier);
	}
	
	public void deleteOuvrier(Integer ouvrierId) {
		Ouvrier ouvrier = ouvrierRepository.findById(ouvrierId).orElse(null);
		if (ouvrier != null) {
			ouvrierRepository.delete(ouvrier);
		}
	}
	
	public Ouvrier findById(Integer ouvrierId) {
		return ouvrierRepository.findById(ouvrierId).orElse(null);
	}
	
}
