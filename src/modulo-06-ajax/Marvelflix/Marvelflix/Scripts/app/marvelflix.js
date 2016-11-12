let marvelflix = {};

marvelflix.toggleLoader = () => {
  ['.loader', '.tela'].forEach(seletor => $(seletor).toggle());
};

marvelflix.renderizarTela = function(nome) {

  // escondendo todas as telas antes de renderizar a tela correta
  let $subTelas = $('.sub-tela');
  $.each($subTelas, (indice, elem) => $(elem).hide());
  let seletor = '';

  switch (nome) {
    case 'principal':
      new TelaPrincipal('#telaPrincipal');
      break;
    case 'login':
      new TelaLogin('#telaLogin');
      break;
  }

}

marvelflix.loadTemplate = function(name) {

  let deferred = $.Deferred();
  $.get(`/static/templates/${name}.tpl.html`).then(
    function(template) {
      deferred.resolve(Handlebars.compile(template));
    }
  );
  return deferred.promise();

}

marvelflix.render = function(viewElementSelector, templateName, data) {

  return new Promise((resolve, reject) => {
    this.loadTemplate(templateName).then(
     function (templateFn) {
       let rendered = templateFn(data);
       $(viewElementSelector).html(rendered);
       resolve();
     }
   );
  });
}

marvelflix.iniciar = function() {
  return marvelflix.renderizarTela('login');
};