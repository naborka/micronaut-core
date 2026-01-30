package io.micronaut.context.bean.definition.builder;

import java.util.List;

/**
 * Common contract for bean definition members.
 *
 * @param <K> The bean element kind type
 * @author Denis Stepanov
 * @since 5.0
 */
sealed public interface MemberDefinition<K> extends AnnotationMetadataProviderRecordStyle permits ConstructorDefinition, FieldDefinition, MethodDefinition {

    List<BeanDefinitionInjectionPoint<K>> injectionPoints();

}
