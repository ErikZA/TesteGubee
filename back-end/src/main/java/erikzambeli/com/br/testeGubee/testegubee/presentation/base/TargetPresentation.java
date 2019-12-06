package erikzambeli.com.br.testeGubee.testegubee.presentation.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TargetExistsException;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class TargetPresentation implements CRUDController<Target>{

    @Autowired
    private TargetService targetService;

    @GetMapping("/service/target/{id}")
    @Override
    public ResponseEntity<Target> readById(@PathVariable Long id) {
        return ResponseEntity.ok(targetService.readById(id));
    }

    @GetMapping("/service/target/{nome}")
    @Override
    public ResponseEntity<Target> readByName(@PathVariable String name) {
        return ResponseEntity.ok(targetService.readByName(name));
    }

    @GetMapping("/service/targets")
    @Override
    public ResponseEntity<List<Target>> readAll() {
        return ResponseEntity.ok(targetService.readAll());
    }

    @PostMapping("/service/target")
    @Override
    public ResponseEntity<Target> create(@RequestBody Target entity) throws AnyPersistenceException, TargetExistsException {
        targetService.create(entity);
        return ResponseEntity.status(201).body(entity);
    }
}
