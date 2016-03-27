<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ include file="/menuBootstrap.jspf" %>

        <h1 style="text-align: center">Eliminar Cliente</h1>
        <hr style="width: 100%; color: black; height: 1px; background-color:black;" /> 
        
        <div class="container">
                    
                     <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/eliminarCliente" >
                        
                        <div class="form-group row" >
                            <span class="col-xs-1"></span>
                            <label class="control-label col-xs-2">ID Cliente</label>
                            <div class="col-xs-7">
                                <input name="idCliente" type="number" class="form-control" id="usr">
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
        
        
    </body>
</html>
