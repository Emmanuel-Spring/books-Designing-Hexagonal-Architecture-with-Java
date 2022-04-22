package com.talentyco.chapter03.domain.specification.shared;

public interface Specification <T> {

    boolean isSatisfiedBy( T t );

    Specification<T> and (Specification<T> specification);


}
