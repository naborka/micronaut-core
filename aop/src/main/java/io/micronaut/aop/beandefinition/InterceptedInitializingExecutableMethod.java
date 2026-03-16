package io.micronaut.aop.beandefinition;

import io.micronaut.context.BeanContext;
import io.micronaut.context.BeanResolutionContext;
import io.micronaut.core.annotation.AnnotationMetadata;
import io.micronaut.core.annotation.Internal;
import io.micronaut.core.type.Argument;
import org.jspecify.annotations.Nullable;

/**
 * Executable method that delegates {@link InterceptedInitializingBeanDefinition} initialization to the interceptor chain.
 *
 * @param <T> The intercepted bean type
 * @author Denis Stepanov
 * @since 5.0
 */
@Internal
public final class InterceptedInitializingExecutableMethod<T> extends AbstractExecutableMethod<T, T> {

    private final InterceptedInitializingBeanDefinition<T> interceptedInitializingBeanDefinition;
    private final BeanResolutionContext beanResolutionContext;
    private final BeanContext beanContext;
    private final T bean;

    /**
     * @param interceptedInitializingBeanDefinition The intercepted initializing bean definition
     * @param beanResolutionContext                 The resolution context
     * @param beanContext                           The bean context
     * @param bean                                  The bean to initialize
     */
    InterceptedInitializingExecutableMethod(InterceptedInitializingBeanDefinition<T> interceptedInitializingBeanDefinition,
                                            BeanResolutionContext beanResolutionContext,
                                            BeanContext beanContext,
                                            T bean) {
        super(interceptedInitializingBeanDefinition.getBeanType(), "initialize", Argument.of(interceptedInitializingBeanDefinition.getBeanType()));
        this.interceptedInitializingBeanDefinition = interceptedInitializingBeanDefinition;
        this.beanResolutionContext = beanResolutionContext;
        this.beanContext = beanContext;
        this.bean = bean;
    }

    @Override
    public AnnotationMetadata getAnnotationMetadata() {
        return interceptedInitializingBeanDefinition.getAnnotationMetadata();
    }

    @Override
    protected T invokeInternal(T instance, @Nullable Object[] arguments) {
        return interceptedInitializingBeanDefinition.doInitialize(beanResolutionContext, beanContext, bean);
    }
}
