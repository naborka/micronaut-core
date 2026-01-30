package io.micronaut.context.bean.definition.builder;

/**
 * Generic builder contract.
 *
 * @param <R> The builder result
 * @author Denis Stepanov
 * @since 5.0
 */
public interface Builder<R> {

    /**
     * @return The builder result
     */
    R build();

}
