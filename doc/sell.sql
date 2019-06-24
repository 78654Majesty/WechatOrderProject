CREATE TABLE `order_detail` (
  `detail_id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `order_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '������',
  `product_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '��Ʒid',
  `product_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT 'Ʒ����',
  `product_price` decimal(8,2) DEFAULT NULL COMMENT '��Ʒ�۸�',
  `product_quantity` int(11) NOT NULL COMMENT '��Ʒ����',
  `product_icon` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '��ƷСͼ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
  PRIMARY KEY (`detail_id`),
  UNIQUE KEY `uqe_order_id` (`order_id`),
  UNIQUE KEY `uqe_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='���������';

CREATE TABLE `orderMaster` (
  `order_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '������',
  `buyer_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '�������',
  `buyer_phone` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '��ҵ绰',
  `buyer_address` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '����ջ��ַ',
  `buyer_openid` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '���΢��',
  `order_amount` decimal(8,2) NOT NULL COMMENT '�����ܽ��',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '����״̬',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '֧��״̬ 0=δ֧��',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `uqe_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='������';

CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '��Ŀ����',
  `category_type` int(11) NOT NULL COMMENT '��Ŀ���',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='��Ŀ��';

CREATE TABLE `product_info` (
  `product_id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `product_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '��Ʒ����',
  `product_price` decimal(8,2) NOT NULL COMMENT '����',
  `product_stock` int(11) NOT NULL COMMENT '���',
  `product_icon` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'Сͼ',
  `category_type` int(11) NOT NULL COMMENT '��Ʒ���',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='��Ʒ��';

CREATE TABLE `seller_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '�̼ҵ���',
  `seller_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '�̼�����',
  `seller_password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '�̼�����',
  `seller_openid` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '�̼�΢��',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uqe_order_id` (`seller_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='�̼���Ϣ';