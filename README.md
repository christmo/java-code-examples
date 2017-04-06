# java-code-examples
Pruebas de Librerías y Códigos de java para utilitarios


- Generación de OTP
- Compresión de Objetos con gzip
- Busqueda de Anotaciones en ClassPath
- Maven release plugin
    - mvn release:prepare --> actualiza las versiones y crea en el repo el tag
    - mvn -B release:prepare --> no interactivo
    - mvn release:perform --> envia al servidor nexus --> se debería tener un perfil para release
    - mvn release:rollback --> regresa las versiones a como estaba y hace rollback en el repo
    - mvn release:clean
    - mvn release:update-versions

- I18N
- DBUnit