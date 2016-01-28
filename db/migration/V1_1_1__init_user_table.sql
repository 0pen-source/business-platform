CREATE TABLE `user` (
  `id`                    int(11) NOT NULL AUTO_INCREMENT,
  `name`                  char(40) DEFAULT NULL,
  `password`              char(50) DEFAULT NULL,
 CONSTRAINT PRIMARY KEY (`id`)
) ;

INSERT INTO `user` VALUES (1,'chenkaihua','chenkaihua');
INSERT INTO `user` VALUES   (2,'test_user','test');
INSERT INTO `user` VALUES (3,'陈开华','mypassword');
INSERT INTO `user` VALUES (6,'myname','mypass');
INSERT INTO `user` VALUES (7,'chenhua','chss');

CREATE VIEW `v_organization` AS
    SELECT
        `org`.`ID` AS `OrgId`,
        `org`.`Name` AS `OrgName`,
        `org`.`OrgCode` AS `OrgCode`,
        `org`.`Creator` AS `Creator`,
        `org`.`License` AS `License`,
        `org`.`Abbreviation` AS `Abbreviation`,
        `org`.`Acronym` AS `Acronym`,
        `org`.`StartTime` AS `StartTime`,
        `org`.`EndTime` AS `EndTime`,
        `member`.`Name` AS `UserName`,
        `member`.`Password` AS `Password`,
        `member`.`Telphone` AS `Telphone`
    FROM
        (`accounting`.`biz_organization` `org`
        JOIN `accounting`.`biz_member` `member`)
    WHERE
        (`org`.`ID` IN (SELECT
                `bomb`.`OrgID`
            FROM
                `accounting`.`biz_orgmemberbook` `bomb`
            WHERE
                (`bomb`.`MemberID` = `member`.`ID`))
            AND (`org`.`Enable` = 1));

