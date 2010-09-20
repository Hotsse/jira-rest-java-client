/*
 * Copyright (C) 2010 Atlassian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atlassian.jira.restjavaclient.domain;

import com.google.common.base.Objects;

import java.util.Collection;

/**
 * TODO: Document this class / interface here
 *
 * @since v0.1
 */
public class Transition {
    private final String name;
    private final String id;
    private final Collection<Field> fields;

    public Transition(String name, String id, Collection<Field> fields) {
        this.name = name;
        this.id = id;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Iterable<Field> getFields() {
        return fields;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transition) {
            Transition that = (Transition) obj;
            return Objects.equal(this.name, that.name)
                    && Objects.equal(this.id, that.id)
                    && Objects.equal(this.fields, that.fields);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, fields);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this).
                add("id", id).
                add("name", name).
                add("fields", fields).
                toString();
    }


    public static class Field {
        private final String name;
        private final boolean isRequired;
        private final String type;

        public Field(String name, boolean isRequired, String type) {
            this.name = name;
            this.isRequired = isRequired;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isRequired() {
            return isRequired;
        }

        public String getType() {
            return type;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name, isRequired, type);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Field) {
                Field that = (Field) obj;
                return Objects.equal(this.name, that.name)
                        && Objects.equal(this.isRequired, that.isRequired)
                        && Objects.equal(this.type, that.type);
            }
            return false;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).
                    add("name", name).
                    add("isRequired", isRequired).
                    add("type", type).
                    toString();
        }

    }
}