/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.runtime.base.internal;

import org.gradle.api.DomainObjectSet;
import org.gradle.api.Incubating;
import org.gradle.api.internal.DefaultDomainObjectSet;
import org.gradle.language.base.LanguageSourceSet;
import org.gradle.language.base.internal.LanguageSourceSetContainer;
import org.gradle.runtime.base.ComponentSpecIdentifier;
import org.gradle.runtime.base.LibrarySpec;
import org.gradle.runtime.base.BinarySpec;

/**
 * Base class for a LibrarySpec.
 * Each custom implementation must extend this DefaultLibrarySpec
 * */

@Incubating
public class DefaultLibrarySpec implements LibrarySpec {
    private final LanguageSourceSetContainer sourceSets = new LanguageSourceSetContainer();
    private final ComponentSpecIdentifier identifier;
    private final DomainObjectSet<BinarySpec> binaries = new DefaultDomainObjectSet<BinarySpec>(BinarySpec.class);

    public DefaultLibrarySpec(ComponentSpecIdentifier identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return identifier.getName();
    }

    public String getProjectPath() {
        return identifier.getProjectPath();
    }

    public String getDisplayName() {
        return String.format("library '%s'", getName());
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

    public DomainObjectSet<LanguageSourceSet> getSource() {
        return sourceSets;
    }

    public void source(Object sources) {
        sourceSets.source(sources);
    }

    public DomainObjectSet<BinarySpec> getBinaries() {
        return binaries;
    }
}