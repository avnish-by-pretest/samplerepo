package com.example.sampletest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capacity {
    String storeNo;
    String productId;
    Date date;
    Double noOfOrdersAccepted;
}
