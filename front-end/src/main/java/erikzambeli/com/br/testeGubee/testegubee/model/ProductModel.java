package erikzambeli.com.br.testeGubee.testegubee.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    private Long id;
    private String Name;
    private String Description;
    private boolean active;
    private double value;
    @SerializedName("targets")
    private List<TargetModel> targets;
    @SerializedName("technologies")
    private List<TechnologyModel> technologies;
}
