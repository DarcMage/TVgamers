<template>

    <body class="login">
      
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            
            <form>
              
              <h3>Acceso al Mantenimiento <h1>"TVGamers"</h1></h3>
              
              <div>
                <input codigo="usuario" name="usuario" v-model="usuario" type="text" class="form-control" placeholder="Usuario" required="" />
              </div>
              <div>
                <input codigo="password" name="password" v-model="password" type="password" class="form-control" placeholder="password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" v-on:click="$event => login()">Iniciar Sesión</a>
                <a class="reset_pass" href="#">Recuperar Contraseña?</a>
              </div>

              <div class="clearfix"></div>

              
            </form>
          </section>
        </div>
        </div>
    </div>

  </body>
</template>
<script>

export default{
	data() {
      return {
		codigo:null,
		usuario:"",
    password: "",
		};
    },
	methods: {
		
		login(){
      
			var data = { 
				usuario: this.usuario,
				password:this.password,
			};
			var metodo="POST";
			fetch("http://localhost:8080/v1/usuario/login", {
			method: metodo, // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
			}).then((response) => response.json())
			.then((data) => {
        if(data.codigo==200){
          Swal.fire({
  icon: 'success',
  timer: 1500
})
                let token=data.token;
                sessionStorage.setItem('usuario_token',data.token);
                var datadecode=atob(token)
                var datos=datadecode.split("!=!");
                datos.forEach(element=> {
                  var datovalor=element.split("=");
                  sessionStorage.setItem('usuario_'+datovalor[0], datovalor[1]);
                 });
                 window.location.href=window.location.origin;
                 
                 }else{
                  Swal.fire({
  icon: 'error',
  title: 'Oops...',
  text: 'Usuario o Contraseña incorrectos',
  footer: '<a href="">Vuelva a Intentar :) </a>'
})
                 // alert(data.mensaje);
                  }
                 })
			.catch((error) => {
				console.error("Error:", error);
				return;
			});
		}
    }
}
</script>