package com.talentyco.chapter02.domain.specification;

import com.talentyco.chapter02.domain.entity.Router;
import com.talentyco.chapter02.domain.specification.shared.AbstractSpecification;
import com.talentyco.chapter02.domain.vo.IP;
import com.talentyco.chapter02.domain.vo.Network;

public class NetworkAvailivilitySpecification extends AbstractSpecification<Router> {

    private IP address;
    private String name;
    private int cidr;

    public NetworkAvailivilitySpecification(IP address, String name, int cidr) {
        this.address = address;
        this.name = name;
        this.cidr = cidr;
    }

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router != null && isNetworkAvailable(router);
    }

    private boolean isNetworkAvailable(Router router) {
        var availability = true;
        for (Network network : router.retrieveNetworks()) {
            if (network.getAddress().equals(address) && network.getName().equals(name) && network.getCidr() == cidr )
                availability = false;
                break;
            }
            return availability;
    }
}
