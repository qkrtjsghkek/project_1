function loginCheck() {
   if (document.frm1.id.value.length == 0) {
      alert("아이디를 입력해주세요.");
      frm1.id.focus();
      return false;
   }
   if (document.frm1.pw.value.length == 0) {
      alert("비밀번호를 입력해주세요.");
      frm1.pw.focus();
      return false;
   }
   return true;
}

function idCheck() {
   if (document.member_join_frm.id.value == "") {
      alert("아이디를 입력하여 주십시오.");
      document.member_join_frm.id.focus();
      return;
   }
   var url = "HosinsaServlet?command=member_id_check&id=" + document.member_join_frm.id.value;
   window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(id) {
   opener.member_join_frm.id.value = document.id_check_frm.id.value;
   opener.member_join_frm.reid.value = document.id_check_frm.id.value;
   self.close();
}

function joinCheck() {
   if (document.member_join_frm.id.value.length == 0) {
      alert("아이디는 필수정보 입니다.");
      member_join_frm.id.focus();
      return false;
   }
   if (document.member_join_frm.id.value.length < 5) {
      alert("아이디는 5자 이상이어야 합니다.");
      member_join_frm.id.focus();
      return false;
   }
   if (document.member_join_frm.pw.value == "") {
      alert("비밀번호는 필수정보 입니다.");
      member_join_frm.pw.focus();
      return false;
   }
   if (document.member_join_frm.pw.value != document.member_join_frm.pw_check.value) {
      alert("비밀번호가 일치하지 않습니다.");
      member_join_frm.pw.focus();
      return false;
   }
   if (document.member_join_frm.reid.value.length == 0) {
      alert("중복 체크를 하지 않았습니다.");
      member_join_frm.id.focus();
      return false;
   }
   return true;
}

function open_win(url, name) {
   window.open(url, name, "width=500, height=230");
}

function passCheck() {
   if (document.frm.pass.value.length == 0) {
      alert("비밀번호를 입력하세요.");
      return false;
   }
   return true;
}
function updateCheck() {
   if (document.user_info_update_frm.pw.value != document.user_info_update_frm.pw_check.value) {
      alert("비밀번호가 일치하지 않습니다.");
      return false;
   }
   if (document.user_info_update_frm.email.value.length == 0) {
      alert("이메일을 입력하세요.");
      return false;
   }
   if (document.user_info_update_frm.phone.value.length == 0) {
      alert("연락처를 입력하세요.");
      return false;
   }
   return true;
}

function joinGoPopup(){
   // 주소검색을 수행할 팝업 페이지를 호출합니다.
   // 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
   var pop = window.open("member/joinJusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
   
   // 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
   //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes");
}

function joinJusoCallBack(roadFullAddr,zipNo){
   // 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
   document.member_join_frm.address.value = roadFullAddr;
   document.member_join_frm.zipcode.value = zipNo;
}

function userGoPopup(){
   // 주소검색을 수행할 팝업 페이지를 호출합니다.
   // 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
   var pop = window.open("member/userJusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
   
   // 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
   //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes");
}

function userJusoCallBack(roadFullAddr,zipNo){
   // 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
   document.user_info_update_frm.address.value = roadFullAddr;
   document.user_info_update_frm.zipcode.value = zipNo;
}

function introducerCheck() {
   if (document.member_join_frm.introducer.value == "") {
      alert("추천인을 입력하여 주십시오.");
      document.member_join_frm.introducer.focus();
      return;
   }

   var url = "HosinsaServlet?command=member_introducer_check&introducer=" + document.member_join_frm.introducer.value;
   window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function intOk(introducer) {
   opener.member_join_frm.introducer.value = document.int_check_frm.introducer.value;
   opener.member_join_frm.reintroducer.value = document.int_check_frm.introducer.value;
   self.close();
}

function category() {
   var category = document.getElementById("category");
   var valueccc = (category.options[category.selectedIndex].value);
   
   var link = "HosinsaServlet?command=product_list&category=" + valueccc;
   location.href=link;
}

document.addEventListener("DOMContentLoaded", function(){

const total=document.getElementById("total_cash");
const point=document.getElementById("use_pnt");
const av_pnt=document.getElementById("av_pnt");
document.getElementById("result_pnt").innerText=total.value;
point.addEventListener('keyup',function(){
   if(parseInt(this.value)>parseInt(total.value)){
      this.value=total.value;
   }else if(parseInt(this.value)>parseInt(av_pnt.value)){
      this.value=av_pnt.value;
   }
   document.getElementById("result_pnt").innerText=total.value-this.value;
})

const proname=document.querySelectorAll(".proname");
const quantity=document.querySelectorAll(".quantity");
const stock=document.querySelectorAll(".stock");
for(i=0;i<proname.length;i++){
   
   if((stock[i].value-quantity[i].value)<0){
      alert(proname[i].innerText+"의 재고가 부족합니다. 수량을 수정해 주세요.");      
      window.history.back();      
   }
   return false;
}

});

function pointCheck() {
   if(document.frm.total_cash.value > document.frm.use_pnt.value){
      alert('결제 금액이 부족합니다.');
       return false;
   }else{
      return true;
   }
}

function search() {
	var num = parseInt(document.search_frm.search_last.value);
	if (document.search_frm.search_last.value.length == 0) {
		alert("검색어를 입력하여 주십시오.");
		document.search_frm.search_last.focus();
		return false;
	}
	
	if (document.search_frm.search_first.value === "선택") {
		alert("아무것도 선택되지 않았습니다.");
		document.search_frm.search_first.focus();
		return false;
	}
	
	if (document.search_frm.search_first.value === "제품번호") {
		if (isNaN(document.search_frm.search_last.value) == true) {
			alert("숫자를 입력하여 주십시오.");
			return false;
		}
	}
	return true;
}

function userCheck(){
	if (document.cart_in_frm.id.value.length === 0){
		alert("로그인 후 사용하실 수 있습니다.");
		return false;
	}
	else{
		alert("장바구니에 담겼습니다.");
		return true;
	}
}

function grade() {
	var grade = document.getElementById("grade");
	var valueGrade = (grade.options[grade.selectedIndex].value);
	
	var link = "HosinsaServlet?command=member_list&grade=" + valueGrade;
	location.href = link;
}

function search_member() {
	if (document.id_search_frm.search_last.value.length == 0) {
		alert("검색어를 입력하여 주십시오.");
		document.id_search_frm.search_last.focus();
		return false;
	}
	if (document.id_search_frm.search_first.value === "선택") {
		alert("아무것도 선택되지 않았습니다.");
		document.id_search_frm.search_first.focus();
		return false;
	}
	return true;
}

function numCheck() {
	if (document.frm3.pronum.value == "") {
		alert("제품번호를 입력하여 주십시오.");
		document.frm3.pronum.focus();
		return;
	}
	var url = "HosinsaServlet?command=product_pronum_check&pronum=" + document.frm3.pronum.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function numok(pronum) {
	opener.frm3.pronum.value = document.pronum_check_frm.pronum.value;
	opener.frm3.reid.value = document.pronum_check_frm.pronum.value;
	self.close();
}