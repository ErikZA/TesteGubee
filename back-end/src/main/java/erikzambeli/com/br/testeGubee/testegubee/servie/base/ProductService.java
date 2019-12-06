package erikzambeli.com.br.testeGubee.testegubee.servie.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Product;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.ProductExistsException;
import erikzambeli.com.br.testeGubee.testegubee.repository.base.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProductService implements CRUDService<Product> {

    private final ProductRepository productRepository;
    private final TechnologyService technologyService;
    private final TargetService targetService;

    @Override
    public Product readById(Long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Product readByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product entity) throws ProductExistsException, AnyPersistenceException {
        if (productRepository.findAll().stream().anyMatch(currentProduct ->
                currentProduct.getName().equalsIgnoreCase(entity.getName()))){
            throw new ProductExistsException();
        }

        var someTargets = this.searchTargets(entity.getTargets());
        var someTechnologies = this.searchTechnologies(entity.getTechnologies());

        try{
            entity.setTechnologies(someTechnologies);
            entity.setTargets(someTargets);
            productRepository.save(entity);
        } catch (Exception e){
            throw new AnyPersistenceException();
        }
    }

    private Set<Target> searchTargets(Set<Target> targets){
        var result = new HashSet<Target>();

        for (Target currentTarget : targets) {
            result.add(targetService.readById(currentTarget.getId()));
        }
        return  result;
    }

    private Set<Technology> searchTechnologies(Set<Technology> technologies){
        var result = new HashSet<Technology>();

        for (Technology currentTechnology : technologies) {
            result.add(technologyService.readById(currentTechnology.getId()));
        }
        return  result;
    }
}
