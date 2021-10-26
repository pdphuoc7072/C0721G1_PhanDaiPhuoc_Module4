<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/25/2021
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>TỜ KHAI Y TẾ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-12 text-center">
            <h3>TỜ KHAI Y TẾ</h3>
        </div>
        <div class="col-12 text-center">
            <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
                CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
        </div>
        <div class="col-12 text-center text-danger">
            <h5>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình sự</h5>
        </div>
        <div class="col-12 mt-4">
            <form:form method="post" action="/medical-declaration/save" modelAttribute="medicalDeclaration">
                <div class="form-group ">
                    <form:label path="fullName">Họ tên (ghi chữ IN HOA) <span
                            class="text-danger">(*)</span> </form:label>
                    <form:input type="text" class="form-control" aria-describedby="fullNameError" path="fullName"/>
                    <small id="fullNameError" class="form-text text-danger"></small>
                </div>
                <div class="form-group row">
                    <div class="col-4">
                        <form:label path="birth">Năm sinh <span class="text-danger">(*)</span> </form:label>
                        <form:input type="date" class="form-control" aria-describedby="birthError" path="birth"/>
                        <small id="birthError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-4">
                        <form:label path="gender">Giới tính <span class="text-danger">(*)</span> </form:label>
                        <form:select class="form-control" aria-describedby="genderError" path="gender"
                                     items="${genderArray}"/>
                        <small id="genderError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-4">
                        <form:label path="nationality">Quốc tịch <span class="text-danger">(*)</span> </form:label>
                        <form:input type="text" class="form-control" aria-describedby="nationalityError"
                                    path="nationality"/>
                        <small id="nationalityError" class="form-text text-danger"></small>
                    </div>
                </div>
                <div class="form-group ">
                    <form:label
                            path="idCardNumber">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác
                        <span class="text-danger">(*)</span> </form:label>
                    <form:input type="text" class="form-control" aria-describedby="idCardNumberError"
                                path="idCardNumber"/>
                    <small id="idCardNumberError" class="form-text text-danger"></small>
                </div>
                <div class="form-group">
                    <form:label path="travelInfo">Thông tin đi lại <span class="text-danger">(*)</span> </form:label>
                    <div class="row">
                        <div class="form-check form-check-inline">
                            <form:radiobuttons class="form-check-input ml-3 mr-3" aria-describedby="travelInfoError"
                                               path="travelInfo" items="${travelInfoArray}"/>
                        </div>
                    </div>
                    <small id="travelInfoError" class="form-text text-danger"></small>
                </div>
                <div class="form-group row">
                    <div class="col-6">
                        <form:label path="vehicleNumber">Số hiệu phương tiện</form:label>
                        <form:input type="text" class="form-control" path="vehicleNumber"/>
                    </div>
                    <div class="col-6">
                        <form:label path="seatNumber">Số ghế</form:label>
                        <form:input type="text" class="form-control" path="seatNumber"/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-6">
                        <div class="row">
                            <div class="col-3">
                                <form:label path="departureDay">Ngày khởi hành <span
                                        class="text-danger">(*)</span> </form:label>
                            </div>
                            <div class="col-9">
                                <form:input type="date" class="form-control" aria-describedby="departureDayError"
                                            path="departureDay"/>
                            </div>
                        </div>
                        <small id="departureDayError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-6">
                        <div class="row">
                            <div class="col-3">
                                <form:label path="endDay">Ngày kết thúc <span
                                        class="text-danger">(*)</span> </form:label>
                            </div>
                            <div class="col-9">
                                <form:input type="date" class="form-control" aria-describedby="endDayError"
                                            path="endDay"/>
                            </div>
                        </div>
                        <small id="endDayError" class="form-text text-danger"></small>
                    </div>
                </div>
                <div class="form-group ">
                    <form:label path="cityIn14day">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?
                        <span class="text-danger">(*)</span> </form:label>
                    <form:input type="text" class="form-control" aria-describedby="cityIn14dayError"
                                path="cityIn14day"/>
                    <small id="cityIn14dayError" class="form-text text-danger"></small>
                </div>
                <div class="form-group ">
                    <form:label path="address">Địa chỉ liên lạc <span class="text-danger">(*)</span> </form:label>
                    <form:input type="text" class="form-control" aria-describedby="addressError" path="address"/>
                    <small id="addressError" class="form-text text-danger"></small>
                </div>
                <div class="form-group row">
                    <div class="col-6">
                        <form:label path="phone">Điện thoại <span class="text-danger">(*)</span> </form:label>
                        <form:input type="text" class="form-control" aria-describedby="phoneError" path="phone"/>
                        <small id="phoneError" class="form-text text-danger"></small>
                    </div>
                    <div class="col-6">
                        <form:label path="email">Email</form:label>
                        <form:input type="text" class="form-control" path="email"/>
                    </div>
                </div>
                <div class="form-group ">
                    <label>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?
                        <span class="text-danger">(*)</span> </label>
                    <div class="row">
                        <div class="col-6">
                            <table class="table border">
                                <thead>
                                <tr>
                                    <th>Triệu chứng</th>
                                    <th>Có Không</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Sốt <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="fever" items="${booleanArray}"/></td>
                                </tr>
                                <tr>
                                    <td>Ho <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="cough" items="${booleanArray}"/></td>
                                </tr>
                                <tr>
                                    <td>Khó thở <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="stuffy" items="${booleanArray}"/></td>
                                </tr>
                                <tr>
                                    <td>Đau họng <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="soreThroat" items="${booleanArray}"/></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-6">
                            <table class="table border">
                                <thead>
                                <tr>
                                    <th scope="col">Triệu chứng</th>
                                    <th scope="col">Có Không</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Nôn/Buồn nôn <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="nausea" items="${booleanArray}"/></td>
                                </tr>
                                <tr>
                                    <td>Tiêu chảy <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="diarrhea" items="${booleanArray}"/></td>
                                </tr>
                                <tr>
                                    <td>Xuất huyết ngoài da <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="skinHemorrhage" items="${booleanArray}"/></td>
                                </tr>
                                <tr>
                                    <td>Nổi ban ngoài da <span class="text-danger">(*)</span></td>
                                    <td><form:radiobuttons path="skinRash" items="${booleanArray}"/></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <label>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có?
                        <span class="text-danger">(*)</span> </label>
                    <table class="table border">
                        <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Có Không</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp
                                xúc động vật <span class="text-danger">(*)</span></td>
                            <td><form:radiobuttons path="market" items="${booleanArray}"/></td>
                        </tr>
                        <tr>
                            <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span
                                    class="text-danger">(*)</span></td>
                            <td><form:radiobuttons path="nCoVPeople" items="${booleanArray}"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-12 text-danger">
                    <p>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý
                        của Ban chỉ đạo quốc gia về phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và
                        đồng ý.</p>
                </div>

                <button type="submit" class="btn btn-primary">Gửi tờ khai</button>
            </form:form>
        </div>

    </div>
</div>

</body>
</html>
