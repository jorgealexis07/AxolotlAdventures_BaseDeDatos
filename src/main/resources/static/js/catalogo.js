let itemsContainer = document.getElementById("CardItems");
let btnAgregar;
let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
let idTimeout;
let datosCarrito = [];
let contador = 0;
//let data= JSON.parse(localStorage.getItem("producto")) ;
let costoTotal=0;
let cantidad =1;


fetch("http://localhost:8080/api/actividades/").then((res)=> {
	if(res.status == "200"){
		console.log(res);
		return res.json();
	}
	else{
		Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: '¡Aun no hay registros!',
        confirmButtonClass: "custom-confirmButtonClass",
      });
		console.log("Error");
	}
}).then((data)=>{
	if(data){
		console.log(data);
		addItem(data);
	}
});


/*function getData() {
  return new Promise((resolve, reject) => {
    if (data == null) {
      reject(new Error("No existen datos"));
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: '¡Aun no hay registros!',
        confirmButtonClass: "custom-confirmButtonClass",
      });
    } //if data == null
    setTimeout(() => resolve(data));
  });
} //function getData

async function accessData() {
  const prod = await getData();
} //async function
accessData();

getData()
  .then((datos) => {
    console.log(datos);
    addItem(data);
  })
  .catch((error) => console.error(error.message));*/
// Inician cards y carrusel ( recuerda que se usaron dos tipos de cards de bootstrap)
// cada paquete iten esta anclado con los id de carusel para que recorra cada uno done debe ser cada producto
// las imagenes cuentan con su propio item.img que a su vez cuenta con 3 imagenes
let rows=[];
let elementosCar=[];
function AddCar(id,title,price){
  contador++;
  localStorage.setItem("contadorProductos",contador);
  console.log("ID: "+ id);
  console.log("Tour: "+ title);
  console.log("Precio: "+ price); 

  costoTotal += price * cantidad;
  localStorage.setItem("costoTotal",costoTotal);
 
  let elemento = `{
    "id" : ${id},
    "title": "${title}",
    "price": ${price} 
  }`;
  elementosCar.push(JSON.parse(elemento) );
  localStorage.setItem("elementosCar",JSON.stringify(elementosCar));
  Swal.fire({
    position: 'top-end',
    icon: 'success',
    title: 'Tu destino ha sido agregado al carrito',
    showConfirmButton: false,
    timer: 1500
  })
  
}
function addItem(items) {
  items.forEach((item) => {
    itemsContainer.insertAdjacentHTML(
      "beforeend",
      `
        <div class="card mb-3 card border-0" style="width: 5040px;" data-ride="carousel">
        <div class="row g-0">
          <div class="col-md-4">
          <div id="carouselExample_${item.id_actividades}" class="carousel slide card-img-top">
          <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="${item.img_actv}" class="d-block w-100" alt="..." >
          
            </div>
          <div class="carousel-item ">
                <img src="${item.img_actv}" class="d-block w-100" alt="..." >
              </div>
              <div class="carousel-item">
                <img src="${item.img_actv}" class="d-block w-100" alt="...">
              </div>
              </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample_${item.id_actividades}" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample_${item.id_actividades}" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
            </div>
            </div>
          <div class="col-md-8">
            <div class="card-body">
            <h3 class="card-title">${item.nom_actv}</h3>
            <p class="card-text">${item.resumen_actv}</p>
          
        <div  class="position-absolute bottom-0 end-0  d-grid gap-2 col-2 mx-auto"><a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal_${item.id_actividades}">Ver más</a></div>  
        <!-- Modal -->
<div class="modal fade" id="exampleModal_${item.id_actividades}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">Paquete</h3>
      
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <h2 class="card-text1">Tour ${item.nom_actv}</h2>
      <div class="descripcion">
      ${item.descrip_actv}

<div class="precio">
     <h1> $ ${item.precio_actv}</h1>
     </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick= AddCar("${item.id_actividades}","${item.nom_actv}","${item.precio_actv}")>Agregar al carrito <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16" >
        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
      </svg></button>
        
      </div>
    </div>
  </div>
</div>
           </div>
        </div>
      </div>
    </div> `
    );
  });


}

// en el body de la cars se agregraron lo s item de resumen y titulo
// Card emergente cuenta con sus propios item de precio y text, se repite item..title
// item,id esta anclado al id de la card para que sea independiente cada una.
//Se agrego un boton de agregar a carrito con un icono de carrito todo de bootstrap con una etiqueta svg
