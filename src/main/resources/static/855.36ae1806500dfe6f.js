"use strict";(self.webpackChunkangular_frontend=self.webpackChunkangular_frontend||[]).push([[855],{8855:(T,m,a)=>{a.r(m),a.d(m,{LeaveemployeeListModule:()=>s});var d=a(6895),r=a(2019),v=a(7652),b=a(8448),e=a(8256),h=a(8463);function Z(n,t){if(1&n){const o=e.EpF();e.TgZ(0,"tr")(1,"td"),e._uU(2),e.qZA(),e.TgZ(3,"td"),e._uU(4),e.qZA(),e.TgZ(5,"td"),e._uU(6),e.qZA(),e.TgZ(7,"td"),e._uU(8),e.qZA(),e.TgZ(9,"td"),e._uU(10),e.qZA(),e.TgZ(11,"td"),e._uU(12),e.qZA(),e.TgZ(13,"button",11),e.NdJ("click",function(){const g=e.CHM(o).$implicit,u=e.oxw();return e.KtG(u.updateLeave(g.leaveId))}),e.TgZ(14,"a",12),e._uU(15,"Edit"),e.qZA()(),e.TgZ(16,"button",13),e.NdJ("click",function(){const g=e.CHM(o).$implicit,u=e.oxw();return e.KtG(u.deleteLeave(g.leaveId))}),e._uU(17,"Delete"),e.qZA()()}if(2&n){const o=t.$implicit,l=t.index,c=e.oxw();e.xp6(2),e.Oqu(c.pageObject.size*c.pageObject.page+(l+1)),e.xp6(2),e.Oqu(o.employee.firstName),e.xp6(2),e.Oqu(o.employee.emailId),e.xp6(2),e.Oqu(o.fromDate),e.xp6(2),e.Oqu(o.toDate),e.xp6(2),e.Oqu(o.reasonToLeave),e.xp6(2),e.Q6J("routerLink",c.admin/c.updateleave)}}const L=function(){return["../leavereport"]};class p{constructor(t,o){this.leaveService=t,this.router=o,this.leaveList=[],this.pageObject={page:0,size:10,totalPage:0,totalElements:0},this.employee=new b.RB,this.leaveEmployee=new v.k}ngOnInit(){this.getPagination()}getPagination(){this.leaveService.getLeavePagination(this.pageObject.page,this.pageObject.size).subscribe(t=>{console.log(t),this.leaveEmployees=t.content,console.log(t.content.totalPages),console.log("number"),this.pageObject.page=t.number,console.log(this.pageObject.page),this.pageObject.totalPage=t.totalPages,console.log("Data ====================="),console.log(t.totalElements),this.pageObject.totalElements=t.totalElements})}myFuction(t,o){"prev"==t&&(this.pageObject.page=o-1,this.pageObject.page>-1&&"prev"==t&&this.pageObject.totalPage>this.pageObject.page&&(this.getPagination(),console.log("prev B"))),"next"==t&&(this.pageObject.page=o+1,"next"==t&&this.pageObject.totalPage>this.pageObject.page?(this.getPagination(),console.log("Next b")):alert("This is a last Page !!!"))}updateLeave(t){this.router.navigate(["updateleave",t])}getSalaryById(t){}deleteLeave(t){this.leaveService.deletetLeave(t).subscribe(l=>{this.leaveEmployees=l})}}p.\u0275fac=function(t){return new(t||p)(e.Y36(h.e),e.Y36(r.F0))},p.\u0275cmp=e.Xpm({type:p,selectors:[["app-leaveemployee-list"]],decls:31,vars:3,consts:[[1,"navbar","navbar-light","bg-primary",2,"margin-top","55px"],[1,"container-fluid"],[2,"color","aliceblue"],[1,"d.flex"],["type","button","data-bs-toggle","modal","data-bs-target","#exampleModal",1,"btn","bth-success",2,"color","black","background-color","rgb(220, 209, 231)"],[1,"nav-link",3,"routerLink"],[1,"table","mt","table-bordered"],["scope","col"],[4,"ngFor","ngForOf"],["type","button",2,"background-color","rgb(189, 189, 228)","border-radius","15px","margin-left","30px","margin-top","15px",3,"click"],["type","button",2,"background-color","rgb(189, 189, 228)","border-radius","15px","margin-left","10px",3,"click"],[1,"btn","btn-info",3,"click"],[2,"text-decoration","none",3,"routerLink"],[1,"btn","btn-danger",2,"color","black",3,"click"]],template:function(t,o){1&t&&(e.TgZ(0,"nav",0)(1,"div",1)(2,"h3",2),e._uU(3,"HR Managements"),e.qZA(),e.TgZ(4,"div",3)(5,"button",4)(6,"a",5),e._uU(7,"Leave_Report"),e.qZA()()()()(),e.TgZ(8,"table",6)(9,"thead")(10,"tr")(11,"th",7),e._uU(12,"index"),e.qZA(),e.TgZ(13,"th",7),e._uU(14,"Employee Name"),e.qZA(),e.TgZ(15,"th",7),e._uU(16,"Email_Id"),e.qZA(),e.TgZ(17,"th",7),e._uU(18,"FromDate"),e.qZA(),e.TgZ(19,"th",7),e._uU(20,"ToDate"),e.qZA(),e.TgZ(21,"th",7),e._uU(22,"Reason To Leave"),e.qZA(),e.TgZ(23,"th",7),e._uU(24,"Action"),e.qZA()()(),e.TgZ(25,"tbody"),e.YNc(26,Z,18,7,"tr",8),e.qZA()(),e.TgZ(27,"button",9),e.NdJ("click",function(){return o.myFuction("prev",o.pageObject.page)}),e._uU(28,"<"),e.qZA(),e.TgZ(29,"button",10),e.NdJ("click",function(){return o.myFuction("next",o.pageObject.page)}),e._uU(30,">"),e.qZA()),2&t&&(e.xp6(6),e.Q6J("routerLink",e.DdM(2,L)),e.xp6(20),e.Q6J("ngForOf",o.leaveEmployees))},dependencies:[d.sg,r.rH]});var y=a(8063);const f=[{path:"",component:p,canActivate:[y.a]}];class i{}i.\u0275fac=function(t){return new(t||i)},i.\u0275mod=e.oAB({type:i}),i.\u0275inj=e.cJS({imports:[r.Bz.forChild(f),r.Bz]});class s{}s.\u0275fac=function(t){return new(t||s)},s.\u0275mod=e.oAB({type:s}),s.\u0275inj=e.cJS({imports:[d.ez,i,r.Bz]})}}]);