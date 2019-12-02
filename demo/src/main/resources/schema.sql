create table customer(customerId int primary key,name varchar(40),address varchar(50),locality varchar(20),landmark varchar(20),city varchar(15),state varchar(20),accountType varchar(10) check(accountType in('simple','golden')),emailId varchar(70),contno varchar(15),password varchar(150),accountDate date);

create table order1(orderId int primary key,orderDate date,orderTime time,cookingInstruction varchar(50),customerId int references customer(customerId)on delete cascade on update cascade,unique(customerId,orderId));

create table selfPickUp(selfPickUpId int primary key,pickUpTime time,pickUpDate date,orderId int references order1(orderId)on delete cascade on update cascade,unique(orderId,selfPickUpid),unique(orderId));

create table homeDelivery(homeDeliveryId int primary key,homeDeliveryAddress varchar(100),orderId int references order1(orderId)on delete cascade on update cascade,unique(homeDeliveryId,orderId),unique(orderId));

create table deliveryBoy(deliveryboyid int primary key,deliveryboyname varchar(30),deliveryboyaddress varchar(100),emailid varchar(30),contno varchar(15),salary float);
