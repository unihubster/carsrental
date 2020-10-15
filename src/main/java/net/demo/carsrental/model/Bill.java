package net.demo.carsrental.model;

import net.demo.carsrental.dao.table.BillStatusTable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bill implements Entity {
    private Long id;
    private String description;
    private BigDecimal totalCost;
    private Status status;
    private LocalDateTime createDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public enum Status {
        NEW(BillStatusTable.STATUS_NEW_ID),
        PAID(BillStatusTable.STATUS_PAID_ID),
        CANCELED(BillStatusTable.STATUS_CANCELED_ID);

        public final int statusId;

        Status(int statusId) {
            this.statusId = statusId;
        }
    }
}
