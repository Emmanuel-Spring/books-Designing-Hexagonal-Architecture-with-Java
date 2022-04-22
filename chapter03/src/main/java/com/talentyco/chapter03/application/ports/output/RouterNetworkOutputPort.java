package com.talentyco.chapter03.application.ports.output;

import com.talentyco.chapter03.domain.entity.Router;
import com.talentyco.chapter03.domain.vo.RouterId;

public interface RouterNetworkOutputPort {

    Router fetchRouterById(RouterId routerId);

    boolean persistRouter(Router router);

}
