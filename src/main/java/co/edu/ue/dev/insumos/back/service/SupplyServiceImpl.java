package co.edu.ue.dev.insumos.back.service;

import co.edu.ue.dev.insumos.back.entity.Insumos;
import co.edu.ue.dev.insumos.back.repository.SupplyJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyServiceImpl implements SupplyService {

    private final SupplyJPA supplyJPA;

    public SupplyServiceImpl(SupplyJPA isupplyJPA){
        this.supplyJPA = isupplyJPA;
    }

    @Override
    public Insumos addSupply(Insumos insumos) {
        return supplyJPA.save(insumos);
    }

    @Override
    public Insumos updateSupply(Insumos insumos) {
        if (findById(insumos.getId()).isPresent()){
            return supplyJPA.save(insumos);
        }else{
            return null;
        }
    }

    @Override
    public List<Insumos> listAll() {
        return supplyJPA.findAll();
    }

    @Override
    public Insumos inactiveSupply(Integer id) {
        Optional<Insumos> resultant = findById(id);

        if (resultant.isPresent()) {
            Insumos insumos = resultant.get();
            insumos.setStatus(0);
            return supplyJPA.save(insumos);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Insumos> findById(Integer id) {
        return supplyJPA.findById(id);
    }
}
