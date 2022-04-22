package com.talentyco.chapter03.application.usecases;

import com.talentyco.chapter03.domain.entity.Router;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {

    List<Router> getRouters(Predicate<Router> filter);
}
