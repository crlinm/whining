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
    <title>Лента</title>
</head>
<body>
<div class="ui container">
    <div class="ui feed">
<#--        <form method="post" action="/users/${user.id}/whines" class="ui form">-->
<#--            <label>${user.displayName}</label>-->
<#--            <div class="field">-->
<#--                <input name="message" placeholder="О чём поноете сегодня?">-->
<#--            </div>-->
<#--            <button class="ui button" type="submit">Поныть</button>-->
<#--        </form>-->
        <#list whines as whine>
            <div class="event">
                <div class="content">
                    <div class="summary">
                        <a class="user" href="/users/${whine.user.id}">${whine.user.displayName}</a>
                        <div class="meta">
                            @${whine.user.nickName}
                        </div>
                        <div class="date">
                            ${whine.date}
                        </div>
                    </div>
                    <#--                    <div class="ui message">-->
                    <div class="extra text" class="ui floating message">
                        ${whine.message}
                    </div>
                    <#--                    </div>-->
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>

