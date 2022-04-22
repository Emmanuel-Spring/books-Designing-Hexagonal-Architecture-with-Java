package com.talentyco.chapter03.domain.service;


import com.talentyco.chapter03.domain.entity.Router;
import com.talentyco.chapter03.domain.specification.CIDRSpecification;
import com.talentyco.chapter03.domain.specification.NetworkAmountSpecification;
import com.talentyco.chapter03.domain.specification.NetworkAvailivilitySpecification;
import com.talentyco.chapter03.domain.specification.RouterTypeSpecification;
import com.talentyco.chapter03.domain.vo.Network;

public class NetworkOperation {

    public static Router createNetwork(Router router, Network network) {
        var availibilitySpec = new NetworkAvailivilitySpecification(network.getAddress(), network.getName(), network.getCidr());
        var cidrSpec = new CIDRSpecification();
        var routerTypeEspec = new RouterTypeSpecification();
        var amountSpec = new NetworkAmountSpecification();

        if (cidrSpec.isSatisfiedBy(network.getCidr()))
            throw new IllegalArgumentException("CIDR is below" + CIDRSpecification.MINIMUM_ALLOWED_CIDR);

        if (!availibilitySpec.isSatisfiedBy(router))
            throw new IllegalArgumentException("Address already exist");

        if (amountSpec.and(routerTypeEspec).isSatisfiedBy(router)) {
            Network newNetwork = router.createNetwork(network.getAddress(), network.getName(), network.getCidr());
            router.addNetworkToSwitch(newNetwork);
        }
        return router;
    }
}
