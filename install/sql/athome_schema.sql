create table if not exists alarm_groups
(
  id int auto_increment
    primary key,
  name varchar(256) not null,
  enabled tinyint(1) default 0 not null,
  fired tinyint(1) default 0 not null,
  constraint name
    unique (name)
);

create table if not exists pincodes
(
  id int auto_increment
    primary key,
  code int not null,
  alarm_group int not null,
  constraint pincodes_ibfk_1
    foreign key (alarm_group) references pincodes (id)
      on update cascade on delete cascade
);

create index fk_alarm_group_pincode
  on pincodes (alarm_group);

create table if not exists stations
(
  id int auto_increment
    primary key,
  name varchar(100) not null,
  site_id int not null,
  type varchar(45) not null,
  x int not null,
  y int not null,
  enabled tinyint(1) default 0 not null
);

create table if not exists weather_locations
(
  id int auto_increment
    primary key,
  place varchar(256) null,
  geo_name_id int not null,
  population int null,
  latitude double not null,
  longitude double not null,
  municipality varchar(256) null,
  country varchar(256) not null,
  district varchar(256) null,
  current tinyint(1) default 0 not null
);

create table if not exists zwave_sensors
(
  id int auto_increment
    primary key,
  ha_id varchar(256) not null,
  node_id varchar(256) not null,
  name varchar(256) not null,
  state int not null,
  alarming tinyint(1) default 0 null,
  sensor_type varchar(256) null,
  unit_of_measurement varchar(256) null,
  enabled tinyint(1) default 0 null
);

