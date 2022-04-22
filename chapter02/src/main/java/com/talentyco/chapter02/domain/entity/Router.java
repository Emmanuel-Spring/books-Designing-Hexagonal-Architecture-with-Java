package com.talentyco.chapter02.domain.entity;

import com.talentyco.chapter02.domain.RouterId;
import com.talentyco.chapter02.domain.RouterType;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Router {
    private final RouterType routerType;
    private final RouterId routerId;


    public Router(RouterType routerType, RouterId routerId) {
        this.routerType = routerType;
        this.routerId = routerId;
    }

    public static Predicate<Router> filterRouterByType(RouterType routerType) {
        return  routerType.equals(RouterType.CORE) ? isCore() : isEdge();
    }

    public static Predicate<Router> isCore() {
        return  p -> p.getRouterType() == RouterType.CORE;
    }

    public static Predicate<Router> isEdge() {
        return p -> p.getRouterType() == RouterType.EDGE;
    }


    public static List<Router> retrieveRouter(List<Router> routers, Predicate<Router> predicates) {
        return routers.stream()
                .filter(predicates)
                .collect(Collectors.<Router>toList());
    }

    public RouterType getRouterType() {
        return routerType;
    }

    @Override
    public String toString() {
        return "Router{" +
                "routerType=" + routerType +
                ", routerId=" + routerId +
                '}';
    }
}
