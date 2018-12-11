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

import ma.tetouan.factoryrest.model.Ouvrier;
import ma.tetouan.factoryrest.service.OuvrierService;

@RestController
@RequestMapping({"/api/ouvrier"})
public class OuvrierController {
	
	@Autowired
	OuvrierService ouvrierService;

    @GetMapping
    public List<Ouvrier> getAllOuvrier(){
        return ouvrierService.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public Ouvrier findOuvrierById(@PathVariable("id") Integer id){
        return ouvrierService.findById(id);
    }
    
    @PostMapping
    public Ouvrier create(@RequestBody Ouvrier ouvrier){
        return ouvrierService.createOuvrier(ouvrier);
    }
    
    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        ouvrierService.deleteOuvrier(id);
    }

}
