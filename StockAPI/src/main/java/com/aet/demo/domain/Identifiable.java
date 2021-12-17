package com.aet.demo.domain;

public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {

    public void setId(Long id);

    public void setCreateDate(String createDate);
    
    public void setLastupdateDate(String lastupdateDate);
}
