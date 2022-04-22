package com.talentyco.chapter03.domain.entity;

import com.talentyco.chapter03.domain.vo.IP;
import com.talentyco.chapter03.domain.vo.Network;
import com.talentyco.chapter03.domain.vo.RouterId;
import com.talentyco.chapter03.domain.vo.RouterType;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Router {
    private final RouterType routerType;
    private final RouterId routerId;
    private Switch networkSwith;


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


    public RouterType getRouterType() {
        return routerType;
    }

    public void addNetworkToSwitch(Network network) {
        this.networkSwith = networkSwith.addNetwork(network);
    }

    public Network createNetwork(IP address, String name, int cidr) {
        return new Network(address, name, cidr);
    }

    public List<Network> retrieveNetworks() {
        return networkSwith.getNetwork();
    }

    public static List<Router> retrieveRouter(List<Router> routers, Predicate<Router> predicates) {
        return routers.stream()
                .filter(predicates)
                .collect(Collectors.<Router>toList());
    }

    @Override
    public String toString() {
        return "Router{" +
                "routerType=" + routerType +
                ", routerId=" + routerId +
                '}';
    }
}
