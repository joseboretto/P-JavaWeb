<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%@ include file="/menuBootstrap.jspf" %>

        <h1 style="text-align: center">Actualizar Datos Cliente</h1>
        <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
        <div class="container">
                    
                     <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/actualizarCliente" >
                        
                        <div class="form-group row" >
                            <span class="col-xs-1"></span>
                            <label class="control-label col-xs-2">ID Cliente</label>
                            <div class="col-xs-7">
                                <input name="idCliente" type="number" class="form-control" id="usr">
                            </div>
                            <span class="col-xs-2"></span>
                        </div>
                    
                

                        <div class="form-group row">
                            <div class="col-xs-1"></div>
                            <label class="control-label col-xs-2">Nuevo Nombre</label>
                            <div class="col-xs-7">
                                <input name="nombreCliente" type="text" class="form-control" id="usr">
                            </div>
                            <div class="col-xs-2"></div>
                        </div>
                         
                         <div class="form-group row" >
                            <span class="col-xs-1"></span>
                            <label class="control-label col-xs-2">Nuevo Numero</label>
                            <div class="col-xs-7">
                                <input name="telefonoCliente" type="number" class="form-control" id="usr">
                            </div>
                            <span class="col-xs-2"></span>
                        </div>
                         
                        <div class="row">
                            <span class="col-xs-3"></span>
                            <button type="submit" class="btn btn-default col-xs-7 ">Submit</button>
                            <span class="col-xs-2"></span>
                        </div>


                        
                  </form>

                
        </div>

