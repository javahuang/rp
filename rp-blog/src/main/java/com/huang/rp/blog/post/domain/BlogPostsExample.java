package com.huang.rp.blog.post.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogPostsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogPostsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPostAuthorIsNull() {
            addCriterion("post_author is null");
            return (Criteria) this;
        }

        public Criteria andPostAuthorIsNotNull() {
            addCriterion("post_author is not null");
            return (Criteria) this;
        }

        public Criteria andPostAuthorEqualTo(Long value) {
            addCriterion("post_author =", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotEqualTo(Long value) {
            addCriterion("post_author <>", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorGreaterThan(Long value) {
            addCriterion("post_author >", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorGreaterThanOrEqualTo(Long value) {
            addCriterion("post_author >=", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorLessThan(Long value) {
            addCriterion("post_author <", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorLessThanOrEqualTo(Long value) {
            addCriterion("post_author <=", value, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorIn(List<Long> values) {
            addCriterion("post_author in", values, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotIn(List<Long> values) {
            addCriterion("post_author not in", values, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorBetween(Long value1, Long value2) {
            addCriterion("post_author between", value1, value2, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostAuthorNotBetween(Long value1, Long value2) {
            addCriterion("post_author not between", value1, value2, "postAuthor");
            return (Criteria) this;
        }

        public Criteria andPostDateIsNull() {
            addCriterion("post_date is null");
            return (Criteria) this;
        }

        public Criteria andPostDateIsNotNull() {
            addCriterion("post_date is not null");
            return (Criteria) this;
        }

        public Criteria andPostDateEqualTo(Date value) {
            addCriterion("post_date =", value, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateNotEqualTo(Date value) {
            addCriterion("post_date <>", value, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateGreaterThan(Date value) {
            addCriterion("post_date >", value, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateGreaterThanOrEqualTo(Date value) {
            addCriterion("post_date >=", value, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateLessThan(Date value) {
            addCriterion("post_date <", value, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateLessThanOrEqualTo(Date value) {
            addCriterion("post_date <=", value, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateIn(List<Date> values) {
            addCriterion("post_date in", values, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateNotIn(List<Date> values) {
            addCriterion("post_date not in", values, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateBetween(Date value1, Date value2) {
            addCriterion("post_date between", value1, value2, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateNotBetween(Date value1, Date value2) {
            addCriterion("post_date not between", value1, value2, "postDate");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtIsNull() {
            addCriterion("post_date_gmt is null");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtIsNotNull() {
            addCriterion("post_date_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtEqualTo(Date value) {
            addCriterion("post_date_gmt =", value, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtNotEqualTo(Date value) {
            addCriterion("post_date_gmt <>", value, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtGreaterThan(Date value) {
            addCriterion("post_date_gmt >", value, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("post_date_gmt >=", value, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtLessThan(Date value) {
            addCriterion("post_date_gmt <", value, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtLessThanOrEqualTo(Date value) {
            addCriterion("post_date_gmt <=", value, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtIn(List<Date> values) {
            addCriterion("post_date_gmt in", values, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtNotIn(List<Date> values) {
            addCriterion("post_date_gmt not in", values, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtBetween(Date value1, Date value2) {
            addCriterion("post_date_gmt between", value1, value2, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostDateGmtNotBetween(Date value1, Date value2) {
            addCriterion("post_date_gmt not between", value1, value2, "postDateGmt");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNull() {
            addCriterion("post_status is null");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNotNull() {
            addCriterion("post_status is not null");
            return (Criteria) this;
        }

        public Criteria andPostStatusEqualTo(String value) {
            addCriterion("post_status =", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotEqualTo(String value) {
            addCriterion("post_status <>", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThan(String value) {
            addCriterion("post_status >", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThanOrEqualTo(String value) {
            addCriterion("post_status >=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThan(String value) {
            addCriterion("post_status <", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThanOrEqualTo(String value) {
            addCriterion("post_status <=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLike(String value) {
            addCriterion("post_status like", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotLike(String value) {
            addCriterion("post_status not like", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusIn(List<String> values) {
            addCriterion("post_status in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotIn(List<String> values) {
            addCriterion("post_status not in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusBetween(String value1, String value2) {
            addCriterion("post_status between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotBetween(String value1, String value2) {
            addCriterion("post_status not between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(String value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(String value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(String value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(String value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(String value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLike(String value) {
            addCriterion("comment_status like", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotLike(String value) {
            addCriterion("comment_status not like", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<String> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<String> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(String value1, String value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(String value1, String value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andPostPasswordIsNull() {
            addCriterion("post_password is null");
            return (Criteria) this;
        }

        public Criteria andPostPasswordIsNotNull() {
            addCriterion("post_password is not null");
            return (Criteria) this;
        }

        public Criteria andPostPasswordEqualTo(String value) {
            addCriterion("post_password =", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordNotEqualTo(String value) {
            addCriterion("post_password <>", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordGreaterThan(String value) {
            addCriterion("post_password >", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("post_password >=", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordLessThan(String value) {
            addCriterion("post_password <", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordLessThanOrEqualTo(String value) {
            addCriterion("post_password <=", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordLike(String value) {
            addCriterion("post_password like", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordNotLike(String value) {
            addCriterion("post_password not like", value, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordIn(List<String> values) {
            addCriterion("post_password in", values, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordNotIn(List<String> values) {
            addCriterion("post_password not in", values, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordBetween(String value1, String value2) {
            addCriterion("post_password between", value1, value2, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostPasswordNotBetween(String value1, String value2) {
            addCriterion("post_password not between", value1, value2, "postPassword");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNull() {
            addCriterion("post_name is null");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNotNull() {
            addCriterion("post_name is not null");
            return (Criteria) this;
        }

        public Criteria andPostNameEqualTo(String value) {
            addCriterion("post_name =", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotEqualTo(String value) {
            addCriterion("post_name <>", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThan(String value) {
            addCriterion("post_name >", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("post_name >=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThan(String value) {
            addCriterion("post_name <", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThanOrEqualTo(String value) {
            addCriterion("post_name <=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLike(String value) {
            addCriterion("post_name like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotLike(String value) {
            addCriterion("post_name not like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameIn(List<String> values) {
            addCriterion("post_name in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotIn(List<String> values) {
            addCriterion("post_name not in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameBetween(String value1, String value2) {
            addCriterion("post_name between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotBetween(String value1, String value2) {
            addCriterion("post_name not between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostModifiedIsNull() {
            addCriterion("post_modified is null");
            return (Criteria) this;
        }

        public Criteria andPostModifiedIsNotNull() {
            addCriterion("post_modified is not null");
            return (Criteria) this;
        }

        public Criteria andPostModifiedEqualTo(Date value) {
            addCriterion("post_modified =", value, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedNotEqualTo(Date value) {
            addCriterion("post_modified <>", value, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGreaterThan(Date value) {
            addCriterion("post_modified >", value, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("post_modified >=", value, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedLessThan(Date value) {
            addCriterion("post_modified <", value, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedLessThanOrEqualTo(Date value) {
            addCriterion("post_modified <=", value, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedIn(List<Date> values) {
            addCriterion("post_modified in", values, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedNotIn(List<Date> values) {
            addCriterion("post_modified not in", values, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedBetween(Date value1, Date value2) {
            addCriterion("post_modified between", value1, value2, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedNotBetween(Date value1, Date value2) {
            addCriterion("post_modified not between", value1, value2, "postModified");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtIsNull() {
            addCriterion("post_modified_gmt is null");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtIsNotNull() {
            addCriterion("post_modified_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtEqualTo(Date value) {
            addCriterion("post_modified_gmt =", value, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtNotEqualTo(Date value) {
            addCriterion("post_modified_gmt <>", value, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtGreaterThan(Date value) {
            addCriterion("post_modified_gmt >", value, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("post_modified_gmt >=", value, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtLessThan(Date value) {
            addCriterion("post_modified_gmt <", value, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtLessThanOrEqualTo(Date value) {
            addCriterion("post_modified_gmt <=", value, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtIn(List<Date> values) {
            addCriterion("post_modified_gmt in", values, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtNotIn(List<Date> values) {
            addCriterion("post_modified_gmt not in", values, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtBetween(Date value1, Date value2) {
            addCriterion("post_modified_gmt between", value1, value2, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostModifiedGmtNotBetween(Date value1, Date value2) {
            addCriterion("post_modified_gmt not between", value1, value2, "postModifiedGmt");
            return (Criteria) this;
        }

        public Criteria andPostParentIsNull() {
            addCriterion("post_parent is null");
            return (Criteria) this;
        }

        public Criteria andPostParentIsNotNull() {
            addCriterion("post_parent is not null");
            return (Criteria) this;
        }

        public Criteria andPostParentEqualTo(Long value) {
            addCriterion("post_parent =", value, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentNotEqualTo(Long value) {
            addCriterion("post_parent <>", value, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentGreaterThan(Long value) {
            addCriterion("post_parent >", value, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentGreaterThanOrEqualTo(Long value) {
            addCriterion("post_parent >=", value, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentLessThan(Long value) {
            addCriterion("post_parent <", value, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentLessThanOrEqualTo(Long value) {
            addCriterion("post_parent <=", value, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentIn(List<Long> values) {
            addCriterion("post_parent in", values, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentNotIn(List<Long> values) {
            addCriterion("post_parent not in", values, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentBetween(Long value1, Long value2) {
            addCriterion("post_parent between", value1, value2, "postParent");
            return (Criteria) this;
        }

        public Criteria andPostParentNotBetween(Long value1, Long value2) {
            addCriterion("post_parent not between", value1, value2, "postParent");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNull() {
            addCriterion("menu_order is null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNotNull() {
            addCriterion("menu_order is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderEqualTo(Integer value) {
            addCriterion("menu_order =", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotEqualTo(Integer value) {
            addCriterion("menu_order <>", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThan(Integer value) {
            addCriterion("menu_order >", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_order >=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThan(Integer value) {
            addCriterion("menu_order <", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThanOrEqualTo(Integer value) {
            addCriterion("menu_order <=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIn(List<Integer> values) {
            addCriterion("menu_order in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotIn(List<Integer> values) {
            addCriterion("menu_order not in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderBetween(Integer value1, Integer value2) {
            addCriterion("menu_order between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_order not between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNull() {
            addCriterion("post_type is null");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNotNull() {
            addCriterion("post_type is not null");
            return (Criteria) this;
        }

        public Criteria andPostTypeEqualTo(String value) {
            addCriterion("post_type =", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotEqualTo(String value) {
            addCriterion("post_type <>", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThan(String value) {
            addCriterion("post_type >", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("post_type >=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThan(String value) {
            addCriterion("post_type <", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThanOrEqualTo(String value) {
            addCriterion("post_type <=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLike(String value) {
            addCriterion("post_type like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotLike(String value) {
            addCriterion("post_type not like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIn(List<String> values) {
            addCriterion("post_type in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotIn(List<String> values) {
            addCriterion("post_type not in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeBetween(String value1, String value2) {
            addCriterion("post_type between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotBetween(String value1, String value2) {
            addCriterion("post_type not between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeIsNull() {
            addCriterion("post_mime_type is null");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeIsNotNull() {
            addCriterion("post_mime_type is not null");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeEqualTo(String value) {
            addCriterion("post_mime_type =", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeNotEqualTo(String value) {
            addCriterion("post_mime_type <>", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeGreaterThan(String value) {
            addCriterion("post_mime_type >", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("post_mime_type >=", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeLessThan(String value) {
            addCriterion("post_mime_type <", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeLessThanOrEqualTo(String value) {
            addCriterion("post_mime_type <=", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeLike(String value) {
            addCriterion("post_mime_type like", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeNotLike(String value) {
            addCriterion("post_mime_type not like", value, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeIn(List<String> values) {
            addCriterion("post_mime_type in", values, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeNotIn(List<String> values) {
            addCriterion("post_mime_type not in", values, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeBetween(String value1, String value2) {
            addCriterion("post_mime_type between", value1, value2, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andPostMimeTypeNotBetween(String value1, String value2) {
            addCriterion("post_mime_type not between", value1, value2, "postMimeType");
            return (Criteria) this;
        }

        public Criteria andHasCodeIsNull() {
            addCriterion("has_code is null");
            return (Criteria) this;
        }

        public Criteria andHasCodeIsNotNull() {
            addCriterion("has_code is not null");
            return (Criteria) this;
        }

        public Criteria andHasCodeEqualTo(Boolean value) {
            addCriterion("has_code =", value, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeNotEqualTo(Boolean value) {
            addCriterion("has_code <>", value, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeGreaterThan(Boolean value) {
            addCriterion("has_code >", value, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_code >=", value, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeLessThan(Boolean value) {
            addCriterion("has_code <", value, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeLessThanOrEqualTo(Boolean value) {
            addCriterion("has_code <=", value, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeIn(List<Boolean> values) {
            addCriterion("has_code in", values, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeNotIn(List<Boolean> values) {
            addCriterion("has_code not in", values, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeBetween(Boolean value1, Boolean value2) {
            addCriterion("has_code between", value1, value2, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasCodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_code not between", value1, value2, "hasCode");
            return (Criteria) this;
        }

        public Criteria andHasPicIsNull() {
            addCriterion("has_pic is null");
            return (Criteria) this;
        }

        public Criteria andHasPicIsNotNull() {
            addCriterion("has_pic is not null");
            return (Criteria) this;
        }

        public Criteria andHasPicEqualTo(Boolean value) {
            addCriterion("has_pic =", value, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicNotEqualTo(Boolean value) {
            addCriterion("has_pic <>", value, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicGreaterThan(Boolean value) {
            addCriterion("has_pic >", value, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_pic >=", value, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicLessThan(Boolean value) {
            addCriterion("has_pic <", value, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicLessThanOrEqualTo(Boolean value) {
            addCriterion("has_pic <=", value, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicIn(List<Boolean> values) {
            addCriterion("has_pic in", values, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicNotIn(List<Boolean> values) {
            addCriterion("has_pic not in", values, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicBetween(Boolean value1, Boolean value2) {
            addCriterion("has_pic between", value1, value2, "hasPic");
            return (Criteria) this;
        }

        public Criteria andHasPicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_pic not between", value1, value2, "hasPic");
            return (Criteria) this;
        }

        public Criteria andIsReprintIsNull() {
            addCriterion("is_reprint is null");
            return (Criteria) this;
        }

        public Criteria andIsReprintIsNotNull() {
            addCriterion("is_reprint is not null");
            return (Criteria) this;
        }

        public Criteria andIsReprintEqualTo(Boolean value) {
            addCriterion("is_reprint =", value, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintNotEqualTo(Boolean value) {
            addCriterion("is_reprint <>", value, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintGreaterThan(Boolean value) {
            addCriterion("is_reprint >", value, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_reprint >=", value, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintLessThan(Boolean value) {
            addCriterion("is_reprint <", value, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintLessThanOrEqualTo(Boolean value) {
            addCriterion("is_reprint <=", value, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintIn(List<Boolean> values) {
            addCriterion("is_reprint in", values, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintNotIn(List<Boolean> values) {
            addCriterion("is_reprint not in", values, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintBetween(Boolean value1, Boolean value2) {
            addCriterion("is_reprint between", value1, value2, "isReprint");
            return (Criteria) this;
        }

        public Criteria andIsReprintNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_reprint not between", value1, value2, "isReprint");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Long value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Long value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Long value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Long value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Long value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Long> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Long> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Long value1, Long value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Long value1, Long value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Long value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Long value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Long value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Long value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Long value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Long value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Long> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Long> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Long value1, Long value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Long value1, Long value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
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