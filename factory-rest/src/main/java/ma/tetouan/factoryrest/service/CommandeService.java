package ma.tetouan.factoryrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.tetouan.factoryrest.model.Commande;
import ma.tetouan.factoryrest.repository.CommandeRepository;

@Service
@Transactional
public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	
	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}
	
	public Commande createCommande(Commande commande) {
		return commandeRepository.save(commande);
	}
	
	public void deleteCommande(Integer commandeId) {
		Commande Commande = commandeRepository.findById(commandeId).orElse(null);
		if (Commande != null) {
			commandeRepository.delete(Commande);
		}
	}
	
	public Commande findById(Integer commandeId) {
		return commandeRepository.findById(commandeId).orElse(null);
	}
}
