/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function CadastrarUsuario()
{
   event.preventDefault() // evita refresh da tela
                
   const URL_TO_FETCH = 'TelaCadastro'

   var formData = new FormData(document.getElementById("fdados"))
   //formData.append('acao', 'confirmar'); opcional, caso queira inserir outra informação
                
   fetch(URL_TO_FETCH, { method: 'post',body: formData 
   }).then(function (response) {
        return response.text()
   }).then(function (retorno) {
        // result recebe a resposta do módulo dinâmico
            document.getElementById('fdados').reset()
            document.getElementById('cadUser').innerHTML = retorno
   }).catch(function (error) {
        console.error(error);
   })
}


