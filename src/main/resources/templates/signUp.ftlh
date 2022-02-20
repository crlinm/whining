<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="https://unpkg.com/fomantic-ui@2.8.8/dist/semantic.min.css">
    <script src="https://unpkg.com/fomantic-ui@2.8.8/dist/semantic.min.js"></script>
    <title>Создайте свой аккаунт</title>
</head>
<body>
<br>
<div class="ui container">
    <form method="post" action="/signUp" class="ui form">
        <div class="ui header">
            Создайте свой аккаунт
        </div>
        <div class="field">
<#--            <label>Имя:</label>-->
            <input name="displayName" placeholder="Имя">
        </div>
        <div class="field">
<#--            <label>Ник</label>-->
            <input name="nickName" placeholder="Ник">
        </div>
        <div class="field">
<#--            <label>Адрес электронной почты</label>-->
            <input type="email" name="email" placeholder="Адрес электронной почты">
        </div>
        <div class="field">
<#--            <label>О себе</label>-->
            <input type="password" name="password" placeholder="Пароль">
        </div>
        <input type="hidden" name="description" value="">
        <button class="ui button" type="submit">Зарегистрироваться</button>
    </form>
    <br>
    Уже есть аккаунт? <a href="/signIn">Войти</a>
</div>
</body>
</html>
