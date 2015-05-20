package com.huang.rp.common.cache.domain;

public class SysParameter {
    private Long id;

    private String code;

    private String value;

    private String paraCode;

    private Byte weight;

    private Integer paraGroup;

    private Boolean isValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParaCode() {
        return paraCode;
    }

    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
    }

    public Integer getParaGroup() {
        return paraGroup;
    }

    public void setParaGroup(Integer paraGroup) {
        this.paraGroup = paraGroup;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}