package com.doublerice.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author songzhuoqi
 * @email sunlightcs@gmail.com
 * @date 2019-04-26 12:37:07
 */
@Data
@TableName("tb_terrace_involved")
public class TerraceInvolvedEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 表主键
	 */
	@TableId
	private String id;
	/**
	 * 用户账号
	 */
	private String userId;
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 维权说明
	 */
	private String rightExplain;
	/**
	 * 申请时间
	 */
	private Date createTime;
	/**
	 * 处理记录
	 */
	private String dealRecord;
	/**
	 * 最后处理时间
	 */
	private Date lastDealTime;
	/**
	 * 状态 1.待处理 2.处理中 3.已解约 4.已赔付买方 5.已赔付卖方
	 */
	private Integer status;
	/**
	 * 最后操作账号
	 */
	private String lastAccount;
	/**
	 * 操作状态1.赔付买方2.赔付卖方3.和平解约
	 */
	private Integer operateStatus;
	/**
	 * 照片路径
	 */
	private String picUrl;

}
