package com.example.blog_api.entity;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants
public enum Roles {
    //@FieldNameConstants generates constant field names based on the field names in your class.

    //An enum (short for "enumeration") is a special data type that consists of a set of predefined constants. Enums are
    //used to represent a fixed set of values or options that are meaningful within a certain. They are often used to
    //improve code readability and maintainability by providing a named and type-safe way to represent a group of related
    //constants

    USER, ADMIN, MEMBER;

    public Roles getRoles(String roles) {
        for(Roles r : Roles.values()) {
            if (r.name().equals(roles)) {
                return r;
            }
        }
        return null;
    }
}
