package com.dang.seq.dto;

import java.util.Date;

/**
 * @Author huangbojs
 */
public class ApiAuthorizeMapDto {
    
    private long partner_id;
    private long api_id;
    private int is_security;
    private Date creation_date;
    private Date last_changed_date;
    public long getPartner_id() {
        return partner_id;
    }
    public void setPartner_id(long partner_id) {
        this.partner_id = partner_id;
    }
    public long getApi_id() {
        return api_id;
    }
    public void setApi_id(long api_id) {
        this.api_id = api_id;
    }
    public Date getCreation_date() {
        return creation_date;
    }
    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
    public Date getLast_changed_date() {
        return last_changed_date;
    }
    public void setLast_changed_date(Date last_changed_date) {
        this.last_changed_date = last_changed_date;
    }
    public int getIs_security() {
        return is_security;
    }
    public void setIs_security(int is_security) {
        this.is_security = is_security;
    }
    
}
