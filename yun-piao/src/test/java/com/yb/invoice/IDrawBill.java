package com.yb.invoice;

import org.springframework.http.ResponseEntity;

/**
 * @Author: yangb
 * @Description:
 */
//开票接口
public interface IDrawBill<T> {

	ResponseEntity<T> execDrawBill();
}
