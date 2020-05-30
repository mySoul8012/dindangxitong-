package com.ming.demo.web.rider;

import com.ming.demo.bean.Result;
import com.ming.demo.model.Order;
import com.ming.demo.model.Rider;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Administrator
 */
public interface RiderController {

    /**
     * 骑手登录
     * @return
     */
    public Result login(HttpServletResponse response, String id, String password);

    // 骑手查看订单
    // 获取骑手信息
    public Rider getRider(String username);

    // 骑手查看订单
    public List<Order> findRiderOrder(String username, int pageNo, int pageSize);

    // 接单更改订单状态为未服务。并写入订单历史记录。传入订单id
    public Result updateStatesOrder(String orderId, String userId);
}
