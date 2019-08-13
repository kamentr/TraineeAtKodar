package net.kodar.universityMVC.business.mapper;

import java.util.function.BiFunction;

public interface GenericBindingTransformer<P, E, N> extends BiFunction<P, E, N> {

}
