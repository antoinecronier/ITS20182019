<div>
${key1}
</div>
<div>
${key2}
</div>
<div>
${key3?c}
</div>
<div>
${key4}
${key4.getFirstname()}
${key4.getLastname()}
${key4.getLogin()}
${key4.getPassword()}
${key4.getRole()}
${key4.getRole().getName()}
</div>
<div>
${key5?string('dd.MM.yyyy')}
</div>
<div>
<#list key6 as field>
    ${field}
</#list>
</div>
<div>
<#list key7 as field>
    ${field.getName()}
</#list>
</div>
<div>
<form action="/index" method="POST">
    <table>
        <tr><td>Id:</td><td><input type='text' name='id' value=''/></td></tr>
        <tr><td>Name:</td><td><input type='text' name='name' value=''/></td></tr>

        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>

    </table>
</form>
</div>
<a href="/index/1">Navigate</a>