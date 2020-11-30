
$(document).ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (country, status) {
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (country, status) {
            $('#idDetails').val(country.id);
            $('#descriptionDetails').val(country.description);
            $('#capitalDetails').val(country.capital);
            $('#codeDetails').val(country.code);
            $('#continentDetails').val(country.continent);
            $('#nationalityDetails').val(country.nationality);
        });

        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $('#confirmDelete').attr('href', href);
        $('#deleteModal').modal();
    });
});


