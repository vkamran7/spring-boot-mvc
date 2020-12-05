
$(document).ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (contact, status) {
            $('#txtIdEdit').val(contact.id);
            $('#txtFirstnameEdit').val(contact.firstname);
            $('#txtLastnameEdit').val(contact.lastname);
            $('#txtEmailEdit').val(contact.email);
            $('#txtPhoneEdit').val(contact.phone);
            $('#txtMobileEdit').val(contact.mobile);
            $('#txtRemarksEdit').val(contact.remarks);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (contact, status) {
            $('#txtIdDetails').val(contact.id);
            $('#txtFirstnameDetails').val(contact.firstname);
            $('#txtLastnameDetails').val(contact.lastname);
            $('#txtEmailDetails').val(contact.email);
            $('#txtPhoneDetails').val(contact.phone);
            $('#txtMobileDetails').val(contact.mobile);
            $('#txtRemarksDetails').val(contact.remarks);
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


