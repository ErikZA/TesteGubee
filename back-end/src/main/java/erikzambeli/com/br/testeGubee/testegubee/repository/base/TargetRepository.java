package erikzambeli.com.br.testeGubee.testegubee.repository.base;


import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<Target, Long> {
    Target findByName(String name);
}
