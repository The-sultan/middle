<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
      <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
      </style>
    </head>
    <body>
        <h2>Número de Cliente: ${idCliente}</h2>
        Total de puntos acumulados: ${puntos}
        <br>
      
        <table style="width:100%">
          <caption>Historial de Pagos</caption>
          <tr>
            <th>Fecha y Hora</th>
            <th>Codigo Moneda</th>
            <th>Monto</th>
            <th>Puntos Generados</th>
          </tr>
          
          ${historial}
        </table>
    
    </body>
</html>