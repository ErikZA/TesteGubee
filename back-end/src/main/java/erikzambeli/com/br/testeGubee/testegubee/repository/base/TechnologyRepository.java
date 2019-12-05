package erikzambeli.com.br.testeGubee.testegubee.repository.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    Technology findByName(String name);
}
