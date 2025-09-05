# Sistema de Notas Académicas 📚

Este es un sistema de gestión de notas académicas desarrollado con **Spring Boot**, **Spring Data JPA**, **Spring Web** y **MySQL**. Permite registrar alumnos, cursos y calificaciones, además de generar reportes como promedio por alumno y estado de aprobación.

## 🧱 Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Web
* MySQL
* Docker & Docker Compose
* Postman (para pruebas)

---

## ⚙️ Estructura del proyecto

* `Alumno`: entidad que representa a un estudiante.
* `Curso`: entidad que representa una materia o asignatura.
* `Nota`: entidad intermedia que relaciona alumnos con cursos y almacena la calificación.
* DTOs para exponer y registrar datos de forma limpia.
* Mappers manuales (sin MapStruct).
* Repositorios, servicios y controladores RESTful.

---

## 🚀 Cómo ejecutar con Docker

### 1. Clonar el repositorio

```bash
git clone https://github.com/Jhon-Alv/springboot-notas-academicas-api
cd notas-academicas
```

### 2. Ejecutar con Docker Compose

Asegúrate de tener Docker y Docker Compose instalados. Luego, ejecuta:

```bash
docker-compose up --build
```

Esto levantará:

* Un contenedor para la API `notas-api` en el puerto **8080**
* Un contenedor de **MySQL** con la base de datos `notas_academicas` expuesto en el puerto **3306**

El sistema esperará hasta que MySQL esté listo antes de iniciar la API.

---

## 🛠️ Variables de entorno

Estas están configuradas en `docker-compose.yml`:

```yaml
SPRING_DATASOURCE_URL=jdbc:mysql://notas-mysql-container:3306/notas_academicas
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=admin
```

---

## 📮 Pruebas con Postman

Una vez desplegado, puedes probar la API usando Postman. Aquí hay ejemplos para la opción **2 (uso de `raw` JSON en `POST`)**:

### ➕ Registrar un Alumno

**POST** `http://localhost:8080/api/alumnos`

```json
{
  "nombre": "Juan Pérez"
}
```

---

### ➕ Registrar un Curso

**POST** `http://localhost:8080/api/cursos`

```json
{
  "nombre": "Matemáticas"
}
```

---

### ➕ Registrar una Nota

**POST** `http://localhost:8080/api/notas`

```json
{
  "alumnoId": 1,
  "cursoId": 1,
  "clasificacion": 17.5
}
```

---

### 📊 Reporte de Promedio por Alumno

**GET** `http://localhost:8080/api/notas/reporte/1`

Respuesta esperada:

```json
{
  "nombreAlumno": "Juan Pérez",
  "promedio": 17.5,
  "estado": "APROBADO"
}
```

---

## 🧹 Limpieza

Para detener y eliminar los contenedores, volúmenes y red:

```bash
docker-compose down -v
```

---

## 📝 Autor

* Jhon Alvarado
* [Jhon-Alv](https://github.com/Jhon-Alv)
