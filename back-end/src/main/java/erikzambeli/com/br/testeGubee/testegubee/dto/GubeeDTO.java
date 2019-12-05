package erikzambeli.com.br.testeGubee.testegubee.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GubeeDTO {
    private String productName;
    private String description;
    private List<String> targetMarket;
    private List<String> stack;
}
