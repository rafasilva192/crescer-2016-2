class TelaLogin {

  constructor(seletor) {
    this.$elem = $(seletor);
    this.registrarBindsEventos();
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos() {
    this.$formLogin = $('#formLogin');
    this.$btnSubmit = this.$formLogin.find('button[type=submit]');
    let self = this;
    let validator = this.$formLogin.validate({
      highlight: function (element, errorClass, validClass) {
        $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function (element, errorClass, validClass) {
        $(element).closest('.form-group').removeClass('has-error');
      },
      showErrors: function () {
        if (validator.numberOfInvalids() === 0) {
          self.$btnSubmit.removeAttr('disabled');
        } else {
          self.$btnSubmit.attr('disabled', true);
        }
        this.defaultShowErrors();
      },
      submitHandler: function () {
        self.$btnSubmit.text('Carregando...');
        self.$btnSubmit.attr('disabled', true);
        setTimeout(function () {
          marvelflix.renderizarTela('principal');
        }, 2000);
      }
    });
  }

  renderizarEstadoInicial() {
    this.$elem.show();
    this.$btnSubmit.attr('disabled', !this.$formLogin.valid());
  }

}