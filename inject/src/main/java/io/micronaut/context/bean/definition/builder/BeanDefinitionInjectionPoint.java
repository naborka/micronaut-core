package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;

/**
 * Models an injection point within a bean definition.
 *
 * @param <T> The element type
 * @author Denis Stepanov
 * @since 5.0
 */
public sealed interface BeanDefinitionInjectionPoint<T> extends AnnotationMetadataProviderRecordStyle {

    /**
     * @return The type of the injection point
     */
    T type();

    /**
     * Parameter-based injection point.
     *
     * @param <K> The element kind
     */
    record ParameterInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, String name) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Property-based injection point.
     *
     * @param <K> The element kind
     */
    record PropertyInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, String propertyName, String propertyPath) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * {@link io.micronaut.context.annotation.Value} injection point.
     *
     * @param <K> The element kind
     */
    record ValueInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, String value, boolean hasExpression) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Single bean injection point.
     *
     * @param <K> The element kind
     */
    record BeanInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Collection of beans injection point.
     *
     * @param <K> The element kind
     */
    record BeansInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, K beanType) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * {@link io.micronaut.context.BeanRegistration} injection point.
     *
     * @param <K> The element kind
     */
    record BeanRegistrationInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, K beanType) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Multiple {@link io.micronaut.context.BeanRegistration} injection point.
     *
     * @param <K> The element kind
     */
    record BeanRegistrationsInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, K beanType) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Map of beans injection point.
     *
     * @param <K> The element kind
     */
    record MapOfBeansInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, K beanType) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Stream of beans injection point.
     *
     * @param <K> The element kind
     */
    record StreamOfBeansInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, K beanType) implements BeanDefinitionInjectionPoint<K> {
    }

    /**
     * Optional bean injection point.
     *
     * @param <K> The element kind
     */
    record OptionalBeanInjectionPoint<K>(K type, AnnotationMetadata annotationMetadata, K beanType) implements BeanDefinitionInjectionPoint<K> {
    }
}
