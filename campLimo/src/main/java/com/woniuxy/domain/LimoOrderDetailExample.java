package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LimoOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LimoOrderDetailExample() {
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

        public Criteria andOrIdIsNull() {
            addCriterion("or_id is null");
            return (Criteria) this;
        }

        public Criteria andOrIdIsNotNull() {
            addCriterion("or_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrIdEqualTo(Integer value) {
            addCriterion("or_id =", value, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdNotEqualTo(Integer value) {
            addCriterion("or_id <>", value, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdGreaterThan(Integer value) {
            addCriterion("or_id >", value, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("or_id >=", value, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdLessThan(Integer value) {
            addCriterion("or_id <", value, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdLessThanOrEqualTo(Integer value) {
            addCriterion("or_id <=", value, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdIn(List<Integer> values) {
            addCriterion("or_id in", values, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdNotIn(List<Integer> values) {
            addCriterion("or_id not in", values, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdBetween(Integer value1, Integer value2) {
            addCriterion("or_id between", value1, value2, "orId");
            return (Criteria) this;
        }

        public Criteria andOrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("or_id not between", value1, value2, "orId");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNumIsNull() {
            addCriterion("p_num is null");
            return (Criteria) this;
        }

        public Criteria andPNumIsNotNull() {
            addCriterion("p_num is not null");
            return (Criteria) this;
        }

        public Criteria andPNumEqualTo(Integer value) {
            addCriterion("p_num =", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumNotEqualTo(Integer value) {
            addCriterion("p_num <>", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumGreaterThan(Integer value) {
            addCriterion("p_num >", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_num >=", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumLessThan(Integer value) {
            addCriterion("p_num <", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumLessThanOrEqualTo(Integer value) {
            addCriterion("p_num <=", value, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumIn(List<Integer> values) {
            addCriterion("p_num in", values, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumNotIn(List<Integer> values) {
            addCriterion("p_num not in", values, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumBetween(Integer value1, Integer value2) {
            addCriterion("p_num between", value1, value2, "pNum");
            return (Criteria) this;
        }

        public Criteria andPNumNotBetween(Integer value1, Integer value2) {
            addCriterion("p_num not between", value1, value2, "pNum");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNull() {
            addCriterion("p_price is null");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNotNull() {
            addCriterion("p_price is not null");
            return (Criteria) this;
        }

        public Criteria andPPriceEqualTo(Double value) {
            addCriterion("p_price =", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotEqualTo(Double value) {
            addCriterion("p_price <>", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThan(Double value) {
            addCriterion("p_price >", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("p_price >=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThan(Double value) {
            addCriterion("p_price <", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThanOrEqualTo(Double value) {
            addCriterion("p_price <=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceIn(List<Double> values) {
            addCriterion("p_price in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotIn(List<Double> values) {
            addCriterion("p_price not in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceBetween(Double value1, Double value2) {
            addCriterion("p_price between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotBetween(Double value1, Double value2) {
            addCriterion("p_price not between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPTotalIsNull() {
            addCriterion("p_total is null");
            return (Criteria) this;
        }

        public Criteria andPTotalIsNotNull() {
            addCriterion("p_total is not null");
            return (Criteria) this;
        }

        public Criteria andPTotalEqualTo(Double value) {
            addCriterion("p_total =", value, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalNotEqualTo(Double value) {
            addCriterion("p_total <>", value, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalGreaterThan(Double value) {
            addCriterion("p_total >", value, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("p_total >=", value, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalLessThan(Double value) {
            addCriterion("p_total <", value, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalLessThanOrEqualTo(Double value) {
            addCriterion("p_total <=", value, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalIn(List<Double> values) {
            addCriterion("p_total in", values, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalNotIn(List<Double> values) {
            addCriterion("p_total not in", values, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalBetween(Double value1, Double value2) {
            addCriterion("p_total between", value1, value2, "pTotal");
            return (Criteria) this;
        }

        public Criteria andPTotalNotBetween(Double value1, Double value2) {
            addCriterion("p_total not between", value1, value2, "pTotal");
            return (Criteria) this;
        }

        public Criteria andOrTypeIsNull() {
            addCriterion("or_type is null");
            return (Criteria) this;
        }

        public Criteria andOrTypeIsNotNull() {
            addCriterion("or_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrTypeEqualTo(Integer value) {
            addCriterion("or_type =", value, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeNotEqualTo(Integer value) {
            addCriterion("or_type <>", value, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeGreaterThan(Integer value) {
            addCriterion("or_type >", value, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("or_type >=", value, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeLessThan(Integer value) {
            addCriterion("or_type <", value, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("or_type <=", value, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeIn(List<Integer> values) {
            addCriterion("or_type in", values, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeNotIn(List<Integer> values) {
            addCriterion("or_type not in", values, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeBetween(Integer value1, Integer value2) {
            addCriterion("or_type between", value1, value2, "orType");
            return (Criteria) this;
        }

        public Criteria andOrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("or_type not between", value1, value2, "orType");
            return (Criteria) this;
        }

        public Criteria andOrStatusIsNull() {
            addCriterion("or_status is null");
            return (Criteria) this;
        }

        public Criteria andOrStatusIsNotNull() {
            addCriterion("or_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrStatusEqualTo(Integer value) {
            addCriterion("or_status =", value, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusNotEqualTo(Integer value) {
            addCriterion("or_status <>", value, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusGreaterThan(Integer value) {
            addCriterion("or_status >", value, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("or_status >=", value, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusLessThan(Integer value) {
            addCriterion("or_status <", value, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusLessThanOrEqualTo(Integer value) {
            addCriterion("or_status <=", value, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusIn(List<Integer> values) {
            addCriterion("or_status in", values, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusNotIn(List<Integer> values) {
            addCriterion("or_status not in", values, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusBetween(Integer value1, Integer value2) {
            addCriterion("or_status between", value1, value2, "orStatus");
            return (Criteria) this;
        }

        public Criteria andOrStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("or_status not between", value1, value2, "orStatus");
            return (Criteria) this;
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

        public Criteria andOrStartTimeIsNull() {
            addCriterion("or_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeIsNotNull() {
            addCriterion("or_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeEqualTo(Date value) {
            addCriterion("or_start_time =", value, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeNotEqualTo(Date value) {
            addCriterion("or_start_time <>", value, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeGreaterThan(Date value) {
            addCriterion("or_start_time >", value, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("or_start_time >=", value, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeLessThan(Date value) {
            addCriterion("or_start_time <", value, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("or_start_time <=", value, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeIn(List<Date> values) {
            addCriterion("or_start_time in", values, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeNotIn(List<Date> values) {
            addCriterion("or_start_time not in", values, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeBetween(Date value1, Date value2) {
            addCriterion("or_start_time between", value1, value2, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("or_start_time not between", value1, value2, "orStartTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeIsNull() {
            addCriterion("or_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeIsNotNull() {
            addCriterion("or_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeEqualTo(Date value) {
            addCriterion("or_end_time =", value, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeNotEqualTo(Date value) {
            addCriterion("or_end_time <>", value, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeGreaterThan(Date value) {
            addCriterion("or_end_time >", value, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("or_end_time >=", value, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeLessThan(Date value) {
            addCriterion("or_end_time <", value, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("or_end_time <=", value, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeIn(List<Date> values) {
            addCriterion("or_end_time in", values, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeNotIn(List<Date> values) {
            addCriterion("or_end_time not in", values, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeBetween(Date value1, Date value2) {
            addCriterion("or_end_time between", value1, value2, "orEndTime");
            return (Criteria) this;
        }

        public Criteria andOrEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("or_end_time not between", value1, value2, "orEndTime");
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