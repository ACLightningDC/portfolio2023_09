<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>API 요청 예제</title>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/jquery-3.7.0.min.js"></script>
</head>
<body>
    <h1>API 요청 예제</h1>
   
    <!-- 사업자 등록번호 입력 필드 -->
    <label for="b_no">사업자 등록번호:</label>
    <input type="text" id="b_no" name="b_no"><br>
   
    <!-- 요청 보내기 버튼 -->
    <button id="requestButton">서버에 요청 보내기</button>

    <script>
        $(document).ready(function() {
            $("#requestButton").click(function() {
                // 입력 필드에서 "b_no" 값을 가져오기
                var bNo = $("#b_no").val();

                var data = {
                    "b_no": [bNo]
                };

                $.ajax({
                    url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=oDzQWmOxHyVL7lTw1kHZO3QAZ3afJHiEN7j7XCDOO%2FfBTlWH3ax7z%2FGSAaN4bl%2BxkmB1Bk%2BYHq2Q6M1dc30MkQ%3D%3D",
                    type: "POST",
                    data: JSON.stringify(data),
                    dataType: "json",
                    contentType: "application/json",
                    success: function(result) {
                        // API 응답에서 "b_no", "b_stt", "b_stt_cd" 값을 추출하여 큰따옴표로 둘러싸서 alert로 표시
                        var alertMessage = `"b_no": "${result.data[0].b_no}"\n"b_stt": "${result.data[0].b_stt}"\n"b_stt_cd": "${result.data[0].b_stt_cd}"`;
                        alert(alertMessage);
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        alert("에러 상태 코드: " + xhr.status + "\n에러 메시지: " + errorThrown + "\n응답 텍스트: " + xhr.responseText);
                    },
                });
            });
        });
    </script>
</body>
</html>