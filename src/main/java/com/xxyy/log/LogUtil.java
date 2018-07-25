package com.xxyy.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志输出
 * @author dangzhizheng
 */
public class LogUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    private static final String GENERAL_LOG_FORMAT = "Class:{%s},Method:{%s},Line:{%s},Msg:{%s}";

    /**
     * 获取代码函数
     */
    private static int getLine() {
        StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
        if (null == steArray[3]) {
            return 0;
        }
        return steArray[3].getLineNumber();
    }

    /**
     * 获取调用的类名称
     */
    private static String getCallClassName() {
        StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
        if (null == steArray[3]) {
            return "";
        }
        return steArray[3].getFileName();
    }

    /**
     * 获取调用的方法名
     */
    private static String getCallFunctionName() {
        StackTraceElement[] steArray = Thread.currentThread().getStackTrace();
        if (null == steArray[3]) {
            return "";
        }
        return steArray[3].getMethodName();
    }

    /**
     * debug
     *
     * @param target 类
     * @param method 方法
     * @param msg    消息
     */
    @SuppressWarnings("rawtypes")
    public static void debug(Class target, String method, String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg));
        }
    }

    public static void debug(String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
        }
    }

    @SuppressWarnings("rawtypes")
    public static void trace(Class target, String method, String msg) {
        logger.trace(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg));
    }

    public static void trace(String msg) {
        logger.trace(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
    }

    @SuppressWarnings("rawtypes")
    public static void info(Class target, String method, String msg) {
        logger.info(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg));
    }

    public static void info(String msg) {
        logger.info(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
    }

    public static void info(String msg, Object... params) {
        msg = String.format(msg, params);
        logger.info(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
    }

    public static void warn(Class target, String method, String msg) {
        logger.warn(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg));
    }

    public static void warn(String msg) {
        logger.warn(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
    }


    public static void warn(Class target, String method, String msg, Throwable ex) {
        logger.warn(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg), ex);
    }

    public static void warn(String msg, Throwable ex) {
        logger.warn(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg), ex);
    }

    @SuppressWarnings("rawtypes")
    public static void error(Class target, String method, String msg) {
        logger.error(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg));
    }

    public static void error(String msg) {
        logger.error(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
    }

    public static void error(String msg, Object... params) {
        msg = String.format(msg, params);
        logger.error(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg));
    }

    @SuppressWarnings("rawtypes")
    public static void error(Class target, String method, String msg, Throwable ex) {
        logger.error(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), msg), ex);
    }

    public static void error(String msg, Throwable ex) {
        logger.error(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), msg), ex);
    }

    @SuppressWarnings("rawtypes")
    public static void error(Class target, String method, Throwable e) {
        logger.error(String.format(GENERAL_LOG_FORMAT, target.getName(), method, getLine(), ""), e);
    }

    public static void error(Throwable e) {
        logger.error(String.format(GENERAL_LOG_FORMAT, getCallClassName(), getCallFunctionName(), getLine(), ""), e);
    }
}
