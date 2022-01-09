<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="content" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<html>
<head>
    <d:head/>
</head>
<body class="fixed-left ">
<div id="wrapper" class="enlarged">
    <d:header/>
    <jsp:invoke fragment="content"/>
</div>
<d:js-plugin/>
</body>
</html>