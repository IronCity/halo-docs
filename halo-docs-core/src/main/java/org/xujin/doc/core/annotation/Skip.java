package org.xujin.doc.core.annotation;

import java.lang.annotation.*;

/**
 * 跳过
 *
 * @author
 * 2018/11/6
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Skip {
}
