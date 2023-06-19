package com.maxi.backapporder.projections;

import java.time.LocalDate;

public interface ClientOrderJoin {
    String getEmail();
    String getNome();
    String getStatus();
    LocalDate getOrderDate();
    Double total();
}
