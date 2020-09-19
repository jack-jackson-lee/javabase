package com.example.javabase.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

public class XmlUtil implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * xml转化为 java bean
     *
     * @param cls     目标类
     * @param xmlPath xml路径
     * @return 生成的对象
     */
    public static <T extends Serializable> T xml2Java(Class<T> cls, String xmlPath) {
        LOG.info("xml2Java start...");

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(xmlPath);
            // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
            JAXBContext context = JAXBContext.newInstance(new Class[]{cls});
            // 创建 Unmarshaller 实例
            Unmarshaller unmarshaller = context.createUnmarshaller();
            LOG.info("xml2Java end...");
            return (T) unmarshaller.unmarshal(fileInputStream);
        } catch (FileNotFoundException e) {
            LOG.error("xml2Java FileNotFoundException", e);
            return null;
        } catch (JAXBException e) {
            LOG.error("xml2Java JAXBException", e);
            return null;
        } finally {
            IOUtil.closeStream(fileInputStream);
        }
    }

    /**
     * java bean 转化为 xml文件
     *
     * @param obj     源对象
     * @param xmlPath 输出xml文件的路径
     */
    public static void java2Xml(Object obj, String xmlPath) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(xmlPath);
            // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Rules
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            // 创建 Marshaller 实例
            Marshaller marshaller = context.createMarshaller();
            // 设置转换参数 -> 这里举例是告诉序列化器是否格式化输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将所需对象序列化 -> 该方法没有返回值
            marshaller.marshal(obj, fileOutputStream);
        } catch (PropertyException e) {
            LOG.error("java2Xml PropertyException", e);
        } catch (JAXBException e) {
            LOG.error("java2Xml JAXBException", e);
        } catch (FileNotFoundException e) {
            LOG.error("java2Xml FileNotFoundException", e);
        } finally {
            IOUtil.closeStream(fileOutputStream);
        }

    }


}
