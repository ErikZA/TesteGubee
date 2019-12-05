package erikzambeli.com.br.testeGubee.testegubee.servie.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TargetExistsException;
import erikzambeli.com.br.testeGubee.testegubee.repository.base.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TargetService implements CRUDService<Target>{
    private final TargetRepository targetRepository;

    @Override
    public Target readById(Long id) {
        return targetRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Target readByName(String name) {
        return targetRepository.findByName(name);
    }

        @Override
    public List<Target> readAll() {
        return targetRepository.findAll();
    }

    @Override
    public void create(Target entity) throws AnyPersistenceException, TargetExistsException {
        if(targetRepository.findAll().stream().anyMatch(currentTarget ->
                currentTarget.getName().equalsIgnoreCase(entity.getName()))){
            throw  new TargetExistsException();
        }
        try {
            targetRepository.save(entity);

        } catch (Exception e) {
            throw new AnyPersistenceException();
        }
    }
}
