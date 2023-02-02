let InputCorreo = document.getElementById("InputCorreo");
let AlertEscritura = document.getElementById("AlertEscritura");
let emailRegex =
  /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
let btnEnviar = document.getElementById("btnEnviar");
let InputNombre = document.getElementById("InputNombre");
let InputTelefono = document.getElementById("InputTelefono");
let InputComentario = document.getElementById("InputComentario");
let alertSuccess = document.getElementById("alert-success");
let idTimeout;
let validos = 0;
let validacion = false;

btnEnviar.addEventListener("click", function (event) {
  event.preventDefault();
  AlertEscritura.style.display = "none";
  if (InputNombre.value.length < 3) {
    AlertEscritura.innerHTML = "Tu nombre no es válido.";
    AlertEscritura.style.display = "block";
    InputNombre.focus();
    InputNombre.select();
    InputNombre.style.border = "solid red 2px";
    validacion = false;
  } else {
    InputNombre.style.border = "solid green 2px";
    validacion = true;
    validos++;
  } // else

  if (InputCorreo.value.match(emailRegex) == null) {
    AlertEscritura.style.display = "block";
    AlertEscritura.innerHTML += "<br/>Tu correo electrónico no es válido.";
    InputCorreo.style.border = "solid red 2px";
    validacion = false;
  } // if
  else {
    InputCorreo.style.border = "solid green 2px";
    validos++;
    validacion = true;
  } // else

  if (InputTelefono.value.length < 10) {
    AlertEscritura.style.display = "block";
    AlertEscritura.innerHTML +=
      "<br/>Tu número no es válido. Debes ingresar un número válido.";
    InputTelefono.style.border = "solid red 2px";
    validacion = false;
  } else {
    InputTelefono.style.border = "solid green 2px";
    validos++;
    validacion = true;
  } // else

  if (InputComentario.value.trim().length < 5) {
    AlertEscritura.innerHTML +=
      "<br/>Tu mensaje debe de contener 5 caracteres o más";
    AlertEscritura.style.display = "block";
    InputComentario.focus();
    InputComentario.select();
    InputComentario.style.border = "solid red 2px";
    validacion = false;
  } //if
  else {
    InputComentario.style.border = "solid green 2px";
    validos++;
    validacion = true;
  } //else
  setTimeout(function () {
    InputCorreo.style.border = "";
    InputNombre.style.border = "";
    InputTelefono.style.border = "";
    InputComentario.style.border = "";
    AlertEscritura.style.display = "none";
  }, 1000);

  if (validacion) {
    console.log(InputCorreo.value);
    Email.send({
      Host: "smtp.elasticemail.com",
      Username: "aajolote9.adventure@gmail.com",
      Password: "1B35D6E2483ABB0DFB136766A57A96C6E0F2",
      To: "aajolote9.adventure@gmail.com",
      From: "aajolote9.adventure@gmail.com",
      Subject: "Adventure Travel Contact",
      Body: ` ${InputNombre.value} quiere ponerse en contacto.
            Su correo es: ${InputCorreo.value}.
            Su telefono es: ${InputTelefono.value}.
            Su comentario:  ${InputComentario.value} `,
    }).then((message /* alert(message) */) =>
    Swal.fire({
        title: '¡Tus datos han sido recibidos, pronto nos pondremos en contacto!',
        icon: 'success',
        confirmButtonClass: 'custom-confirm-button-class',
      })  
      
    ); //then
    setTimeout(function () {
      InputCorreo.style.border = "";
      InputNombre.style.border = "";
      InputTelefono.style.border = "";
      InputComentario.style.border = "";
      InputCorreo.value = "";
      InputNombre.value = "";
      InputTelefono.value = "";
      InputComentario.value = "";
      /*  alertSuccess.innerHTML = "Su mensaje fue enviado con éxito ";
            alertSuccess.style.display = 'block'; */
    }, 2000);
  } //==4
}); //Email send
