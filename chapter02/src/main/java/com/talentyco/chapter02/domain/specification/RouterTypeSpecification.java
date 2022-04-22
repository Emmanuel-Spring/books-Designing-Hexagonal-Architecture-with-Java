package com.talentyco.chapter02.domain.specification;

import com.talentyco.chapter02.domain.entity.Router;
import com.talentyco.chapter02.domain.specification.shared.AbstractSpecification;
import com.talentyco.chapter02.domain.vo.RouterType;

public class RouterTypeSpecification extends AbstractSpecification<Router> {

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.getRouterType().equals(RouterType.EDGE) || router.getRouterType().equals(RouterType.CORE);
    }
}
