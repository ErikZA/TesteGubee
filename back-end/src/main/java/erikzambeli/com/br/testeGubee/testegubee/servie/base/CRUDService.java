package erikzambeli.com.br.testeGubee.testegubee.servie.base;

import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.ProductExistsException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TargetExistsException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TechnologyExistsException;

import java.util.List;

public interface CRUDService <T>{

    public T readById(Long id);
    public T readByName(String name);
    public List<T> readAll();
    public void create(T entity) throws AnyPersistenceException, TechnologyExistsException, TargetExistsException, ProductExistsException;
}
