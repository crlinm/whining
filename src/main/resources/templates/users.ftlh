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
    <title>Пользователи</title>
</head>
<body>
<div class="ui container">
<#--    <h1> Добавление пользователя</h1>-->
<#--    <form method="post" action="/users" class="ui form">-->
<#--        <div class="field">-->
<#--            <label><@spring.message 'users.form.input.firstName'/>:</label>-->
<#--            <input name="displayName" placeholder="<@spring.message 'users.form.input.firstName'/>">-->
<#--        </div>-->
<#--        <div class="field">-->
<#--            <label>Ник</label>-->
<#--            <input name="nickName" placeholder="Ник">-->
<#--        </div>-->
<#--        <div class="field">-->
<#--            <label>Адрес электронной почты</label>-->
<#--            <input name="email" placeholder="email">-->
<#--        </div>-->
<#--        <div class="field">-->
<#--            <label>О себе</label>-->
<#--            <input name="description" placeholder="О себе">-->
<#--        </div>-->
<#--        <button class="ui button" type="submit">Добавить</button>-->
<#--    </form>-->
    <#if errors??>
        <h1 style="color: red">${errors}</h1>
    </#if>
    <br>
    <br>
    <table class="ui celled table compact striped sortable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Ник</th>
            <th>Почта</th>
            <th>О себе</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.displayName}</td>
                <td>${user.nickName}</td>
                <td>${user.email}</td>
                <td>${user.description}</td>
                <td>
<#--                    <form method="post" action="/users/${user.id}/delete">-->
<#--                        <input type="submit" value="Удалить" class="ui negative button">-->
<#--                    </form>-->
                    <a href="/users/${user.id}">Перейти</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>

