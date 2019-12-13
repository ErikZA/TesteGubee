package erikzambeli.com.br.testeGubee.testegubee.presentation.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TargetExistsException;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin(origins= "*")
public class TargetPresentation implements CRUDController<Target>{

    @Autowired
    private TargetService targetService;

    @GetMapping("/service/targetperid/{id}")
    @Override
    public ResponseEntity<Target> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(targetService.readById( id));
    }

    @GetMapping("/service/targetpername/{name}")
    @Override
    public ResponseEntity<Target> readByName(@PathVariable String name) {
        return ResponseEntity.ok(targetService.readByName(name));
    }

    @GetMapping("/service/targets")
    @Override
    public ResponseEntity<List<Target>> readAll() {
        return ResponseEntity.ok(targetService.readAll());
    }

    @PostMapping("/service/new/target")
    @Override
    public ResponseEntity<Target> create(@RequestBody Target entity) throws AnyPersistenceException, TargetExistsException {
        targetService.create(entity);
        return ResponseEntity.status(201).body(entity);
    }
}
