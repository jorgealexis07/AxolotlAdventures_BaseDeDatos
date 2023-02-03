let itemsContainer = document.getElementById("CardItems");
let btnAgregar;
let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
let idTimeout;
let datosCarrito = [];
let contador = 0;
//let data= JSON.parse(localStorage.getItem("producto")) ;
let costoTotal=0;
let cantidad =1;
let data;
let productos;

/*fetch("http://localhost:8080/api/actividades/", {
      method: "get",
      headers: {
        "Content-Type": "application/json",
      },
    })
    .then((response) => response.json())
    .then((datos) => {
      console.log("Success:", datos);
      data = datos;
       console.log(datos);
    })
    .catch((error) => {
      console.error("Error:", error);
    });*/
    


/*async function accessData() {
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
  /* console.log("ID: "+ id);
  console.log("Tour: "+ title);
  console.log("Precio: "+ price); */

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

const URL_MAIN ='http://localhost:8080/api/actividades/';
function addItem(items) {
  fetch(URL_MAIN, {
    method: "get",
  })
    .then(function (response) {
      response.json().then(function (json) {
        console.log(json);
        console.log(json.length);
        productos = json;
        Array.from(json).forEach((item, index) => {
          itemsContainer.innerHTML +=
            `
        <div class="card mb-3 card border-0" style="width: 5040px;" data-ride="carousel">
        <div class="row g-0">
          <div class="col-md-4">
          <div id="carouselExample_${item.id_Actividades}" class="carousel slide card-img-top">
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
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample_${item.id_Actividades}" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-slide="next" id="btnVer_${item.id_Actividades}" onclick="view(${index});">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
            </div>
            </div>
          <div class="col-md-8">
            <div class="card-body">
            <h3 class="card-title">${item.nom_actv}</h3>
            <p class="card-text">${item.resumen_actv}</p>
          
        <div  class="position-absolute bottom-0 end-0  d-grid gap-2 col-2 mx-auto"><a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal_${item.id_Actividades}">Ver más</a></div>  
        
           </div>
        </div>
      </div>
    </div> `;
        });
      });
    })
    .catch(function (err) {
      console.log(err);
    });
}

window.addEventListener("load", function (){
    addItem(itemsContainer); 
})

function view(index) {
    // console.log(index);
    // console.table(productos[index]);
    document.getElementById("productTitleModal").innerHTML=productos[index].nom_actv;
    document.getElementById("productBodyModal").innerHTML=`${productos[index].item.resumen_actv}  <img class="bd-placeholder-img card-img-top" role="img" />
    <strong>$ ${productos[index].precio_actv} MXN<strong>`;
    $("#productModal").modal("show");
}// view
// en el body de la cars se agregraron lo s item de resumen y titulo
// Card emergente cuenta con sus propios item de precio y text, se repite item..title
// item,id esta anclado al id de la card para que sea independiente cada una.
//Se agrego un boton de agregar a carrito con un icono de carrito todo de bootstrap con una etiqueta svg
