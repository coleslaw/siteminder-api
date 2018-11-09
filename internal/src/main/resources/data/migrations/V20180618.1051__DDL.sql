CREATE TABLE `RunTimeConfig` (
`urn` varchar(75) NOT NULL DEFAULT '',
`configKey` varchar(100) DEFAULT NULL COMMENT 'key of the configuration ',
`configValue` varchar(100) DEFAULT NULL COMMENT 'value of the configuration ',
`environment` varchar(100) DEFAULT NULL COMMENT 'devployed environment ',
`system` int(50) DEFAULT NULL COMMENT 'its the client id,eg,. 1',
`subsystem` varchar(100) DEFAULT NULL COMMENT 'to subtype of a client, eg., PRES, ROYAL',
`active` tinyint(1) DEFAULT '0' COMMENT 'is configuration active',
`activeFrom` bigint(20) DEFAULT NULL COMMENT 'start date of activation ',
`activeTo` bigint(20) DEFAULT NULL COMMENT 'end date of activation ',
`created` bigint(20) DEFAULT NULL,
`updated` bigint(20) DEFAULT NULL,
`tag` varchar(20) DEFAULT NULL COMMENT 'to identify the group of configs, eg,. QUEUE',
`encrypted` tinyint(1) DEFAULT '0' COMMENT 'is configuration encrypted',
PRIMARY KEY (`urn`),
KEY `TAG_INDEX` (`tag`),
KEY `KEY_INDEX` (`configKey`),
KEY `KEY_ENV_INDEX` (`configKey`,`environment`,`system`,`subsystem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Account` (
`account_id` varchar(50) NOT NULL,
`name` varchar(255) DEFAULT NULL COMMENT 'its the client name,eg,. ILH',
`created` bigint(20) DEFAULT NULL,
`modified` bigint(20) DEFAULT NULL,
`version` int(11) DEFAULT NULL,
`isDeleted` tinyint(1) DEFAULT '0',
`isActive` tinyint(1) DEFAULT '1',
PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `System` (
`system_id` int(11)  NOT NULL AUTO_INCREMENT,
`account_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
`name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'to subtype of a client, eg., PRES, ROYAL',
`apiKey` varchar(255) COLLATE utf8_bin DEFAULT NULL,
`systemCode` varchar(50) COLLATE utf8_bin DEFAULT NULL,
`startDate` bigint(20) NOT NULL,
`endDate` bigint(20) NOT NULL,
`isActive` tinyint(1) DEFAULT '1',
`created` bigint(20) DEFAULT NULL,
`modified` bigint(20) DEFAULT NULL,
`version` int(11) DEFAULT '0',
`isDeleted` tinyint(1) DEFAULT '0',
PRIMARY KEY (`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




