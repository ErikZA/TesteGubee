package erikzambeli.com.br.testeGubee.testegubee.presentation.base;

import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.ProductExistsException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TargetExistsException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TechnologyExistsException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDController<T> {

    public ResponseEntity<T> readById(Long id);
    public ResponseEntity<T> readByName(String name);
    public ResponseEntity<List<T>> readAll();
    public ResponseEntity<T> create(T entity) throws AnyPersistenceException, TechnologyExistsException, TargetExistsException, ProductExistsException;
}
