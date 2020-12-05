
$(document).ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (invoice, status) {
            $('#idEdit').val(invoice.id);
            $('#ddlClientEdit').val(invoice.clientid);

            let invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateEdit').val(invoiceDate);
            $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
            $('#remarksEdit').val(invoice.remarks);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (invoice, status) {
            $('#idDetails').val(invoice.id);
            $('#ddlClientDetails').val(invoice.clientid);

            let invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateDetails').val(invoiceDate);
            $('#ddlStatusDetails').val(invoice.invoicestatusid);
            $('#remarksDetails').val(invoice.remarks);
            $('#lastModifiedByDetails').val(invoice.lastModifiedBy);
            $('#lastModifiedDateDetails').val(invoice.lastModifiedDate);
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


