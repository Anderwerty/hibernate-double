package org.example.entity;

//import org.hibernate.annotations.Type;

import jakarta.persistence.Convert;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.type.StandardConverter;
import org.hibernate.type.descriptor.java.JavaType;

import java.util.Date;

public class UserDetails {
    //    @Type(type = "")
    private Date registrationDate;

//    @Type(type="org.hibernate.type.NumericBooleanType") // hibernate 5

    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class) //hibernate 6
    private boolean isActive;


//    @Convert(converter =org.example.entity.RoleEnumConverter.class )
    @Enumerated(EnumType.STRING)
    private Role role;
}

enum Role {
    CLIENT, ADMIN, MANAGER ;

    public static void main(String[] args) {
    }
}


@Convert
class RoleEnumConverter implements StandardConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return null;
    }

    @Override
    public Role toDomainValue(String relationalForm) {
        return null;
    }

    @Override
    public String toRelationalValue(Role domainForm) {
        return null;
    }

    @Override
    public JavaType<Role> getDomainJavaType() {
        return null;
    }

    @Override
    public JavaType<String> getRelationalJavaType() {
        return null;
    }
}
