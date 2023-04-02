<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 ">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Formulario de Personas <small>crear/editar</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">Settings 1</a>
                                    <a class="dropdown-item" href="#">Settings 2</a>
                                </div>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <br />
                        <form class="form-label-left input_mask">

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" class="form-control has-feedback-left" id="inputSuccess2" placeholder="Nombres">
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" class="form-control" id="inputSuccess3" placeholder="Apellidos">
                                <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="tel" class="form-control has-feedback-left" id="inputSuccess5" placeholder="Celular">
                                <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="date" class="form-control " id="inputSuccess4" placeholder="Edad">
                               
                            </div>

                            

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <select class="form-control has-feedback-left" placeholder="Sexo" tabindex="-1">
                                        <option>Masculino</option>
										<option>Femenino</option>										
								</select>
                                <span class="fa fa-male form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" class="form-control" id="inputSuccess5" placeholder="DNI">
                                <span class="fa fa-file-text-o form-control-feedback right" aria-hidden="true"></span>
                            </div>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="tel" class="form-control has-feedback-left" id="inputSuccess5" placeholder="Cargo">
                                <span class="fa fa-magic form-control-feedback left" aria-hidden="true"></span>
                            </div>
                            
                                                       
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" class="form-control" id="inputSuccess3" placeholder="Dirección">
                                <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                            </div>
                            
                            <div class="col-md-12 col-sm-12  form-group has-feedback">
								<label class="control-label col-md-3 col-sm-3 label-align">Distrito</label>
								<div class="col-md-6 col-sm-6 ">
									<select class="select2_single form-control" tabindex="-1">
										<option>Sin Menu Padre</option>										
										<option></option>	
									</select>
								</div>
							</div>
                     

                           
                            
                            <div class="ln_solid"></div>
                            <div class="form-group row">
                                <div class="col-md-9 col-sm-9  offset-md-3">
                                    <button type="button" class="btn btn-primary">Cancelar</button>
                                    <button class="btn btn-primary" type="reset">Resetear</button>
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

               


            </div>
        </div>
    </div>

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
								v-model="searchnombre" v-on:input="iniciarCarga();" required class="form-control" placeholder="Buscar por Producto">
							</div>
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>Juego</th>
                          <th>nombre</th>
                          <th>Precio</th>
                          <th>Stock</th>
                          <th>id_desc</th>
                          <th>id_valo</th>
                          <th>id_imagen</th>
                          <th>id_cat</th>
                          <th>desp_1</th>
                          <th>desp_2</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>
					  <tbody>
						<tr v-for="itemJuego in listaProducto" v-bind:key="itemJuego" v-bind:itemJuego="itemJuego" >
                          <td>{{itemJuego.nombre}}</td>
                          <td>{{itemJuego.fecha }}</td>
                          <td>{{itemJuego.precompra}}</td>
                          <td>{{itemJuego.preventa}}</td>
						  <td>{{itemJuego.stock}}</td>
							<td>{{itemJuego.distrito.nombre}}</td>
							<td>{{itemJuego.distrito.nombre}}</td>
							<td>{{itemJuego.distrito.nombre}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarJuego(itemJuego)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarJuego(itemJuego.id_juego)"  style="cursor:pointer; color:red"></i>
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
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre de Producto <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="nombre" name="nombre" v-model="nombre" required class="form-control ">
								</div>
							</div>

                            <div class="item form-group">
											<label for="fecha" class="col-form-label col-md-3 col-sm-3 label-align">Fecha Vencimiento <span class="required"></span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input id="fecha" v-model= "fecha" class="date-picker form-control" placeholder="dd-mm-yyyy" type="text" required="required" onfocus="this.type='date'" onmouseover="this.type='date'" onclick="this.type='date'" onblur="this.type='text'" onmouseout="timeFunctionLong(this)">
											</div>
							</div>
                            
                            <div class="item form-group">
								<label for="precompra" class="col-form-label col-md-3 col-sm-3 label-align">Precio de Compra </label>
								<div class="col-md-6 col-sm-6 ">
									<input id="precompra" v-model="precompra" class="form-control" type="text" name="precompra">
								</div>
							</div>

                            <div class="item form-group">
								<label for="preventa" class="col-form-label col-md-3 col-sm-3 label-align">Precio de Venta </label>
								<div class="col-md-6 col-sm-6 ">
									<input id="preventa" v-model="preventa" class="form-control" type="text" name="preventa">
								</div>
							</div>

                            <div class="item form-group">
								<label for="stock" class="col-form-label col-md-3 col-sm-3 label-align">Stock </label>
								<div class="col-md-6 col-sm-6 ">
									<input id="stock" v-model="stock" class="form-control" type="text" name="stock">
								</div>
							</div>


							<div class="form-group row">
								<label class="control-label col-md-3 col-sm-3 label-align">Categoria </label>
								<div class="col-md-6 col-sm-6 ">
									<select id="categoriaPadre" v-model="categoriaPadre" class="select2_single form-control" tabindex="-1" name="categoriaPadre">	
										<option v-for="itemCategoria in listacategoria"  :key="itemCategoria.codigo" :value="itemCategoria.codigo">{{ itemCategoria.nombre }}</option>
									</select>
								</div>
							</div>

                            <div class="form-group row">
								<label class="control-label col-md-3 col-sm-3 label-align">Presentación </label>
								<div class="col-md-6 col-sm-6 ">
									<select id="presentacionPadre" v-model="presentacionPadre" class="select2_single form-control" tabindex="-1" name="presentacionPadre">							
										<option v-for="itemPresentacion in listapresentacion"  :key="itemPresentacion.codigo" :value="itemPresentacion.codigo">{{ itemPresentacion.nombre }}</option>	
									</select>
								</div>
							</div>

                            <div class="form-group row">
								<label class="control-label col-md-3 col-sm-3 label-align">Proveedor </label>
								<div class="col-md-6 col-sm-6 ">
									<select id="proveedorPadre" v-model="proveedorPadre" class="select2_single form-control" tabindex="-1" name="proveedorPadre">
																				
										<option v-for="itemProveedor in listaProveedor"  :key="itemProveedor.codigo" :value="itemProveedor.codigo">{{ itemProveedor.nombre }}</option>	
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
	import axios from "axios";
	function timeFunctionLong(input) {
	setTimeout(function() {
	input.type = 'text';
	}, 60000);
	}
                                                    
												
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
			this.searchnombre=""
		},
		cancelar(){
			this.mostrarformulario=false;
		}
	},

	created() {
      this.iniciarCarga();
    },

  data(){
  return {
    juego:[]
    
    }
  },
  
  data: () => ({
    result: null
  }),
  created() {
    axios.get("http://localhost:8080/v1/juego/").then((result) => {
      this.result = result.data;
    })
  }
}

</script>