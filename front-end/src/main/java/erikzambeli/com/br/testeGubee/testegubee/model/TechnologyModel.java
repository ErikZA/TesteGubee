package erikzambeli.com.br.testeGubee.testegubee.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnologyModel {
    private Long id;
    private String Name;
    private String Description;
    private String developer;
    private String version;
}
