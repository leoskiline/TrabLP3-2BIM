function MostraAnuncios()
{   event.preventDefault() // evita refresh da tela
    var filtro=document.getElementById("categoria").value // verifica o filtro
    const URL_TO_FETCH='APIRestful?categoria='+filtro
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('JSON').innerHTML = result
        });
    }).catch (function(err) {console.error(err)})

}