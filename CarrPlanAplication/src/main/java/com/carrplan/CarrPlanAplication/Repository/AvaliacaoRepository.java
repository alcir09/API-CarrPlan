package com.carrplan.CarrPlanAplication.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carrplan.CarrPlanAplication.models.AvaliacaoModel;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, UUID>{
    
}
