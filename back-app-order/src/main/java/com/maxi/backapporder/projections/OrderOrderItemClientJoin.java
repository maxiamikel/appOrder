package com.maxi.backapporder.projections;

import java.time.LocalDateTime;

public interface OrderOrderItemClientJoin {
    Long getId();
    String getNome();
    String getEmail();
    LocalDateTime getOrderDate();
    String getStatus();
    String getClient();
    Double getTotal(); 
}
