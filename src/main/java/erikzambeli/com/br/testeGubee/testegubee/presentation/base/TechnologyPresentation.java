package erikzambeli.com.br.testeGubee.testegubee.presentation.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TechnologyExistsException;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin(origins= "*")
public class TechnologyPresentation implements CRUDController<Technology> {

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/service/technologyperid/{id}")
    @Override
    public ResponseEntity<Technology> readById(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.readById( id));
    }

    @GetMapping("/service/technologypername/{name}")
    @Override
    public ResponseEntity<Technology> readByName(@PathVariable String name) {
        return ResponseEntity.ok(technologyService.readByName(name));
    }

    @GetMapping("/service/technologies")
    @Override
    public ResponseEntity<List<Technology>> readAll() {
        return ResponseEntity.ok(technologyService.readAll());
    }

    @PostMapping("/service/new/technology")
    @Override
    public ResponseEntity<Technology> create(@RequestBody Technology entity) throws AnyPersistenceException, TechnologyExistsException{
        technologyService.create(entity);
        return ResponseEntity.status(201).body(entity);
    }
}
