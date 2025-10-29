# README - Campeonato MotoGP

## 📋 Descripción del Proyecto

Sistema de gestión de campeonatos de MotoGP desarrollado en Java con interfaz gráfica Swing. La aplicación permite gestionar escuderías, pilotos, circuitos y clasificaciones del campeonato, con funcionalidades avanzadas de exportación e importación de datos en formato XML.

## 🚀 Características Principales

### Gestión de Datos
- **Escuderías**: Administración completa de equipos con colores personalizados y pilotos asociados.
- **Pilotos**: Registro de pilotos con información de país, escudería, moto y puntuación.
- **Circuitos**: Base de datos de circuitos internacionales con longitud y ubicación.
- **Motos**: Información detallada de las motocicletas de cada equipo.

### Funcionalidades de la Interfaz
- Panel de altas para circuitos, escuderías y pilotos.
- Visualización de clasificaciones de pilotos y escuderías.
- Listados detallados con información visual.
- Interfaz personalizada con fuente oficial MotoGP.

### Modo Avanzado XML

#### 1. **Exportación de Datos**
El sistema permite exportar todo el campeonato a formato XML estructurado, incluyendo:
- Escuderías con sus pilotos asociados.
- Información completa de cada piloto (nombre, país, moto, puntos).
- Circuitos con detalles técnicos. 

#### 2. **Parser XML**
Sistema de lectura y análisis de documentos XML externos para importar datos de campeonatos históricos. 

#### 3. **Consultas XPath**
Funcionalidad avanzada para realizar búsquedas específicas en documentos XML:
- Mostrar los 5 primeros pilotos.
- Filtrar pilotos por marca de moto (ejemplo: Yamaha)
- Buscar pilotos por nacionalidad (ejemplo: Españoles) 

## 🏗️ Estructura del Proyecto

### Paquetes Principales

#### `data`
Contiene las clases del modelo de datos:
- `Campeonato`: Clase principal que gestiona todas las entidades.
- `Piloto`: Representa a un piloto con sus atributos.
- `Escuderia`: Gestiona equipos y sus pilotos.
- `Circuito`: Información de circuitos.
- `Moto`: Detalles de las motocicletas.
- `Pais`: Enumeración de países.

#### `GUI`
Interfaces gráficas para la gestión estándar:
- Paneles de altas (circuitos, escuderías, pilotos)
- Paneles de clasificación.
- Paneles de listados y opciones.

#### `GUI_XML`
Interfaces para funcionalidades XML avanzadas:
- `XMLExporter`: Exportación a XML.
- `XmlParser`: Parsing de documentos XML.
- `XPathQueries`: Consultas XPath.
- Paneles de búsqueda y modo avanzado.

## 💾 Persistencia de Datos

### Sistema de Serialización
El proyecto implementa dos mecanismos de persistencia:

#### 1. **Escuderías**
Guarda y carga automáticamente las asociaciones entre escuderías y pilotos en formato serializado. 

#### 2. **Circuitos**
Serialización de circuitos personalizados añadidos por el usuario. 

### Guardado Automático
El sistema utiliza un shutdown hook para guardar automáticamente los datos al cerrar la aplicación.

## 🎮 Cómo Ejecutar

### Requisitos
- Java JDK 8 o superior.
- NetBeans IDE (recomendado) o cualquier IDE compatible con proyectos Ant.

### Compilación y Ejecución
```bash
# Con NetBeans
Abrir el proyecto y ejecutar desde el IDE

# Con Ant desde línea de comandos
ant clean build
ant run
``` 

### Punto de Entrada
La aplicación inicia desde la clase `Main` que crea una instancia de la aplicación con el nombre "MOTOGP2024". 

## 📊 Datos de Prueba

El sistema incluye datos de prueba precargados con:
- 11 escuderías oficiales del campeonato 2024.
- 22 pilotos con puntuaciones aleatorias.
- 18 circuitos internacionales. 

```bash
## 📁 Estructura de Archivos

CampeonatoMotoGP/
├── src/
│   ├── data/              # Modelo de datos
│   ├── GUI/               # Interfaces gráficas básicas
│   └── GUI_XML/           # Interfaces XML avanzadas
├── res/
│   ├── fonts/             # Fuente MotoGP personalizada
│   ├── imgCircuito/       # Imágenes de circuitos
│   ├── imgEscuderias/     # Logos de escuderías
│   ├── imgInterfaz/       # Recursos de interfaz
│   ├── imgMotos/          # Imágenes de motos
│   ├── imgPilotos/        # Fotos de pilotos
│   └── storage/           # Archivos de datos y XML
├── nbproject/             # Configuración NetBeans
└── build.xml             # Script de compilación Ant
```

## 🔧 Características Técnicas

### Tecnologías Utilizadas
- **Java Swing**: Interfaz gráfica.
- **DOM Parser**: Manipulación de XML.
- **XPath**: Consultas avanzadas en XML.
- **Serialización Java**: Persistencia de datos.
- **TreeSet/HashSet**: Gestión de colecciones ordenadas.

### Patrones y Características
- Serialización de objetos para persistencia.
- Implementación de `Comparable` para ordenación automática.
- Uso de `equals` y `hashCode` personalizados.
- Shutdown hooks para guardado automático.

## 📝 Notas

- Los archivos de datos se guardan automáticamente en `res/storage/`
- Las exportaciones XML se generan en `res/storage/campeonato2024.xml`
- El proyecto incluye un archivo XML de ejemplo de pilotos históricos: `___dalesEsteArch__ridersMotoGP.xml`
- La fuente personalizada MotoGP se carga automáticamente al iniciar.

## 🎨 Personalización

Cada escudería incluye colores primarios y secundarios personalizados para la interfaz visual:

---

**Desarrolladores**: 
 - [Rubén](https://github.com/rubenhs9)
 - [Jesús](https://github.com/LightnigFast)

**Proyecto**: Sistema de Gestión de Campeonato MotoGP 2024
