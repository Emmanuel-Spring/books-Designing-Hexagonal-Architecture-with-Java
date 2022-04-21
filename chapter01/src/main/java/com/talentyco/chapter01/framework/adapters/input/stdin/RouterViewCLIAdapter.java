package com.talentyco.chapter01.framework.adapters.input.stdin;


import com.talentyco.chapter01.application.ports.input.RouterViewInputPort;
import com.talentyco.chapter01.application.usecases.RouterViewUseCase;
import com.talentyco.chapter01.domain.Router;
import com.talentyco.chapter01.domain.RouterType;
import com.talentyco.chapter01.framework.adapters.output.file.RouterViewFileAdapter;

import java.util.List;

public class RouterViewCLIAdapter {

    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter() {
        setAdapters();
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRouters(
                Router.filterRouterByType(RouterType.valueOf(type)));
    }

    private void setAdapters() {
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }


}
