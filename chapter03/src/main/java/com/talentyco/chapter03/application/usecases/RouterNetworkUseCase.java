package com.talentyco.chapter03.application.usecases;

import com.talentyco.chapter03.domain.entity.Router;
import com.talentyco.chapter03.domain.vo.Network;
import com.talentyco.chapter03.domain.vo.RouterId;

import java.util.List;
import java.util.function.Predicate;

public interface RouterNetworkUseCase {

    List<Router> getRouters(Predicate<Router> filter);

}
