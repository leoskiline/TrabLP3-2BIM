function LogarUsuario()
{   event.preventDefault() // evita refresh da tela
    var usuario = document.getElementById("usuario").value
    var senha = document.getElementById("senha").value
    const URL_TO_FETCH='TelaUsuario?usuario='+usuario+'&senha='+senha
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('ViewUser').innerHTML = result
            MostrarCategoria()
        });
    }).catch (function(err) {console.error(err)})

}



function MostrarCategoria()
{   
    //event.preventDefault() // evita refresh da tela
    var categoria = document.getElementById("categoria").value
    const URL_TO_FETCH='TelaUsuario?acao=mostrar&categoria='+categoria
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('mostrarCat').innerHTML = result
        });
    }).catch (function(err) {console.error(err)})
}

function MostrarCategoria2()
{   
    event.preventDefault() // evita refresh da tela
    var categoria = document.getElementById("categoria").value
    const URL_TO_FETCH='TelaUsuario?acao=mostrar&categoria='+categoria
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('mostrarCat').innerHTML = result
        });
    }).catch (function(err) {console.error(err)})
}

function SelectCategorias(listCategoria)
{
        
        const CategoriasSelect = document.getElementById("cbCategoria")
        var CategoriasList = listCategoria.split(",");
        CategoriasList.forEach((categorias) =>
        {
           option = new Option(categorias, categorias.toLowerCase())
           CategoriasSelect.options[CategoriasSelect.options.length] = option
        })
        return CategoriasList;
}


function GravarCategoria()
{
    event.preventDefault() // evita refresh da tela
    var categoria = document.getElementById("categoria").value
    var cod = document.getElementById("cod").value
    if(categoria.length > 0)
    {
        const URL_TO_FETCH='TelaUsuario?acao=confirmar&categoria='+categoria+'&cod='+cod
        fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
        {
            response.text().then(function(result)  //response é um promisse
            {
                // result contém a resposta do módulo dinâmico
                document.getElementById('gravouCat').innerHTML = result
                document.getElementById('fdados').reset();  
                MostrarCategoria()
            });
        }).catch (function(err) {console.error(err)})  
    }
    else
    {
        document.getElementById('gravouCat').innerHTML = "<div class='alert alert-danger alert-dismissible fade show'><button type='button' class='close' data-dismiss='alert'>&times;</button>Digite algo no campo <strong>Categoria!</strong> </div>"
    }  
    
}




function ApagaAlteraCategoria(acao, cod)
{   //event.preventDefault(); // evita refresh da tela
    var url = ""
    switch (acao)
    {
        case "apagar":
            url = "TelaUsuario?acao=apagar&cod=" + cod
            break
        case "alterar":
            url = "TelaUsuario?acao=alterar&cod=" + cod
            break
    }
    
    fetch(url,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            if (acao === 'apagar')
            {
                document.getElementById('gravouCat').innerHTML = result
                MostrarCategoria()
            } else
            {
                var aux = result;
                var categoria = aux.split(",");
                var form = document.forms["dados"];
                form.cod.value = categoria[0];
                form.categoria.value = categoria[1];
            }
        });
    }).catch (function(err) {console.error(err);});

}