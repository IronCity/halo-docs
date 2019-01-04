package io.httpdoc.jackson.deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.httpdoc.core.deserialization.Deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

/**
 * YAML反序列化器
 *
 * @author
 * @date 2018-04-17 10:29
 **/
public class YamlDeserializer implements Deserializer {
    private final YAMLMapper mapper;

    public YamlDeserializer() {
        this(new YAMLFactory());
    }

    public YamlDeserializer(YAMLFactory factory) {
        this(new YAMLMapper(factory));
    }

    public YamlDeserializer(YAMLMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Map<String, Object> deserialize(InputStream in) throws IOException {
        return mapper.readValue(in, new TypeReference<Map<String, Object>>() {
        });
    }

    @Override
    public Map<String, Object> deserialize(Reader reader) throws IOException {
        return mapper.readValue(reader, new TypeReference<Map<String, Object>>() {
        });
    }
}
