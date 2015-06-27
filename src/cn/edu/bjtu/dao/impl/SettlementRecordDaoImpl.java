package cn.edu.bjtu.dao.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.SettlementRecordDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Settlement;
@Repository
public class SettlementRecordDaoImpl extends BaseDaoImpl<Settlement> implements SettlementRecordDao{
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderService orderService;
	
}
