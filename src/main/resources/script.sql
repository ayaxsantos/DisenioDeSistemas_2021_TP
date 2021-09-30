create database rescatedepatitas;

use rescatedepatitas;

create table usuario(
    id_usuario mediumint auto_increment,
    nombre_usuario varchar(32) not null,
    contraseña varchar(32) not null,
    constraint id_usuario_pk primary key (id_usuario)
);

create table administrador(
    id_administrador mediumint primary key auto_increment,
    id_usuario mediumint,
    constraint administrador_id_usuario_fk foreign key (id_usuario) references usuario(id_usuario)
);

create table animal(
    id_animal mediumint auto_increment,
    descripcion varchar(20) not null,
    constraint id_animal_pk primary key (id_animal)
);

create table sexo(
    id_sexo mediumint auto_increment,
    descripcion varchar(20) not null,
    constraint id_sexo_pk primary key (id_sexo)
);

create table tamaño(
    id_tamaño mediumint auto_increment,
    descripcion varchar(20) not null,
    constraint id_tamaño_pk primary key (id_tamaño)
);

create table documento(
    id_documento mediumint auto_increment,
    tipo varchar(10) not null,
    numero mediumint not null,
    constraint id_documento_pk primary key (id_documento)
);

create table direccion(
    id_direccion mediumint auto_increment,
    latitud double not null,
    longitud double not null,
    constraint id_direccion primary key (id_direccion)
);