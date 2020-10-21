/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function CadastrarAnuncio()
{   event.preventDefault() // evita refresh da tela
    var acao = document.getElementById("acao").value
    var descricao = document.getElementById("descricao").value
    var horario_atendimento = document.getElementById("horario_atendimento").value
    var categoriaCad = document.getElementById("categoriaCad").value
    var contato = document.getElementById("contato").value
    var foto1 = document.getElementById("foto1").value
    var foto2 = document.getElementById("foto2").value
    var foto3 = document.getElementById("foto3").value
    const URL_TO_FETCH='TelaUsuario?acao='+acao+'&descricao='+descricao+'&horario_atendimento='+horario_atendimento+'&categoriaCad='+categoriaCad+'&foto1='+foto1+'&foto2='+foto2+'&foto3='+foto3+'&contato='+contato
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('cadAnuncio').innerHTML = result
            document.getElementById('fdados').reset();  
            
        });
    }).catch (function(err) {console.error(err)})

}

