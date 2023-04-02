<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosmenus" v-show="!mostrarformulario">
					<div class="x_title">
						<h2>Menus de Opciones <small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a>
								<i class="fa fa-plus" v-on:click="nuevoregistro();"></i></a>
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
								<input type="text" id="searchnombre" name="searchnombre" 
								v-model="searchnombre" v-on:input="iniciarCarga();" required class="form-control" placeholder="Buscar por nombre de Menu">
							</div>
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Icono</th>
                          <th>Url</th>
                          <th>Menu Padre</th>
                          <th>Orden</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>
					<tbody>
						<tr v-for="itemMenu in listamenus" v-bind:key="itemMenu" v-bind:itemMenu="itemMenu" >
                          <td>{{itemMenu.nombre}}</td>
                          <td><i v-bind:class="'fa ' + itemMenu.icono" ></i> {{ itemMenu.icono }}</td>
                          <td>{{itemMenu.url }}</td>
                          <td>{{itemMenu.nombrePadre||''}}</td>
                          <td>{{itemMenu.orden}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarMenu(itemMenu)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarMenu(itemMenu.codigo)"  style="cursor:pointer; color:red"></i>
						  </td>
                        </tr>   	             
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>



					</div>
				</div>
				<div class="x_panel" id="formulariomenus" v-show="mostrarformulario">
					<div class="x_title">
						<h2>Menus de Opciones <small>editar/crear</small></h2>
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
						<br />
						<form id="frmMenu" class="form-horizontal form-label-left">
							<input type="hidden" id="id" name="id" v-model="id"/>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre de Menu <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="nombre" name="nombre" v-model="nombre" required class="form-control ">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="des">Icono <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="icono" name="icono" v-model="icono"  required class="form-control">
								</div>
							</div>
							<div class="item form-group">
								<label for="url" class="col-form-label col-md-3 col-sm-3 label-align">Enlace -> URL</label>
								<div class="col-md-6 col-sm-6 ">
									<input id="url" v-model="url" class="form-control" type="text" name="url">
								</div>
							</div>

							<div class="item form-group">
								<label for="orden" class="col-form-label col-md-3 col-sm-3 label-align">Orden</label>
								<div class="col-md-6 col-sm-6 ">
									<input id="orden" v-model="orden" class="form-control" type="text" name="orden">
								</div>
							</div>
						
							<div class="form-group row">
								<label class="control-label col-md-3 col-sm-3 label-align">Menu Padre</label>
								<div class="col-md-6 col-sm-6 ">
									<select v-model="menuPadre" class="select2_single form-control" tabindex="-1">
										<option >Sin Menu Padre</option>										
										<option v-for="itemMenu in listamenus"  :key="itemMenu.codigo" :value="itemMenu.codigo">{{ itemMenu.nombre }}</option>		
									</select>
								</div>
							</div>
							

							<div class="ln_solid"></div>
							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3">
									<button class="btn btn-primary" type="button" v-on:click="cancelar();">Cancel</button>
									<button class="btn btn-primary" type="reset">Reset</button>
									<button type="button" class="btn btn-success" v-on:click="guardardatos();">Submit</button>
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
        url: null,
		icono:"",
		orden:"",
		menuPadre:null,
		listamenus:[],
		searchnombre:"",
		mostrarformulario:false

      };
    },
	methods: {
		async iniciarCarga() {
			try {
				var urltmp="http://localhost:8080/v1/menu/buscar/"+this.searchnombre;
				if(this.searchnombre=="") urltmp=urltmp="http://localhost:8080/v1/menu/menupadres";
			const response = await fetch(urltmp);
			this.listamenus= this.listMenuItems = await response.json(); 
			console.log("listaMenu:",this.listMenuItems)  
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				nombre: this.nombre,
				url:this.url,
				icono:this.icono,
				orden:this.orden,
				menuPadre:this.menuPadre
				
			};
			var metodo="POST";
			console.log(this.codigo)

			if(this.codigo!=null||this.codigo!=""){//guardar datos			
				data.codigo=this.codigo
				metodo="PUT";
			}
			
			fetch("http://localhost:8080/v1/menu/", {
			method: metodo, // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
			}).then((response) => response.json())
			.then((data) => {
				this.codigo=null;
				this.iniciarCarga();
				this.mostrarformulario=false;
			})
			.catch((error) => {
				console.error("Error:", error);
				return;
			});
		},
		editarMenu(datos){
			this.codigo=datos.codigo;
			this.nombre=datos.nombre;
			this.url=datos.url;
			this.orden=datos.orden;
			this.menuPadre=datos.menuPadre;
			this.icono=datos.icono;
			this.mostrarformulario=true;
		},
		async eliminarMenu(codigotmp){
			Swal.fire({
				title: 'Estas Seguro de Eliminar el Registro Seleccionado? ',
				showDenyButton: true,
				showCancelButton: true,
				confirmButtonText: 'Si, Borrar',
				denyButtonText: `No, Cancelar`,
				})
.then((result) => {
  /* Read more about isConfirmed, isDenied below */

  if (result.isConfirmed) {
	fetch("http://localhost:8080/v1/menu/"+codigotmp,{
		method: "DELETE",
		headers:{
			"Content-Type": "aplication/json",},
			}).then((response) => response.text())	
			.then((data) =>{
			Swal.fire(data, '', 'success')
			this.iniciarCarga();
		})
	.catch((error) => {
		Swal.fire('Error: '+error, '', 'error')
		return;
	});
	
  } else if (result.isDenied) {
    Swal.fire('Operación Cancelada', '', 'info')
  }
  
})
		},
		nuevoregistro(){
			this.mostrarformulario=true;
			this.codigo=null;
			this.nombre="";
			this.icono="";
			this.url="";
			this.orden=0;
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