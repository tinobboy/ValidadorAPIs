# API Testing Framework

Este es un framework para realizar pruebas de backend desarrollado en **Java** utilizando **Cucumber**, **Gradle**, **RestAssured** y **JUnit**. El framework está diseñado para facilitar la creación, ejecución y mantenimiento de pruebas automatizadas para APIs.


> [!IMPORTANT]
>## Prerequisitos
>Antes de comenzar, asegúrate de tener instalado y agregado a variables de entorno lo siguiente:
> 
>  **Java 11 JDK**: El framework está desarrollado en Java, por lo que necesitas tener instalado el JDK 11.
> 
>  **Gradle 7.6.4 o superior**: Gradle se utiliza para la gestión de dependencias y la construcción del proyecto.


>[!NOTE]
> Documentacion BackEnd: [https://rickandmortyapi.com/documentation](https://rickandmortyapi.com/documentation/#character-schema)


Estructura del proyecto
src/
├── test/java/steps/APISteps       # Steps excecutions y validaciones de los escenarios escritos en cucumber
├── test/resources/features        # Test de los escenarios escritos en cucumber


## Cómo ejecutar los tests en IntelliJ IDEA
1. clonar el proyecto en git bash con el comando "git clone https://github.com/tinobboy/ValidadorAPIs.git"
   
3. Configurar el proyecto en IntelliJ IDEA
- Abre IntelliJ IDEA.
- Selecciona File > Open y elige el directorio del proyecto.
- Asegúrate de que IntelliJ IDEA reconozca el proyecto como un proyecto Gradle. Si no lo hace, ve a File > Project Structure > Project y selecciona el SDK de Java 11.
- Sincroniza el proyecto con Gradle haciendo clic en el botón Refresh en la pestaña Gradle (generalmente en el lado derecho de la ventana).

3. Ejecutar todos los tests
- Navega a la clase TestsBDD en src\test\java\test\java\tests\TestsBDD.java
- Haz clic derecho sobre la clase y selecciona Run 'TestsBDD'.
- Esto ejecutará todos los tests definidos en los archivos .feature dentro de src/test/resources/features.
