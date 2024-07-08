DROP TABLE IF EXISTS VendorPrices;
DROP TABLE IF EXISTS Instrument;
DROP TABLE IF EXISTS Vendor;

create table Instrument(
    InstrumentId varchar(20) PRIMARY KEY,
    InstrumentDescription varchar(100)
);

create table Vendor(
    VendorId varchar(20) PRIMARY KEY,
    VendorDescription varchar(100)
);

create table VendorPrices(
    VendorId varchar(20),
    InstrumentId varchar(20),
    Price double,
    PriceDate DATETIME,
    FOREIGN KEY (VendorId) references Vendor(VendorId),
    FOREIGN KEY (InstrumentId) references Instrument(InstrumentId),
    PRIMARY KEY (VendorId, InstrumentId)
);

insert into Instrument values('In001', 'Instrument Description 001');
insert into Instrument values('In002', 'Instrument Description 002');
insert into Instrument values('In003', 'Instrument Description 003');

insert into Vendor values('V001', 'Vendor Name 001');
insert into Vendor values('V002', 'Vendor Name 002');
insert into Vendor values('V003', 'Vendor Name 003');
insert into Vendor values('V004', 'Vendor Name 004');

insert into VendorPrices (VendorId, InstrumentId, Price, PriceDate) values('V001', 'In001', 123.45, '2024-06-24 01:12:53');
insert into VendorPrices (VendorId, InstrumentId, Price, PriceDate) values('V002', 'In001', 7351.55, '2024-06-23 11:52:33');
insert into VendorPrices (VendorId, InstrumentId, Price, PriceDate) values('V003', 'In001', 662.32, '2024-06-25 12:54:21');
insert into VendorPrices (VendorId, InstrumentId, Price, PriceDate) values('V003', 'In002', 5552.23, '2024-05-24 01:29:23');
insert into VendorPrices (VendorId, InstrumentId, Price, PriceDate) values('V002', 'In003', 224.75, '2024-06-24 04:34:37');
insert into VendorPrices (VendorId, InstrumentId, Price, PriceDate) values('V004', 'In003', 3572.21, '2024-05-23 08:55:58');
