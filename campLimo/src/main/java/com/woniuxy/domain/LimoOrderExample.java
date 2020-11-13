package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LimoOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LimoOrderExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(Integer value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(Integer value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(Integer value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(Integer value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(Integer value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<Integer> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<Integer> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(Integer value1, Integer value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(Integer value1, Integer value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOTimeIsNull() {
            addCriterion("o_time is null");
            return (Criteria) this;
        }

        public Criteria andOTimeIsNotNull() {
            addCriterion("o_time is not null");
            return (Criteria) this;
        }

        public Criteria andOTimeEqualTo(Date value) {
            addCriterion("o_time =", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeNotEqualTo(Date value) {
            addCriterion("o_time <>", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeGreaterThan(Date value) {
            addCriterion("o_time >", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("o_time >=", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeLessThan(Date value) {
            addCriterion("o_time <", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeLessThanOrEqualTo(Date value) {
            addCriterion("o_time <=", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeIn(List<Date> values) {
            addCriterion("o_time in", values, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeNotIn(List<Date> values) {
            addCriterion("o_time not in", values, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeBetween(Date value1, Date value2) {
            addCriterion("o_time between", value1, value2, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeNotBetween(Date value1, Date value2) {
            addCriterion("o_time not between", value1, value2, "oTime");
            return (Criteria) this;
        }

        public Criteria andOStatusIsNull() {
            addCriterion("o_status is null");
            return (Criteria) this;
        }

        public Criteria andOStatusIsNotNull() {
            addCriterion("o_status is not null");
            return (Criteria) this;
        }

        public Criteria andOStatusEqualTo(Integer value) {
            addCriterion("o_status =", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusNotEqualTo(Integer value) {
            addCriterion("o_status <>", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusGreaterThan(Integer value) {
            addCriterion("o_status >", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_status >=", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusLessThan(Integer value) {
            addCriterion("o_status <", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusLessThanOrEqualTo(Integer value) {
            addCriterion("o_status <=", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusIn(List<Integer> values) {
            addCriterion("o_status in", values, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusNotIn(List<Integer> values) {
            addCriterion("o_status not in", values, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusBetween(Integer value1, Integer value2) {
            addCriterion("o_status between", value1, value2, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("o_status not between", value1, value2, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOTotalIsNull() {
            addCriterion("o_total is null");
            return (Criteria) this;
        }

        public Criteria andOTotalIsNotNull() {
            addCriterion("o_total is not null");
            return (Criteria) this;
        }

        public Criteria andOTotalEqualTo(Double value) {
            addCriterion("o_total =", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalNotEqualTo(Double value) {
            addCriterion("o_total <>", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalGreaterThan(Double value) {
            addCriterion("o_total >", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("o_total >=", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalLessThan(Double value) {
            addCriterion("o_total <", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalLessThanOrEqualTo(Double value) {
            addCriterion("o_total <=", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalIn(List<Double> values) {
            addCriterion("o_total in", values, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalNotIn(List<Double> values) {
            addCriterion("o_total not in", values, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalBetween(Double value1, Double value2) {
            addCriterion("o_total between", value1, value2, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalNotBetween(Double value1, Double value2) {
            addCriterion("o_total not between", value1, value2, "oTotal");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andUrIdIsNull() {
            addCriterion("ur_id is null");
            return (Criteria) this;
        }

        public Criteria andUrIdIsNotNull() {
            addCriterion("ur_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrIdEqualTo(Integer value) {
            addCriterion("ur_id =", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdNotEqualTo(Integer value) {
            addCriterion("ur_id <>", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdGreaterThan(Integer value) {
            addCriterion("ur_id >", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ur_id >=", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdLessThan(Integer value) {
            addCriterion("ur_id <", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdLessThanOrEqualTo(Integer value) {
            addCriterion("ur_id <=", value, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdIn(List<Integer> values) {
            addCriterion("ur_id in", values, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdNotIn(List<Integer> values) {
            addCriterion("ur_id not in", values, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdBetween(Integer value1, Integer value2) {
            addCriterion("ur_id between", value1, value2, "urId");
            return (Criteria) this;
        }

        public Criteria andUrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ur_id not between", value1, value2, "urId");
            return (Criteria) this;
        }
    }

    /**
     */
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