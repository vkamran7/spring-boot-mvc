
$(document).ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (location, status) {
            $('#idEdit').val(location.id);
            $('#ddlCountryEdit').val(location.countryid);
            $('#ddlStateEdit').val(location.stateid);
            $('#descriptionEdit').val(location.description);
            $('#detailsEdit').val(location.details);
            $('#cityEdit').val(location.city);
            $('#addressEdit').val(location.address);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (location, status) {
            $('#idDetails').val(location.id);
            $('#ddlCountryDetails').val(location.countryid);
            $('#ddlStateDetails').val(location.stateid);
            $('#descriptionDetails').val(location.description);
            $('#detailsDetails').val(location.details);
            $('#cityDetails').val(location.city);
            $('#addressDetails').val(location.address);
            $('#lastModifiedByDetails').val(location.lastModifiedBy);
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


