package io.httpdoc.core;

/**
 * 资源操作符形式参数
 *
 * @author
 * @date 2018-04-12 13:41
 **/
public class Parameter extends Definition {
    public static final String HTTP_PARAM_SCOPE_HEADER = "header";
    public static final String HTTP_PARAM_SCOPE_PATH = "path";
    public static final String HTTP_PARAM_SCOPE_MATRIX = "matrix";
    public static final String HTTP_PARAM_SCOPE_QUERY = "query";
    public static final String HTTP_PARAM_SCOPE_BODY = "body";
    public static final String HTTP_PARAM_SCOPE_COOKIE = "cookie";
    public static final String HTTP_PARAM_SCOPE_FIELD = "field";
    private static final long serialVersionUID = 8199679343694443326L;
    private String name;
    private String alias;
    private String scope;
    private Schema type;
    private String path;
    private String style;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Schema getType() {
        return type;
    }

    public void setType(Schema type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
