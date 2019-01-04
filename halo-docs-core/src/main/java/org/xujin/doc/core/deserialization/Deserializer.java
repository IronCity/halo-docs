package org.xujin.doc.core.deserialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

/**
 * 文档反序列化器
 *
 * @author
 * @date 2018-04-17 10:28
 **/
public interface Deserializer {

    Map<String, Object> deserialize(InputStream in) throws IOException;

    Map<String, Object> deserialize(Reader reader) throws IOException;

}
