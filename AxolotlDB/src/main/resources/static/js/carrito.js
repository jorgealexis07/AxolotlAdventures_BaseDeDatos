let total = document.getElementById("precioTotal");
let tabla = document.getElementById("tablaListaCompras");
let cuerpoTabla = tabla.getElementsByTagName("tbody");
//let alertValidaciones = document.getElementById("alertValidaciones");
//let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
let productosTotal = document.getElementById("productosTotal");
let precioTotal = document.getElementById("precioTotal");
let contador=0;
let totalEnProductos=0;
let costoTotal=0;
let precio=0;
let cantidad =1;
let idTimeout;
let datos = []; // new Array();
let btnAgregar = document.getElementById("btnAgregar");
let btnClear = document.getElementById("btnClear");

window.addEventListener("load", function(event){
    let tmp= localStorage.getItem("contadorProductos");
     if(tmp!=null) {
          contador= parseInt(tmp);
          contadorProductos.innerHTML= contador;
          /* contadorProductosCar.style="block";
          contadorProductosCar.innerHTML= contador; */
     }//if
     else{
          Swal.fire({
               title: '<strong>Tu carrito aún esta vacío</strong>',
               icon: 'info',
               html:
                 'Selecciona el destino a donde desees viajar con Axolotl Adventures.',
               showCloseButton: true,
              
               focusConfirm: false,
               confirmButtonText:
                 '<i class="fa fa-thumbs-up"></i> OK',
               confirmButtonAriaLabel: 'Thumbs up, great!',
              
             })
     }
     
     tmp= localStorage.getItem("costoTotal");
     if(tmp!=null) {
          costoTotal= parseFloat(tmp);
          precioTotal.innerHTML ="$ "+ costoTotal.toFixed(2);
     }//if

     tmp= localStorage.getItem("elementosCar");
     if(tmp!=null){
          datos = JSON.parse(tmp);
          datos.forEach(element => {
               cuerpoTabla[0].innerHTML +=  `<tr>
               <th>${element.id}</th>
               <td>${element.title}</td>
               <td>$ ${element.price}</td>
               </tr> `;
           });
     }//if

} );
btnClear.addEventListener ("click", function(event){


        Swal.fire({
  title: "¿Estás seguro?",
  text: "Los elementos de su carrito se eliminarán permanentemente",
  icon: "warning",
})
.then(() => {

     contador= 0;
     contadorProductos.innerHTML= contador;
     costoTotal= 0;
     precioTotal.innerHTML ="$ "+ costoTotal.toFixed(2);
     cuerpoTabla[0].innerHTML="";

     localStorage.removeItem("contadorProductos");
     localStorage.removeItem("totalEnProductos");
     localStorage.removeItem("costoTotal");
     localStorage.removeItem("datos");
     
     localStorage.clear();
    // Muestra un mensaje de éxito
    const Toast = Swal.mixin({
     toast: true,
     position: 'top-end',
     showConfirmButton: false,
     timer: 1000,
     timerProgressBar: true,
     didOpen: (toast) => {
       toast.addEventListener('mouseenter', Swal.stopTimer)
       toast.addEventListener('mouseleave', Swal.resumeTimer)
     }
   })
   
   Toast.fire({
     icon: 'success',
     title: 'El carrito se ha limpiado'
   })

});

     

});