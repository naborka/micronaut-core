package io.micronaut.aop.beandefinition;

import io.micronaut.context.BeanContext;
import io.micronaut.context.BeanResolutionContext;
import io.micronaut.core.annotation.AnnotationMetadata;
import io.micronaut.core.annotation.Internal;
import io.micronaut.core.beans.BeanConstructor;
import io.micronaut.core.type.Argument;
import io.micronaut.inject.annotation.AnnotationMetadataHierarchy;
import org.jspecify.annotations.Nullable;

/**
 * The intercepted implementation of {@link io.micronaut.core.beans.BeanConstructor}.
 *
 * @param <T> The intercepted bean type
 * @author Denis Stepanov
 * @since 5.0
 */
@Internal
final class InterceptedParametrizedBeanConstructor<T> implements BeanConstructor<T> {

    private final InterceptedParametrizedInstantiateBeanDefinition<T> interceptedInstantiateBeanDefinition;
    private final BeanResolutionContext beanResolutionContext;
    private final BeanContext beanContext;
    private final AnnotationMetadata annotationMetadata;

    /**
     * @param interceptedInstantiateBeanDefinition The intercepted bean definition
     * @param beanResolutionContext                The resolution context
     * @param beanContext                          The bean context
     */
    InterceptedParametrizedBeanConstructor(InterceptedParametrizedInstantiateBeanDefinition<T> interceptedInstantiateBeanDefinition,
                                           BeanResolutionContext beanResolutionContext,
                                           BeanContext beanContext) {
        this.interceptedInstantiateBeanDefinition = interceptedInstantiateBeanDefinition;
        this.beanResolutionContext = beanResolutionContext;
        this.beanContext = beanContext;
        this.annotationMetadata = new AnnotationMetadataHierarchy(
            interceptedInstantiateBeanDefinition.getAnnotationMetadata(),
            interceptedInstantiateBeanDefinition.getConstructor().getAnnotationMetadata()
        );
    }

    @Override
    public T instantiate(@Nullable Object... parameterValues) {
        return interceptedInstantiateBeanDefinition.doInstantiate(beanResolutionContext, beanContext, parameterValues);
    }

    @Override
    public AnnotationMetadata getAnnotationMetadata() {
        return annotationMetadata;
    }

    @Override
    public Class<T> getDeclaringBeanType() {
        return interceptedInstantiateBeanDefinition.getBeanType();
    }

    @Override
    public Argument<?>[] getArguments() {
        return interceptedInstantiateBeanDefinition.getConstructor().getArguments();
    }
}
