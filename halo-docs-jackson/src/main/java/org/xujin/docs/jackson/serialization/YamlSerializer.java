package org.xujin.docs.jackson.serialization;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.xujin.doc.core.serialization.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

/**
 * YAML序列化器
 *
 * @author
 * @date 2018-04-17 10:05
 **/
public class YamlSerializer implements Serializer {
    private final YAMLMapper mapper;

    public YamlSerializer() {
        this(new YAMLFactory());
    }

    public YamlSerializer(YAMLFactory factory) {
        this(new YAMLMapper(factory));
        this.mapper.configure(YAMLGenerator.Feature.WRITE_DOC_START_MARKER, false);
        this.mapper.configure(YAMLGenerator.Feature.MINIMIZE_QUOTES, false);
    }

    public YamlSerializer(YAMLMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getName() {
        return "yaml";
    }

    @Override
    public String getType() {
        return "application/yaml";
    }

    @Override
    public void serialize(Map<String, Object> doc, OutputStream out) throws IOException {
        mapper.writeValue(out, doc);
    }

    @Override
    public void serialize(Map<String, Object> doc, Writer writer) throws IOException {
        mapper.writeValue(writer, doc);
    }

}
