package com.reyes.shipping;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoriesAspect {

    @After("bean(*Repository) && !bean(*JPARepository)")
    public void dispatch() {
        System.out.println("aspect executed");
    }

}
