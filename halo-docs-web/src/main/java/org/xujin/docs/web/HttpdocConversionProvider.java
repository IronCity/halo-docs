package org.xujin.docs.web;

import org.xujin.docs.web.conversion.*;
import org.xujin.docs.web.conversion.*;

import java.util.Arrays;

/**
 * Httpdoc配置类转换提供器
 *
 * @author
 * @date 2018-06-27 10:27
 **/
public class HttpdocConversionProvider extends StandardConversionProvider {

    public HttpdocConversionProvider() {
        super(Arrays.<Converter>asList(
                new PrimaryConverter(),
                new WrapperConverter(),
                new NumberConverter(),
                new StringConverter(),
                new DateConverter(),
                new EnumConverter(),
                new ArrayConverter(),
                new ListConverter(),
                new SetConverter(),
                new MapConverter()
        ));
    }

}
