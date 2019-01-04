package io.httpdoc.core.fragment;

import io.httpdoc.core.Preference;
import io.httpdoc.core.appender.IndentAppender;
import io.httpdoc.core.appender.LineAppender;

import java.io.IOException;
import java.util.*;

/**
 * 代码块碎片
 *
 * @author
 * @date 2018-04-27 16:37
 **/
public class BlockFragment implements Fragment {
    protected List<CharSequence> sentences = new ArrayList<>();
    protected Set<String> imports = new LinkedHashSet<>();

    public BlockFragment(CharSequence... sentences) {
        this(Arrays.asList(sentences));
    }

    public BlockFragment(List<CharSequence> sentences) {
        this.sentences = new ArrayList<>(sentences);
    }

    @Override
    public <T extends LineAppender<T>> void joinTo(T appender, Preference preference) throws IOException {
        appender.append("{").enter();
        IndentAppender apd = new IndentAppender(appender, preference.getIndent());
        for (CharSequence sentence : sentences) apd.append(sentence).enter();
        apd.close();
        appender.append("}").enter();
    }

    @Override
    public Set<String> imports() {
        return imports != null ? imports : Collections.<String>emptySet();
    }

    public List<CharSequence> getSentences() {
        return sentences;
    }

    public void setSentences(List<CharSequence> sentences) {
        this.sentences = sentences;
    }

    public Set<String> getImports() {
        return imports;
    }

    public void setImports(Set<String> imports) {
        this.imports = imports;
    }
}
