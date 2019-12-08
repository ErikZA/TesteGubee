package erikzambeli.com.br.testeGubee.testegubee.repository.base;


import erikzambeli.com.br.testeGubee.testegubee.entity.base.Product;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    List<Product> findAllByTargets(Target target);

    List<Product> findAllByTechnologies(Technology technology);
}
