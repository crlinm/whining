<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="https://unpkg.com/fomantic-ui@2.8.8/dist/semantic.min.css">
    <script src="https://unpkg.com/fomantic-ui@2.8.8/dist/semantic.min.js"></script>
    <title>${user.displayName}</title>
</head>
<body>
<div class="ui container">
<#--    <h3>Имя - ${user.displayName}</h3>-->
<#--    <h3>Ник - ${user.nickName}</h3>-->
<#--    <h3>Почта - ${user.email}</h3>-->
<#--    <h3>О себе - ${user.description}</h3>-->
<#--    <br>-->
    <form method="post" action="/users/${user.id}/update" class="ui form">
        <label>
            Имя: <input name="displayName" value="${user.displayName}">
        </label>
        <label>
            Ник: <input name="nickName" value="${user.nickName}">
        </label>
        <label>
            Почта: <input name="email" value="${user.email}">
        </label>
        <label>
            О себе: <input name="description" value="${user.description}">
        </label>
        <input type="submit" value="Сохранить" class="ui button">
    </form>
</div>
</body>
</html>