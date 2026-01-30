package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * Describes a method-related contribution to a bean definition.
 *
 * @param <K> The bean element kind type
 * @param <M> The method representation type
 * @author Denis Stepanov
 * @since 5.0
 */
public record MethodDefinition<K, M>(M methodElement,
                                     AnnotationMetadata annotationMetadata,
                                     List<BeanDefinitionInjectionPoint<K>> injectionPoints,
                                     boolean requiresReflection,
                                     boolean isOptional,
                                     boolean isSetter,
                                     BeanDefinitionInjectionPoint.@Nullable PropertyInjectionPoint<K> booleanInjectionPoint) implements MemberDefinition<K> {

    /**
     * Creates a method definition.
     *
     * @param methodElement      The method element
     * @param annotationMetadata The annotation metadata
     * @param injectionPoints    The injection points
     * @param requiresReflection Whether reflective invocation is required
     */
    public MethodDefinition(M methodElement, AnnotationMetadata annotationMetadata, List<BeanDefinitionInjectionPoint<K>> injectionPoints, boolean requiresReflection) {
        this(methodElement, annotationMetadata, injectionPoints, requiresReflection, false, false, null);
    }

    /**
     * Creates a method definition marking the method as a setter if required.
     *
     * @param methodElement      The method element
     * @param annotationMetadata The annotation metadata
     * @param injectionPoints    The injection points
     * @param requiresReflection Whether reflective invocation is required
     * @param isSetter           Whether the method acts as a setter
     */
    public MethodDefinition(M methodElement, AnnotationMetadata annotationMetadata, List<BeanDefinitionInjectionPoint<K>> injectionPoints, boolean requiresReflection, boolean isSetter) {
        this(methodElement, annotationMetadata, injectionPoints, requiresReflection, false, isSetter, null);
    }
}
