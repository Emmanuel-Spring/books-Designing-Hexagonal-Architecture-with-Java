package com.talentyco.chapter03.application.ports.output;

import com.talentyco.chapter03.domain.entity.Router;

import java.util.List;

public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
