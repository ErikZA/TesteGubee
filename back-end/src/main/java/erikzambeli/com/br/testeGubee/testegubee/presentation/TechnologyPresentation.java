package erikzambeli.com.br.testeGubee.testegubee.presentation;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TechnologyExistsException;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TechnologyPresentation implements CRUDController<Technology> {

    private TechnologyService technologyService;

    @GetMapping("/service/technology/{id}")
    @Override
    public ResponseEntity<Technology> readById(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.readById(id));
    }

    @GetMapping("/service/technology/{nome}")
    @Override
    public ResponseEntity<Technology> readByName(@PathVariable String name) {
        return ResponseEntity.ok(technologyService.readByName(name));
    }

    @GetMapping("/service/technologies")
    @Override
    public ResponseEntity<List<Technology>> readAll() {
        return ResponseEntity.ok(technologyService.readAll());
    }

    @PostMapping("/service/technology")
    @Override
    public ResponseEntity<Technology> create(@RequestBody Technology entity) throws AnyPersistenceException, TechnologyExistsException{
        technologyService.create(entity);
        return ResponseEntity.status(201).body(entity);
    }
}
