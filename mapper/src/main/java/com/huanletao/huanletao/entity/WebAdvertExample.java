package com.huanletao.huanletao.entity;

import java.util.ArrayList;
import java.util.List;

public class WebAdvertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebAdvertExample() {
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

        public Criteria andAdvertidIsNull() {
            addCriterion("advertid is null");
            return (Criteria) this;
        }

        public Criteria andAdvertidIsNotNull() {
            addCriterion("advertid is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertidEqualTo(Integer value) {
            addCriterion("advertid =", value, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidNotEqualTo(Integer value) {
            addCriterion("advertid <>", value, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidGreaterThan(Integer value) {
            addCriterion("advertid >", value, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidGreaterThanOrEqualTo(Integer value) {
            addCriterion("advertid >=", value, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidLessThan(Integer value) {
            addCriterion("advertid <", value, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidLessThanOrEqualTo(Integer value) {
            addCriterion("advertid <=", value, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidIn(List<Integer> values) {
            addCriterion("advertid in", values, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidNotIn(List<Integer> values) {
            addCriterion("advertid not in", values, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidBetween(Integer value1, Integer value2) {
            addCriterion("advertid between", value1, value2, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertidNotBetween(Integer value1, Integer value2) {
            addCriterion("advertid not between", value1, value2, "advertid");
            return (Criteria) this;
        }

        public Criteria andAdvertnameIsNull() {
            addCriterion("advertname is null");
            return (Criteria) this;
        }

        public Criteria andAdvertnameIsNotNull() {
            addCriterion("advertname is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertnameEqualTo(String value) {
            addCriterion("advertname =", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotEqualTo(String value) {
            addCriterion("advertname <>", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameGreaterThan(String value) {
            addCriterion("advertname >", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameGreaterThanOrEqualTo(String value) {
            addCriterion("advertname >=", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameLessThan(String value) {
            addCriterion("advertname <", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameLessThanOrEqualTo(String value) {
            addCriterion("advertname <=", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameLike(String value) {
            addCriterion("advertname like", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotLike(String value) {
            addCriterion("advertname not like", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameIn(List<String> values) {
            addCriterion("advertname in", values, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotIn(List<String> values) {
            addCriterion("advertname not in", values, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameBetween(String value1, String value2) {
            addCriterion("advertname between", value1, value2, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotBetween(String value1, String value2) {
            addCriterion("advertname not between", value1, value2, "advertname");
            return (Criteria) this;
        }

        public Criteria andTarurlIsNull() {
            addCriterion("tarurl is null");
            return (Criteria) this;
        }

        public Criteria andTarurlIsNotNull() {
            addCriterion("tarurl is not null");
            return (Criteria) this;
        }

        public Criteria andTarurlEqualTo(String value) {
            addCriterion("tarurl =", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlNotEqualTo(String value) {
            addCriterion("tarurl <>", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlGreaterThan(String value) {
            addCriterion("tarurl >", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlGreaterThanOrEqualTo(String value) {
            addCriterion("tarurl >=", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlLessThan(String value) {
            addCriterion("tarurl <", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlLessThanOrEqualTo(String value) {
            addCriterion("tarurl <=", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlLike(String value) {
            addCriterion("tarurl like", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlNotLike(String value) {
            addCriterion("tarurl not like", value, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlIn(List<String> values) {
            addCriterion("tarurl in", values, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlNotIn(List<String> values) {
            addCriterion("tarurl not in", values, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlBetween(String value1, String value2) {
            addCriterion("tarurl between", value1, value2, "tarurl");
            return (Criteria) this;
        }

        public Criteria andTarurlNotBetween(String value1, String value2) {
            addCriterion("tarurl not between", value1, value2, "tarurl");
            return (Criteria) this;
        }

        public Criteria andPicaddressIsNull() {
            addCriterion("picaddress is null");
            return (Criteria) this;
        }

        public Criteria andPicaddressIsNotNull() {
            addCriterion("picaddress is not null");
            return (Criteria) this;
        }

        public Criteria andPicaddressEqualTo(String value) {
            addCriterion("picaddress =", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotEqualTo(String value) {
            addCriterion("picaddress <>", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressGreaterThan(String value) {
            addCriterion("picaddress >", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressGreaterThanOrEqualTo(String value) {
            addCriterion("picaddress >=", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressLessThan(String value) {
            addCriterion("picaddress <", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressLessThanOrEqualTo(String value) {
            addCriterion("picaddress <=", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressLike(String value) {
            addCriterion("picaddress like", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotLike(String value) {
            addCriterion("picaddress not like", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressIn(List<String> values) {
            addCriterion("picaddress in", values, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotIn(List<String> values) {
            addCriterion("picaddress not in", values, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressBetween(String value1, String value2) {
            addCriterion("picaddress between", value1, value2, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotBetween(String value1, String value2) {
            addCriterion("picaddress not between", value1, value2, "picaddress");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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