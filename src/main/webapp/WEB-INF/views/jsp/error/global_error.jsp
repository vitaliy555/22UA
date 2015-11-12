<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Opsss Exception : </h2>

	<c:if test="${not empty ex}">
		<h2>${ex}</h2>
	</c:if>

</body>
</html>