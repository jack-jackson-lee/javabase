package com.example.javabase.base;

import com.example.javabase.bean.RuleItem;
import com.example.javabase.bean.Rules;
import com.example.javabase.util.XmlUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class XmlTest {

    private static final Logger LOG = LoggerFactory.getLogger(XmlTest.class);

    @Test
    public void test01() throws JsonProcessingException {
        XmlUtil util = new XmlUtil();
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\config\\Rule.xml";
        LOG.info(path);
        Rules rule = util.xml2Java(Rules.class, path);
        ObjectMapper objectMapper = new ObjectMapper();
        LOG.info(objectMapper.writeValueAsString(rule));
    }

    @Test
    public void test02() {
        XmlUtil util = new XmlUtil();
        Rules rules = new Rules();
        RuleItem ruleItem = new RuleItem("paramId", "Integer", "[1,1000000]", "", "1 to 1000000", "1到100万");
        RuleItem ruleItem2 = new RuleItem("paramId2", "Integer", "[1,1000000]", "", "2 to 1000000", "2到100万");
        List<RuleItem> list = new ArrayList<>();
        list.add(ruleItem);
        list.add(ruleItem2);
        rules.setRuleItems(list);
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\files\\Rule2.xml";
        util.java2Xml(rules, path);
    }

}
