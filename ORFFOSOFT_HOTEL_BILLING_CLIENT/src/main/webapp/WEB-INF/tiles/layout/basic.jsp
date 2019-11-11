<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en" class="fullscreen-bg">
<head>
<title>
<tiles:getAsString name="title" />
</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

</head>
<body>
<!-- Header -->
<tiles:insertAttribute name="header" />
<!-- Body -->
<tiles:insertAttribute name="body" />
<!-- Footer -->
<tiles:insertAttribute name="footer" />
<tiles:insertAttribute name="script" />
</body>


</html>