package com.reyes.shipping.cargoDomain.domainServices;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoJPARepository extends JpaRepository<Cargo, Long> {
}
