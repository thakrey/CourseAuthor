/*
deploy the LCEC schema database changes

Usage for deployment to production:
    cd <perforceroot>/srv/lrn-secure-service/mainlin/dba/
    p4 sync ...
    cd deployment
    sqlplus <lcec_username>/<lcec_password>@lcecDB @deploy_lrn_secure_services.sql
*/
-- Moved the ../patch/insert..sql files to 2012.3 to avoid confusion
-- This will keep the lowest level empty.
-- Therefore, if you run these scripts it will fail
-- 
whenever sqlerror exit failure rollback
whenever oserror exit failure rollback
spool $PUB_LOG/deploy_lrn_secure_services.log;
set time on;
set feedback on;
set define off;
set echo on;
set serveroutput on size 1000000

start ../patch/insert_rsa_keys_type.sql;


spool off;
exit;

