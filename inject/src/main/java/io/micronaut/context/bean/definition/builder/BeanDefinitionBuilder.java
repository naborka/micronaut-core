package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;

import java.util.List;

/**
 * Builder abstraction for collecting bean definition metadata.
 *
 * @param <C> The class type
 * @param <M> The method element type
 * @param <F> The field type
 * @param <R> The builder result
 * @author Denis Stepanov
 * @since 5.0
 */
public interface BeanDefinitionBuilder<C, M, F, R> extends Builder<R> {

    /**
     * Adds an executable method to the bean definition.
     *
     * @param methodElement      The method element
     * @param requiresReflection Whether reflective invocation is required
     */
    void addExecutableMethod(M methodElement, boolean requiresReflection);

    /**
     * Adds a method injection point to the bean definition.
     *
     * @param methodDefinition The method definition
     */
    void addMethodInjection(MethodDefinition<C, M> methodDefinition);

    /**
     * Adds a field injection point to the bean definition.
     *
     * @param fieldDefinition The field definition
     */
    void addFieldInjection(FieldDefinition<C, F> fieldDefinition);

    /**
     * Registers a {@code @PostConstruct} method.
     *
     * @param methodDefinition The lifecycle method definition
     */
    void addPostConstruct(MethodDefinition<C, M> methodDefinition);

    /**
     * Registers a {@code @PreDestroy} method.
     *
     * @param methodDefinition The lifecycle method definition
     */
    void addPreDestroy(MethodDefinition<C, M> methodDefinition);

    /**
     * Adds a field-based configuration builder.
     *
     * @param fieldElement        The configuration field
     * @param annotationMetadata  Associated annotation metadata
     * @param builderMethods      The builder methods
     */
    void addFieldConfigurationBuilder(F fieldElement, AnnotationMetadata annotationMetadata, List<MethodDefinition<C, M>> builderMethods);

    /**
     * Adds a method-based configuration builder.
     *
     * @param methodElement       The configuration method
     * @param annotationMetadata  Associated annotation metadata
     * @param builderMethods      The builder methods
     */
    void addMethodConfigurationBuilder(M methodElement, AnnotationMetadata annotationMetadata, List<MethodDefinition<C, M>> builderMethods);

}
