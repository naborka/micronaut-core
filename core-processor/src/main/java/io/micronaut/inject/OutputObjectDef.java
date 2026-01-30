package io.micronaut.inject;

import io.micronaut.inject.writer.OriginatingElements;
import io.micronaut.sourcegen.model.ObjectDef;
import org.jspecify.annotations.Nullable;

/**
 * Aggregates the generated {@link ObjectDef} together with service metadata.
 *
 * @param objectDef           The generated object definition
 * @param serviceClass        The service to be registered
 * @param originatingElements The originating elements
 * @author Denis Stepanov
 * @since 5.0
 */
public record OutputObjectDef(ObjectDef objectDef, @Nullable Class<?> serviceClass, OriginatingElements originatingElements) {
}
