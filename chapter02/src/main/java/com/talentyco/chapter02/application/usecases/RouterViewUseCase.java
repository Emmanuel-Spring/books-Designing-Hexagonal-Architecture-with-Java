package com.talentyco.chapter02.application.usecases;

import com.talentyco.chapter02.domain.entity.Router;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {

    List<Router> getRouters(Predicate<Router> filter);
}
