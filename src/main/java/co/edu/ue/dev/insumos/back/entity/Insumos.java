package co.edu.ue.dev.insumos.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "insumos")
public class Insumos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ins_name", nullable = false, length = 100)
    private String name;

    @Column(name = "ins_description", length = 255)
    private String description;

    @Column(name = "ins_amount", nullable = false)
    private Integer amount;

    @Column(name = "ins_price", nullable = false)
    private Integer price;

    @Column(name = "ins_status", nullable = false)
    private Integer status = 1;


}
