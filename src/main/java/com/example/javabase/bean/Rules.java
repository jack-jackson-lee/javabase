package com.example.javabase.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * xml转java bean类
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Rule")
public class Rules implements Serializable {

    @XmlElement(name = "Item")
    private List<RuleItem> ruleItems;

    public List<RuleItem> getRuleItems() {
        return ruleItems;
    }

    public void setRuleItems(List<RuleItem> ruleItems) {
        this.ruleItems = ruleItems;
    }
}
