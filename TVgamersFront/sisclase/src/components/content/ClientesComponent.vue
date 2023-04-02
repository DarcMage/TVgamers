<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 ">
				<div class="x_panel" id="tabladatoscliente" v-show="!mostrarformulario">
								<div class="x_title">
									<h2>Clientes<small>listado</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a>
											<i class="fa fa-files-o" v-on:click="nuevoregistro();"></i></a>
										</li>
										<li><a class="collapse-link">
											<i class="fa fa-chevron-up"></i></a>
										</li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
							<div class="x_content">

								<div class="row">
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Apellidos</th>
                          <th>Número de Documento</th>
						  <th>Dirección</th>
						  <th>Telefono</th>
						  <th>Correo</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>


                      <tbody>
                        <tr v-for="itemCliente in listacliente " v-bind:key="itemCliente" v-bind:itemMenu="itemCliente">
                          <td>{{ itemCliente.nombre}}</td>
                          <td>{{ itemCliente.apellidos}}</td>
                          <td>{{ itemCliente.dni }}</td>
						  <td>{{ itemCliente.direccion }}</td>
						  <td>{{ itemCliente.telefono }}</td>
						  <td>{{ itemCliente.correo }}</td>
						  <td class="text-center">
							<i class="fa fa-pencil-square-o" v-on:click="editarcliente(itemCliente)" style="cursor:pointer ; padding-right: 1ex; color: green;"></i>
							<i class="fa fa-trash" v-on:click="eliminarcliente(itemCliente.id)" style="cursor:pointer ; color:red"></i>
						  </td>
                        </tr>     
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

								</div>
							</div>
							<div class="x_panel"  id="formulariocliente" v-show="mostrarformulario">
								<div class="x_title">
									<h2>Formulario de Cliente <small>crear/editar</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link">
											<i class="fa fa-chevron-up"></i></a>
										</li>
									
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<form id="frmCliente" class="form-label-left ">
										<input type="hidden" id="id" name="id" v-model="id"/>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="nombre" name="nombre" v-model="nombre" required class="form-control ">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="apellidos">Apellidos <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="apellidos" name="apellidos" v-model="apellidos" required class="form-control">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="numerodocumento">Número de Documento <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="dni" name="dni" v-model="dni" required class="form-control">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="direccion">Dirección <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="direccion" name="direccion" v-model="direccion" required class="form-control">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="telefono">Telefono<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="tel" id="telefono" name="telefono" v-model="telefono" required class="form-control">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="correo">Correo <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="email" id="correo" name="correo" v-model="correo" required class="form-control">
											</div>
										</div>
										<div class="ln_solid"></div>
										<div class="form-group row">
											<div class="col-md-9 col-sm-9  offset-md-3">
												<button type="button" class="btn btn-primary" v-on:click="cancelar();">Cancelar</button>
												<button class="btn btn-primary" type="reset">Resetear</button>
												<button type="button" class="btn btn-success" v-on:click="guardardatos();">Guardar</button>
											</div>
										</div>

									</form>
                                </div>
							
							</div>	
            </div>	
		</div>
    </div>	
</template>
<script>
export default {


	
	data(){
		
    return {
		idcliente:null,
        nombre:"",
		apellidos:"",
		dni:null,
		direccion:"",
		telefono:"",
		correo:"",
		listacliente:[],
		mostrarformulario:false,
    };
  },
  methods: {
	async iniciarCarga() {
      try {
			const response = await fetch("http://localhost:8080/cliente/")
			this.listacliente= this.ListClienteItems = await response.json(); 
			console.log("listacliente:",this.ListClienteItems)  
			} catch (error) {
			//console.log(error);
			}
    },
	guardardatos(){
		var data = { 
			nombre: this.nombre,
			apellidos:this.apellidos,
			dni:this.dni,
			direccion:this.direccion,
			telefono:this.telefono,
			correo:this.correo,
		 };
		 if(this.idcliente!==null){
			data.idcliente=this.idcliente;
			metodo="PUT";
		 }
		
		fetch("http://localhost:8080/v1/cliente/", {
			method: metodo, // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
		}) .then((response) => response.json())
		.then((data) => {
			this.idcliente=null;
			this.iniciarCarga();
			this.mostrarformulario=false;
		})
		.catch((error) => {
			console.error("Error:", error);
			return;
		});
	},
	editarcliente(datos){
		this.idcliente=datos.idcliente;
		this.nombre=datos.nombre;
		this.apellidos=datos.apellidos;
		this.dni=datos.dni;
		this.direccion=datos.direccion;
		this.telefono=datos.telefono;
		this.correo=datos.correo;
		this.mostrarformulario=true;
	},
	async eliminarcliente(idtmp){
		try{
			const response = await fetch("http://localhost:8080/v1/cliente/"+idtmp,{
				method:"DELETE",
			})
			if(response.status==200){
				this.idproveedor = null;
				this.iniciarCarga();
			}
		} catch (error) {
			//console.log(error);
		}
		console.log(idtmp)
	},
	nuevoregistro(){
		this.mostrarformulario=true;
		this.idcliente=null;
		this.nombre="";
		this.apellidos="";
		this.dni="";
		this.direccion="";
		this.telefono="";
		this.correo="";
	},
	cancelar(){
		this.mostrarformulario=false;
	}
  },
  created() {
      this.iniciarCarga();
    },
}

</script>