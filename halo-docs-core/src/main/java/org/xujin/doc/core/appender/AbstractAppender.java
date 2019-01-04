package org.xujin.doc.core.appender;

import java.io.IOException;

/**
 * 抽象的拼接器
 *
 * @author
 * @date 2018-04-27 17:46
 **/
public abstract class AbstractAppender<T extends AbstractAppender<T>> extends CloseableAppender<T> implements Appender<T> {

    @Override
    public T append(CharSequence text) throws IOException {
        return append(text, 0, text.length());
    }

    @Override
    public T append(CharSequence text, int start, int end) throws IOException {
        for (int i = start; i < end; i++) append(text.charAt(i));
        return (T) this;
    }

}
