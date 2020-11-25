
$(document).ready(function () {
    $('.table #addButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (state, status) {
            $('#idEdit').val(state.id);
            $('#ddlCountryAdd').val(state.countryid);
            $('#capitalEdit').val(state.capital);
            $('#codeEdit').val(state.code);
            $('#nameEdit').val(state.name);
            $('#detailsEdit').val(state.details);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (state, status) {
            $('#idEdit').val(state.id);
            $('#ddlCountryDetails').val(state.countryid);
            $('#nameDetails').val(state.name);
            $('#detailsDetails').val(state.details);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
            // $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
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


