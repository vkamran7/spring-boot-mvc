
$(document).ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (vehicleModel, status) {
            $('#idEdit').val(vehicleModel.id);
            $('#descriptionEdit').val(vehicleModel.description);
            $('#detailsEdit').val(vehicleModel.details);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (vehicleModel, status) {
            $('#idDetails').val(vehicleModel.id);
            $('#descriptionDetails').val(vehicleModel.description);
            $('#detailsDetails').val(vehicleModel.details);
            $('#lastModifiedByDetails').val(vehicleModel.lastModifiedBy);
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


