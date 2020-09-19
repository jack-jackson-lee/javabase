package com.example.javabase.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * xml转java bean类
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Item")
public class RuleItem implements Serializable {

    @XmlElement(name = "Name", required = true)
    private String itemName;
    @XmlElement(name = "ItemType", required = true)
    private String itemType;
    @XmlElement(name = "Regexp", required = true)
    private String itemRegexp;
    @XmlElement(name = "ItemRange", required = true)
    private String itemRange;
    @XmlElement(name = "EN_US", required = true)
    private String descriptionEn;
    @XmlElement(name = "ZH_CN", required = true)
    private String descriptionZh;


    public RuleItem() {
    }

    public RuleItem(String itemName, String itemType, String itemRegexp, String itemRange, String descriptionEn, String descriptionZh) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemRegexp = itemRegexp;
        this.itemRange = itemRange;
        this.descriptionEn = descriptionEn;
        this.descriptionZh = descriptionZh;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemRegexp() {
        return itemRegexp;
    }

    public void setItemRegexp(String itemRegexp) {
        this.itemRegexp = itemRegexp;
    }

    public String getItemRange() {
        return itemRange;
    }

    public void setItemRange(String itemRange) {
        this.itemRange = itemRange;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionZh() {
        return descriptionZh;
    }

    public void setDescriptionZh(String descriptionZh) {
        this.descriptionZh = descriptionZh;
    }
}


