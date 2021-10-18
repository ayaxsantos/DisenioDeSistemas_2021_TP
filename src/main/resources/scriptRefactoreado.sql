create database rescatedepatitas;

use rescatedepatitas;

create table documento(
    id mediumint auto_increment,
    tipo varchar(10) not null,
    numero mediumint not null,
    constraint id_documento_pk primary key (id)
);

create table organizacion(
    id mediumint auto_increment,
    nombre_organizacion varchar(40),
    id_direccion mediumint,
    id_tamaño_foto mediumint,
    id_calidad_foto mediumint,
    constraint id_organizacion_pk primary key(id),
    constraint organizacion_id_direccion_fk foreign key (id_direccion) references direccion(id),
    constraint organizacion_id_tamaño_foto_fk foreign key (id_tamaño_foto) references tamañoFoto(id),
    constraint organizacion_id_calidad_foto_fk foreign key (id_calidad_foto) references calidadFoto(id)
);

create table tamañoFoto(
    id mediumint auto_increment,
    descripcion varchar(10),
    constraint id_tamaño_foto_pk primary key(id)
);

create table calidadFoto(
    id mediumint auto_increment,
    descripcion varchar(10),
    constraint id_calidad_foto_pk primary key(id)
);

create table direccion(
    id mediumint auto_increment,
    latitud double not null,
    longitud double not null,
    constraint id_direccion_pk primary key (id)
);

create table animal(
    id mediumint auto_increment,
    descripcion varchar(20) not null,
    constraint id_animal_pk primary key (id)
);

create table sexo(
    id mediumint auto_increment,
    descripcion varchar(20) not null,
    constraint id_sexo_pk primary key (id)
);

create table tamaño(
    id mediumint auto_increment,
    descripcion varchar(20) not null,
    constraint id_tamaño_pk primary key (id)
);

create table preferencia(
	id mediumint auto_increment,
    id_animal mediumint,
    id_sexo mediumint,
    id_tamaño mediumint,
    constraint id_preferencia_pk primary key (id),
    constraint preferencia_id_animal_fk foreign key (id_animal) references animal(id),
	constraint preferencia_id_sexo_fk foreign key (id_sexo) references sexo(id),
	constraint preferencia_id_tamaño_fk foreign key (id_tamaño) references tamaño(id)
);

create table persona(
    id mediumint auto_increment,
    fecha_nacimiento date not null,
    id_documento mediumint,
    id_direccion mediumint,
    id_preferencia mediumint,
    id_usuario mediumint,
    constraint id_persona_pk primary key (id),
    constraint persona_id_documento_fk foreign key (id_documento) references documento(id_documento),
    constraint persona_id_direccion_fk foreign key (id_direccion) references direccion(id),
	constraint persona_id_preferencia_fk foreign key (id_preferencia) references preferencia(id),
    constraint persona_id_usuario_fk foreign key (id_usuario) references usuario(id)
);

create table usuario(
    id mediumint auto_increment,
    nombre_usuario varchar(32) not null,
    contraseña varchar(32) not null,
    constraint id_usuario_pk primary key (id)
);

create table administrador(
    id mediumint primary key auto_increment,
    id_usuario mediumint,
    id_organizacion mediumint,
    constraint administrador_id_usuario_fk foreign key (id_usuario) references usuario(id),
    constraint administrador_id_organizacion_fk foreign key (id_organizacion) references organizacion(id)
);

create table mascota(
	id mediumint auto_increment,
    nombre_mascota varchar(50) not null,
    apodo varchar(25),
    edad int,
    descripcion_fisica varchar(1000),
    id_animal mediumint,
    id_sexo mediumint,
    id_tamaño mediumint,
    id_persona mediumint,
    constraint id_mascota_pk primary key (id),
    constraint mascota_id_persona_fk foreign key (id_persona) references persona(id),
    constraint mascota_id_animal_fk foreign key (id_animal) references animal(id),
	constraint mascota_id_sexo_fk foreign key (id_sexo) references sexo(id),
	constraint mascota_id_tamaño_fk foreign key (id_tamaño) references tamaño(id)
);

create table contacto(
	id mediumint auto_increment,
    nombre varchar(40),
    apellido varchar(40),
    telefono varchar(20),
    mail varchar(20),
    constraint id_contacto_pk primary key (id)
);


create table persona_x_contacto(
    id mediumint auto_increment,
    id_persona mediumint,
    id_contacto mediumint,
    constraint id_persona_x_contacto_pk primary key (id),
    constraint persona_x_contacto_id_persona_fk foreign key (id_persona) references persona(id),
    constraint persona_x_contacto_id_contacto_fk foreign key (id_contacto) references contacto(id)
);

create table voluntario(
    id mediumint auto_increment,
    id_usuario mediumint,
    id_organizacion mediumint,
    constraint id_voluntario_pk primary key (id),
    constraint voluntario_id_usuario_fk foreign key (id_usuario) references usuario(id),
    constraint voluntario_id_organizacion_fk foreign key (id_organizacion) references organizacion(id)
);

create table usuario_x_organizacion(
    id mediumint auto_increment,
    id_organizacion mediumint,
    id_usuario mediumint,
    constraint id_usuario_x_organizacion_pk primary key (id),
    constraint usuario_x_organizacion_id_organizacion foreign key (id_organizacion) references organizacion(id),
    constraint usuario_x_organizacion_id_usuario foreign key (id_usuario) references usuario(id)
);

create table medio_de_comunicacion(
    id mediumint auto_increment,
    descripcion varchar(20),
    constraint id_medio_de_comunicacion_pk primary key (id)
);

create table medio_de_comunicacion_preferido(
	id mediumint auto_increment,
    es_preferido bool,
    id_medio_de_comunicacion mediumint,
    id_contacto mediumint,
    constraint id_medio_preferido_pk primary key (id),
    constraint medio_de_comunicacion_preferido_id_medio_fk foreign key (id_medio_de_comunicacion) references medio_de_comunicacion(id),
    constraint medio_de_comunicacion_preferido_id_contacto_fk foreign key (id_contacto) references contacto(id)
);