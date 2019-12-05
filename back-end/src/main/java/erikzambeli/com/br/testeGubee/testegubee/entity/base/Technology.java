package erikzambeli.com.br.testeGubee.testegubee.entity.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Technology extends Person implements Serializable {

    private String developer;
    private String version;

    @Builder
    public static Technology create (String name, String developer, String version, String description){
            Technology technology = new Technology();
            technology.setDeveloper(developer);
            technology.setName(name);
            technology.setVersion(version);
            technology.setDescription(description);

            return technology;
    }
}
