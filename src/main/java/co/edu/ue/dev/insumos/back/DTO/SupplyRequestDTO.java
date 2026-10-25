package co.edu.ue.dev.insumos.back.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SupplyRequestDTO {
    private String name;
    private String description;
    private Integer amount;
    private Integer price;
}