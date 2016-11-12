$(function () {
  marvelflix.iniciar();
  $.ajaxPrefilter((options, _, jqXHR) => {
    marvelflix.toggleLoader();
    jqXHR.done(() => {
      marvelflix.toggleLoader();
    });
  });
});