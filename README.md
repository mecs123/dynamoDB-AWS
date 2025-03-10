# Proyecto: API REST con Spring Boot y DynamoDB

## 📌 Descripción
Este proyecto es una API REST básica desarrollada con **Spring Boot** y **AWS DynamoDB** como base de datos NoSQL. La API permite realizar operaciones CRUD sobre una entidad **Usuario**.

## 🔥 Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3**
- **AWS SDK for Java v2**
- **DynamoDB Local (para pruebas)**
- **Lombok** (para reducir código boilerplate)
- **Spring Web** (para crear la API REST)
- **Spring Boot DevTools** (para desarrollo)
- **Docker** (opcional, para levantar DynamoDB Local)

## 🚀 Flujo de Desarrollo de la API

1. **Configurar AWS IAM**
   - Crear un usuario IAM en AWS con permisos sobre DynamoDB.
   - Generar `Access Key` y `Secret Key`.

2. **Configurar DynamoDB**
   - Crear la tabla `usuarios` en **AWS DynamoDB** con:
     - 📌 **Llave primaria (Partition Key)** → `usuarioId` (String)
     - 📌 **Llave compuesta (Partition Key + Sort Key, si aplica)** → `usuarioId` + `email`
     - 📌 **Índice Secundario Local (LSI)** → `email` (para búsquedas rápidas por email dentro de la misma partition)
     - 📌 **Índice Secundario Global (GSI)** → `pais` (para consultar usuarios por país)

3. **Configurar el Proyecto Spring Boot**
   - Agregar dependencias en `pom.xml` para AWS SDK y DynamoDB.
   - Configurar credenciales de AWS en `application.yml`.

4. **Crear la Entidad `Usuario`**
   - Definir la clase con anotaciones de DynamoDB.
   - Incluir atributos como `usuarioId`, `nombre`, `email`, `pais`, `fechaCreacion`.

5. **Implementar el Repositorio DynamoDB**
   - Usar `DynamoDbEnhancedClient` para manejar la base de datos.
   - Definir métodos para `save`, `findById`, `deleteById` y `findByGSI` (búsquedas por `pais`).

6. **Crear el Servicio (`UsuarioService`)**
   - Implementar la lógica de negocio.
   - Manejar validaciones antes de guardar en DynamoDB.

7. **Desarrollar el Controlador (`UsuarioController`)**
   - Implementar endpoints:
     - `POST /usuarios` → Crear usuario
     - `GET /usuarios/{id}` → Obtener usuario por ID
     - `DELETE /usuarios/{id}` → Eliminar usuario
     - `GET /usuarios/pais/{pais}` → Buscar usuarios por país (usando GSI)

8. **Probar la API**
   - Usar **Postman** o `curl` para pruebas.
   - Verificar que los datos se almacenan correctamente en DynamoDB.

9. **Implementar pruebas unitarias e integración**
   - Usar `@SpringBootTest` con un mock de DynamoDB.

## 📖 Configuración de Credenciales AWS
Para conectar la API con AWS, configurar las credenciales en `application.yml` o mediante variables de entorno:

```yaml
aws:
  accessKey: ""
  secretKey: ""
  region: "us-east-1"
  dynamodb:
    endpoint: "https://dynamodb.us-east-1.amazonaws.com"
```

Para pruebas en **DynamoDB Local**, cambiar `endpoint` a `http://localhost:8000`.

## 🛠 Comandos Útiles

**Levantar DynamoDB Local con Docker:**
```sh
docker run -p 8000:8000 amazon/dynamodb-local
```

**Ejecutar la API:**
```sh
mvn spring-boot:run
```

**Probar la API con `curl`:**
```sh
curl -X POST http://localhost:8080/usuarios -H "Content-Type: application/json" -d '{"usuarioId":"1","nombre":"Juan","email":"juan@email.com","pais":"CO"}'
```

## 📌 Conclusión

✅ Configurar una API con **Spring Boot** y **DynamoDB**.
✅ Conectar la API a **AWS** con credenciales seguras.
✅ Implementar CRUD con **DynamoDBEnhancedClient**.
✅ Usar **GSI y LSI** para mejorar consultas.
