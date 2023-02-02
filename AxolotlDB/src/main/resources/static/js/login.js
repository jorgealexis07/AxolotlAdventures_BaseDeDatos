let btnIniciar = document.getElementById("btn-iniciar");
let dataUser = localStorage.getItem("dataUser");
let inputEmail = document.getElementById("correo");
let inputPassword = document.getElementById("password");
let alertError = document.getElementById("alert-error");
let alertSuccess = document.getElementById("alert-success");
let usuarioEncontrado = false;

let UsuarioLogeado="";
if (dataUser) {
  dataUser = JSON.parse(dataUser);
} else {
  dataUser = [];
}
// Eliminar el objeto en el LocalStorage
localStorage.removeItem("NameUserLogeado");
btnIniciar.addEventListener("click", function (event) {
  event.preventDefault();
 
  alertError.style.display = "none";
  alertError.innerHTML = "";
  alertSuccess.style.display = "none";
  alertSuccess.innerHTML = "";

  // Validar que el correo y la contraseña existan en el Local Storage
  for (let i = 0; i < dataUser.length; i++) {
    if (
      dataUser[i].correo === inputEmail.value &&
      dataUser[i].password === inputPassword.value
    ) {
      UsuarioLogeado=dataUser[i].nombre;
       // Almacenar el objeto en el LocalStorage
      localStorage.setItem("NameUserLogeado", UsuarioLogeado);
      console.log(UsuarioLogeado);
      usuarioEncontrado = true;
      break;
    }
  }
  if (usuarioEncontrado) {
    Swal.fire("¡Bienvenidxs!", "", "success");
    // Redireccion en caso exitoso
    setTimeout(() => {
      window.location.href = "/index.html";
    }, 2000);
  } else {
    //Mostrar mensaje de error si la validacion falla
    alertError.innerHTML =
      "El correo electrónico o la contraseña son incorrectos.";
    alertError.style.display = "block";
    setTimeout(() => {
      alertError.style.display = "none";
    }, 2000);
  }
});
