package com.talentyco.chapter02.application.ports.input;

import com.talentyco.chapter02.application.ports.output.RouterViewOutputPort;
import com.talentyco.chapter02.application.usecases.RouterViewUseCase;
import com.talentyco.chapter02.domain.entity.Router;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewInputPort implements RouterViewUseCase {

    private RouterViewOutputPort routerViewOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort) {
        this.routerViewOutputPort = routerViewOutputPort;
    }


    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerViewOutputPort.fetchRouters();
        return Router.retrieveRouter(routers, filter);
    }
}
