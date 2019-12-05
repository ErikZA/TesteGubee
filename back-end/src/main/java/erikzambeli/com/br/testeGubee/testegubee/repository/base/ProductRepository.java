package erikzambeli.com.br.testeGubee.testegubee.repository.base;


import erikzambeli.com.br.testeGubee.testegubee.entity.base.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
