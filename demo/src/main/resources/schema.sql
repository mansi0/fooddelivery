create table customer(
    customerId varchar(100) primary key,
    name varchar(40),
    address varchar(50),
    locality varchar(50),
    landmark varchar(50),
    city varchar(15),
    state varchar(20),
    emailId varchar(70),
    contno varchar(15),
    password varchar(150),
    accountDate date,
    notification varchar(5)
    );


create table order1(
    orderId varchar(100) primary key,
    orderDate date,
    orderTime time,
    cookingInstruction varchar(50),
    customerId varchar(100) references customer(customerId)on delete cascade on update cascade,
    unique(customerId,orderId)
    );


create table selfPickUp(
    selfPickUpId varchar(100) primary key,
    pickUpTime time,
    pickUpDate date,
    orderId varchar(100) references order1(orderId)on delete cascade on update cascade,
    unique(orderId,selfPickUpid),
    unique(orderId)
    );


create table deliveryBoy(
    deliveryboyid varchar(100) primary key,
    deliveryboyname varchar(50),
    deliveryboyaddress varchar(100),
    deliveryboyemailid varchar(50),
    deliveryboycontno varchar(15),
    deliveryboysalary float,
    deliveryArea varchar(100),
    deliveryBoyStatus varchar(10) check(deliveryBoyStatus in('active','inactive')),
    deliveryBoypassword varchar(150),
    noofdays int,
    deliveryboyshift varchar(10) check(deliveryboyshift in('morning','evening','night')),
    noofdelivery int,
    notification boolean
    );

create table homeDelivery(
    homeDeliveryId varchar(100) primary key,
    homeDeliveryAddress varchar(100),
    orderId varchar(100) references order1(orderId)on delete cascade on update cascade,
    deliveryboyid varchar(100) references deliveryboy(deliveryboyid)on delete cascade on update cascade,
    unique(homeDeliveryId,orderId,deliveryboyid),
    unique(orderId)
    );


CREATE TABLE hotel(
    hotelid varchar(100) PRIMARY KEY,
    hotelpassword VARCHAR(150),
    hotelemailid VARCHAR(50),
    hotelcontno varchar(15),
    hotelname VARCHAR(50),
    hoteladdress varchar(50),
    hotellocality varchar(50),
    hotellandmark varchar(50),
    hotelcity varchar(15),
    hotelstate varchar(20),
    openat time,
    closeat time,
    approximatecost float,
    hotelopeningdate DATE,
    expressdelivery boolean,
    hotelstatus varchar(10),
    hotelmenutype text[],
    hotelfacility text[],
    hotelcuisine text[],
    hotelrating text[],
    hotelreview text[],
    notification boolean
);



