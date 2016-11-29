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
                console.log(data);
                return {
                    results: $.map(data, function (item) {
                        return {
                            text: item.nombre + ' - ' + item.email,
                            id: item.id
                        }
                    })
                };
            },
            cache: true
        },
        minimumInputLength: 2
    } );
} );