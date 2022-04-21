package com.talentyco.chapter01.application.ports.output;

import com.talentyco.chapter01.domain.Router;

import java.util.List;

public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
