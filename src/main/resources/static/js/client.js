
$(document).ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('#txtIdEdit').val(client.id);
            $('#txtAddressEdit').val(client.address);
            $('#txtCityEdit').val(client.city);
            $('#ddlCountryEdit').val(client.countryid);
            $('#ddlStateEdit').val(client.stateid);
            $('#txtEmailEdit').val(client.email);
            $('#txtMobileEdit').val(client.mobile);
            $('#txtWebsiteEdit').val(client.website);
            $('#txtNameEdit').val(client.name);
            $('#txtPhoneEdit').val(client.phone);
            $('#txtDetailsEdit').val(client.details);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('#idDetails').val(client.id);
            $('#descriptionDetails').val(client.description);
            $('#capitalDetails').val(client.capital);
            $('#codeDetails').val(client.code);
            $('#continentDetails').val(client.continent);
            $('#nationalityDetails').val(client.nationality);
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


