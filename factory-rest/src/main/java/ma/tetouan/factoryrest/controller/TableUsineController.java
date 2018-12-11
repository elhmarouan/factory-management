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

import ma.tetouan.factoryrest.model.TableUsine;
import ma.tetouan.factoryrest.service.TableUsineService;

@RestController
@RequestMapping({"/api/table"})
public class TableUsineController {
	
	@Autowired
	TableUsineService tableUsineService;

    @GetMapping
    public List<TableUsine> getAllTableUsine(){
        return tableUsineService.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public TableUsine findTableUsineById(@PathVariable("id") Integer id){
        return tableUsineService.findById(id);
    }
    
    @PostMapping
    public TableUsine create(@RequestBody TableUsine tableUsine){
        return tableUsineService.createTableUsine(tableUsine);
    }
    
    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        tableUsineService.deleteTableUsine(id);
    }


}
