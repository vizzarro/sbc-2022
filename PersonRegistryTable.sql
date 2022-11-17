create table address (
address_id int not null auto_increment,
primary key (address_id),
street varchar(30),
civic varchar(5),
postalcode int(10),
home enum("RESIDENCE", "DOMICILE")
);

create table person (
name varchar(60),
surname varchar(60),
fiscalcode varchar(16),
primary key (fiscalcode),
gender enum("M","F"),
address_id int(10),
foreign key (address_id) references address(address_id),
birth_date date,
cell_number varchar(20)
);