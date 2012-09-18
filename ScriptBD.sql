DROP TABLE IF EXISTS `bomba`;
CREATE TABLE IF NOT EXISTS `bomba` (
  `id` int(10) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `capacidad` varchar(50) DEFAULT NULL,
  `fechaInstalacion` varchar(50) DEFAULT NULL,
  `fechaUltimoMantenimiento` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `idPozo` int(10) DEFAULT NULL
);

DROP TABLE IF EXISTS `estacionebombeo`;
CREATE TABLE IF NOT EXISTS `estacionebombeo` (
  `id` int(10) DEFAULT NULL,
  `presionEntrada` varchar(50) DEFAULT NULL,
  `presionSalida` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `capacidadMaxima` varchar(50) DEFAULT NULL,
  `cantidadBombas` varchar(50) DEFAULT NULL,
  `encargadoEstacion` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL
);

DROP TABLE IF EXISTS `lecturamedidor`;
CREATE TABLE IF NOT EXISTS `lecturamedidor` (
  `id` int(10) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `medicion` varchar(50) DEFAULT NULL,
  `responsable` varchar(50) DEFAULT NULL,
  `idMedidor` int(10) DEFAULT NULL,
  `numeroLectura` int(10) DEFAULT NULL
);

DROP TABLE IF EXISTS `medidor`;
CREATE TABLE IF NOT EXISTS `medidor` (
  `id` int(10) DEFAULT NULL,
  `material` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `diametro` varchar(50) DEFAULT NULL,
  `presionTrabajo` varchar(50) DEFAULT NULL,
  `fechaInstalacion` varchar(50) DEFAULT NULL,
  `fechaUltimaInspeccion` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL
);

DROP TABLE IF EXISTS `pozo`;
CREATE TABLE IF NOT EXISTS `pozo` (
  `id` int(10) DEFAULT NULL,
  `profundidad` varchar(50) DEFAULT NULL,
  `tipoRevestimiento` varchar(50) DEFAULT NULL,
  `diametro` varchar(50) DEFAULT NULL,
  `capacidadMaximaEpocaSeca` varchar(50) DEFAULT NULL,
  `capacidadMaximaEpocaLLuviosa` varchar(50) DEFAULT NULL
);

DROP TABLE IF EXISTS `tanquealmacenamiento`;
CREATE TABLE IF NOT EXISTS `tanquealmacenamiento` (
  `id` int(10) DEFAULT NULL,
  `capacidad` varchar(50) DEFAULT NULL,
  `material` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `fechaInstalacion` varchar(50) DEFAULT NULL,
  `fechaUltimaInspeccion` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL
);

DROP TABLE IF EXISTS `tuberia`;
CREATE TABLE IF NOT EXISTS `tuberia` (
  `id` int(10) DEFAULT NULL,
  `material` varchar(50) DEFAULT NULL,
  `diametro` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `largo` varchar(50) DEFAULT NULL,
  `presionMaxima` varchar(50) DEFAULT NULL,
  `fechaInstalacion` varchar(50) DEFAULT NULL,
  `fechaUltimaInspeccion` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL
);

DROP TABLE IF EXISTS `valvula`;
CREATE TABLE IF NOT EXISTS `valvula` (
  `id` int(10) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `diametro` varchar(50) DEFAULT NULL,
  `presionMaxima` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `numeroSerie` varchar(50) DEFAULT NULL,
  `fechaInstalacion` varchar(50) DEFAULT NULL,
  `fechaUltimaInspeccion` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL
);

-- DATOS --------------------------------------------------

-- VALVULAS
INSERT INTO `valvula` (`id`, `tipo`, `diametro`, `presionMaxima`, `marca`, `numeroSerie`, `fechaInstalacion`, `fechaUltimaInspeccion`, `estado`) VALUES
	(1, 'compuerta', '11', '111', 'valvulas SA', '1000', '2011-10-10', '2012-01-10', 'bueno'),
	(2, 'macho', '22', '222', 'valvulas SA', '2000', '2010-12-12', '2011-10-10', 'malo'),
	(3, 'globo', '33', '333', 'valvulas SA', '3000', '2010-09-22', '2011-10-10', 'bueno'),
	(4, 'bola', '44', '444', 'valvulas SA', '4000', '2012-01-01', '2012-05-10', 'regular'),
	(5, 'mariposa', '55', '555', 'valvulas SA', '5000', '2011-10-10', '2012-02-20', 'bueno'),
	(6, 'bola', '66', '666', 'valvulas SA', '6000', '2011-10-10', '2012-02-20', 'bueno');
	
-- TANQUES ALMACENAMIENTO
INSERT INTO `tanquealmacenamiento` (`id`, `capacidad`, `material`, `tipo`, `fechaInstalacion`, `fechaUltimaInspeccion`, `estado`) VALUES 
	(1, '10', 'hierro', 'aéreo', '2010-10-10', '2011-10-10', 'bueno'),
	(2, '20', 'concreto', 'en el terreno', '2010-10-10', '2011-10-10', 'bueno'),
	(3, '30', 'hierro', 'en el terreno', '2010-10-10', '2012-01-10', 'malo'),
	(4, '40', 'concreto', 'aéreo', '2011-10-10', '2012-01-10', 'bueno'),
	(5, '50', 'hierro', 'en el terreno', '2010-12-10', '2011-10-10', 'bueno'),
	(6, '60', 'concreto', 'aéreo', '2010-10-12', '2011-12-10', 'regular');
	
-- POZOS
INSERT INTO `pozo` (`id`, `profundidad`, `tipoRevestimiento`, `diametro`, `capacidadMaximaEpocaSeca`, `capacidadMaximaEpocaLLuviosa`) VALUES 
	(1, '10', 'concreto', '10', '100', '1000'),
	(2, '20', 'hierro', '20', '200', '2000'),
	(3, '30', 'pvc', '30', '300', '3000'),
	(4, '40', 'concreto', '40', '400', '4000'),
	(5, '50', 'pvc', '50', '500', '5000'),
	(6, '60', 'pvc', '60', '600', '6000');
	
-- BOMBAS
INSERT INTO `bomba` (`id`, `marca`, `modelo`, `capacidad`, `fechaInstalacion`, `fechaUltimoMantenimiento`, `estado`, `idPozo`) VALUES 
	(1, 'Bomba SA', 'Modelo 1', '10', '2010-101-10', '2011-10-10', 'bueno', 1),
	(2, 'Bomba SA', 'Modelo 2', '20', '2010-101-10', '2011-10-10', 'bueno', 2),
	(3, 'Bomba SA', 'Modelo 3', '30', '2010-101-10', '2011-10-10', 'bueno', 3),
	(4, 'Bomba SA', 'Modelo 3', '40', '2010-101-10', '2011-10-10', 'malo', 4),
	(5, 'Bomba SA', 'Modelo 3', '50', '2010-101-10', '2011-10-10', 'regular', 5),
	(6, 'Bomba SA', 'Modelo 5', '60', '2010-101-10', '2011-10-10', 'regular', 6),
	(7, 'Bomba SA', 'Modelo 2', '70', '2010-101-10', '2011-10-10', 'bueno', 1),
	(8, 'Bomba SA', 'Modelo 2', '80', '2010-101-10', '2011-10-10', 'regular', 2),
	(9, 'Bomba SA', 'Modelo 8', '90', '2010-101-10', '2011-10-10', 'bueno', 3),
	(10, 'Bomba SA', 'Modelo 2', '11', '2010-101-10', '2011-10-10', 'bueno', 4),
	(11, 'Bomba SA', 'Modelo 2', '22', '2010-101-10', '2011-10-10', 'regular', 5),
	(12, 'Bomba SA', 'Modelo 1', '33', '2010-101-10', '2011-10-10', 'malo', 6);
	
	
-- ESTACION DE BOMBEO	
INSERT INTO `estacionebombeo` (`id`, `presionEntrada`, `presionSalida`, `tipo`, `capacidadMaxima`, `cantidadBombas`, `encargadoEstacion`, `telefono`) VALUES 
	(1, '100', '100', 'eléctrica', '1000', '10', 'Juan Perez', '11111111'),
	(2, '200', '200', 'eléctrica', '2000', '20', 'Juan Perez', '11111111'),
	(3, '300', '300', 'combustible', '3000', '30', 'Carlos Soto', '22222222'),
	(4, '400', '400', 'combustible', '4000', '40', 'Carlos Soto', '22222222'),
	(5, '500', '500', 'combustible', '5000', '50', 'Carlos Soto', '22222222'),
	(6, '600', '600', 'combustible', '6000', '60', 'Pedro Soto', '33333333');

-- TUBERIAS	
INSERT INTO `tuberia` (`id`, `material`, `diametro`, `tipo`, `largo`, `presionMaxima`, `fechaInstalacion`, `fechaUltimaInspeccion`, `estado`) VALUES 
	(1, 'concreto', '10', 'principal', '10', '100', '2011-10-10', '2012-01-10', 'bueno'),
	(2, 'hierro', '20', 'acometida', '20', '200', '2012-01-10', '2012-05-10', 'regular'),
	(3, 'pvc', '30', 'secundaria', '30', '300', '2010-10-10', '2012-01-10', 'bueno'),
	(4, 'hierro', '40', 'principal', '40', '400', '2012-01-10', '2012-05-10', 'regular'),
	(5, 'concreto', '50', 'secundaria', '50', '500', '2010-10-10', '2012-01-10', 'bueno'),
	(6, 'concreto', '60', 'principal', '60', '600', '2011-10-10', '2012-01-10', 'malo');
	
-- LECTURAS MEDIDOR
INSERT INTO `lecturamedidor` (`id`, `fecha`, `medicion`, `responsable`, `idMedidor`, `numeroLectura`) VALUES 
	(1, '2012-01-01', '100', 'Juan Perez', 1, 1),
	(2, '2012-02-01', '200', 'Juan Perez', 2, 1),
	(3, '2012-03-01', '300', 'Juan Perez', 3, 1),
	(4, '2012-04-01', '100', 'Carlos Soto', 4, 1),
	(5, '2012-05-01', '400', 'Juan Perez', 1, 2),
	(6, '2012-06-01', '500', 'Carlos Soto', 2, 2),
	(7, '2012-06-01', '100', 'Carlos Soto', 3, 2),
	(8, '2012-05-01', '100', 'Carlos Soto', 4, 2),
	(9, '2012-04-01', '200', 'Juen Perez', 5, 1),
	(10, '2012-03-01', '500', 'Juan Perez', 6, 1),
	(11, '2012-02-01', '600', 'Carlos Soto', 6, 2),
	(12, '2012-01-01', '600', 'Carlos Soto', 4, 2);

-- MEDIDOR
INSERT INTO `medidor` (`id`, `material`, `marca`, `tipo`, `diametro`, `presionTrabajo`, `fechaInstalacion`, `fechaUltimaInspeccion`, `estado`) VALUES 
	(1, 'hierro', 'Medidor SA', 'chorro', '100', '1000', '2010-10-10', '2011-10-10', 'bueno'),
	(2, 'pvc', 'Medidor SA', 'único', '200', '2000', '2010-10-10', '2011-10-10', 'malo'),
	(3, 'hierro', 'Medidor SA', 'chorro', '300', '3000', '2010-10-10', '2011-10-10', 'bueno'),
	(4, 'pvc', 'Medidor SA', 'único', '400', '4000', '2010-10-10', '2011-10-10', 'malo'),
	(5, 'pvc', 'Medidor SA', 'chorro', '500', '5000', '2010-10-10', '2011-10-10', 'bueno'),
	(6, 'hierro', 'Medidor SA', 'tipo paleta', '600', '6000', '2010-10-10', '2011-10-10', 'regular');
	

	