<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>


</script>
</head>
<body>

<div class="modal fade" id="pageModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">New message</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>

			<br>
			<input type="radio" name="pageType" value="pro">제품 
			<input type="radio" name="pageType" value="text">페이지
			<br>
			<input type="text" name="name" value="text">페이지 이름
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" type="submit">페이지 추가</button>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="SelectPageModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">New message</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <select name="categori">
				<option value="카테고리 없음">
			</select>
			<hr>
			<input type="radio" name="pageType" value="pro">제품 
			<input type="radio" name="pageType" value="text">페이지
			<br>
			<input type="text" name="name" value="text">페이지 이름
			<button class="btn btn-primary" type="submit">페이지 추가</button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="CreatePageModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">New message</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
        				새로운 카테고리 사용<input type="text"name="categori" value="N">
        	
			<hr>
			<input type="radio" name="pageType" value="pro">제품 
			<input type="radio" name="pageType" value="text">페이지
			<br>
			<input type="text" name="name" value="text">페이지 이름
			
			<button class="btn btn-primary" type="submit">페이지 추가</button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>

<br>
현재 페이지
<br>
전체 제품
<br>
기본 샵 소개 페이지


        	<div>
        	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#CreatePageModal">카테고리 만들기</button>
        	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#SelectPageModal">카테고리 선택</button>
        	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#pageModal">카테고리 없음</button>
        	</div>






</body>
</html>