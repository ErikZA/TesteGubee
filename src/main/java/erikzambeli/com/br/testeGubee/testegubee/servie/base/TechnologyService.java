package erikzambeli.com.br.testeGubee.testegubee.servie.base;

import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import erikzambeli.com.br.testeGubee.testegubee.exception.AnyPersistenceException;
import erikzambeli.com.br.testeGubee.testegubee.exception.TechnologyExistsException;
import erikzambeli.com.br.testeGubee.testegubee.repository.base.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TechnologyService implements CRUDService<Technology>{

    private final TechnologyRepository technologyRepository;

    @Override
    public Technology readById(Long id) {
        return technologyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Technology readByName(String name) {
        return technologyRepository.findByName(name);
    }

    @Override
    public List<Technology> readAll() {
            return technologyRepository.findAll();
    }

    @Override
    public void create(Technology entity) throws AnyPersistenceException, TechnologyExistsException {
            if(technologyRepository.findAll().stream().anyMatch(currentTechnology ->
                    currentTechnology.getName().equalsIgnoreCase(entity.getName()))){
                throw  new TechnologyExistsException();
            }
            try {
                technologyRepository.save(entity);

            } catch (Exception e) {
                throw new AnyPersistenceException();
            }
    }
}
