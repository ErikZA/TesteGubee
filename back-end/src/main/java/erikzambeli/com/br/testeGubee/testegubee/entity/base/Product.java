package erikzambeli.com.br.testeGubee.testegubee.entity.base;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Product extends Person implements Serializable {

    private boolean active;
    private double value;

    @SerializedName("targets")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Target> targets;

    @SerializedName("technologies")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Technology> technologies;

    @Builder
    public static Product creat (boolean active, double value, Set<Target> targets, Set<Technology> technologies, String name, String description) {
        Product product =new Product();
        product.setName(name);
        product.setDescription(description);
        product.setActive(active);
        product.setValue(value);
        product.setTargets(targets);
        product.setTechnologies(technologies);

        return product;
    }
}
