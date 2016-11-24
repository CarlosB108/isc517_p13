/**
 * Created by AcMined on 11/24/2016.
 */

var init_select2 = null;
$( document ).ready(function( ) {

    init_select2 = function( ){
        $( '.selector' ).select2( {
            theme: "bootstrap",
            width: '100%'
        } );
    };

    init_select2();

    $( "#contacts_list" ).select2( {
        ajax: {
            url: "/contacto/search",
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    q: params.term
                };
            },
            processResults: function (data) {
                // parse the results into the format expected by Select2.
                // since we are using custom formatting functions we do not need to
                // alter the remote JSON data
                return {
                    results: data
                };
            },
            cache: true
        },
        minimumInputLength: 2
    } );
} );