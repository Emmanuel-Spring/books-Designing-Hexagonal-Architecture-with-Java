package com.talentyco.chapter03.application.ports.input;

import com.talentyco.chapter03.application.ports.output.RouterNetworkOutputPort;
import com.talentyco.chapter03.application.usecases.RouterNetworkUseCase;
import com.talentyco.chapter03.domain.entity.Router;
import com.talentyco.chapter03.domain.service.NetworkOperation;
import com.talentyco.chapter03.domain.vo.Network;
import com.talentyco.chapter03.domain.vo.RouterId;

import java.util.List;
import java.util.function.Predicate;

import static com.talentyco.chapter03.domain.service.NetworkOperation.createNetwork;

public class RouterNetworkInputPort implements RouterNetworkUseCase {

    private final RouterNetworkOutputPort routerNetworkOutputPort;

    public RouterNetworkInputPort(RouterNetworkOutputPort routerNetworkOutputPort) {
        this.routerNetworkOutputPort = routerNetworkOutputPort;
    }

    @Override
    public Router addNetworkToRouter(RouterId routerId, Network network) {
        var router = fetchRouter(routerId);
        return createNetwork(router, network);
    }

    private Router fetchRouter(RouterId routerId) {
        return routerNetworkOutputPort.fetchRouterById(routerId);
    }

    private Router createNetwork(Router router, Network network) {
        var newRouter = NetworkOperation.createNetwork(router,network);
        return persistNetwork(router) ? newRouter : router;
    }

    private boolean persistNetwork(Router router) {
        return routerNetworkOutputPort.persistRouter(router);
    }
}
