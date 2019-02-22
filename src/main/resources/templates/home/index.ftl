<#import "/spring.ftl" as spring/>

<#include "../includable/headersInclude.ftl"/>

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form action="/index" method="POST">
                    <div class="form-group">
                      <input type="text" name="user.login" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter your login">
                    </div>
                    <div class="form-group">
                      <input type="password" name="user.password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <input type="text" name="roleId" class="form-control form-control-user" id="exampleInputPassword" placeholder="Role id">
                    </div>
                    <div class="form-group">
                      <input type="text" name="description" class="form-control form-control-user" id="exampleInputPassword" placeholder="Description">
                    </div>
                    <input type="submit" class="btn btn-primary btn-user btn-block">
                    </input>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>



<#include "../includable/footersInclude.ftl"/>

