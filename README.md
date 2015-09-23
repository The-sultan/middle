# middle
Repo para introducción al middleware

Pasos para correr Obligatorio 1

1. Descargar tomcat https://tomcat.apache.org/download-80.cgi.

2. Modificar el archivo tomcat-users.xml en la carpeta conf del tomcat, agregando la siguiente linea.

`<user username="tomcat" password="tomcatuser"`
`roles="tomcat,manager-gui,admin-gui,manager-script" />`

3. Si el S.O. es windows, modificar el archivo context.xml remplazando el tag
`<Context>`
por el tag
`<Context antiResourceLocking="true">`

4. Levantar tomcat, modo debug si prefieren corriendo en la carpeta bin
`catalina jpda start`

5. En una consola, sobre la carpeta raiz del partner1 compilar y deployar al tomcat con:
`mvn tomcat7:deploy`

6. Aplicar el mismo paso que el anterior pero para el partner 2

7. Teniendo ambos partners levantados, compilar y deployar el sistema central, que precisa que ambos partners estén levantados para poder generar los clientes:
`mvn tomcat7:deploy`

8. Si en cualquier momento de desea redeployar algún proyecto:
`mvn tomcat7:redeploy`
