# README - Campeonato MotoGP

## 📋 Descripción del Proyecto

Sistema de gestión de campeonatos de MotoGP desarrollado en Java con interfaz gráfica Swing. La aplicación permite gestionar escuderías, pilotos, circuitos y clasificaciones del campeonato, con funcionalidades avanzadas de exportación e importación de datos en formato XML.

## 🚀 Características Principales

### Gestión de Datos
- **Escuderías**: Administración completa de equipos con colores personalizados y pilotos asociados
- **Pilotos**: Registro de pilotos con información de país, escudería, moto y puntuación
- **Circuitos**: Base de datos de circuitos internacionales con longitud y ubicación
- **Motos**: Información detallada de las motocicletas de cada equipo

### Funcionalidades de la Interfaz
- Panel de altas para circuitos, escuderías y pilotos
- Visualización de clasificaciones de pilotos y escuderías
- Listados detallados con información visual
- Interfaz personalizada con fuente oficial MotoGP [1](#0-0) 

### Modo Avanzado XML

#### 1. **Exportación de Datos**
El sistema permite exportar todo el campeonato a formato XML estructurado, incluyendo:
- Escuderías con sus pilotos asociados
- Información completa de cada piloto (nombre, país, moto, puntos)
- Circuitos con detalles técnicos [2](#0-1) 

#### 2. **Parser XML**
Sistema de lectura y análisis de documentos XML externos para importar datos de campeonatos históricos. [3](#0-2) 

#### 3. **Consultas XPath**
Funcionalidad avanzada para realizar búsquedas específicas en documentos XML:
- Mostrar los 5 primeros pilotos
- Filtrar pilotos por marca de moto (ejemplo: Yamaha)
- Buscar pilotos por nacionalidad (ejemplo: españoles) [4](#0-3) 

## 🏗️ Estructura del Proyecto

### Paquetes Principales

#### `data`
Contiene las clases del modelo de datos:
- `Campeonato`: Clase principal que gestiona todas las entidades
- `Piloto`: Representa a un piloto con sus atributos
- `Escuderia`: Gestiona equipos y sus pilotos
- `Circuito`: Información de circuitos
- `Moto`: Detalles de las motocicletas
- `Pais`: Enumeración de países [5](#0-4) 

#### `GUI`
Interfaces gráficas para la gestión estándar:
- Paneles de altas (circuitos, escuderías, pilotos)
- Paneles de clasificación
- Paneles de listados y opciones

#### `GUI_XML`
Interfaces para funcionalidades XML avanzadas:
- `XMLExporter`: Exportación a XML
- `XmlParser`: Parsing de documentos XML
- `XPathQueries`: Consultas XPath
- Paneles de búsqueda y modo avanzado

## 💾 Persistencia de Datos

### Sistema de Serialización
El proyecto implementa dos mecanismos de persistencia:

#### 1. **Escuderías**
Guarda y carga automáticamente las asociaciones entre escuderías y pilotos en formato serializado. [6](#0-5) 

#### 2. **Circuitos**
Serialización de circuitos personalizados añadidos por el usuario. [7](#0-6) 

### Guardado Automático
El sistema utiliza un shutdown hook para guardar automáticamente los datos al cerrar la aplicación. [8](#0-7) 

## 🎮 Cómo Ejecutar

### Requisitos
- Java JDK 8 o superior
- NetBeans IDE (recomendado) o cualquier IDE compatible con proyectos Ant

### Compilación y Ejecución
```bash
# Con NetBeans
Abrir el proyecto y ejecutar desde el IDE

# Con Ant desde línea de comandos
ant clean build
ant run
``` [9](#0-8) 

### Punto de Entrada
La aplicación inicia desde la clase `Main` que crea una instancia de la aplicación con el nombre "MOTOGP2024". [10](#0-9) 

## 📊 Datos de Prueba

El sistema incluye datos de prueba precargados con:
- 11 escuderías oficiales del campeonato 2024
- 22 pilotos con puntuaciones aleatorias
- 18 circuitos internacionales [11](#0-10) 

## 📁 Estructura de Archivos

```
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
- **Java Swing**: Interfaz gráfica
- **DOM Parser**: Manipulación de XML
- **XPath**: Consultas avanzadas en XML
- **Serialización Java**: Persistencia de datos
- **TreeSet/HashSet**: Gestión de colecciones ordenadas

### Patrones y Características
- Serialización de objetos para persistencia
- Implementación de `Comparable` para ordenación automática
- Uso de `equals` y `hashCode` personalizados
- Shutdown hooks para guardado automático [12](#0-11) 

## 📝 Notas

- Los archivos de datos se guardan automáticamente en `res/storage/`
- Las exportaciones XML se generan en `res/storage/campeonato2024.xml`
- El proyecto incluye un archivo XML de ejemplo de pilotos históricos: `___dalesEsteArch__ridersMotoGP.xml`
- La fuente personalizada MotoGP se carga automáticamente al iniciar

## 🎨 Personalización

Cada escudería incluye colores primarios y secundarios personalizados para la interfaz visual: [13](#0-12) 

---

**Desarrollador**: Rubén  
**Proyecto**: Sistema de Gestión de Campeonato MotoGP 2024

### Citations

**File:** src/data/Campeonato.java (L19-28)
```java
public class Campeonato  {
    private List<Moto> motos = new ArrayList<>();
    private List<Piloto> pilotos = new ArrayList<>();
    private Set<Circuito> circuitos = new TreeSet<>();
    private Set<Circuito> circuitosAdd = new HashSet<>();
    private List<Escuderia> escuderias = new ArrayList<>();
    
    
    private String nombreCampeonato;
    private Font fuenteMotoGP;
```

**File:** src/data/Campeonato.java (L45-52)
```java
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { 
            try { 
                FicheroEscuderias.guardarFichero(escuderias);
                FicheroCircuito.guardarCircuitos(this.circuitosAdd);
            } catch (IOException ex) {
                Logger.getLogger(Campeonato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
```

**File:** src/data/Campeonato.java (L66-80)
```java
    private void crearFuenteMotoGP(){
        try {
            //Especificar la ruta del archivo .ttf
            String rutaArchivoTTF = ".\\res\\fonts\\MotoGPDisplay-Bold.ttf";

            //Crea un objeto File con la ruta del archivo .ttf
            File archivoTTF = new File(rutaArchivoTTF);

            //Carga la fuente desde el archivo .ttf
           fuenteMotoGP = Font.createFont(Font.TRUETYPE_FONT, archivoTTF);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
```

**File:** src/GUI_XML/XMLExporter.java (L23-94)
```java
    public void exportarCampeonato(Campeonato campeonato, String archivoSalida) {
        try {
            // Crear un nuevo documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Nodo raíz
            Element campeonatoElement = doc.createElement("campeonato");
            doc.appendChild(campeonatoElement);

            // Escuderías
            Element escuderiasElement = doc.createElement("escuderias");
            campeonatoElement.appendChild(escuderiasElement);

            for (Escuderia escuderia : campeonato.getEscuderias()) {
                Element escuderiaElement = doc.createElement("escuderia");
                escuderiasElement.appendChild(escuderiaElement);
                agregarElemento(doc, escuderiaElement, "nombre", escuderia.getNombre());

                for (Piloto piloto : escuderia.getPilotos()) {
                    Element pilotoElement = doc.createElement("piloto");
                    escuderiaElement.appendChild(pilotoElement);

                    // Añadir los datos del piloto
                    agregarElemento(doc, pilotoElement, "nombre", piloto.getNombre());
                    agregarElemento(doc, pilotoElement, "pais", piloto.getPais().name());
                    agregarElemento(doc, pilotoElement, "moto", piloto.getMoto().getModelo());
                    agregarElemento(doc, pilotoElement, "puntos", String.valueOf(piloto.getPuntos()));
                }
            }

            // Circuitos
            Element circuitosElement = doc.createElement("circuitos");
            campeonatoElement.appendChild(circuitosElement);

            for (Circuito circuito : campeonato.getCircuitos()) {
                Element circuitoElement = doc.createElement("circuito");
                circuitosElement.appendChild(circuitoElement);

                // Añadir los datos del circuito
                agregarElemento(doc, circuitoElement, "nombre", circuito.getNombre());
                agregarElemento(doc, circuitoElement, "pais", circuito.getPais());
                agregarElemento(doc, circuitoElement, "longitud", String.valueOf(circuito.getLongitud()));
            }

            // Guardar el documento en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoSalida));

            transformer.transform(source, result);

//            System.out.println("Archivo XML exportado correctamente a: " + archivoSalida);
            
            String nombreArchivo = "campeonato2024.xml";
            String rutaGuardado = "res\\storage\\campeonato2024.xml";
            String mensaje = "<html><div style='text-align: center;'>El archivo " + nombreArchivo + 
            " ha sido guardado exitosamente en:<br>" + rutaGuardado + "</div></html>";
            JOptionPane.showMessageDialog(null, mensaje, "CONFIRMADO", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            String mensaje = "<html><div style='text-align: center;'>Ha ocurrido un error al exportar el campeonato:<br> " + 
                  e.getMessage()  + "</div></html>";

                JOptionPane.showMessageDialog(null, mensaje, "CONFIRMADO", JOptionPane.ERROR_MESSAGE);
        }
    }
```

**File:** src/GUI_XML/XmlParser.java (L15-42)
```java
public class XmlParser {
    
    private Document document;

    public XmlParser(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.document = builder.parse(new File(filePath));
        this.document.getDocumentElement().normalize();
    }
    
    public String getXmlAsString() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);

        return writer.toString();
    }

    public Document getDocument() {
        return document;
    }
    
}
```

**File:** src/GUI_XML/XPathQueries.java (L27-53)
```java
    public void mostrarCincoPrimeros() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//row[position() <= 5]/data1", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            resultados.add("- " + nodes.item(i).getTextContent());
        }
    }

    public void numeroNombreYamaha() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//row[data3='Yamaha']/data1", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            resultados.add("- " + nodes.item(i).getTextContent());
        }
    }

    public void pilotosEsp() throws Exception {
        NodeList nodes = (NodeList) xPath.evaluate("//row[contains(data1, '(ESP)')]/data1", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            resultados.add("- " + nodes.item(i).getTextContent());
        }
    }

    
    public void ejecutarConsultas() throws Exception {
        mostrarCincoPrimeros();
        numeroNombreYamaha();
        pilotosEsp();
    }
```

**File:** src/data/FicheroEscuderias.java (L23-47)
```java
    //Guardar escuderías en un archivo
    public static void guardarFichero(List<Escuderia> escuderias) throws IOException {
        //Validar si el archivo no existe, se crea automáticamente al abrir FileOutputStream
        File archivo = new File(RUTA_FICHERO_ESCUDERIAS);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            // Serializamos solo el nombre de la escudería y los nombres de los pilotos
            List<Map<String, List<String>>> datosSerializados = new ArrayList<>();
            for (Escuderia escuderia : escuderias) {
                System.out.println(escuderia.getNombre());
                Map<String, List<String>> escuderiaInfo = new HashMap<>();
                List<String> nombresPilotos = new ArrayList<>();
                for (Piloto piloto : escuderia.getPilotos()) {
                    System.out.println(" -" + piloto.getNombre());
                    nombresPilotos.add(piloto.getNombre());
                }
                escuderiaInfo.put(escuderia.getNombre(), nombresPilotos);
                datosSerializados.add(escuderiaInfo);
            }
            oos.writeObject(datosSerializados);
        }
    }
```

**File:** src/data/FicheroCircuito.java (L19-27)
```java
    public static void guardarCircuitos(Set<Circuito> circuitos) throws FileNotFoundException, IOException{
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO))){
            os.writeObject(circuitos);
            System.out.println("DATOS GUARDADOS EN "+RUTA_FICHERO);
        }catch(IOException e){
            e.printStackTrace();
            System.err.println("ERROR AL GUARDAR LOS DATOS EN EL FICHERO :(");
        }
    }
```

**File:** build.xml (L10-11)
```text
<project name="CampeonatoMotoGP" default="default" basedir=".">
    <description>Builds, tests, and runs the project CampeonatoMotoGP.</description>
```

**File:** src/data/Main.java (L4-10)
```java
public class Main {

    public static void main(String[] args) {
        App app = new App("MOTOGP2024");
    }
    
}
```

**File:** src/data/App.java (L31-40)
```java
        datosPrueba(campeonato2024);
        datosPruebaCircuito(campeonato2024);
        
        campeonato2024.cargarFicheroEscuderias(false);
     
        
//        campeonato2024.mostrarCircuitos();
        
        modoGrafico();
    }
```

**File:** src/data/Circuito.java (L6-17)
```java
public class Circuito implements Comparable<Circuito>, Serializable{
    private String nombre;
    private String pais;
    private String imagen;
    private double longitud;

    public Circuito(String nombre, String pais, double longitud, String imagen) {
        this.nombre = nombre;
        this.pais = pais;
        this.longitud = longitud;
        this.imagen = imagen;
    }
```

**File:** src/data/Escuderia.java (L23-29)
```java
    public Escuderia(String nombre, Pais Pais, String rutaImagen,Color colorPrimario,Color colorSecundario) {
        this.nombre = nombre;
        this.Pais = Pais;
        this.rutaImagen = rutaImagen;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
    }
```
