<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/26/2021
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>TỜ KHAI Y TẾ</title>
</head>
<body>
<h4>Thông tin khai báo:</h4>
<p>
    <a href="/medical-declaration">
        Khai báo lại
    </a>
</p>
<form:form method="post" action="/medical-declaration/update" modelAttribute="medicalDeclaration">
    <table>
        <tr>
            <td>Họ tên: </td>
            <td>${medicalDeclaration.fullName}</td>
        </tr>
        <tr>
            <td>Năm sinh: </td>
            <td>${medicalDeclaration.birth}</td>
        </tr>
        <tr>
            <td>Giới tính: </td>
            <td>${medicalDeclaration.gender}</td>
        </tr>
        <tr>
            <td>Quốc tịch: </td>
            <td>${medicalDeclaration.nationality}</td>
        </tr>
        <tr>
            <td>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác: </td>
            <td>${medicalDeclaration.idCardNumber}</td>
        </tr>
        <tr>
            <td>Thông tin đi lại: </td>
            <td>${medicalDeclaration.travelInfo}</td>
        </tr>
        <tr>
            <td>Số hiệu phương tiện: </td>
            <td>${medicalDeclaration.vehicleNumber}</td>
        </tr>
        <tr>
            <td>Ngày khởi hành: </td>
            <td>${medicalDeclaration.departureDay}</td>
        </tr>
        <tr>
            <td>Ngày kết thúc: </td>
            <td>${medicalDeclaration.endDay}</td>
        </tr>
        <tr>
            <td>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?: </td>
            <td>${medicalDeclaration.cityIn14day}</td>
        </tr>
        <tr>
            <td>Địa chỉ liên lạc: </td>
            <td>${medicalDeclaration.address}</td>
        </tr>
        <tr>
            <td>Điện thoại: </td>
            <td>${medicalDeclaration.phone}</td>
        </tr>
        <tr>
            <td>Email: </td>
            <td>${medicalDeclaration.email}</td>
        </tr>
        <tr>
            <td>Triệu chứng Sốt: </td>
            <c:if test="${medicalDeclaration.fever == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.fever == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Ho: </td>
            <c:if test="${medicalDeclaration.cough == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.cough == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Khó thở: </td>
            <c:if test="${medicalDeclaration.stuffy == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.stuffy == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Đau họng: </td>
            <c:if test="${medicalDeclaration.soreThroat == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.soreThroat == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Nôn/Buồn nôn: </td>
            <c:if test="${medicalDeclaration.nausea == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.nausea == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Tiêu chảy: </td>
            <c:if test="${medicalDeclaration.diarrhea == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.diarrhea == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Xuất huyết ngoài da: </td>
            <c:if test="${medicalDeclaration.skinHemorrhage == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.skinHemorrhage == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Triệu chứng Nổi ban ngoài da: </td>
            <c:if test="${medicalDeclaration.skinRash == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.skinRash == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc động vật: </td>
            <c:if test="${medicalDeclaration.market == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.market == false}">
                <td>Không</td>
            </c:if>
        </tr>
        <tr>
            <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV: </td>
            <c:if test="${medicalDeclaration.nCoVPeople == true}">
                <td>Có</td>
            </c:if>
            <c:if test="${medicalDeclaration.nCoVPeople == false}">
                <td>Không</td>
            </c:if>
        </tr>
    </table>
    <button type="submit">Cập nhật thông tin</button>
</form:form>

</body>
</html>
