package org.xujin.docs.jackson.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.xujin.doc.core.serialization.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

/**
 * JSON 文档序列化器
 *
 * @author
 * @date 2018-04-24 12:30
 **/
public class JsonSerializer implements Serializer {
    private final ObjectMapper mapper;

    public JsonSerializer() {
        this(new JsonFactory());
    }

    public JsonSerializer(JsonFactory factory) {
        this(new ObjectMapper(factory));
    }

    public JsonSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getName() {
        return "json";
    }

    @Override
    public String getType() {
        return "application/json";
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
