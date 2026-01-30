package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;

import java.util.List;

/**
 * Describes a constructor used in a bean definition.
 *
 * @param <K> The bean element kind type
 * @param <C> The constructor representation type
 * @author Denis Stepanov
 * @since 5.0
 */
public record ConstructorDefinition<K, C>(C constructorElement,
                                          AnnotationMetadata annotationMetadata,
                                          List<BeanDefinitionInjectionPoint<K>> injectionPoints,
                                          boolean requiresReflection) implements MemberDefinition<K> {
}
