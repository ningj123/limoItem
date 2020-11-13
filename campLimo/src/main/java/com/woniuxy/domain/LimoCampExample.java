package com.woniuxy.domain;

import java.util.ArrayList;
import java.util.List;

public class LimoCampExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LimoCampExample() {
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

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCAddressIsNull() {
            addCriterion("c_address is null");
            return (Criteria) this;
        }

        public Criteria andCAddressIsNotNull() {
            addCriterion("c_address is not null");
            return (Criteria) this;
        }

        public Criteria andCAddressEqualTo(String value) {
            addCriterion("c_address =", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotEqualTo(String value) {
            addCriterion("c_address <>", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressGreaterThan(String value) {
            addCriterion("c_address >", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressGreaterThanOrEqualTo(String value) {
            addCriterion("c_address >=", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressLessThan(String value) {
            addCriterion("c_address <", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressLessThanOrEqualTo(String value) {
            addCriterion("c_address <=", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressLike(String value) {
            addCriterion("c_address like", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotLike(String value) {
            addCriterion("c_address not like", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressIn(List<String> values) {
            addCriterion("c_address in", values, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotIn(List<String> values) {
            addCriterion("c_address not in", values, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressBetween(String value1, String value2) {
            addCriterion("c_address between", value1, value2, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotBetween(String value1, String value2) {
            addCriterion("c_address not between", value1, value2, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCPhoneIsNull() {
            addCriterion("c_phone is null");
            return (Criteria) this;
        }

        public Criteria andCPhoneIsNotNull() {
            addCriterion("c_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCPhoneEqualTo(String value) {
            addCriterion("c_phone =", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneNotEqualTo(String value) {
            addCriterion("c_phone <>", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneGreaterThan(String value) {
            addCriterion("c_phone >", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("c_phone >=", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneLessThan(String value) {
            addCriterion("c_phone <", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneLessThanOrEqualTo(String value) {
            addCriterion("c_phone <=", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneLike(String value) {
            addCriterion("c_phone like", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneNotLike(String value) {
            addCriterion("c_phone not like", value, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneIn(List<String> values) {
            addCriterion("c_phone in", values, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneNotIn(List<String> values) {
            addCriterion("c_phone not in", values, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneBetween(String value1, String value2) {
            addCriterion("c_phone between", value1, value2, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCPhoneNotBetween(String value1, String value2) {
            addCriterion("c_phone not between", value1, value2, "cPhone");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeIsNull() {
            addCriterion("c_open_time is null");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeIsNotNull() {
            addCriterion("c_open_time is not null");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeEqualTo(String value) {
            addCriterion("c_open_time =", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeNotEqualTo(String value) {
            addCriterion("c_open_time <>", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeGreaterThan(String value) {
            addCriterion("c_open_time >", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("c_open_time >=", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeLessThan(String value) {
            addCriterion("c_open_time <", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("c_open_time <=", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeLike(String value) {
            addCriterion("c_open_time like", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeNotLike(String value) {
            addCriterion("c_open_time not like", value, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeIn(List<String> values) {
            addCriterion("c_open_time in", values, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeNotIn(List<String> values) {
            addCriterion("c_open_time not in", values, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeBetween(String value1, String value2) {
            addCriterion("c_open_time between", value1, value2, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCOpenTimeNotBetween(String value1, String value2) {
            addCriterion("c_open_time not between", value1, value2, "cOpenTime");
            return (Criteria) this;
        }

        public Criteria andCSpecialIsNull() {
            addCriterion("c_special is null");
            return (Criteria) this;
        }

        public Criteria andCSpecialIsNotNull() {
            addCriterion("c_special is not null");
            return (Criteria) this;
        }

        public Criteria andCSpecialEqualTo(String value) {
            addCriterion("c_special =", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialNotEqualTo(String value) {
            addCriterion("c_special <>", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialGreaterThan(String value) {
            addCriterion("c_special >", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialGreaterThanOrEqualTo(String value) {
            addCriterion("c_special >=", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialLessThan(String value) {
            addCriterion("c_special <", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialLessThanOrEqualTo(String value) {
            addCriterion("c_special <=", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialLike(String value) {
            addCriterion("c_special like", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialNotLike(String value) {
            addCriterion("c_special not like", value, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialIn(List<String> values) {
            addCriterion("c_special in", values, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialNotIn(List<String> values) {
            addCriterion("c_special not in", values, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialBetween(String value1, String value2) {
            addCriterion("c_special between", value1, value2, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCSpecialNotBetween(String value1, String value2) {
            addCriterion("c_special not between", value1, value2, "cSpecial");
            return (Criteria) this;
        }

        public Criteria andCCityIsNull() {
            addCriterion("c_city is null");
            return (Criteria) this;
        }

        public Criteria andCCityIsNotNull() {
            addCriterion("c_city is not null");
            return (Criteria) this;
        }

        public Criteria andCCityEqualTo(String value) {
            addCriterion("c_city =", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotEqualTo(String value) {
            addCriterion("c_city <>", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityGreaterThan(String value) {
            addCriterion("c_city >", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityGreaterThanOrEqualTo(String value) {
            addCriterion("c_city >=", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityLessThan(String value) {
            addCriterion("c_city <", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityLessThanOrEqualTo(String value) {
            addCriterion("c_city <=", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityLike(String value) {
            addCriterion("c_city like", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotLike(String value) {
            addCriterion("c_city not like", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityIn(List<String> values) {
            addCriterion("c_city in", values, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotIn(List<String> values) {
            addCriterion("c_city not in", values, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityBetween(String value1, String value2) {
            addCriterion("c_city between", value1, value2, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotBetween(String value1, String value2) {
            addCriterion("c_city not between", value1, value2, "cCity");
            return (Criteria) this;
        }

        public Criteria andCDesIsNull() {
            addCriterion("c_des is null");
            return (Criteria) this;
        }

        public Criteria andCDesIsNotNull() {
            addCriterion("c_des is not null");
            return (Criteria) this;
        }

        public Criteria andCDesEqualTo(String value) {
            addCriterion("c_des =", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesNotEqualTo(String value) {
            addCriterion("c_des <>", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesGreaterThan(String value) {
            addCriterion("c_des >", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesGreaterThanOrEqualTo(String value) {
            addCriterion("c_des >=", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesLessThan(String value) {
            addCriterion("c_des <", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesLessThanOrEqualTo(String value) {
            addCriterion("c_des <=", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesLike(String value) {
            addCriterion("c_des like", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesNotLike(String value) {
            addCriterion("c_des not like", value, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesIn(List<String> values) {
            addCriterion("c_des in", values, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesNotIn(List<String> values) {
            addCriterion("c_des not in", values, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesBetween(String value1, String value2) {
            addCriterion("c_des between", value1, value2, "cDes");
            return (Criteria) this;
        }

        public Criteria andCDesNotBetween(String value1, String value2) {
            addCriterion("c_des not between", value1, value2, "cDes");
            return (Criteria) this;
        }

        public Criteria andCImagesIsNull() {
            addCriterion("c_images is null");
            return (Criteria) this;
        }

        public Criteria andCImagesIsNotNull() {
            addCriterion("c_images is not null");
            return (Criteria) this;
        }

        public Criteria andCImagesEqualTo(String value) {
            addCriterion("c_images =", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesNotEqualTo(String value) {
            addCriterion("c_images <>", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesGreaterThan(String value) {
            addCriterion("c_images >", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesGreaterThanOrEqualTo(String value) {
            addCriterion("c_images >=", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesLessThan(String value) {
            addCriterion("c_images <", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesLessThanOrEqualTo(String value) {
            addCriterion("c_images <=", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesLike(String value) {
            addCriterion("c_images like", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesNotLike(String value) {
            addCriterion("c_images not like", value, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesIn(List<String> values) {
            addCriterion("c_images in", values, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesNotIn(List<String> values) {
            addCriterion("c_images not in", values, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesBetween(String value1, String value2) {
            addCriterion("c_images between", value1, value2, "cImages");
            return (Criteria) this;
        }

        public Criteria andCImagesNotBetween(String value1, String value2) {
            addCriterion("c_images not between", value1, value2, "cImages");
            return (Criteria) this;
        }

        public Criteria andCStatusIsNull() {
            addCriterion("c_status is null");
            return (Criteria) this;
        }

        public Criteria andCStatusIsNotNull() {
            addCriterion("c_status is not null");
            return (Criteria) this;
        }

        public Criteria andCStatusEqualTo(Integer value) {
            addCriterion("c_status =", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotEqualTo(Integer value) {
            addCriterion("c_status <>", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusGreaterThan(Integer value) {
            addCriterion("c_status >", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_status >=", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLessThan(Integer value) {
            addCriterion("c_status <", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLessThanOrEqualTo(Integer value) {
            addCriterion("c_status <=", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusIn(List<Integer> values) {
            addCriterion("c_status in", values, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotIn(List<Integer> values) {
            addCriterion("c_status not in", values, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusBetween(Integer value1, Integer value2) {
            addCriterion("c_status between", value1, value2, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("c_status not between", value1, value2, "cStatus");
            return (Criteria) this;
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

        public Criteria andCOneIsNull() {
            addCriterion("c_one is null");
            return (Criteria) this;
        }

        public Criteria andCOneIsNotNull() {
            addCriterion("c_one is not null");
            return (Criteria) this;
        }

        public Criteria andCOneEqualTo(String value) {
            addCriterion("c_one =", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneNotEqualTo(String value) {
            addCriterion("c_one <>", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneGreaterThan(String value) {
            addCriterion("c_one >", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneGreaterThanOrEqualTo(String value) {
            addCriterion("c_one >=", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneLessThan(String value) {
            addCriterion("c_one <", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneLessThanOrEqualTo(String value) {
            addCriterion("c_one <=", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneLike(String value) {
            addCriterion("c_one like", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneNotLike(String value) {
            addCriterion("c_one not like", value, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneIn(List<String> values) {
            addCriterion("c_one in", values, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneNotIn(List<String> values) {
            addCriterion("c_one not in", values, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneBetween(String value1, String value2) {
            addCriterion("c_one between", value1, value2, "cOne");
            return (Criteria) this;
        }

        public Criteria andCOneNotBetween(String value1, String value2) {
            addCriterion("c_one not between", value1, value2, "cOne");
            return (Criteria) this;
        }

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
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