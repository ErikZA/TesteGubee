package erikzambeli.com.br.testeGubee.testegubee.servie.base;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import erikzambeli.com.br.testeGubee.testegubee.dto.GubeeDTO;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Product;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Target;
import erikzambeli.com.br.testeGubee.testegubee.entity.base.Technology;
import erikzambeli.com.br.testeGubee.testegubee.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class BuildBaseService {

    private final ProductService productService;
    private final TechnologyService technologyService;
    private final TargetService targetService;
    private final JsonParsingService jsonParsingService;

    public void buildBaseJson() throws URLJsonNotFound {
        try {
            JsonArray objects = jsonParsingService.
                    parse("https://jsonstorage.net/api/items/998ce6f5-c6f8-47a2-b40a-e773fe5dc8ee");
            this.arraySplitjson(objects);
        } catch (Exception e){
            throw new URLJsonNotFound();
        }
    }

    private void arraySplitjson(JsonArray objects) {
        Gson gson = new Gson();
        Set<GubeeDTO> gubeeDTOS = new HashSet<>();
        for (int i=0; i<objects.size(); i++){
            gubeeDTOS.add(gson.fromJson(objects.get(i),GubeeDTO.class));
        }
        List<List<String>> targetDTO = gubeeDTOS.stream().map(GubeeDTO::getTargetMarket)
                .distinct().collect(Collectors.toList());
        this.buildTarget(targetDTO);
        List<List<String>> technologiesDTO = gubeeDTOS.stream()
                .map(GubeeDTO::getStack).distinct().collect(Collectors.toList());
        this.buildTechnologies(technologiesDTO);
        this.buildProducts(gubeeDTOS);
    }

    private void buildTarget(List<List<String>> targets) {
        for (List<String> inLista  : targets) {
            for (String aux : inLista) {
                try {
                    targetService.create(Target.builder().name(aux).build());
                } catch (AnyPersistenceException e) {
                    e.getMessage();
                } catch (TargetExistsException e) {
                    e.getMessage();
                }
            }
        }
    }

    private void buildTechnologies(List<List<String>> technologies){
        for (List<String> inLista  : technologies) {
            for (String aux : inLista) {
                try {
                    technologyService.create(Technology.builder().name(aux).build());
                } catch (AnyPersistenceException e) {
                    e.getMessage();
                } catch (TechnologyExistsException e) {
                    e.getMessage();
                }
            }
        }
    }

    private void buildProducts(Set<GubeeDTO> products){
        for (GubeeDTO aux : products) {
            Set<Target> targets = new HashSet<>();
            Set<Technology> technologies = new HashSet<>();

            for (String target : aux.getTargetMarket())
                targets.add(targetService.readByName(target));

            for (String techno : aux.getStack())
                technologies.add(technologyService.readByName(techno));

            try {
                productService.create(Product.builder().name(aux.getProductName()).description(aux.getDescription()).
                        technologies(technologies).targets(targets).build());
            } catch (AnyPersistenceException e) {
                e.getMessage();
            } catch (ProductExistsException e) {
                e.getMessage();
            }
        }
    }

    @Override
    public String toString(){
        return "{'msg':'build base sucessful'}";
    }
}
