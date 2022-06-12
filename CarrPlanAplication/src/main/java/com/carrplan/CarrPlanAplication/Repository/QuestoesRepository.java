package com.carrplan.CarrPlanAplication.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.carrplan.CarrPlanAplication.models.QuestoesModel;

public interface QuestoesRepository extends JpaRepository<QuestoesModel, UUID>{
    
    

}
