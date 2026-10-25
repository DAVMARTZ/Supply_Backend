
package co.edu.ue.dev.insumos.back.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplyResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer amount;
    private Integer price;
    private Integer status;
}
