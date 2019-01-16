package ma.tetouan.factoryrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.tetouan.factoryrest.model.Commande;
import ma.tetouan.factoryrest.model.Semaine;
import ma.tetouan.factoryrest.model.Statut;
import ma.tetouan.factoryrest.service.CommandeService;
import ma.tetouan.factoryrest.service.SemaineService;
import ma.tetouan.factoryrest.service.StatutService;

@RestController
@RequestMapping({"/api/commande"})
public class CommandeController {

	@Autowired
	CommandeService commandeService;
	
	@Autowired
	StatutService statutService;
	
	@Autowired
	SemaineService semaineService;

    @GetMapping
    public List<Commande> getAllCommande(){
        return commandeService.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public Commande findCommandeById(@PathVariable("id") Integer id){
        return commandeService.findById(id);
    }
    
    @PostMapping
    public Commande create(@RequestBody Commande commande){
        return commandeService.createCommande(commande);
    }
    
    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        commandeService.deleteCommande(id);
    }

    @GetMapping(path = {"/statut"})
    public List<Statut> getAllStatuts(){
        return statutService.findAll();
    }
    
    @GetMapping(path = {"/semaine"})
    public List<Semaine> getAllSemaines(){
        return semaineService.findAll();
    }
}
