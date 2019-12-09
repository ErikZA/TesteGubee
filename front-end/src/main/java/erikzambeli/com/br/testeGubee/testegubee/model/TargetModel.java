package erikzambeli.com.br.testeGubee.testegubee.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TargetModel {
    private Long id;
    private String Name;
    private String Description;
}
