let navBar = document.getElementById("menu");
let NameUserLogeado = localStorage.getItem("NameUserLogeado");
let cont = 0;

function IsLogU() {
  if (NameUserLogeado != null) {
    console.log(NameUserLogeado);
    return true;
  } else {
    return false;
  }
}
console.log(IsLogU());
function menu() {
  navBar.innerHTML = ` 
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a  href="/index.html">
      <img id="ajolotito" src="/fotos/logo2.png" alt="Link to homepage">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
      <ul class="navbar-nav mx-auto mb-2 mb-lg-0 ">
        <li class="nav-item">
          <a aria-current="page" href="/html/catalogo.html" class="nave-menudo-link navegador-link" >Destinos</a>
        </li>
        <li class="nav-item">
          <a aria-current="page" href="/html/contacto.html" class="nave-menudo-link navegador-link">Contacto</a>
        </li>
        <li class="nav-item">
          <a aria-current="page" href="/html/aboutus.html" class="nave-menudo-link navegador-link">Nosotros</a>
        </li>
	 <li class="nav-item">
          <a aria-current="page" href="/html/registro.html" class="nave-menudo-link navegador-link">Registrarse</a>
        </li>
        <!-- <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li> -->
      </ul>

      <ul class="navbar-nav mb-2 mb-lg-0">
        <li class="nav-item dropdown">
        <a class="nave-menudo-link navegador-link" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          ${IsLogU() ? NameUserLogeado : "Mi Usuario"}
        </a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="../html/login.html">Iniciar Sesión</a></li>
          <li><hr class="dropdown-divider"></li>
          <li><a class="dropdown-item" href="../html/login.html">Cerrar Sesión</a></li>
        </ul>
      </li>
    </ul>
      <a href="/html/carrito.html">
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="white" class="bi bi-cart-plus" viewBox="0 0 16 16">
          <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"/>
          <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
        </svg>
      </a>
      <span class="badge rounded-pill text-bg-danger" 
                            id="contadorProductosCar" style="display:none;">0</span>
    </div>
  </div>
</nav>
`;
}

menu();

window.addEventListener("load", function (event) {
  let tmp = localStorage.getItem("contadorProductos");
  if (tmp != null) {
    cont = parseInt(tmp);
    contadorProductosCar.innerHTML = cont;
    contadorProductosCar.style = "display:block;";
  }
});
