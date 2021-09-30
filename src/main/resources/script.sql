create database rescatedepatitas;

use rescatedepatitas;

create table documento(
    id_documento mediumint auto_increment,
    tipo varchar(10) not null,
    numero mediumint not null,
    constraint id_documento_pk primary key (id_documento)
);

create table usuario(
    id_usuario mediumint auto_increment,
    nombre_usuario varchar(32) not null,
    contraseña varchar(32) not null,
    id_documento mediumint,
    constraint id_usuario_pk primary key (id_usuario),
    constraint usuario_id_persona_fk foreign key (id_documento) references documento(id_documento)
);


create table organizacion(
    id_organizacion mediumint auto_increment,
    constraint id_organizacion_pk primary key(id_organizacion)
);

create table administrador(
    id_administrador mediumint primary key auto_increment,
    id_usuario mediumint,
    id_organizacion mediumint,
    constraint administrador_id_usuario_fk foreign key (id_usuario) references usuario(id_usuario),
    constraint administrador_id_organizacion_fk foreign key (id_organizacion) references organizacion(id_organizacion)
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

create table direccion(
    id_direccion mediumint auto_increment,
    latitud double not null,
    longitud double not null,
    constraint id_direccion_pk primary key (id_direccion)
);



create table mascota(
	id_mascota mediumint auto_increment,
    nombre_mascota varchar(50) not null,
    apodo varchar(25),
    edad int,
    descripcion_fisica varchar(1000),
    id_animal mediumint,
    id_sexo mediumint,
    id_tamaño mediumint,
    constraint id_mascota_pk primary key (id_mascota),
    constraint mascota_id_animal_fk foreign key (id_animal) references animal(id_animal),
	constraint mascota_id_sexo_fk foreign key (id_sexo) references sexo(id_sexo),
	constraint mascota_id_tamaño_fk foreign key (id_tamaño) references tamaño(id_tamaño)
);

create table preferencia(
	id_preferencia mediumint auto_increment,
    id_animal mediumint,
    id_sexo mediumint,
    id_tamaño mediumint,
    constraint id_preferencia_pk primary key (id_preferencia),
    constraint preferencia_id_animal_fk foreign key (id_animal) references animal(id_animal),
	constraint preferencia_id_sexo_fk foreign key (id_sexo) references sexo(id_sexo),
	constraint preferencia_id_tamaño_fk foreign key (id_tamaño) references tamaño(id_tamaño)

);

create table contacto(
	id_contacto mediumint auto_increment,
    nombre varchar(40),
    apellido varchar(40),
    telefono varchar(20),
    mail varchar(20),
    constraint id_contacto_pk primary key (id_contacto)
);

create table persona(
    id_persona mediumint auto_increment,
    fechaNacimiento date not null,
    id_documento mediumint,
    id_direccion mediumint,
    id_persona_x_contacto mediumint,
    id_preferencia mediumint,
    constraint id_persona_pk primary key (id_persona),
    constraint persona_id_documento_fk foreign key (id_documento) references documento(id_documento),
    constraint persona_id_direccion_fk foreign key (id_direccion) references direccion(id_direccion),
	constraint persona_id_preferencia_fk foreign key (id_preferencia) references preferencia(id_preferencia)
    #constraint persona_id_persona_x_contacto_fk foreign key (id_persona_x_contacto) references persona_x_contacto(id_persona_x_contacto)
);

create table persona_x_contacto(
    id_persona_x_contacto mediumint auto_increment,
    id_persona mediumint,
    id_contacto mediumint,
    constraint id_persona_x_contacto_pk primary key (id_persona_x_contacto),
    constraint persona_x_contacto_id_persona_fk foreign key (id_persona) references persona(id_persona),
    constraint persona_x_contacto_id_contacto_fk foreign key (id_contacto) references contacto(id_contacto)
);

create table voluntario(
    id_voluntario mediumint auto_increment,
    id_usuario mediumint,
    id_organizacion mediumint,
    constraint id_voluntario_pk primary key (id_voluntario),
    constraint voluntario_id_usuario_fk foreign key (id_usuario) references usuario(id_usuario),
    constraint voluntario_id_organizacion_fk foreign key (id_organizacion) references organizacion(id_organizacion)
);

create table usuario_x_organizacion(
    id_usuario_x_organizacion mediumint auto_increment,
    id_organizacion mediumint,
    id_usuario mediumint,
    constraint id_usuario_x_organizacion_pk primary key (id_usuario_x_organizacion),
    constraint usuario_x_organizacion_id_organizacion foreign key (id_organizacion) references organizacion(id_organizacion),
    constraint usuario_x_organizacion_id_usuario foreign key (id_usuario) references usuario(id_usuario)
);

create table medio_de_comunicacion(
    id_medio_de_comunicacion mediumint auto_increment,
    descripcion varchar(20),
    constraint id_medio_de_comunicacion_pk primary key (id_medio_de_comunicacion)
);

create table medio_de_comunicacion_preferido(
	id_medio_preferido mediumint auto_increment,
    es_preferido bool,
    id_medio_de_comunicacion mediumint,
    id_contacto mediumint,
    constraint id_medio_preferido_pk primary key (id_medio_preferido),
    constraint medio_de_comunicacion_preferido_id_medio_fk foreign key (id_medio_de_comunicacion) references medio_de_comunicacion(id_medio_de_comunicacion),
    constraint medio_de_comunicacion_preferido_id_contacto_fk foreign key (id_contacto) references contacto(id_contacto)
);

