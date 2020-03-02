package com.reyes.shipping;

import com.reyes.shipping.common.AggregateRoot;
import com.reyes.shipping.common.DomainEvent;
import com.reyes.shipping.common.DomainEventPublisher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoriesAspect {

    @Autowired
    private DomainEventPublisher<DomainEvent> eventPublisher;

    @After("bean(*Repository) && !bean(*JPARepository)")
    public void dispatch(JoinPoint joinPoint) {
//        System.out.println("aspect executed");
        if(joinPoint.getArgs()[0] instanceof AggregateRoot)
            publishEvents(((AggregateRoot)joinPoint.getArgs()[0]));
    }

    private void publishEvents(AggregateRoot aggregateRoot) {
        aggregateRoot.getDomainEvents().forEach(eventPublisher::publish);
        aggregateRoot.clearEvents();
    }

}
