package co.edu.ue.dev.insumos.back.service;

import co.edu.ue.dev.insumos.back.entity.Insumos;

import java.util.List;
import java.util.Optional;

public interface SupplyService {
    Insumos addSupply(Insumos insumos);
    Insumos updateSupply(Insumos insumos);
    List<Insumos> listAll();
    Insumos inactiveSupply(Integer id);
    Optional<Insumos> findById (Integer id);
}
