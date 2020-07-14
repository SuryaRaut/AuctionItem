package com.example.auctionproject.dto;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class AuctionDTO {
    private long id;
    public String itemId;
    public String description;
    public AuctionDTO(){}
    public AuctionDTO(String itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
