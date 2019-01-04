package org.xujin.doc.core.conversion;

/**
 * 默认转换格式
 *
 * @author
 * @date 2018-04-18 15:10
 **/
public class DefaultFormat implements Format {
    private static final long serialVersionUID = 2432350326973481952L;

    @Override
    public String getRefPrefix() {
        return REF_PREFIX;
    }

    @Override
    public String getRefSuffix() {
        return REF_SUFFIX;
    }

    @Override
    public String getMapPrefix() {
        return MAP_PREFIX;
    }

    @Override
    public String getMapSuffix() {
        return MAP_SUFFIX;
    }

    @Override
    public String getArrPrefix() {
        return ARR_PREFIX;
    }

    @Override
    public String getArrSuffix() {
        return ARR_SUFFIX;
    }

    @Override
    public boolean isPkgIncluded() {
        return false;
    }

    @Override
    public boolean isCanonical() {
        return false;
    }

}
