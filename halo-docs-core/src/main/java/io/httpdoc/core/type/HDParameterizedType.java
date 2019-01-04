package io.httpdoc.core.type;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 参数化类型
 *
 * @author
 * @date 2018-05-04 11:14
 **/
public class HDParameterizedType extends HDType {
    private HDClass rawType;
    private HDType ownerType;
    private HDType[] actualTypeArguments;

    protected HDParameterizedType() {
    }

    public HDParameterizedType(HDClass rawType, HDType ownerType, HDType... actualTypeArguments) {
        this.rawType = rawType;
        this.ownerType = ownerType;
        this.actualTypeArguments = actualTypeArguments;
    }

    public HDParameterizedType(Class<?> rawType, Type ownerType, Type... actualTypeArguments) {
        this.rawType = HDType.valueOf(rawType);
        this.ownerType = HDType.valueOf(ownerType);
        this.actualTypeArguments = HDType.valuesOf(actualTypeArguments);
    }

    @Override
    public CharSequence getAbbrName() {
        StringBuilder builder = new StringBuilder();
        builder.append(rawType.getAbbrName());
        for (int i = 0; actualTypeArguments != null && i < actualTypeArguments.length; i++) {
            if (i == 0) builder.append("<");
            else builder.append(", ");
            builder.append(actualTypeArguments[i] instanceof HDTypeVariable ? ((HDTypeVariable) actualTypeArguments[i]).getName() : actualTypeArguments[i].getAbbrName());
            if (i == actualTypeArguments.length - 1) builder.append(">");
        }
        return builder;
    }

    @Override
    public CharSequence getTypeName() {
        StringBuilder builder = new StringBuilder();
        builder.append(rawType.getTypeName());
        for (int i = 0; actualTypeArguments != null && i < actualTypeArguments.length; i++) {
            if (i == 0) builder.append("<");
            else builder.append(", ");
            builder.append(actualTypeArguments[i] instanceof HDTypeVariable ? ((HDTypeVariable) actualTypeArguments[i]).getName() : actualTypeArguments[i].getTypeName());
            if (i == actualTypeArguments.length - 1) builder.append(">");
        }
        return builder;
    }

    @Override
    public Set<String> imports() {
        Set<String> imports = new LinkedHashSet<>();
        if (rawType != null) imports.addAll(rawType.imports());
        if (ownerType != null) imports.addAll(ownerType.imports());
        for (int i = 0; actualTypeArguments != null && i < actualTypeArguments.length; i++) imports.addAll(actualTypeArguments[i].imports());
        return imports;
    }

    public HDClass getRawType() {
        return rawType;
    }

    void setRawType(HDClass rawType) {
        this.rawType = rawType;
    }

    public HDType getOwnerType() {
        return ownerType;
    }

    void setOwnerType(HDType ownerType) {
        this.ownerType = ownerType;
    }

    public HDType[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    void setActualTypeArguments(HDType[] actualTypeArguments) {
        this.actualTypeArguments = actualTypeArguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HDParameterizedType that = (HDParameterizedType) o;

        if (rawType != null ? !rawType.equals(that.rawType) : that.rawType != null) return false;
        if (ownerType != null ? !ownerType.equals(that.ownerType) : that.ownerType != null) return false;
        return Arrays.equals(actualTypeArguments, that.actualTypeArguments);
    }

    @Override
    public int hashCode() {
        int result = rawType != null ? rawType.hashCode() : 0;
        result = 31 * result + (ownerType != null ? ownerType.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(actualTypeArguments);
        return result;
    }
}
