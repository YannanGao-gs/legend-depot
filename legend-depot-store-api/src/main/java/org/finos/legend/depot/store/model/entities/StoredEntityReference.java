//  Copyright 2021 Goldman Sachs
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//

package org.finos.legend.depot.store.model.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredEntityReference extends StoredEntity
{
    @JsonProperty
    private String reference;

    @JsonCreator
    public StoredEntityReference(@JsonProperty(value = "groupId") String groupId,
                                 @JsonProperty(value = "artifactId") String artifactId,
                                 @JsonProperty(value = "versionId") String versionId,
                                 @JsonProperty(value = "reference") String reference,
                                 @JsonProperty(value = "entityAttributes") Map<String, ?> entityAttributes)
    {
        super(groupId, artifactId, versionId, entityAttributes);
        this.reference = reference;
    }

    public StoredEntityReference(String groupId, String artifactId, String versionId)
    {
        super(groupId, artifactId, versionId);
    }

    public String getReference()
    {
        return reference;
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
