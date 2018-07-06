package net.htjs.pt4.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OwnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OwnerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNull() {
            addCriterion("car_num is null");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNotNull() {
            addCriterion("car_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumEqualTo(Integer value) {
            addCriterion("car_num =", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotEqualTo(Integer value) {
            addCriterion("car_num <>", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThan(Integer value) {
            addCriterion("car_num >", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_num >=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThan(Integer value) {
            addCriterion("car_num <", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThanOrEqualTo(Integer value) {
            addCriterion("car_num <=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumIn(List<Integer> values) {
            addCriterion("car_num in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotIn(List<Integer> values) {
            addCriterion("car_num not in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumBetween(Integer value1, Integer value2) {
            addCriterion("car_num between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotBetween(Integer value1, Integer value2) {
            addCriterion("car_num not between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIsNull() {
            addCriterion("room_area is null");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIsNotNull() {
            addCriterion("room_area is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAreaEqualTo(Long value) {
            addCriterion("room_area =", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotEqualTo(Long value) {
            addCriterion("room_area <>", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaGreaterThan(Long value) {
            addCriterion("room_area >", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaGreaterThanOrEqualTo(Long value) {
            addCriterion("room_area >=", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLessThan(Long value) {
            addCriterion("room_area <", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLessThanOrEqualTo(Long value) {
            addCriterion("room_area <=", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIn(List<Long> values) {
            addCriterion("room_area in", values, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotIn(List<Long> values) {
            addCriterion("room_area not in", values, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaBetween(Long value1, Long value2) {
            addCriterion("room_area between", value1, value2, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotBetween(Long value1, Long value2) {
            addCriterion("room_area not between", value1, value2, "roomArea");
            return (Criteria) this;
        }

        public Criteria andWaterPriceIsNull() {
            addCriterion("water_price is null");
            return (Criteria) this;
        }

        public Criteria andWaterPriceIsNotNull() {
            addCriterion("water_price is not null");
            return (Criteria) this;
        }

        public Criteria andWaterPriceEqualTo(Long value) {
            addCriterion("water_price =", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceNotEqualTo(Long value) {
            addCriterion("water_price <>", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceGreaterThan(Long value) {
            addCriterion("water_price >", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("water_price >=", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceLessThan(Long value) {
            addCriterion("water_price <", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceLessThanOrEqualTo(Long value) {
            addCriterion("water_price <=", value, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceIn(List<Long> values) {
            addCriterion("water_price in", values, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceNotIn(List<Long> values) {
            addCriterion("water_price not in", values, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceBetween(Long value1, Long value2) {
            addCriterion("water_price between", value1, value2, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andWaterPriceNotBetween(Long value1, Long value2) {
            addCriterion("water_price not between", value1, value2, "waterPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIsNull() {
            addCriterion("property_price is null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIsNotNull() {
            addCriterion("property_price is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceEqualTo(Long value) {
            addCriterion("property_price =", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotEqualTo(Long value) {
            addCriterion("property_price <>", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThan(Long value) {
            addCriterion("property_price >", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("property_price >=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThan(Long value) {
            addCriterion("property_price <", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThanOrEqualTo(Long value) {
            addCriterion("property_price <=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIn(List<Long> values) {
            addCriterion("property_price in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotIn(List<Long> values) {
            addCriterion("property_price not in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceBetween(Long value1, Long value2) {
            addCriterion("property_price between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotBetween(Long value1, Long value2) {
            addCriterion("property_price not between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateIsNull() {
            addCriterion("property_fee_date is null");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateIsNotNull() {
            addCriterion("property_fee_date is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateEqualTo(Date value) {
            addCriterionForJDBCDate("property_fee_date =", value, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("property_fee_date <>", value, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("property_fee_date >", value, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("property_fee_date >=", value, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateLessThan(Date value) {
            addCriterionForJDBCDate("property_fee_date <", value, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("property_fee_date <=", value, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateIn(List<Date> values) {
            addCriterionForJDBCDate("property_fee_date in", values, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("property_fee_date not in", values, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("property_fee_date between", value1, value2, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andPropertyFeeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("property_fee_date not between", value1, value2, "propertyFeeDate");
            return (Criteria) this;
        }

        public Criteria andSimplePriceIsNull() {
            addCriterion("simple_price is null");
            return (Criteria) this;
        }

        public Criteria andSimplePriceIsNotNull() {
            addCriterion("simple_price is not null");
            return (Criteria) this;
        }

        public Criteria andSimplePriceEqualTo(Long value) {
            addCriterion("simple_price =", value, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceNotEqualTo(Long value) {
            addCriterion("simple_price <>", value, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceGreaterThan(Long value) {
            addCriterion("simple_price >", value, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceGreaterThanOrEqualTo(Long value) {
            addCriterion("simple_price >=", value, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceLessThan(Long value) {
            addCriterion("simple_price <", value, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceLessThanOrEqualTo(Long value) {
            addCriterion("simple_price <=", value, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceIn(List<Long> values) {
            addCriterion("simple_price in", values, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceNotIn(List<Long> values) {
            addCriterion("simple_price not in", values, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceBetween(Long value1, Long value2) {
            addCriterion("simple_price between", value1, value2, "simplePrice");
            return (Criteria) this;
        }

        public Criteria andSimplePriceNotBetween(Long value1, Long value2) {
            addCriterion("simple_price not between", value1, value2, "simplePrice");
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