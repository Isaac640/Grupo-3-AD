# Grupo 3 Módulo de Acceso a Datos 'AD'

# API REST - GUARDIAS - Documentación

## **ÍNDICE DE CONTENIDOS**
1. [INTRODUCCIÓN](#introducción)
2. [CLASES](#clases)
3. [CONSULTAS](#consultas)
   1. [CONSULTAS GENERALES](#consultas-generales)
   2. [CONSULTAS ESPECÍFICAS](#consultas-específicas)
4. [CONCLUSIÓN](#conclusión)

<!-- 
Repositorio para Acceso a Datos
### http://localhost:8080/v2/api-docs 		--- 	Confirmar que Swagger está montado.
### http://localhost:8080/swagger-ui.html 	--- 	Para ver la API 
-->

---

## **INTRODUCCIÓN**

La API REST, es una interfaz que se ajusta a los datos que contiene la Base de Datos de Guardia con el objetivo de permitir la interación de tanto de la Aplicación Móvil como la Aplicación de Escritorio.

---

## **CLASES**
Antes que nada, lo primero de lo que debemos de hablar es un poco las clases que contienen esta Base de Datos.

Estas clases que coincidirán con las tablas de la BD a su vez contendrán una clase Repositorio que es la que nos permitirá realizar otra clase Controlador que será el que realizará las operaciones.

Estas operaciones pueden ser:
* Publicaciones
* Modificaciones
* Eliminaciones
* Consultas de Datos

---

Las Clases que componen las tablas de la Base de Datos son las siguientes:

### **1. Profesor**
La clase `Profesor` contiene la información básica de los profesores para la posterior gestión de las Guardias.

### **2. Perfiles**
La clase `Perfil` contiene los distintos perfiles de los usuarios que tendrán que ver con los permisos de acceso a las diferentes aplicaciones tanto móvil como de escritorio

### 3. Profesor Tiene Perfil
La clase `Profesor Tiene Perfil` tiene como objetivo contener dentro de ella todas las perfiles de usuario que pueda tener un profesor.

### **4. Horario**
La clase `Horario` contiene los diferentes horarios que tiene el centro. 
Cada uno de los horarios indica que un determinado profesor tiene en una hora lectiva clase con un grupo en un determinado aula.

### 5. Horario Guardia
La clase `Horario Guardia` contiene la información que relaciona directamente a un profesor con una Guardia

### **6. Guardia**
La clase `Guardia` contiene la información acerca de todas las guardias que en un futuro necesiten o que ya hayan sido cubiertas por un profesor.

### 7. Aviso Guardia
La clase `Aviso Guardia` tendrá como objetivo registrar futuras faltas tanto sea solo unas horas o sea en un mismo día completo.<br/>
Esto sirve para para registrar las faltas, retrasos o problemas que no han sido revistos con antelación.

### 8. Baja Permiso
La clase `Baja Permiso` contiene toda la información acerca de las bajas médicas, permisos y otros menesteres concedidos a los profesores.

---

## **CONSULTAS**

Ahora hablaremos de forma breve de todas las consultas realizadas, para qué sirven estas consultas y que aplicación va a usuarlas. Hay que tener en cuenta que va a haber consultas que pueden ser usadas tanto por la Aplicación Móvil como por la Aplicación de Escritorio.

Para empezar hay que hablar de una consulta que contiene todas las clases de la API. Esa consulta es un obtener todos.<br/>
Esta consulta salvo en obtención de los datos en alguna tabla sin filtros no tiene utilidad y ha servido sobre todo para comprobar que la API REST se estaba conectando con la Base de Datos de Guardias y se estaban obteniendo datos en formato JSON de esa misma consulta.<br/>
La consulta de obtener todos es la misma para todas las clases y sigue esta estructura.

```java
@GetMapping("/todos")
	public List<Clase> obtenerTodos(){
		return claseRepositorio.findAll();
	}
```

---

### **CONSULTAS GENERALES**

Una vez ya comentada la consulta que poseen todas las clases vamos a las consultas generales.

- **Consultas de búsqueda por ID**.<br/>
Tienen como objetivo realizar la búsqueda de un único registro utilizando como filtro la propia PK de la tabla. Todas las clases que poseen una búsqueda por ID siguen la misma estructura que es la siguiente:

```java
@GetMapping("/buscarId")
	public Clase buscarId(@RequestParam(value = "id", defaultValue = "0") int id) {
		return claseRepositorio.findById(id).get();
	}
```

- **Consultas de Creación de Datos**.<br/>
Tiene como objetivo que a través de un proceso realizado tanto por la aplicación móvil como por la aplicación de escritorio, esto añada un dato dentro de la Base de Datos. Todas las clases que tenga un método de creación seguirán la misma estructura.

```java
@PostMapping("/add")
	public boolean crearElementoClase(@RequestBody Clase clase) {
      /**
       * EN CASO DE QUE TENGA RELACIÓN CON OTRA CLASE DIFERENTE, EJEMPLO UNA
       * CLASE DE HORARIOS
       */ 		
		clase.setHorario(obtenerTodos().get(0).getHorario());
		
		if (clase != null && clase.getId() == 0) {
			claseRepositorio.save(clase);
			return true;
		}
		
		return false;
	}
```

- **Consultas de Actualización de Datos**.<br/>
Tiene como objetivo que los datos que se hayan modificado de un registro ya sea por medio de la Aplicación Móvil como de la Aplicación de Escritorio sean guardados en la Base de Datos. Todas las clases que tengan un método de actualización de datos seguirán una estructura como la siguiente:

```java
@PostMapping("/actualizar")
	public boolean actualizarElementoClase(@RequestBody Clase clase) {
      /**
       * EN CASO DE QUE TENGA RELACIÓN CON OTRA CLASE DIFERENTE, EJEMPLO UNA
       * CLASE DE HORARIOS
       */
      try{
         clase.setHorario(obtenerTodos().get(0).getHorario());
		
         if (clase != null && clase.getId() != 0) {
            claseRepositorio.save(clase);
            return true;
         } 
      } catch (Exception e){
         return false;
      }
		
      return false;
	}
```

- **Consultas de Eliminación de Datos**.<br/>
Su función es eliminar un registro de la Base de Datos ya que se ha realizado un proceso de eliminación en la Aplicación Móvil o en la Aplicación de Escritorio. Todas las clases que tengan un método de eliminado de datos seguirán una estructura como la siguiente:

```java
@PostMapping("/eliminar")
	public boolean eliminar(@RequestHeader(value = "id", defaultValue = "0") int id) {
		try {
			claseRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
```

---

### **CONSULTAS ESPECÍFICAS**

Una vez comentadas posibles métodos repetidos dentro de la API REST, ahora comentaremos las consultas que solo tienen una única función y que por lo tanto se usan en una única clase.<br/>
Estas consultas son:

- **Login de Usuario** (Ejemplo: Profesor): Esta consulta se utiliza verificar el inicio de sesión de un usuario. Esta funcionalidad la utilizan tanto la Aplicación Móvil como la Aplicación Web.<br/>
Lo que hace es que al recibir de la Aplicación el usuario y la contraseña, esos datos se cotejan en la Base de Datos. Si no hay ningún usuario y contraseña se devuelve un 0 y si hay un usuario y contraseña que coinciden con las datos que se han introducido se devuelve el ID de ese usuario (Profesor).<br/>
Esta consulta la puede localizar en la clase repositorio `Login Controller`

```java
public int greeting(String user, String passwd)
```

- **Autorellenado**: Esta consulta consiste en que mientras en la Aplicación de Escritorio filtramos el contenido de una lista por medio de unos parámetros, la propia aplicación nos indica sin necesidad de finalizar todo, una lista de los Datos más acordes a los filtros indicados.<br/>
Todo esto se realizará a la vez que se está modificando el filtro.<br/>
Debajo se puede ver que son los datos que recoge el autorrellenado de la aplicación

```java
public List<String> autoRellenar(int id, int dia, int hora)
```

---

## **CONCLUSIÓN**
Con esto concluye la documentación de la API REST realizada para la parte de AD (Acceso a Datos).<br/>
Esta documentación sirve sobre todo para que si alguien que no ha programado esta aplicación lee esta documentación, pueda entender su funcionamiento y en caso de modificar o añadir algo nuevo, además de añadirlo a una nueva versión de la documentación, sirve para que estas operaciones concluyan en el menor de los plazos posibles.