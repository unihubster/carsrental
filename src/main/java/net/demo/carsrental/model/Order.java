package net.demo.carsrental.model;

import net.demo.carsrental.dao.table.OrderStatusTable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order implements Entity {
    private Long id;
    private Car car;
    private LocalDateTime startRentDate;
    private LocalDateTime endRentDate;
    private String comment;
    private Status status;
    private LocalDateTime createDate;
    private LocalDateTime paidDate;

    public BigDecimal calculateTotalCost() {
        return car.getRentCost();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public enum Status {
        NEW(OrderStatusTable.STATUS_NEW_ID),
        REJECTED(OrderStatusTable.STATUS_REJECTED_ID),
        PAID(OrderStatusTable.STATUS_PAID_ID),
        CANCELED(OrderStatusTable.STATUS_CANCELED_ID);

        public final int statusId;

        Status(int statusId) {
            this.statusId = statusId;
        }
    }
}
