package com.renxf.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "orders")
public class Orders {

  private long id;
  private long type;
  private java.sql.Timestamp createdAt;
  @TableField(exist = false)
  private List<Products> productsList;
}
