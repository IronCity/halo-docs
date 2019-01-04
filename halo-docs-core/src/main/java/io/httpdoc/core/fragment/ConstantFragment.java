package io.httpdoc.core.fragment;

import io.httpdoc.core.Preference;
import io.httpdoc.core.appender.LineAppender;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

/**
 * 常量碎片
 *
 * @author
 * @date 2018-05-07 13:59
 **/
public class ConstantFragment implements Fragment {
    protected CommentFragment commentFragment;
    protected String name;

    public ConstantFragment() {
    }

    public ConstantFragment(String name) {
        this.name = name;
    }

    public ConstantFragment(CommentFragment commentFragment, String name) {
        this.commentFragment = commentFragment;
        this.name = name;
    }

    @Override
    public <T extends LineAppender<T>> void joinTo(T appender, Preference preference) throws IOException {
        if (commentFragment != null) commentFragment.joinTo(appender, preference);
        appender.append(name);
    }

    @Override
    public Set<String> imports() {
        return Collections.emptySet();
    }

    public CommentFragment getCommentFragment() {
        return commentFragment;
    }

    public void setCommentFragment(CommentFragment commentFragment) {
        this.commentFragment = commentFragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
