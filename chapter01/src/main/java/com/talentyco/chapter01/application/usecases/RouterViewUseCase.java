package com.talentyco.chapter01.application.usecases;

import com.talentyco.chapter01.domain.Router;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {

    List<Router> getRouters(Predicate<Router> filter);
}
