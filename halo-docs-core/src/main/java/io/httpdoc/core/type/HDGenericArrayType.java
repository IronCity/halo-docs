package io.httpdoc.core.type;

import java.util.Collections;
import java.util.Set;

/**
 * 泛型数组类型
 *
 * @author
 * @date 2018-05-04 14:57
 **/
public class HDGenericArrayType extends HDType {
    private HDType genericComponentType;

    protected HDGenericArrayType() {
    }

    public HDGenericArrayType(HDType genericComponentType) {
        this.genericComponentType = genericComponentType;
    }

    @Override
    public CharSequence getAbbrName() {
        return genericComponentType.getAbbrName() + "[]";
    }

    @Override
    public CharSequence getTypeName() {
        return genericComponentType.getTypeName() + "[]";
    }

    @Override
    public Set<String> imports() {
        return genericComponentType != null ? genericComponentType.imports() : Collections.<String>emptySet();
    }

    public HDType getGenericComponentType() {
        return genericComponentType;
    }

    void setGenericComponentType(HDType genericComponentType) {
        this.genericComponentType = genericComponentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HDGenericArrayType that = (HDGenericArrayType) o;

        return genericComponentType != null ? genericComponentType.equals(that.genericComponentType) : that.genericComponentType == null;
    }

    @Override
    public int hashCode() {
        return genericComponentType != null ? genericComponentType.hashCode() : 0;
    }
}
