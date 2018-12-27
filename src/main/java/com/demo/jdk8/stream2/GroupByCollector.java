package com.demo.jdk8.stream2;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/24
 */
public class GroupByCollector {
    public static <T,A,K,D,M extends Map<K,D>> Collector<T,?,M> groupBy(
            Function<? super T,? extends K> classifier,
            Supplier<M> mapFactory,
            Collector<? super T,A,D> downStream){
        Supplier<A> downStreamSupplier = downStream.supplier();
        BiConsumer<A, ? super T> downStreamAccumulator = downStream.accumulator();
        BiConsumer<Map<K,A>,T> accumulator= (m, t) -> {
            K key = Objects.requireNonNull(classifier.apply(t), "must be not null");
            A container= m.computeIfAbsent(key,k->downStreamSupplier.get());
            downStreamAccumulator.accept(container,t);
        };
        BinaryOperator<Map<K, A>> merger = mapMerger(downStream.combiner());
        Supplier<Map<K,A>> mangledFactory= (Supplier<Map<K, A>>) mapFactory;
        if(downStream.characteristics().contains(IDENTITY_FINISH)){
            return new CollectorImpl(mangledFactory,accumulator,merger,IDENTITY_FINISH);
        }else {
            final Function<A, A> finisher = (Function<A, A>) downStream.finisher();
        }
        return null;
    }

    private static <K,V> BinaryOperator<Map<K,V>> mapMerger(BinaryOperator<V> combiner) {

        return (m1,m2)->{
            for(Map.Entry<K,V> entry:m2.entrySet()){
                m1.merge(entry.getKey(),entry.getValue(),combiner);
            }
            return m1;
        };
    }

    private static class CollectorImpl<T,A,M> implements Collector<T, A, M> {
        public <A, K> CollectorImpl(Supplier<Map<K, A>> mangledFactory, BiConsumer<Map<K, A>, T> accumulator, BinaryOperator<Map<K, A>> merger, Characteristics identityFinish) {

        }

        @Override
        public Supplier<A> supplier() {
            return null;
        }

        @Override
        public BiConsumer<A, T> accumulator() {
            return null;
        }

        @Override
        public BinaryOperator<A> combiner() {
            return null;
        }

        @Override
        public Function<A, M> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return null;
        }
    }
}
