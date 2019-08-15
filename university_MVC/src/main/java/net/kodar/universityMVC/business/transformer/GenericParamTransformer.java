package net.kodar.universityMVC.business.transformer;

import java.util.function.BiFunction;

public interface GenericParamTransformer<P, E, N> extends BiFunction<P, E, N> {

}
