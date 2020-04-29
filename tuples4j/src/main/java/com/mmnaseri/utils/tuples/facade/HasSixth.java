package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasSixth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A sixth() {
        return (A) get(5);
    }

    default T sixth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropSixth();


    default boolean checkSixth(Predicate<A> predicate) {
        return predicate.test(sixth());
    }

}
