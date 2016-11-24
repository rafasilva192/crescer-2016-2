var itemMagicoIndex = {};

itemMagicoIndex.paginaAtual = 0;

itemMagicoIndex.excluir = function (id) {
    $.ajax({
        url: 'ItemMagico/Excluir/' + id,
        type: 'POST'
    })
    .then(function (resultado) {
        alert(resultado.Mensagem);
        itemMagicoIndex.carregarListaDeItens();
        itemMagicoIndex.carregarItensRaros();
    });
}

itemMagicoIndex.carregarListaDeItens = function () {
    $.ajax({
        url: 'ItemMagico/CarregarListaComTodosOsItens',
        type: 'GET',
        data: {
            pagina: itemMagicoIndex.paginaAtual
        }
    })
    .then(function (resultado) {
        $('#container-lista').html(resultado);
        itemMagicoIndex.atualizarBotoesDeNavegacao();

        return $.ajax({
            url: 'ItemMagico/FazNada',
            type: 'GET'
        });
    })
    .then(function (resultadoFazNada) {
        console.log(resultadoFazNada.Mensagem);
    })
    .fail(function (erro) {
        console.error(erro);
    });
}

itemMagicoIndex.carregarItensRaros = function () {
    $.ajax({
        url: 'ItemMagico/CarregarListaDeRaros',
        type: 'GET'
    })
    .then(function (resultado) {
        $('#container-lista-raros').html(resultado);
    })
    .fail(function (erro) {
        console.error(erro);
    });
}

itemMagicoIndex.voltarPagina = function () {
    if (itemMagicoIndex.paginaAtual > 0) {
        itemMagicoIndex.paginaAtual--;
        itemMagicoIndex.carregarListaDeItens();
    }
}

itemMagicoIndex.avancarPagina = function () {
    itemMagicoIndex.paginaAtual++;
    itemMagicoIndex.carregarListaDeItens();
}

itemMagicoIndex.atualizarBotoesDeNavegacao = function () {
    itemMagicoIndex.$btnVoltarPagina.attr('disabled', itemMagicoIndex.paginaAtual === 0);

    var ultimaPagina = !!$('#grid-todos-os-itens').data("ultima-pagina");
    itemMagicoIndex.$btnAvancarPagina.attr('disabled', ultimaPagina);
}

itemMagicoIndex.configurarBotoesDeNavegacao = function () {
    itemMagicoIndex.$btnVoltarPagina.click(itemMagicoIndex.voltarPagina);
    itemMagicoIndex.$btnAvancarPagina.click(itemMagicoIndex.avancarPagina);
}

itemMagicoIndex.iniciar = function () {
    itemMagicoIndex.$btnVoltarPagina = $("#btn-voltar-pagina");
    itemMagicoIndex.$btnAvancarPagina = $("#btn-avancar-pagina");

    itemMagicoIndex.configurarBotoesDeNavegacao();

    itemMagicoIndex.carregarListaDeItens();
    itemMagicoIndex.carregarItensRaros();
}
