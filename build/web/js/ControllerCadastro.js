/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function CadastrarUsuario()
{   event.preventDefault() // evita refresh da tela
    var usuario = document.getElementById("usuario").value
    var senha = document.getElementById("senha").value
    var foto = document.getElementById("foto").value
    var nome = document.getElementById("nome").value
    var logradouro = document.getElementById("logradouro").value
    const URL_TO_FETCH='TelaCadastro?usuario='+usuario+'&senha='+senha+'&foto='+foto+'&nome='+nome+'&logradouro='+logradouro
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('ViewUser').innerHTML = result
            document.getElementById('fdados').reset();  
            
        });
    }).catch (function(err) {console.error(err)})

}

