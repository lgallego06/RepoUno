-- DROP DATABASE ecodosruedas;
-- CREATE SCHEMA EcoDosRuedas;
-- USE EcoDosRuedas;
CREATE TABLE proveedor (
prov_id int  primary key,
prov_nombre char(20) ,
prov_direccion char(45) ,
prov_telefono char(20)
);
INSERT into proveedor values(101, "Auteco","calle 7 No. 45-17","05713224459");
insert into proveedor values (102, "Hitachi", "calle 19 No. 108-26", "05714223344");
insert into proveedor values (103, "Bosch", "carrera 68 No. 26-45", "05715678798");
insert into proveedor values (104, "Teco", "calle 77 No. 68-33", "05712213243");
insert into proveedor values (105, "General Electric", "calle 29 No. 26-12", "05717239919");

CREATE TABLE clientes (
    alias char(20) PRIMARY KEY,
    nombre CHAR(20) ,
    apellido CHAR(20) ,
    celular char(20),
    email varchar(45) ,
	contraseña int,
    f_nacimiento date
    );
    insert into clientes values('lucky','Pedro','Perez','3157623967','lucky@gmail.com',14904040,'1995-10-30');
    insert into clientes values('malopez','Maria','Lopez','3205844650','malopez@gmail.com',50404053,'1997-01-05');
    insert into clientes values('diva','Ana','Diaz','3115845540','diva@gmail.com',95043949,'1990-04-29');
    insert into clientes values('dreamer','Luis','Rojas','3202475143','dreamer@gmail.com',14949309,'1999-03-18');
    insert into clientes values('ninja','Andres','Cruz','3507652949','ninja@gmail.com',16473955,'1990-07-29');
    insert into clientes values('neon','Nelson','Ruiz','3505050650','neon@gmail.com',84933955,'1993-08-23');
    insert into clientes values('rose','Claudia','Mendez','3205436789','rose@gmail.com',18905436,'1999-06-24');
    insert into clientes values('green','Jorge','Rodriguez','3115844554','green@gmail.com',85493015,'1989-10-04');
    
create table fabricantes(
fabricante char(20) primary key
);
insert into fabricantes values('Cannondale');
insert into fabricantes values('Trek');
insert into fabricantes values('Yeti');
insert into fabricantes values('Fuji');
insert into fabricantes values('Bmc');
insert into fabricantes values('Starker');
insert into fabricantes values('Lucky Lion');
insert into fabricantes values('Be Electric');
insert into fabricantes values('Aima');
insert into fabricantes values('Mec de Colombia');
insert into fabricantes values('Atom Electric');

    CREATE TABLE bicicletas (
    id int  primary key,
    fabricante CHAR(20),
    precio INT,
    año INT ,
    foreign key(fabricante) references fabricantes(fabricante)
);
insert into bicicletas values(1001,'Cannondale',1200000,2020);
insert into bicicletas values(1002,'Trek',1450000,2019);
insert into bicicletas values(1003,'Yeti',2000000,2020);
insert into bicicletas values(1004,'Fuji',950000,2021);
insert into bicicletas values(1005,'Bmc',1950000,1018);

CREATE TABLE motocicletas (
    id int  primary key,
    fabricante CHAR(20) ,
    precio INT  ,
    autonomia int,
	id_prov int,
    foreign key(fabricante) references fabricantes(fabricante),
	foreign key(id_prov) references proveedor(prov_id)
    );
    insert into motocicletas values(2001,'Starker',4200000,18,101);
    insert into motocicletas values(2002,'Lucky Lion',5600000,16,102);
    insert into motocicletas values(2003,'Be Electric',4600000,26,101);
    insert into motocicletas values(2004,'Aima',8000000,36,103);
    insert into motocicletas values(2005,'Mec de Colombia',59000000,20,104);
    insert into motocicletas values(2006,'Atom Electric',4500000,12,105);

create table compras(
id int primary key,
alias char(20),
fabricante char(20),
fecha_hora timestamp,
foreign key(fabricante) references fabricantes(fabricante),
foreign key(alias) references clientes(alias)
);
insert into compras values(01,'lucky','Cannondale','2017-10-25 20:00:00');
insert into compras values(02,'lucky','Trek','2019-03-15 18:30:00');
insert into compras values(03,'lucky','Starker','2019-05-20 20:30:00');
insert into compras values(04,'malopez','Cannondale','2018-05-20 20:30:00');
insert into compras values(05,'malopez','Starker','2020-01-20 20:30:00');
insert into compras values(06,'diva','Yeti','2019-05-20 20:30:00');
insert into compras values(07,'diva','Fuji','2018-06-22 21:30:00');
insert into compras values(08,'diva','Lucky Lion','2020-03-17 15:30:20');
insert into compras values(09,'dreamer','Lucky Lion','2020-03-17 15:30:20');
insert into compras values(10,'dreamer','Be Electric','2020-04-10 18:30:20');
insert into compras values(11,'ninja','Aima','2020-02-17 20:30:20');
insert into compras values(12,'ninja','Starker','2020-02-20 16:30:20');
insert into compras values(13,'ninja','Mec de Colombia','2020-03-27 18:30:20');
insert into compras values(14,'rose','Atom Electric','2020-03-20 21:30:20');
insert into compras values(15,'green','Yeti','2020-01-10 17:30:20');
insert into compras values(16,'green','Trek','2020-02-15 20:30:20');
insert into compras values(17,'green','Bmc','2020-03-17 18:30:20');

update bicicletas set año=2017 where fabricante='Cannondale';
update clientes set celular='3115678432' where alias='ninja';
delete from compras where alias='green' and fabricante='trek';

select 'consulta 1';
select fabricante from fabricantes order by fabricante;
 select 'consulta 2';
 select fabricante,precio,año from bicicletas where año>=2019 order by fabricante;
 select 'consulta 3';
 select fabricante from motocicletas where id_prov=101;
 select 'consulta 4';
 select fabricante from compras where alias='lucky' order by fabricante;
 select 'consulta 5';
 select c.alias,c.nombre,c.apellido from clientes c, compras p where c.alias=p.alias and p.fabricante='Yeti' order by nombre;
  select 'consulta 6';
 select count(fabricante) from bicicletas where año>=2019;