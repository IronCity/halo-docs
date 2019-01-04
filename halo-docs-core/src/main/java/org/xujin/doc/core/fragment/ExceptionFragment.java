package org.xujin.doc.core.fragment;

import org.xujin.doc.core.Preference;
import org.xujin.doc.core.appender.LineAppender;
import org.xujin.doc.core.type.HDClass;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

/**
 * 异常声明代码碎片
 *
 * @author
 * @date 2018-07-10 13:16
 **/
public class ExceptionFragment implements Fragment {
    private HDClass type;
    private String comment;

    public ExceptionFragment() {
    }

    public ExceptionFragment(HDClass type) {
        this.type = type;
    }

    @Override
    public Set<String> imports() {
        return type != null ? type.imports() : Collections.<String>emptySet();
    }

    @Override
    public <T extends LineAppender<T>> void joinTo(T appender, Preference preference) throws IOException {
        if (type != null) appender.append(type);
    }

    public HDClass getType() {
        return type;
    }

    public void setType(HDClass type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
