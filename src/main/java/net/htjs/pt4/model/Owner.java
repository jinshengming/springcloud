package net.htjs.pt4.model;

import java.util.Date;

public class Owner {
    private Integer id;

    private String name;

    private String idCard;

    private String detailAddress;

    private String phone;

    private Integer carNum;

    private Long roomArea;

    private Long waterPrice;

    private Long propertyPrice;

    private Date propertyFeeDate;

    private Long simplePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Long getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(Long roomArea) {
        this.roomArea = roomArea;
    }

    public Long getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(Long waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Long getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Long propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public Date getPropertyFeeDate() {
        return propertyFeeDate;
    }

    public void setPropertyFeeDate(Date propertyFeeDate) {
        this.propertyFeeDate = propertyFeeDate;
    }

    public Long getSimplePrice() {
        return simplePrice;
    }

    public void setSimplePrice(Long simplePrice) {
        this.simplePrice = simplePrice;
    }
}