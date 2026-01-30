package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;

import java.util.List;

/**
 * Describes a field injection in a bean definition.
 *
 * @param <K> The bean element kind type
 * @param <F> The field representation type
 * @author Denis Stepanov
 * @since 5.0
 */
public record FieldDefinition<K, F>(F fieldElement,
                                    AnnotationMetadata annotationMetadata,
                                    BeanDefinitionInjectionPoint<K> injectionPoint,
                                    boolean requiresReflection,
                                    boolean isOptional) implements MemberDefinition<K> {

    @Override
    public List<BeanDefinitionInjectionPoint<K>> injectionPoints() {
        return List.of();
    }
}
