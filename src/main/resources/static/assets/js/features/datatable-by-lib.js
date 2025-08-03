$(document).ready(function(){
    $('#main-datatable').DataTable( {
        serverSide: true,
        ajax: {
            url: '/mapping/card-ffid/datatable',
            type: "POST"
        }
    });
});