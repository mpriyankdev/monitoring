

insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('1','monitoring-svc','zuul.routes.stub-svc-1.url','latest','default','http://localhost:8081');
insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('2','monitoring-svc','zuul.routes.stub-svc-1.path','latest','default','/stub1/hello/**');
insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('3','monitoring-svc','zuul.routes.stub-svc-1.strip-prefix','latest','default','false');
insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('4','monitoring-svc','zuul.routes.stub-svc-1.service-id','latest','default','stub-svc-1');

insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('5','monitoring-svc','zuul.routes.stub-svc-2.url','latest','default','http://localhost:8086');
insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('6','monitoring-svc','zuul.routes.stub-svc-2.path','latest','default','/stub2/hello/**');
insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('7','monitoring-svc','zuul.routes.stub-svc-2.strip-prefix','latest','default','false');
insert into CAT1_MONITOR_CONFIG_PROPERTIES(config_id,application,key,label,profile,value) values ('8','monitoring-svc','zuul.routes.stub-svc-2.service-id','latest','default','stub-svc-2');

commit;