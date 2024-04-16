#!/bin/bash

# Función para instalar Maven en sistemas basados en Debian/Ubuntu
install_maven_debian() {
    echo "Instalando Maven..."
    sudo apt update
    sudo apt install maven -y
    echo "Maven ha sido instalado."
}

# Comprueba si Maven está instalado
if ! [ -x "$(command -v mvn)" ]; then
    # Detecta el sistema operativo y ejecuta la función de instalación correspondiente
    if [ -f /etc/debian_version ]; then
        install_maven_debian
    else
        echo "Sistema operativo no soportado para la instalación automática de Maven."
        exit 1
    fi
else
    echo "Maven está instalado."
fi

# Crea el proyecto usando Maven
mvn archetype:generate \
    -DgroupId=com.endes.biblioteca \
    -DartifactId=biblioteca \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false

# Navega al directorio del proyecto
cd biblioteca

# Eliminar el archivo de prueba generado por defecto que utiliza JUnit 4
rm src/test/java/com/endes/biblioteca/AppTest.java

# Actualiza el pom.xml para JUnit 5
cat << EOF > pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.endes.biblioteca</groupId>
    <artifactId>biblioteca</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- JUnit 5 (Jupiter) dependencies for testing -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
        <!-- Agrega otras dependencias necesarias aquí -->
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <release>8</release>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
EOF

# Crear las clases de Java para Autor y Libro
cat << EOF > src/main/java/com/endes/biblioteca/Autor.java
package com.endes.biblioteca;

public class Autor {
    private String name;
    private String biography;

    // Constructor, getters y setters aquí
}
EOF

cat << EOF > src/main/java/com/endes/biblioteca/Libro.java
package com.endes.biblioteca;

import java.util.List;

public class Libro {
    private String isbn;
    private String title;
    private List<Autor> autores;

    // Constructor, getters y setters aquí
}
EOF

# Crear pruebas para Autor y Libro
mkdir -p src/test/java/com/endes/biblioteca

cat << EOF > src/test/java/com/endes/biblioteca/AutorTest.java
package com.endes.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutorTest {
    @Test
    void testAuthorCreation() {
        Autor autor = new Autor();
        assertNotNull(autor);
    }
}
EOF

cat << EOF > src/test/java/com/endes/biblioteca/LibroTest.java
package com.endes.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {
    @Test
    void testBookCreation() {
        Libro libro = new Libro();
        assertNotNull(libro);
    }
}
EOF
