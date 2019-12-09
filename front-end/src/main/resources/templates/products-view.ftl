<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gerencia Pais</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <div class="jumbotron">
        <h1>Busca de Produtos</h1>
        <p>Essa página é responsável por listar os produtos. </p>
    </div>
       <div class="row">
        <div class="col">
            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Tecnologias</th>
                    <th>Mercado Alvo</th>
                </tr>
                </thead>
                <tbody>
                <#list products as product>
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td><ul>
                        <#list product.technologies as technology>
                        <li>${technology.name}</li>
                            </#list>
                            </ul></td>
                        <td><ul>
                        <#list product.targets as target>
                            <li>${target.name}</li>
                        </#list>
                        </ul></td>

                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>