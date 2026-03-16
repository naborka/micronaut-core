package io.micronaut.context.bean.definition.builder;

/**
 * Builder abstraction for proxy-oriented bean definitions.
 *
 * @param <M> The method element type
 * @param <R> The builder result
 * @author Denis Stepanov
 * @since 5.0
 */
public interface ProxyBuilder<C, M, R> extends Builder<R> {

    /**
     * Adds an interface to be implemented by the proxy.
     *
     * @param interfaceElement          The interface element
     */
    void implementInterface(C interfaceElement);

    /**
     * Adds a proxied method that delegates to the target.
     *
     * @param methodElement The method to proxy
     */
    void addProxyMethod(M methodElement);

    /**
     * Adds an introduction method implemented directly by the proxy.
     *
     * @param methodElement The method to introduce
     */
    void addIntroductionMethod(M methodElement);

    /**
     * Adds a method that should participate in around advice.
     *
     * @param methodElement The method element
     */
    void addAroundMethod(M methodElement);

}
