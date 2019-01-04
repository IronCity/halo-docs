package org.xujin.doc.core.interpretation;

import org.xujin.doc.core.kit.StringKit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 拓展的注释
 *
 * @author
 * 2018/10/31
 */
public abstract class ExtendedInterpretation extends Interpretation {

    protected ExtendedInterpretation(String content, Note[] notes, String text) {
        super(content, notes, text);
    }

    public String getName() {
        for (int i = 0; notes != null && i < notes.length; i++) if ("@name".equals(notes[i].getKind())) return notes[i].getText();
        return null;
    }

    public String getPackage() {
        for (int i = 0; notes != null && i < notes.length; i++) if ("@package".equals(notes[i].getKind())) return notes[i].getText();
        return null;
    }

    public String getSummary() {
        for (int i = 0; notes != null && i < notes.length; i++) if ("@summary".equals(notes[i].getKind())) return notes[i].getText();
        return null;
    }

    public String getDeprecated() {
        for (int i = 0; notes != null && i < notes.length; i++) if ("@deprecated".equals(notes[i].getKind())) return StringKit.isBlank(notes[i].getText()) ? "deprecated" : notes[i].getText();
        return null;
    }

    public boolean isSkip() {
        for (int i = 0; notes != null && i < notes.length; i++) if ("@skip".equals(notes[i].getKind())) return true;
        return false;
    }

    public List<String> getTags() {
        List<String> tags = new ArrayList<>();
        for (int i = 0; notes != null && i < notes.length; i++) if ("@tag".equals(notes[i].getKind())) tags.add(notes[i].getText());
        return tags;
    }

    public List<String> getIgnores() {
        List<String> ignores = new ArrayList<>();
        for (int i = 0; notes != null && i < notes.length; i++) if ("@ignore".equals(notes[i].getKind())) ignores.add(notes[i].getText());
        return ignores;
    }

    public Map<String, String> getAliases() {
        Map<String, String> aliases = new LinkedHashMap<>();
        for (int i = 0; notes != null && i < notes.length; i++) {
            if ("@alias".equals(notes[i].getKind())) {
                String text = notes[i].getText();
                if (text == null) text = "";
                String[] texts = text.trim().split("\\s+");
                if (texts.length > 1) aliases.put(texts[0], texts[1]);
                else aliases.put("", texts[0]);
            }
        }
        return aliases;
    }

    public String getAlias() {
        Map<String, String> aliases = getAliases();
        return aliases != null && !aliases.isEmpty() ? aliases.entrySet().iterator().next().getValue() : null;
    }

    public Integer getOrder() {
        for (int i = 0; notes != null && i < notes.length; i++) {
            if ("@order".equals(notes[i].getKind()) && notes[i].getText().matches("-?\\d+")) {
                return Integer.valueOf(notes[i].getText());
            }
        }
        return null;
    }

    public Map<String, String> getStyles() {
        Map<String, String> aliases = new LinkedHashMap<>();
        for (int i = 0; notes != null && i < notes.length; i++) {
            if ("@style".equals(notes[i].getKind())) {
                String text = notes[i].getText();
                if (text == null) text = "";
                String[] texts = text.trim().split("\\s+");
                if (texts.length > 1) aliases.put(texts[0], texts[1]);
                else aliases.put("", texts[0]);
            }
        }
        return aliases;
    }

    public String getStyle() {
        Map<String, String> styles = getStyles();
        return styles != null && !styles.isEmpty() ? styles.entrySet().iterator().next().getValue() : null;
    }

}
