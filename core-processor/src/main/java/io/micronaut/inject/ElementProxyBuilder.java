package io.micronaut.inject;

import io.micronaut.context.bean.definition.builder.ProxyBuilder;
import io.micronaut.inject.ast.ClassElement;
import io.micronaut.inject.ast.MethodElement;
import io.micronaut.inject.writer.OriginatingElements;

import java.util.List;

/**
 * Proxy builder that operates on {@link ClassElement} definitions.
 *
 * @param <R> The builder result type
 * @author Denis Stepanov
 * @since 5.0
 */
public interface ElementProxyBuilder<R> extends ProxyBuilder<ClassElement, MethodElement, List<R>>, OriginatingElements {

    /**
     * @return The underlying bean definition builder used to materialize the proxy
     */
    ElementBeanDefinitionBuilder<R> beanDefinitionBuilder();

}
