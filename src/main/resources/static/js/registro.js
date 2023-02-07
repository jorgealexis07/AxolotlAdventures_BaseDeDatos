let btnEnviar = document.getElementById("btn-enviar");
let dataUser = JSON.parse(localStorage.getItem("dataUser")) || [];

// Validaciones
function validaNombre(nombre) {
  return nombre.trim().replace(/ /g, "").length >= 3;
}
function validaCorreo(correo) {
  let email =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return correo.match(email) !== null;
}
function validaTelefono(telefono) {
  let telefonoRegex = /^\d{10}$/;
  return telefono.match(telefonoRegex) !== null;
}
function validaPassword(password) {
  let passwordRegex =
    /(?=(.*[0-9]))(?=.*[\!@#$%^&*()\\[\]{}\-_+=|:;"'<>,./?])(?=.*[a-z])(?=(.*[A-Z]))(?=(.*)).{8,}/;
  return password.match(passwordRegex) !== null;
}

// Manejo de eventos
btnEnviar.addEventListener("click", function (event) {
  event.preventDefault();
  let inputNombre = document.getElementById("nombre");
  let inputEmail = document.getElementById("correo");
  let inputTel = document.getElementById("telefono");
  let inputPassword = document.getElementById("password");
  let inputRPassword = document.getElementById("Rpassword");
  let alertError = document.getElementById("alert-error");
  let alertSuccess = document.getElementById("alert-success");
  alertError.style.display = "none";
  alertError.innerHTML = "";

  if (
    validaNombre(inputNombre.value) &&
    validaCorreo(inputEmail.value) &&
    validaTelefono(inputTel.value) &&
    validaPassword(inputPassword.value) &&
    inputPassword.value == inputRPassword.value
  ) {
    // Agregar los datos del usuario al arreglo
    dataUser.push({
      nombre: inputNombre.value,
      correo: inputEmail.value,
      telefono: inputTel.value,
      password: inputPassword.value,
    });
	   fetch("/api/clientes/", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        nom_cliente: inputNombre.value,
        email_cliente: inputEmail.value,
        cel_cliente: inputTel.value,
        contr_cliente: inputPassword.value,
      })
    })
    .then((response) => response.json())
    .then((data) => {
      console.log("Success:", data);
    })
    .catch((error) => {
      console.error("Error:", error);
    });


    // Almacenar el objeto en el LocalStorage
    localStorage.setItem("dataUser", JSON.stringify(dataUser));

    // Mostrar mensaje de éxito
    //alertSuccess.innerHTML = "Registro exitoso";
    //alertSuccess.style.display = 'block';
    inputNombre.style.border = "solid green 2px";
    inputEmail.style.border = "solid green 2px";
    inputTel.style.border = "solid green 2px";
    inputPassword.style.border = "solid green 2px";
    inputRPassword.style.border = "solid green 2px";
    /* Swal.fire({
      title: "¡Registro exitoso!",
      icon: "success",
      confirmButtonClass: "custom-confirm-button-class",
    }); */
    Swal.fire({
      title: "¡Registro exitoso!",
      icon: "success",
      confirmButtonClass: "custom-confirm-button-class",
      confirmButtonColor: "#e23d82",
        imageUrl: '/fotos/logo22.png',
    });
    inputNombre.value = "";
    inputEmail.value = "";
    inputTel.value = "";
    inputPassword.value = "";
    inputRPassword.value = "";
    inputNombre.style.border = "";
    inputEmail.style.border = "";
    inputTel.style.border = "";
    inputPassword.style.border = "";
    inputRPassword.style.border = "";
  } else {
    // Mostrar mensajes de error
    if (!validaNombre(inputNombre.value)) {
      alertError.innerHTML += "El nombre debe contener 3 caracteres o más.";
      inputNombre.style.border = "solid red 2px";
    }
    if (!validaCorreo(inputEmail.value)) {
      alertError.innerHTML += "<br/>El correo electrónico no es válido.";
      inputEmail.style.border = "solid red 2px";
    }
    if (!validaTelefono(inputTel.value)) {
      alertError.innerHTML += "<br/>El teléfono no es válido.";
      inputTel.style.border = "solid red 2px";
    }
    if (!validaPassword(inputPassword.value)) {
      alertError.innerHTML += "<br/>La contraseña no es válida.";
      inputPassword.style.border = "solid red 2px";
    }
    if (!validaPassword(inputRPassword.value)) {
      alertError.innerHTML +=
        "<br/>La contraseña y su confirmación deben ser iguales y cumplir con los requisitos de seguridad.";
      inputRPassword.style.border = "solid red 2px";
    }
    setTimeout(() => {
      alertError.innerHTML = "";
      alertError.style.display = "none";
      inputNombre.style.border = "";
      inputEmail.style.border = "";
      inputTel.style.border = "";
      inputPassword.style.border = "";
      inputRPassword.style.border = "";
    }, 2000);

    alertError.style.display = "block";
  }
});
