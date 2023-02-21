
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : escuela


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `escuela`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_spanish_ci';

#
# Structure for the `alumnos` table : 
#

CREATE TABLE `alumnos` (
  `clave_alumno` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL DEFAULT '',
  `edad` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `curso_actual` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`clave_alumno`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='alumnos de la escuela';

#
# Structure for the `asignaturas` table : 
#

CREATE TABLE `asignaturas` (
  `clave_asignatura` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL DEFAULT '',
  `clave_aula` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`clave_asignatura`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='asignaturas de la escuela';

#
# Structure for the `aulas` table : 
#

CREATE TABLE `aulas` (
  `clave_aula` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`clave_aula`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Structure for the `horarios` table : 
#

CREATE TABLE `horarios` (
  `clave_horario` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `hora_inicio` time NOT NULL DEFAULT '00:00:00',
  `hora_fin` time NOT NULL DEFAULT '00:00:00',
  `dia` enum('lunes','martes','miercoles','jueves','viernes') NOT NULL DEFAULT 'lunes',
  `clave_asignatura` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`clave_horario`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

#
# Structure for the `listas` table : 
#

CREATE TABLE `listas` (
  `clave_lista` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `clave_profesor` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `clave_alumno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `clave_asignatura` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`clave_lista`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='listas que relacionan a alumnos, profesores y asignaturas';

#
# Structure for the `profesores` table : 
#

CREATE TABLE `profesores` (
  `clave_profesor` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL COMMENT 'Nombre completo',
  `correoElectronico` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL DEFAULT 'username@misena.edu.co' COMMENT 'correo institucional',
  `user` varchar(9) NOT NULL DEFAULT '0' COMMENT 'Usuario para acceso al sistema',
  PRIMARY KEY (`clave_profesor`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='profesores de la escuela';

#
# Data for the `alumnos` table  (LIMIT 0,500)
#

INSERT INTO `alumnos` (`clave_alumno`, `nombre`, `edad`, `curso_actual`) VALUES 
  (1,'Luis Perez',10,2),
  (2,'Juan Lopez',11,3),
  (3,'Ana Gonzalez',10,3),
  (4,'Laura Sanchez',12,3),
  (5,'Antonio Ruiz',12,3),
  (6,'Pedro Jimenez',10,2);

COMMIT;

#
# Data for the `asignaturas` table  (LIMIT 0,500)
#

INSERT INTO `asignaturas` (`clave_asignatura`, `nombre`, `clave_aula`) VALUES 
  (1,'Historia',1),
  (2,'Biología',1),
  (3,'Matemáticas',4);

COMMIT;

#
# Data for the `aulas` table  (LIMIT 0,500)
#

INSERT INTO `aulas` (`clave_aula`, `nombre`) VALUES 
  (1,'1A'),
  (2,'1B'),
  (3,'2A'),
  (4,'2B');

COMMIT;

#
# Data for the `horarios` table  (LIMIT 0,500)
#

INSERT INTO `horarios` (`clave_horario`, `hora_inicio`, `hora_fin`, `dia`, `clave_asignatura`) VALUES 
  (1,'08:00:00','10:00:00','lunes',1),
  (2,'10:00:00','12:00:00','lunes',2),
  (3,'12:00:00','14:00:00','lunes',3),
  (4,'08:00:00','12:00:00','martes',1),
  (5,'12:00:00','14:00:00','martes',2),
  (6,'10:00:00','12:00:00','miercoles',3),
  (7,'12:00:00','14:00:00','miercoles',1),
  (8,'08:00:00','10:00:00','jueves',2),
  (9,'10:00:00','12:00:00','jueves',3),
  (10,'12:00:00','14:00:00','jueves',1),
  (11,'08:00:00','12:00:00','viernes',2);

COMMIT;

#
# Data for the `listas` table  (LIMIT 0,500)
#

INSERT INTO `listas` (`clave_lista`, `clave_profesor`, `clave_alumno`, `clave_asignatura`) VALUES 
  (1,1,1,1),
  (2,1,2,1),
  (3,1,3,1),
  (4,1,1,2),
  (5,1,2,2),
  (6,1,3,2),
  (7,2,4,3),
  (8,2,5,3),
  (9,2,6,3);

COMMIT;

#
# Data for the `profesores` table  (LIMIT 0,500)
#

INSERT INTO `profesores` (`clave_profesor`, `nombre`, `correoElectronico`, `user`) VALUES 
  (1,'Roberto Juarez','username@misena.edu.co','rj'),
  (2,'Marcela Herrera','username@misena.edu.co','mh'),
  (3,'rodrigo Aranda Fernandez','raranda@ucundinamarca.edu.co','raf');

COMMIT;

