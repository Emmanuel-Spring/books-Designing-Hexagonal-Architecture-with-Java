package com.talentyco.chapter02.application.ports.output;

import com.talentyco.chapter02.domain.entity.Router;

import java.util.List;

public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
