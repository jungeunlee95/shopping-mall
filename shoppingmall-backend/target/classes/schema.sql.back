-- Table OAUTH_CLIENT_DETAILS
DROP TABLE IF EXISTS oauth_client_details;

create table oauth_client_details (
  client_id               VARCHAR(255) PRIMARY KEY,
  resource_ids            VARCHAR(255),
  client_secret           VARCHAR(255),
  scope                   VARCHAR(255),
  authorized_grant_types  VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities             VARCHAR(255),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(255)
);

-- Table OAUTH_CLIENT_TOKEN
DROP TABLE IF EXISTS oauth_client_token;

create table oauth_client_token (
  token_id          VARCHAR(255),
  token             VARBINARY(4096),
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255)
);

-- Table OAUTH_ACCESS_TOKEN
DROP TABLE IF EXISTS oauth_access_token;

create table oauth_access_token (
  token_id          VARCHAR(255),
  token             VARBINARY(4096),
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    VARBINARY(4096),
  refresh_token     VARCHAR(255)
);

-- Table OAUTH_REFRESH_TOKEN
DROP TABLE IF EXISTS oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token VARBINARY(4096),
  authentication VARBINARY(4096)
);

-- Table OAUTH_CODE
DROP TABLE IF EXISTS oauth_code;
create table oauth_code (
  code VARCHAR(255), authentication VARBINARY(4096)
);

-- Table OAUTH_APPROVALS
DROP TABLE IF EXISTS oauth_approvals;
create table oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

-- customized oauth_client_details table
-- DROP TABLE IF EXISTS ClientDetails;
-- create table ClientDetails (
--  appId VARCHAR(256) PRIMARY KEY,
--  resourceIds VARCHAR(256),
--  appSecret VARCHAR(256),
--  scope VARCHAR(256),
--  grantTypes VARCHAR(256),
--  redirectUrl VARCHAR(256),
--  authorities VARCHAR(256),
--  access_token_validity INTEGER,
--  refresh_token_validity INTEGER,
--  additionalInformation VARCHAR(4096),
--  autoApproveScopes VARCHAR(256)
-- );