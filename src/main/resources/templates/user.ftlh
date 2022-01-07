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
    <form method="post" action="/profile/update" class="ui form">
        <div class="field">
            <label>Имя:</label>
            <input name="displayName" value="${user.displayName}">
        </div>
        <div class="field">
            <label>Ник:</label>
            <input name="nickName" value="${user.nickName}">
        </div>
        <div class="field">
            <label>email:</label>
            <input name="email" value="${user.email}">
        </div>
        <div class="field">
            <label>О себе:</label>
            <input name="description" value="${user.description}">
        </div>
        <input type="submit" value="Сохранить" class="ui blue button">
        <input formaction="/profile/delete" type="submit" value="Удалить" class="ui negative button">
        <a href="/users/${user.id}">Перейти в ленту</a>
    </form>
</div>
</body>
</html>