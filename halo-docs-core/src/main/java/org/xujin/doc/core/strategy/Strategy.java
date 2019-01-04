package org.xujin.doc.core.strategy;

import java.io.IOException;

/**
 * 生成策略
 *
 * @author
 * @date 2018-07-04 11:25
 **/
public interface Strategy {

    /**
     * 生成
     *
     * @param task 生成任务
     * @throws IOException IO 异常
     */
    void execute(Task task) throws IOException;

}
