<%@page language="java" contentType="text/html"%>
<%@page isThreadSafe="false"%>
<%! int k = 0;%>
<html><head><title>Concurrency</title></head><body>
<%
  out.print(k);
  int j = k + 1;
  Thread.sleep(5000); // nos ayudara a observar el comportamiento esperando 5 segundos.
  k = j;
  out.println(" -> " + k);
  %>
</body></html>