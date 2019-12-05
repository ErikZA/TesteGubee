package erikzambeli.com.br.testeGubee.testegubee.presentation;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Product;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.ProductExistsException;
import erikzambeli.com.br.testeGubee.testegubee.exception.URLJsonNotFound;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.BuildBase;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductPresentation implements CRUDController<Product> {

    private ProductService productService;
    private BuildBase buildBase;

    @GetMapping("/service/product/{id}")
    @Override
    public ResponseEntity<Product> readById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.readById(id));
    }

    @GetMapping("/service/product/{nome}")
    @Override
    public ResponseEntity<Product> readByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.readByName(name));
    }

    @GetMapping("/service/products")
    @Override
    public ResponseEntity<List<Product>> readAll() {
        return ResponseEntity.ok(productService.readAll());
    }

    @PostMapping("/service/product")
    @Override
    public ResponseEntity<Product> create(@RequestBody Product entity) throws AnyPersistenceException, ProductExistsException {
        productService.create(entity);
        return ResponseEntity.status(201).body(entity);
    }

    @GetMapping("/service")
    public ResponseEntity.BodyBuilder readAllJson() throws URLJsonNotFound {
        buildBase.buildBaseJson();
        return ResponseEntity.status(201);
    }
}
