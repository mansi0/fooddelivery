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




create table deliveryBoy(
    deliveryboyid varchar(100) primary key,
    deliveryboyname varchar(50),
    deliveryboyaddress varchar(100),
    deliveryboyemailid varchar(50),
    deliveryboycontno varchar(15),
    deliveryArea varchar(100),
    deliveryBoypassword varchar(150),
    accountDate date,
    deliveryBoyStatus varchar(10) check(deliveryBoyStatus in('active','inactive')),
    noofdays int,
    deliveryboyshift varchar(10) check(deliveryboyshift in('morning','evening','night')),
    noofdelivery int,
    deliveryboysalary float,
    notification varchar(5)
    );

CREATE TABLE image(
    imagepath varchar(50)
);


CREATE TABLE hotel(
    hotelid varchar(100) PRIMARY KEY,
    hotelpassword VARCHAR(150),
    hotelemailid VARCHAR(50),
    hotelcontno varchar(15),
    hotelname VARCHAR(50),
    hoteladdress varchar(80),
    hotellocality varchar(80),
    hotellandmark varchar(80),
    hotelcity varchar(15),
    hotelstate varchar(20),
    openat time,
    closeat time,
    approximatecost float,
    hotelopeningdate DATE,
    expressdelivery boolean,
    hotelstatus varchar(20),
    hotelmenutype varchar(20),
    hotelfacility text[],
    hotelcuisine text[],
    hotelimage varchar(100),
    notification varchar(5),
    hotelrating text[],
    hotelreview text[]
);


create table food(
    foodid varchar(100) PRIMARY KEY,
    foodname varchar(80),
    foodtype int,
    category varchar(50)
);

create table hotel_food (
    hotelfoodid varchar(100) PRIMARY KEY,
    hotelid varchar(100) REFERENCES hotel(hotelid) ON DELETE CASCADE ON UPDATE CASCADE,
    foodid VARCHAR(100) REFERENCES food(foodid) ON DELETE CASCADE ON UPDATE CASCADE,
    foodspeciality VARCHAR(200),
    price float,
    size varchar,
    unique(hotelid,foodid)
);

create table order1(
    orderId varchar(100) primary key,
    customerId varchar(100) references customer(customerId)on delete cascade on update cascade,
    hotelid varchar(100) REFERENCES hotel(hotelid)ON DELETE CASCADE ON UPDATE CASCADE,
    orderDate date,
    orderTime time,
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

create table homeDelivery(
    homeDeliveryId varchar(100) primary key,
    homeDeliveryAddress varchar(100),
    orderId varchar(100) references order1(orderId)on delete cascade on update cascade,
    deliveryboyid varchar(100) references deliveryboy(deliveryboyid)on delete cascade on update cascade,
    unique(homeDeliveryId,orderId,deliveryboyid),
    unique(orderId)
    );



CREATE TABLE food_order (
    foodorderid VARCHAR(100) PRIMARY KEY,
    foodid VARCHAR(100) REFERENCES food(foodid) ON DELETE CASCADE ON UPDATE CASCADE,
    orderId varchar(100) references order1(orderId)on delete cascade on update cascade,
    quantity int,
    UNIQUE(foodid,orderId)
);

CREATE TABLE hotel_order(
    hotelorderid VARCHAR(100) PRIMARY KEY,
    hotelid varchar(100) REFERENCES hotel(hotelid) ON DELETE CASCADE ON UPDATE CASCADE,
    orderId varchar(100) references order1(orderId)on delete cascade on update cascade,
    UNIQUE(hotelid,orderid)
);


