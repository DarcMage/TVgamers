<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosmenus">
					<div class="x_title">
						<h2>Menus de Opciones <small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link">
								<i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a class="dropdown-item" href="#">Settings 1</a>
									</li>
									<li><a class="dropdown-item" href="#">Settings 2</a>
									</li>
								</ul>
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
                          <th>Dirección </th>
                          <th>Celular</th>
                          <th>Distrito</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>
					  
                      <tbody>
                        <tr v-for="itemProveedor in listaProveedor ">
                          <td>{{itemProveedor.nombre}}</td>
                          <td>{{itemProveedor.apellidos }}</td>
                          <td>{{itemProveedor.direccion}}</td>
                          <td>{{itemProveedor.celular}}</td>
							<td>{{itemProveedor.distrito.nombre||''}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarProveedor(itemProveedor)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarProveedor(itemProveedor.codigo)"  style="cursor:pointer; color:red"></i>
						  </td>
						  </tr>
						           
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>



					</div>
				</div>
				<div class="x_panel" id="formulariomenus">
					<div class="x_title">
						<h2>Menus de Opciones <small>editar/crear</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link">
								<i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a class="dropdown-item" href="#">Settings 1</a>
									</li>
									<li><a class="dropdown-item" href="#">Settings 2</a>
									</li>
								</ul>
							</li>
							<li><a class="close-link"><i class="fa fa-close"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form id="frmMenu" v-on:submit="guardardatos()"  data-parsley-validate class="form-horizontal form-label-left">
							<input type="hidden" id="id" name="id" v-model="id"/>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="nombre" name="nombre" v-model="nombre" required class="form-control ">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="apellidos">Apellidos <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="apellidos" name="apellidos" v-model="apellidos"  required class="form-control">
								</div>
							</div>
							<div class="item form-group">
								<label for="direccion" class="col-form-label col-md-3 col-sm-3 label-align">Dirección </label>
								<div class="col-md-6 col-sm-6 ">
									<input id="direccion" v-model="direccion" class="form-control" type="text" name="direccion">
								</div>
							</div>

							<div class="item form-group">
								<label for="celular" class="col-form-label col-md-3 col-sm-3 label-align">Celular </label>
								<div class="col-md-6 col-sm-6 ">
									<input id="celular" v-model="celular" class="form-control" type="text" name="celular">
								</div>
							</div>
						
							<div class="form-group row">
								<label class="control-label col-md-3 col-sm-3 label-align">Distrito </label>
								<div class="col-md-6 col-sm-6 ">
									<select v-model="distritoPadre" class="select2_single form-control" tabindex="-1">
																	
										<option v-for="itemDistrito in listadistrito"  :key="itemDistrito.codigo" :value="itemDistrito.codigo">{{ itemDistrito.nombre }}</option>		
									</select>
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3">
									<button class="btn btn-primary" type="button">Cancel</button>
									<button class="btn btn-primary" type="reset">Reset</button>
									<button type="submit" class="btn btn-success">Submit</button>
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
export default{
	data() {
      return {
		codigo:null,
		nombre:"",
        apellidos: "",
		direccion:"",
		celular:"",
		distritoPadre:null,
		listadistrito:[],
		listaProveedor:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8080/v1/proveedor/");
			this.listaProveedor= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
			try{
				const respons = await fetch("http://localhost:8080/v1/distrito/");
				this.listadistrito=this.listDistritoItems = await respons.json();
			}catch(error){

			}
		},
		guardardatos(){
			var data = { 
				nombre: this.nombre,
				apellidos:this.apellidos,
				direccion:this.direccion,
				distritoPadre:this.distritoPadre,
				
			};
			var metodo="POST";
			console.log(this.codigo)

			if(this.codigo!=null||this.codigo!=""){//guardar datos			
				data.codigo=this.codigo
				metodo="PUT";
			}
			fetch("http://localhost:8080/v1/proveedor/", {
			method: metodo, // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
			}).then((response) => response.json())
			.then((data) => {
				this.iniciarCarga();
			})
			.catch((error) => {
				console.error("Error:", error);
				return;
			});
		},
		editarProveedor(datos){
			this.codigo=datos.codigo;
			this.nombre=datos.nombre;
			this.apellidos=datos.apellidos;
			this.direccion=datos.direccion;
			this.celular=datos.celular;
			this.distritoPadre=datos.distrito.codigo;
			console.log(datos.distrito.nombre, this.distritoPadre, datos.distrito)
			
		},
		eliminarProveedor(codigotmp){
			console.log(codigotmp);
		}
	},
	created() {
      this.iniciarCarga();
    },
}
</script>