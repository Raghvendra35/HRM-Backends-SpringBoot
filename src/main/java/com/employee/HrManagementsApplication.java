Forgot Component

HTML



<body>
<div id="forgot">

<div class="container">
  <div id="forgot-row" class="row justify-content-center">
    <div id="forgot-column" class="col-md-6">
     <div id="forgot-box" class="col-md-12" style="height: 220px;">
       
       
        <h3 class="text-center m-3">Your Registered Email</h3>
 

        <div class="form-group">
          <input type="email" [(ngModel)]="forgotData.emailId" name="emailId" placeholder="Enter email here " class="form-control" />
        </div>
          <div class="container text-center">
            <Button type="submit" class="btn btn-warning" (click)="formSubmit()" >Send OTP</Button>
            <!-- <Button type="button" (click)="openModal()">OpenModal</Button> -->
          </div>
     </div>   

    </div>

  </div>  


</div>
</div>
</body>







<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" style="height: 600px;">
    <div class="modal-content">
      <!-- <div class="modal-header"> -->
        <!-- <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1> -->
        <!-- <div class="modal-dialog modal-dialog-centered"> -->
                <div class="alert alert-success mt-3" role="alert" style="width: 450px;" style="margin-left: 0px;">
            We have sent OTP your email.....
            </div>
           <input type="number" placeholder="Enter OTP here">
      
   
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Varify</button>
      </div>
    </div>
  </div>
  <!-- Vertically centered modal -->
<!-- 
</div> -->
</div>

