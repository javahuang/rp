package com.huang.rp.common.persistence.keymgt.domain;

import java.util.ArrayList;
import java.util.List;

public class IDTableVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IDTableVoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIdIsNull() {
            addCriterion("id_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIdIsNotNull() {
            addCriterion("id_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdIdEqualTo(Integer value) {
            addCriterion("id_id =", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotEqualTo(Integer value) {
            addCriterion("id_id <>", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdGreaterThan(Integer value) {
            addCriterion("id_id >", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_id >=", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdLessThan(Integer value) {
            addCriterion("id_id <", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdLessThanOrEqualTo(Integer value) {
            addCriterion("id_id <=", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdIn(List<Integer> values) {
            addCriterion("id_id in", values, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotIn(List<Integer> values) {
            addCriterion("id_id not in", values, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdBetween(Integer value1, Integer value2) {
            addCriterion("id_id between", value1, value2, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id_id not between", value1, value2, "idId");
            return (Criteria) this;
        }

        public Criteria andIdValueIsNull() {
            addCriterion("id_value is null");
            return (Criteria) this;
        }

        public Criteria andIdValueIsNotNull() {
            addCriterion("id_value is not null");
            return (Criteria) this;
        }

        public Criteria andIdValueEqualTo(Integer value) {
            addCriterion("id_value =", value, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueNotEqualTo(Integer value) {
            addCriterion("id_value <>", value, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueGreaterThan(Integer value) {
            addCriterion("id_value >", value, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_value >=", value, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueLessThan(Integer value) {
            addCriterion("id_value <", value, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueLessThanOrEqualTo(Integer value) {
            addCriterion("id_value <=", value, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueIn(List<Integer> values) {
            addCriterion("id_value in", values, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueNotIn(List<Integer> values) {
            addCriterion("id_value not in", values, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueBetween(Integer value1, Integer value2) {
            addCriterion("id_value between", value1, value2, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdValueNotBetween(Integer value1, Integer value2) {
            addCriterion("id_value not between", value1, value2, "idValue");
            return (Criteria) this;
        }

        public Criteria andIdNameIsNull() {
            addCriterion("id_name is null");
            return (Criteria) this;
        }

        public Criteria andIdNameIsNotNull() {
            addCriterion("id_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdNameEqualTo(String value) {
            addCriterion("id_name =", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotEqualTo(String value) {
            addCriterion("id_name <>", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameGreaterThan(String value) {
            addCriterion("id_name >", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameGreaterThanOrEqualTo(String value) {
            addCriterion("id_name >=", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameLessThan(String value) {
            addCriterion("id_name <", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameLessThanOrEqualTo(String value) {
            addCriterion("id_name <=", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameLike(String value) {
            addCriterion("id_name like", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotLike(String value) {
            addCriterion("id_name not like", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameIn(List<String> values) {
            addCriterion("id_name in", values, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotIn(List<String> values) {
            addCriterion("id_name not in", values, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameBetween(String value1, String value2) {
            addCriterion("id_name between", value1, value2, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotBetween(String value1, String value2) {
            addCriterion("id_name not between", value1, value2, "idName");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeIsNull() {
            addCriterion("id_cache_size is null");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeIsNotNull() {
            addCriterion("id_cache_size is not null");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeEqualTo(Integer value) {
            addCriterion("id_cache_size =", value, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeNotEqualTo(Integer value) {
            addCriterion("id_cache_size <>", value, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeGreaterThan(Integer value) {
            addCriterion("id_cache_size >", value, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_cache_size >=", value, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeLessThan(Integer value) {
            addCriterion("id_cache_size <", value, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeLessThanOrEqualTo(Integer value) {
            addCriterion("id_cache_size <=", value, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeIn(List<Integer> values) {
            addCriterion("id_cache_size in", values, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeNotIn(List<Integer> values) {
            addCriterion("id_cache_size not in", values, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeBetween(Integer value1, Integer value2) {
            addCriterion("id_cache_size between", value1, value2, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdCacheSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("id_cache_size not between", value1, value2, "idCacheSize");
            return (Criteria) this;
        }

        public Criteria andIdPrefixIsNull() {
            addCriterion("id_prefix is null");
            return (Criteria) this;
        }

        public Criteria andIdPrefixIsNotNull() {
            addCriterion("id_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andIdPrefixEqualTo(String value) {
            addCriterion("id_prefix =", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixNotEqualTo(String value) {
            addCriterion("id_prefix <>", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixGreaterThan(String value) {
            addCriterion("id_prefix >", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("id_prefix >=", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixLessThan(String value) {
            addCriterion("id_prefix <", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixLessThanOrEqualTo(String value) {
            addCriterion("id_prefix <=", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixLike(String value) {
            addCriterion("id_prefix like", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixNotLike(String value) {
            addCriterion("id_prefix not like", value, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixIn(List<String> values) {
            addCriterion("id_prefix in", values, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixNotIn(List<String> values) {
            addCriterion("id_prefix not in", values, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixBetween(String value1, String value2) {
            addCriterion("id_prefix between", value1, value2, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIdPrefixNotBetween(String value1, String value2) {
            addCriterion("id_prefix not between", value1, value2, "idPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixIsNull() {
            addCriterion("is_prefix is null");
            return (Criteria) this;
        }

        public Criteria andIsPrefixIsNotNull() {
            addCriterion("is_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrefixEqualTo(Boolean value) {
            addCriterion("is_prefix =", value, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixNotEqualTo(Boolean value) {
            addCriterion("is_prefix <>", value, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixGreaterThan(Boolean value) {
            addCriterion("is_prefix >", value, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_prefix >=", value, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixLessThan(Boolean value) {
            addCriterion("is_prefix <", value, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixLessThanOrEqualTo(Boolean value) {
            addCriterion("is_prefix <=", value, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixIn(List<Boolean> values) {
            addCriterion("is_prefix in", values, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixNotIn(List<Boolean> values) {
            addCriterion("is_prefix not in", values, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prefix between", value1, value2, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIsPrefixNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prefix not between", value1, value2, "isPrefix");
            return (Criteria) this;
        }

        public Criteria andIdLengthIsNull() {
            addCriterion("id_length is null");
            return (Criteria) this;
        }

        public Criteria andIdLengthIsNotNull() {
            addCriterion("id_length is not null");
            return (Criteria) this;
        }

        public Criteria andIdLengthEqualTo(Integer value) {
            addCriterion("id_length =", value, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthNotEqualTo(Integer value) {
            addCriterion("id_length <>", value, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthGreaterThan(Integer value) {
            addCriterion("id_length >", value, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_length >=", value, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthLessThan(Integer value) {
            addCriterion("id_length <", value, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthLessThanOrEqualTo(Integer value) {
            addCriterion("id_length <=", value, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthIn(List<Integer> values) {
            addCriterion("id_length in", values, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthNotIn(List<Integer> values) {
            addCriterion("id_length not in", values, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthBetween(Integer value1, Integer value2) {
            addCriterion("id_length between", value1, value2, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("id_length not between", value1, value2, "idLength");
            return (Criteria) this;
        }

        public Criteria andIdSuffixIsNull() {
            addCriterion("id_suffix is null");
            return (Criteria) this;
        }

        public Criteria andIdSuffixIsNotNull() {
            addCriterion("id_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andIdSuffixEqualTo(String value) {
            addCriterion("id_suffix =", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixNotEqualTo(String value) {
            addCriterion("id_suffix <>", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixGreaterThan(String value) {
            addCriterion("id_suffix >", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("id_suffix >=", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixLessThan(String value) {
            addCriterion("id_suffix <", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixLessThanOrEqualTo(String value) {
            addCriterion("id_suffix <=", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixLike(String value) {
            addCriterion("id_suffix like", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixNotLike(String value) {
            addCriterion("id_suffix not like", value, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixIn(List<String> values) {
            addCriterion("id_suffix in", values, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixNotIn(List<String> values) {
            addCriterion("id_suffix not in", values, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixBetween(String value1, String value2) {
            addCriterion("id_suffix between", value1, value2, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIdSuffixNotBetween(String value1, String value2) {
            addCriterion("id_suffix not between", value1, value2, "idSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixIsNull() {
            addCriterion("is_suffix is null");
            return (Criteria) this;
        }

        public Criteria andIsSuffixIsNotNull() {
            addCriterion("is_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuffixEqualTo(Boolean value) {
            addCriterion("is_suffix =", value, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixNotEqualTo(Boolean value) {
            addCriterion("is_suffix <>", value, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixGreaterThan(Boolean value) {
            addCriterion("is_suffix >", value, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_suffix >=", value, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixLessThan(Boolean value) {
            addCriterion("is_suffix <", value, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixLessThanOrEqualTo(Boolean value) {
            addCriterion("is_suffix <=", value, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixIn(List<Boolean> values) {
            addCriterion("is_suffix in", values, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixNotIn(List<Boolean> values) {
            addCriterion("is_suffix not in", values, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixBetween(Boolean value1, Boolean value2) {
            addCriterion("is_suffix between", value1, value2, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andIsSuffixNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_suffix not between", value1, value2, "isSuffix");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("step like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("step not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableFieldIsNull() {
            addCriterion("table_field is null");
            return (Criteria) this;
        }

        public Criteria andTableFieldIsNotNull() {
            addCriterion("table_field is not null");
            return (Criteria) this;
        }

        public Criteria andTableFieldEqualTo(String value) {
            addCriterion("table_field =", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldNotEqualTo(String value) {
            addCriterion("table_field <>", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldGreaterThan(String value) {
            addCriterion("table_field >", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldGreaterThanOrEqualTo(String value) {
            addCriterion("table_field >=", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldLessThan(String value) {
            addCriterion("table_field <", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldLessThanOrEqualTo(String value) {
            addCriterion("table_field <=", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldLike(String value) {
            addCriterion("table_field like", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldNotLike(String value) {
            addCriterion("table_field not like", value, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldIn(List<String> values) {
            addCriterion("table_field in", values, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldNotIn(List<String> values) {
            addCriterion("table_field not in", values, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldBetween(String value1, String value2) {
            addCriterion("table_field between", value1, value2, "tableField");
            return (Criteria) this;
        }

        public Criteria andTableFieldNotBetween(String value1, String value2) {
            addCriterion("table_field not between", value1, value2, "tableField");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}