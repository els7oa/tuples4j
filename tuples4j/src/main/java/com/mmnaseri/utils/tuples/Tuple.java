package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.*;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public interface Tuple<Z> {

    int size();

    Z get(int i);

    Tuple<Z> change(int index, Z value);

    Tuple<Z> clear();

    Tuple<Z> drop(int index);

    default Fluents.FluentList<Z> asList() {
        return IntStream.range(0, size()).boxed()
                        .map(this::get)
                        .collect(toCollection(Fluents.FluentList::new));
    }

    <X extends Z> Tuple<Z> extend(X value);

    default LabeledTuple<Z> withLabels(String... labels) {
        return withLabels(Arrays.asList(labels));
    }

    default LabeledTuple<Z> withLabels(List<String> labels) {
        return new DefaultLabeledTuple<>(this, labels);
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(String... labels) {
        return labelWith(Arrays.asList(labels));
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(List<String> labels) {
        return zTuple -> zTuple.withLabels(labels);
    }

    static <Z> EmptyTuple<Z> empty() {
        return new EmptyTuple<>();
    }

    static <A> OneTuple<Object, A> one(A first) {
        return new OneTuple<>(first);
    }

    static <A, B> TwoTuple<Object, A, B> two(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    static <A, B, C> ThreeTuple<Object, A, B, C> three(A first,
            B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    static <A, B, C, D>
    FourTuple<Object, A, B, C, D> four(A first, B second, C third, D fourth) {
        return new FourTuple<>(first, second, third, fourth);
    }

    static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> five(
            A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

    static <A, B, C, D, E,
                   F> SixTuple<Object, A, B, C, D, E, F> six(
            A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

    static <A, B, C, D, E,
                   F, G> SevenTuple<Object, A, B, C, D, E, F, G> seven(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    static <A, B, C, D, E,
                   F, G,
                   H> EightTuple<Object, A, B, C, D, E, F, G, H> eight(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> nine(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> ten(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                              tenth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J, K>
    ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> eleven(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                                 tenth, eleventh);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J, K, L> TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> twelve(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh,
            L twelfth) {
        return new TwelveTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                                 tenth, eleventh,
                                 twelfth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> large(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh,
            L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh,
                                         eighth, ninth, tenth,
                                         eleventh, twelfth, thirteenth, rest);
    }


    static <Z> EmptyTuple<Z> of() {
        return empty();
    }

    static <A> OneTuple<Object, A> of(A first) {
        return new OneTuple<>(first);
    }

    static <A, B> TwoTuple<Object, A, B> of(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    static <A, B, C> ThreeTuple<Object, A, B, C> of(A first,
            B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    static <A, B, C, D>
    FourTuple<Object, A, B, C, D> of(A first, B second, C third, D fourth) {
        return new FourTuple<>(first, second, third, fourth);
    }

    static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> of(
            A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

    static <A, B, C, D, E,
                   F> SixTuple<Object, A, B, C, D, E, F> of(
            A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

    static <A, B, C, D, E,
                   F, G> SevenTuple<Object, A, B, C, D, E, F, G> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    static <A, B, C, D, E,
                   F, G,
                   H> EightTuple<Object, A, B, C, D, E, F, G, H> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                              tenth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J, K>
    ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                                 tenth, eleventh);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J, K, L> TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh,
            L twelfth) {
        return new TwelveTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                                 tenth, eleventh,
                                 twelfth);
    }

    static <A, B, C, D, E,
                   F, G,
                   H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh,
            L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh,
                                         eighth, ninth, tenth,
                                         eleventh, twelfth, thirteenth, rest);
    }

}