use zeus;
CREATE TABLE `board` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `board_name` VARCHAR(150) NOT NULL DEFAULT '' COMMENT '论坛板块名称',
  `board_desc` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '论坛板块描述',
  `topic_num` int(11) NOT NULL DEFAULT 0 COMMENT '帖子数目',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '论坛板块表';

CREATE TABLE `board_manager` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `board_id` int(11) UNSIGNED NOT NULL COMMENT '板块id',
  `user_id` int (11) UNSIGNED NOT NULL COMMENT '用户id',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_board_user` (`board_id`, `user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户管理板块关联表';

CREATE TABLE `topic` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `board_id` int(11) UNSIGNED NOT NULL COMMENT '所属板块id',
  `topic_title` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '话题标题',
  `user_id` int (11) UNSIGNED NOT NULL COMMENT '发表用户id',
  `last_post_time` DATETIME DEFAULT NULL COMMENT '最后回复时间',
  `topic_views` int(11) NOT NULL DEFAULT 0 COMMENT '浏览数',
  `topic_replies` int(11) NOT NULL DEFAULT 0 COMMENT '回复数',
  `digest` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '0 不是精华话题, 1是精华话题',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '话题表';

CREATE TABLE `post` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `board_id` int(11) UNSIGNED NOT NULL COMMENT '所属板块id',
  `topic_id` int(11) UNSIGNED NOT NULL COMMENT '所属话题id',
  `user_id` int (11) UNSIGNED NOT NULL COMMENT '发表用户id',
  `post_type` TINYINT(4) NOT NULL DEFAULT 1 COMMENT '0主帖子,１回复帖子',
  `post_title` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '帖子标题',
  `post_text` text COMMENT '帖子内容',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '帖子表';

CREATE TABLE `user` (
  `user_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(128) NOT NULL COMMENT '用户密码',
  `user_type` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '0普通用户, 1管理员',
  `locked` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '0未锁定, １已锁定',
  `credit` int(11) NOT NULL DEFAULT 0 COMMENT '积分',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

CREATE TABLE `login_log` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '用户id',
  `ip` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '登录ip',
  `login_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '登录日志';