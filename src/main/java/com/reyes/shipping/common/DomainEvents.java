package com.reyes.shipping.common;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component("DomainEventsHandler")
public final class DomainEvents {

    private static Set<Class<? extends Handler>> handlers;

//    public DomainEvents() {
//        if (handlers == null) {
//            Reflections reflections = new Reflections("com.kings", new SubTypesScanner());
//            handlers = reflections.getSubTypesOf(Handler.class);
//        }
//    }

    public void dispatch(DomainEvent domainEvent) {
        handlers.forEach(handle -> {
            Arrays.asList(handle.getDeclaredMethods()).forEach(method -> {
                if(method.getName().equals("handle")) {
                    List<Class<?>> parameters = Arrays.asList((method.getParameterTypes()));
                    if(parameters.contains(domainEvent.getClass())) {
                        Handler handler = null;
                        try {
                            handler = handle.getDeclaredConstructor().newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        handler.handle(domainEvent);
                    }
                }
            });
        });
    }
}
