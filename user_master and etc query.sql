CREATE TABLE user_feature (
	user_id INT(10) NOT NULL,
	feature_id INT(10) NOT NULL,
	CONSTRAINT pk_user_feature PRIMARY KEY (user_id, feature_id),
	CONSTRAINT fk_user_feature_featureid FOREIGN KEY (feature_id) REFERENCES app_feature(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT fk_user_feature_userid FOREIGN KEY (user_id) REFERENCES user_master(id) ON UPDATE CASCADE ON DELETE RESTRICT
);




CREATE TABLE app_feature (
	id INT(10) NOT NULL AUTO_INCREMENT,
	VERSION INT(10) NULL,
	created_by INT(10) NOT NULL,
	created_date TIMESTAMP NOT NULL,
	description VARCHAR(255) NULL,
	feature_name VARCHAR(255) NOT NULL,
	style_class VARCHAR(255) NULL,
	application_id INT(10) NULL,
	parent_id INT(10) NULL,
	modified_by INT(10) NULL,
	modified_date TIMESTAMP NULL,
	action_key VARCHAR(255) NOT NULL,
	CODE VARCHAR(255) NOT NULL,
	has_file_movement BOOL NULL,
	active_status BOOL NULL,
	CONSTRAINT pk_appfeature_id PRIMARY KEY (id),
	CONSTRAINT uk_appfeature_feature_name UNIQUE (feature_name),
	CONSTRAINT uq_appfeature_code UNIQUE (CODE),
	CONSTRAINT fk_appfeature_parentid FOREIGN KEY (parent_id) REFERENCES app_feature(id) ON UPDATE CASCADE ON DELETE RESTRICT
);



CREATE TABLE role_master (
	id INT(10) NOT NULL AUTO_INCREMENT,
	role_name VARCHAR(250) NOT NULL,
	created_by INT(10) NULL,
	created_date TIMESTAMP NOT NULL,
	modified_by INT(10) NULL,
	modified_date TIMESTAMP NULL,
	VERSION INT(10) NULL,
	STATUS BOOL NULL DEFAULT FALSE,
	application_id INT(10) NULL,
	CONSTRAINT pk_role_master PRIMARY KEY (id),
	CONSTRAINT uq_role_master_rolename UNIQUE (role_name),
	CONSTRAINT fk_role_master_createdby FOREIGN KEY (created_by) REFERENCES user_master(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT fk_role_master_modifiedby FOREIGN KEY (modified_by) REFERENCES user_master(id) ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE role_feature (
	role_id INT(10) NOT NULL,
	feature_id INT(10) NOT NULL,
	CONSTRAINT pk_rolefeature_roleid_featureid PRIMARY KEY (role_id, feature_id),
	CONSTRAINT fk_rolefeature_featureid FOREIGN KEY (feature_id) REFERENCES app_feature(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT fk_rolefeature_roleid FOREIGN KEY (role_id) REFERENCES role_master(id) ON UPDATE CASCADE ON DELETE RESTRICT
);




CREATE TABLE app_config (
	app_key VARCHAR(100) NOT NULL,
	app_value VARCHAR(100) NOT NULL,
	created_by INT(10) NOT NULL,
	created_date TIMESTAMP NOT NULL,
	modified_by INT(10) NULL,
	modified_date TIMESTAMP NULL,
	VERSION INT(10) NOT NULL,
	CONSTRAINT pk_app_config PRIMARY KEY (app_key),
	CONSTRAINT fk_app_config_createdby FOREIGN KEY (created_by) REFERENCES user_master(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT fk_app_config_modifiedby FOREIGN KEY (modified_by) REFERENCES user_master(id) ON UPDATE CASCADE ON DELETE RESTRICT
);


INSERT INTO entity_master
(id, entity_type_id, parent_id, CODE, NAME, address_id, gst_number, active_status, created_by, created_date, modified_by, 
modified_date, region_id, VERSION, contact_number, email_id)
VALUES(3, NULL, NULL, 'Mark', 'MarkSolution', NULL, 'GST_0120', TRUE, 809, '2019-03-06 16:06:33.452', NULL, NULL, NULL, 1, 
'996956859', NULL);



INSERT INTO user_master
(id, username, PASSWORD, created_by, created_date, modified_by, modified_date, VERSION, STATUS, user_type, email_id, second_password,
 mobile_number, entity_id)
VALUES(1, 'admin', '/RJFtj5I3i+EBkpN955nyXGxnP2Mo6eO4bSD7RDROudDrhaQVOqz3Y14', NULL, '2018-09-21 21:19:20.532', NULL, NULL, 1, TRUE, 
'ADMIN_USER', NULL, NULL, NULL, 3);

INSERT INTO role_master
(id, role_name, created_by, created_date, modified_by, modified_date, VERSION, STATUS, application_id)
VALUES(1, 'Admin', 1, '2019-03-06 16:09:18.852', NULL, NULL, NULL, TRUE, 2);

INSERT INTO app_feature
(id, VERSION, created_by, created_date, description, feature_name, style_class, application_id, parent_id, modified_by, 
modified_date, action_key, CODE, has_file_movement, active_status)
VALUES(1, 0, 1, '2017-10-19 19:28:09.298', 'Group', 'Group', 'menuLevelTwo', 1, 1, NULL, NULL, 'stmenu', 
'USER_MANAGEMENT_GROUP', NULL, NULL);

INSERT INTO role_feature (role_id, feature_id) VALUES(1, 1);


-- Drop table

-- DROP TABLE public.role_user;

CREATE TABLE role_user (
	user_id INT(10) NOT NULL,
	role_id INT(10) NOT NULL,
	id_unique INT(10) NULL,
	CONSTRAINT pk_role_user PRIMARY KEY (user_id, role_id),
	CONSTRAINT fk_role_user_roleid FOREIGN KEY (role_id) REFERENCES role_master(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT fk_role_user_userid FOREIGN KEY (user_id) REFERENCES user_master(id) ON UPDATE CASCADE ON DELETE RESTRICT
);


INSERT INTO role_user (user_id, role_id, id_unique) VALUES(1, 1, 1);








