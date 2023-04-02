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


    
</template>