package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LimoJoinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LimoJoinExample() {
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

        public Criteria andJIdIsNull() {
            addCriterion("j_id is null");
            return (Criteria) this;
        }

        public Criteria andJIdIsNotNull() {
            addCriterion("j_id is not null");
            return (Criteria) this;
        }

        public Criteria andJIdEqualTo(Integer value) {
            addCriterion("j_id =", value, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdNotEqualTo(Integer value) {
            addCriterion("j_id <>", value, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdGreaterThan(Integer value) {
            addCriterion("j_id >", value, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("j_id >=", value, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdLessThan(Integer value) {
            addCriterion("j_id <", value, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdLessThanOrEqualTo(Integer value) {
            addCriterion("j_id <=", value, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdIn(List<Integer> values) {
            addCriterion("j_id in", values, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdNotIn(List<Integer> values) {
            addCriterion("j_id not in", values, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdBetween(Integer value1, Integer value2) {
            addCriterion("j_id between", value1, value2, "jId");
            return (Criteria) this;
        }

        public Criteria andJIdNotBetween(Integer value1, Integer value2) {
            addCriterion("j_id not between", value1, value2, "jId");
            return (Criteria) this;
        }

        public Criteria andJNameIsNull() {
            addCriterion("j_name is null");
            return (Criteria) this;
        }

        public Criteria andJNameIsNotNull() {
            addCriterion("j_name is not null");
            return (Criteria) this;
        }

        public Criteria andJNameEqualTo(String value) {
            addCriterion("j_name =", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotEqualTo(String value) {
            addCriterion("j_name <>", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameGreaterThan(String value) {
            addCriterion("j_name >", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameGreaterThanOrEqualTo(String value) {
            addCriterion("j_name >=", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameLessThan(String value) {
            addCriterion("j_name <", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameLessThanOrEqualTo(String value) {
            addCriterion("j_name <=", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameLike(String value) {
            addCriterion("j_name like", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotLike(String value) {
            addCriterion("j_name not like", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameIn(List<String> values) {
            addCriterion("j_name in", values, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotIn(List<String> values) {
            addCriterion("j_name not in", values, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameBetween(String value1, String value2) {
            addCriterion("j_name between", value1, value2, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotBetween(String value1, String value2) {
            addCriterion("j_name not between", value1, value2, "jName");
            return (Criteria) this;
        }

        public Criteria andJPhoneIsNull() {
            addCriterion("j_phone is null");
            return (Criteria) this;
        }

        public Criteria andJPhoneIsNotNull() {
            addCriterion("j_phone is not null");
            return (Criteria) this;
        }

        public Criteria andJPhoneEqualTo(String value) {
            addCriterion("j_phone =", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneNotEqualTo(String value) {
            addCriterion("j_phone <>", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneGreaterThan(String value) {
            addCriterion("j_phone >", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("j_phone >=", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneLessThan(String value) {
            addCriterion("j_phone <", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneLessThanOrEqualTo(String value) {
            addCriterion("j_phone <=", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneLike(String value) {
            addCriterion("j_phone like", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneNotLike(String value) {
            addCriterion("j_phone not like", value, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneIn(List<String> values) {
            addCriterion("j_phone in", values, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneNotIn(List<String> values) {
            addCriterion("j_phone not in", values, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneBetween(String value1, String value2) {
            addCriterion("j_phone between", value1, value2, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJPhoneNotBetween(String value1, String value2) {
            addCriterion("j_phone not between", value1, value2, "jPhone");
            return (Criteria) this;
        }

        public Criteria andJSerailIsNull() {
            addCriterion("j_serail is null");
            return (Criteria) this;
        }

        public Criteria andJSerailIsNotNull() {
            addCriterion("j_serail is not null");
            return (Criteria) this;
        }

        public Criteria andJSerailEqualTo(String value) {
            addCriterion("j_serail =", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailNotEqualTo(String value) {
            addCriterion("j_serail <>", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailGreaterThan(String value) {
            addCriterion("j_serail >", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailGreaterThanOrEqualTo(String value) {
            addCriterion("j_serail >=", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailLessThan(String value) {
            addCriterion("j_serail <", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailLessThanOrEqualTo(String value) {
            addCriterion("j_serail <=", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailLike(String value) {
            addCriterion("j_serail like", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailNotLike(String value) {
            addCriterion("j_serail not like", value, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailIn(List<String> values) {
            addCriterion("j_serail in", values, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailNotIn(List<String> values) {
            addCriterion("j_serail not in", values, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailBetween(String value1, String value2) {
            addCriterion("j_serail between", value1, value2, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJSerailNotBetween(String value1, String value2) {
            addCriterion("j_serail not between", value1, value2, "jSerail");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressIsNull() {
            addCriterion("j_limo_address is null");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressIsNotNull() {
            addCriterion("j_limo_address is not null");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressEqualTo(String value) {
            addCriterion("j_limo_address =", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressNotEqualTo(String value) {
            addCriterion("j_limo_address <>", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressGreaterThan(String value) {
            addCriterion("j_limo_address >", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("j_limo_address >=", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressLessThan(String value) {
            addCriterion("j_limo_address <", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressLessThanOrEqualTo(String value) {
            addCriterion("j_limo_address <=", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressLike(String value) {
            addCriterion("j_limo_address like", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressNotLike(String value) {
            addCriterion("j_limo_address not like", value, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressIn(List<String> values) {
            addCriterion("j_limo_address in", values, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressNotIn(List<String> values) {
            addCriterion("j_limo_address not in", values, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressBetween(String value1, String value2) {
            addCriterion("j_limo_address between", value1, value2, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoAddressNotBetween(String value1, String value2) {
            addCriterion("j_limo_address not between", value1, value2, "jLimoAddress");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeIsNull() {
            addCriterion("j_limo_type is null");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeIsNotNull() {
            addCriterion("j_limo_type is not null");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeEqualTo(String value) {
            addCriterion("j_limo_type =", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeNotEqualTo(String value) {
            addCriterion("j_limo_type <>", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeGreaterThan(String value) {
            addCriterion("j_limo_type >", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("j_limo_type >=", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeLessThan(String value) {
            addCriterion("j_limo_type <", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeLessThanOrEqualTo(String value) {
            addCriterion("j_limo_type <=", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeLike(String value) {
            addCriterion("j_limo_type like", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeNotLike(String value) {
            addCriterion("j_limo_type not like", value, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeIn(List<String> values) {
            addCriterion("j_limo_type in", values, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeNotIn(List<String> values) {
            addCriterion("j_limo_type not in", values, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeBetween(String value1, String value2) {
            addCriterion("j_limo_type between", value1, value2, "jLimoType");
            return (Criteria) this;
        }

        public Criteria andJLimoTypeNotBetween(String value1, String value2) {
            addCriterion("j_limo_type not between", value1, value2, "jLimoType");
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

        public Criteria andJCardImagesIsNull() {
            addCriterion("j_card_images is null");
            return (Criteria) this;
        }

        public Criteria andJCardImagesIsNotNull() {
            addCriterion("j_card_images is not null");
            return (Criteria) this;
        }

        public Criteria andJCardImagesEqualTo(String value) {
            addCriterion("j_card_images =", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesNotEqualTo(String value) {
            addCriterion("j_card_images <>", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesGreaterThan(String value) {
            addCriterion("j_card_images >", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesGreaterThanOrEqualTo(String value) {
            addCriterion("j_card_images >=", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesLessThan(String value) {
            addCriterion("j_card_images <", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesLessThanOrEqualTo(String value) {
            addCriterion("j_card_images <=", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesLike(String value) {
            addCriterion("j_card_images like", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesNotLike(String value) {
            addCriterion("j_card_images not like", value, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesIn(List<String> values) {
            addCriterion("j_card_images in", values, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesNotIn(List<String> values) {
            addCriterion("j_card_images not in", values, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesBetween(String value1, String value2) {
            addCriterion("j_card_images between", value1, value2, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJCardImagesNotBetween(String value1, String value2) {
            addCriterion("j_card_images not between", value1, value2, "jCardImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesIsNull() {
            addCriterion("j_limo_images is null");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesIsNotNull() {
            addCriterion("j_limo_images is not null");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesEqualTo(String value) {
            addCriterion("j_limo_images =", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesNotEqualTo(String value) {
            addCriterion("j_limo_images <>", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesGreaterThan(String value) {
            addCriterion("j_limo_images >", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesGreaterThanOrEqualTo(String value) {
            addCriterion("j_limo_images >=", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesLessThan(String value) {
            addCriterion("j_limo_images <", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesLessThanOrEqualTo(String value) {
            addCriterion("j_limo_images <=", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesLike(String value) {
            addCriterion("j_limo_images like", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesNotLike(String value) {
            addCriterion("j_limo_images not like", value, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesIn(List<String> values) {
            addCriterion("j_limo_images in", values, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesNotIn(List<String> values) {
            addCriterion("j_limo_images not in", values, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesBetween(String value1, String value2) {
            addCriterion("j_limo_images between", value1, value2, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJLimoImagesNotBetween(String value1, String value2) {
            addCriterion("j_limo_images not between", value1, value2, "jLimoImages");
            return (Criteria) this;
        }

        public Criteria andJStartTimeIsNull() {
            addCriterion("j_start_time is null");
            return (Criteria) this;
        }

        public Criteria andJStartTimeIsNotNull() {
            addCriterion("j_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andJStartTimeEqualTo(Date value) {
            addCriterion("j_start_time =", value, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeNotEqualTo(Date value) {
            addCriterion("j_start_time <>", value, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeGreaterThan(Date value) {
            addCriterion("j_start_time >", value, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("j_start_time >=", value, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeLessThan(Date value) {
            addCriterion("j_start_time <", value, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("j_start_time <=", value, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeIn(List<Date> values) {
            addCriterion("j_start_time in", values, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeNotIn(List<Date> values) {
            addCriterion("j_start_time not in", values, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeBetween(Date value1, Date value2) {
            addCriterion("j_start_time between", value1, value2, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("j_start_time not between", value1, value2, "jStartTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeIsNull() {
            addCriterion("j_end_time is null");
            return (Criteria) this;
        }

        public Criteria andJEndTimeIsNotNull() {
            addCriterion("j_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andJEndTimeEqualTo(Date value) {
            addCriterion("j_end_time =", value, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeNotEqualTo(Date value) {
            addCriterion("j_end_time <>", value, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeGreaterThan(Date value) {
            addCriterion("j_end_time >", value, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("j_end_time >=", value, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeLessThan(Date value) {
            addCriterion("j_end_time <", value, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("j_end_time <=", value, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeIn(List<Date> values) {
            addCriterion("j_end_time in", values, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeNotIn(List<Date> values) {
            addCriterion("j_end_time not in", values, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeBetween(Date value1, Date value2) {
            addCriterion("j_end_time between", value1, value2, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("j_end_time not between", value1, value2, "jEndTime");
            return (Criteria) this;
        }

        public Criteria andJTypeIsNull() {
            addCriterion("j_type is null");
            return (Criteria) this;
        }

        public Criteria andJTypeIsNotNull() {
            addCriterion("j_type is not null");
            return (Criteria) this;
        }

        public Criteria andJTypeEqualTo(Integer value) {
            addCriterion("j_type =", value, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeNotEqualTo(Integer value) {
            addCriterion("j_type <>", value, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeGreaterThan(Integer value) {
            addCriterion("j_type >", value, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("j_type >=", value, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeLessThan(Integer value) {
            addCriterion("j_type <", value, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeLessThanOrEqualTo(Integer value) {
            addCriterion("j_type <=", value, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeIn(List<Integer> values) {
            addCriterion("j_type in", values, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeNotIn(List<Integer> values) {
            addCriterion("j_type not in", values, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeBetween(Integer value1, Integer value2) {
            addCriterion("j_type between", value1, value2, "jType");
            return (Criteria) this;
        }

        public Criteria andJTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("j_type not between", value1, value2, "jType");
            return (Criteria) this;
        }

        public Criteria andJEmailIsNull() {
            addCriterion("j_email is null");
            return (Criteria) this;
        }

        public Criteria andJEmailIsNotNull() {
            addCriterion("j_email is not null");
            return (Criteria) this;
        }

        public Criteria andJEmailEqualTo(String value) {
            addCriterion("j_email =", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailNotEqualTo(String value) {
            addCriterion("j_email <>", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailGreaterThan(String value) {
            addCriterion("j_email >", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailGreaterThanOrEqualTo(String value) {
            addCriterion("j_email >=", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailLessThan(String value) {
            addCriterion("j_email <", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailLessThanOrEqualTo(String value) {
            addCriterion("j_email <=", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailLike(String value) {
            addCriterion("j_email like", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailNotLike(String value) {
            addCriterion("j_email not like", value, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailIn(List<String> values) {
            addCriterion("j_email in", values, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailNotIn(List<String> values) {
            addCriterion("j_email not in", values, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailBetween(String value1, String value2) {
            addCriterion("j_email between", value1, value2, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJEmailNotBetween(String value1, String value2) {
            addCriterion("j_email not between", value1, value2, "jEmail");
            return (Criteria) this;
        }

        public Criteria andJRemarkIsNull() {
            addCriterion("j_remark is null");
            return (Criteria) this;
        }

        public Criteria andJRemarkIsNotNull() {
            addCriterion("j_remark is not null");
            return (Criteria) this;
        }

        public Criteria andJRemarkEqualTo(String value) {
            addCriterion("j_remark =", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkNotEqualTo(String value) {
            addCriterion("j_remark <>", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkGreaterThan(String value) {
            addCriterion("j_remark >", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("j_remark >=", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkLessThan(String value) {
            addCriterion("j_remark <", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkLessThanOrEqualTo(String value) {
            addCriterion("j_remark <=", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkLike(String value) {
            addCriterion("j_remark like", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkNotLike(String value) {
            addCriterion("j_remark not like", value, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkIn(List<String> values) {
            addCriterion("j_remark in", values, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkNotIn(List<String> values) {
            addCriterion("j_remark not in", values, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkBetween(String value1, String value2) {
            addCriterion("j_remark between", value1, value2, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJRemarkNotBetween(String value1, String value2) {
            addCriterion("j_remark not between", value1, value2, "jRemark");
            return (Criteria) this;
        }

        public Criteria andJCampNameIsNull() {
            addCriterion("j_camp_name is null");
            return (Criteria) this;
        }

        public Criteria andJCampNameIsNotNull() {
            addCriterion("j_camp_name is not null");
            return (Criteria) this;
        }

        public Criteria andJCampNameEqualTo(String value) {
            addCriterion("j_camp_name =", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameNotEqualTo(String value) {
            addCriterion("j_camp_name <>", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameGreaterThan(String value) {
            addCriterion("j_camp_name >", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameGreaterThanOrEqualTo(String value) {
            addCriterion("j_camp_name >=", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameLessThan(String value) {
            addCriterion("j_camp_name <", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameLessThanOrEqualTo(String value) {
            addCriterion("j_camp_name <=", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameLike(String value) {
            addCriterion("j_camp_name like", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameNotLike(String value) {
            addCriterion("j_camp_name not like", value, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameIn(List<String> values) {
            addCriterion("j_camp_name in", values, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameNotIn(List<String> values) {
            addCriterion("j_camp_name not in", values, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameBetween(String value1, String value2) {
            addCriterion("j_camp_name between", value1, value2, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJCampNameNotBetween(String value1, String value2) {
            addCriterion("j_camp_name not between", value1, value2, "jCampName");
            return (Criteria) this;
        }

        public Criteria andJStatusIsNull() {
            addCriterion("j_status is null");
            return (Criteria) this;
        }

        public Criteria andJStatusIsNotNull() {
            addCriterion("j_status is not null");
            return (Criteria) this;
        }

        public Criteria andJStatusEqualTo(Integer value) {
            addCriterion("j_status =", value, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusNotEqualTo(Integer value) {
            addCriterion("j_status <>", value, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusGreaterThan(Integer value) {
            addCriterion("j_status >", value, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("j_status >=", value, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusLessThan(Integer value) {
            addCriterion("j_status <", value, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusLessThanOrEqualTo(Integer value) {
            addCriterion("j_status <=", value, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusIn(List<Integer> values) {
            addCriterion("j_status in", values, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusNotIn(List<Integer> values) {
            addCriterion("j_status not in", values, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusBetween(Integer value1, Integer value2) {
            addCriterion("j_status between", value1, value2, "jStatus");
            return (Criteria) this;
        }

        public Criteria andJStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("j_status not between", value1, value2, "jStatus");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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