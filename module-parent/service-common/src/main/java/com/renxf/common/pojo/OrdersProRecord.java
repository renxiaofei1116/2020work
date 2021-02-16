package com.renxf.common.pojo;

import lombok.Data;
import javax.persistence.Table;

@Data
@Table(name = "orders_pro_record")
public class OrdersProRecord {

  private Integer id;
  private Integer ordId;
  private Integer proId;

}
