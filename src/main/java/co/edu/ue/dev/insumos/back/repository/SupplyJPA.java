package co.edu.ue.dev.insumos.back.repository;

import co.edu.ue.dev.insumos.back.entity.Insumos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyJPA extends JpaRepository<Insumos, Integer> {
}
