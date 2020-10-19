function MostraAnuncios()
{   event.preventDefault() // evita refresh da tela
    var filtro=document.getElementById("filtro").value // verifica o filtro
    const URL_TO_FETCH='TelaAnuncios?acao=consultar&filtro='+filtro
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('tabelaAnuncios').innerHTML = result
        });
    }).catch (function(err) {console.error(err)})

}
