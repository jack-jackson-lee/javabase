package com.example.javabase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {

    private static final Logger LOG = LoggerFactory.getLogger(IOUtil.class);

    public static boolean closeStream(Closeable... closeables) {
        LOG.info("closeStream start ...");
        try {
            if (closeables.length > 0) {
                for (Closeable closeable : closeables) {
                    if (null != closeable) {
                        closeable.close();
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("closeStream error", e);
            return false;
        }
        LOG.info("closeStream end...");
        return true;
    }
}
