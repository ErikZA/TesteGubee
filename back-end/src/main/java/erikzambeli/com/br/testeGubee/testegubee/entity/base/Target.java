package erikzambeli.com.br.testeGubee.testegubee.entity.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Target extends Person implements Serializable {

    public Target() {
        super();
    }

    @Builder
    public static Target create(String name, String description) {
        Target target = new Target();
        target.setDescription(description);
        target.setName(name);

        return target;
    }
}
