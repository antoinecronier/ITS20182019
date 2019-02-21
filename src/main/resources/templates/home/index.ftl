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












