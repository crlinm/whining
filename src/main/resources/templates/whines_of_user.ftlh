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
    <title>${user.displayName} (@${user.nickName})</title>
</head>
<body>
<br>
<#--<div class="ui  modal">-->
<#--    <div class="ui icon header">-->
<#--        <i class="archive icon"></i>-->
<#--        Archive Old Messages-->
<#--    </div>-->
<#--    <div class="content">-->
<#--        <p>Your inbox is getting full, would you like us to enable automatic archiving of old messages?</p>-->
<#--    </div>-->
<#--    <div class="actions">-->
<#--        <div class="ui red basic cancel inverted button">-->
<#--            <i class="remove icon"></i>-->
<#--            No-->
<#--        </div>-->
<#--        <div class="ui green ok inverted button">-->
<#--            <i class="checkmark icon"></i>-->
<#--            Yes-->
<#--        </div>-->
<#--    </div>-->
<#--</div>-->
<#--<script>-->
<#--    $('.ui.modal')-->
<#--        .modal('show')-->
<#--    ;-->
<#--</script>-->
<div class="ui container">
    <div class="ui header">
        ${user.displayName}
    </div>
    <#if user.id==authenticatedUserId>
        <form method="post" action="/whine" class="ui form">
            <div>
                <a class="ui button grey basic mini" href="/profile">Редактировать профиль</a>
                <a class="ui button basic mini" href="/home">Вернуться в общую ленту</a>
<#--                <button class="ui button">-->
<#--                    Follow-->
<#--                </button>-->
            </div>
            <div class="ui divider hidden">
            </div>
            <div class="field">
                <input name="message" placeholder="О чём поноете сегодня?">
            </div>
            <button class="ui button" type="submit">Поныть</button>
        </form>
    </#if>
<#--    <a class="ui button basic mini" href="/home">Вернуться в общую ленту</a>-->
    <div class="ui feed">
        <#list whines as whine>
        <#--            <div class="event segment ui">-->
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
                    <#if whine.user.id==authenticatedUserId>
                        <div class="meta">
                            <form method="post" action="/whines/${whine.id}/delete">
                                <button type="submit" class="ui icon button negative">
                                    <i class="trash alternate outline icon"></i>
                                </button>
<#--                                <i class="pen square icon">-->
<#--                                    <input formaction="/whines/${whine.id}/update" type="submit">-->
<#--                                </i>-->
<#--                                <button>-->
<#--&lt;#&ndash;                                    <i class="pen square icon"></i>&ndash;&gt;-->
<#--                                    <i class="pencil alternate icon"></i>-->
<#--                                </button>-->
                                <button formaction="/whines/${whine.id}/update" type="submit" class="ui icon button">
                                    <i class="pencil alternate icon"></i>
                                </button>
                            </form>
                        </div>
                    </#if>
                    <#--                    </div>-->
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>

