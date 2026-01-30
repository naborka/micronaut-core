package io.micronaut.context.bean.definition.builder;

import io.micronaut.core.annotation.AnnotationMetadata;
import io.micronaut.core.annotation.AnnotationMetadataProvider;
import io.micronaut.core.annotation.Internal;

/**
 * Record-friendly abstraction for {@link AnnotationMetadataProvider} implementations.
 *
 * @author Denis Stepanov
 * @since 5.0
 */
@Internal
interface AnnotationMetadataProviderRecordStyle extends AnnotationMetadataProvider {

    AnnotationMetadata annotationMetadata();

    @Override
    default AnnotationMetadata getAnnotationMetadata() {
        return annotationMetadata();
    }
}
