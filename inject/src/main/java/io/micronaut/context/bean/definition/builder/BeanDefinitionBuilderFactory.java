package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;
import org.jspecify.annotations.Nullable;

/**
 * Factory for creating {@link BeanDefinitionBuilder} instances.
 *
 * @param <C>   The class type
 * @param <Ctr> The constructor element type
 * @param <M>   The method element type
 * @param <F>   The field type
 * @param <R>   The builder result
 * @author Denis Stepanov
 * @since 5.0
 */
public interface BeanDefinitionBuilderFactory<C, Ctr, M, F, R> {

    /**
     * Creates a builder backed by the given constructor definition.
     *
     * @param constructorDefinition The constructor definition
     * @return The bean definition builder
     */
    BeanDefinitionBuilder<C, M, F, R> constructor(ConstructorDefinition<C, Ctr> constructorDefinition);

    /**
     * Creates a builder backed by the given constructor definition.
     *
     * @param constructorDefinition The constructor definition
     * @param beanDefinitionName    An explicit bean definition name
     * @param annotationMetadata    Annotation metadata to associate
     * @return The bean definition builder
     */
    BeanDefinitionBuilder<C, M, F, R> constructor(ConstructorDefinition<C, Ctr> constructorDefinition,
                                               @Nullable String beanDefinitionName,
                                               @Nullable AnnotationMetadata annotationMetadata);

    /**
     * Creates a builder backed by the given factory method.
     *
     * @param methodDefinition The factory method definition
     * @return The bean definition builder
     */
    BeanDefinitionBuilder<C, M, F, R> factoryMethod(MethodDefinition<C, M> methodDefinition);

    /**
     * Creates a builder backed by the given factory field.
     *
     * @param fieldDefinition The factory field definition
     * @return The bean definition builder
     */
    BeanDefinitionBuilder<C, M, F, R> factoryField(FieldDefinition<C, F> fieldDefinition);

}
