package com.reyes.shipping.scheduleDomain.domainServices;

import com.reyes.shipping.scheduleDomain.aggregates.DeliveryProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryJPARepository extends JpaRepository<DeliveryProgram, Long> {
}
