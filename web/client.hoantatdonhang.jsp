<%-- 
    Document   : hoantatdonhang
    Created on : Oct 19, 2023, 10:20:11 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en" class="flexbox">
    <head>
        <link rel="shortcut icon" href="/prj302/assets/theme.hstatic.net/favicon.png?v=90" type="image/png" />
        <title>
            OxyWatch - Đơn hàng #100010
        </title>


        <meta name="description" content="OxyWatch - Đơn h&#224;ng #100010" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='/prj302/assets/hstatic.net/checkouts.css?v=1.1' rel='stylesheet' type='text/css'  media='all'  />
        <link href='/prj302/assets/theme.hstatic.net/check_out.css?v=90' rel='stylesheet' type='text/css'  media='all'  />
        <script src='/prj302/assets/hstatic.net/jquery.min.js' type='text/javascript'></script>
        <script src='/prj302/assets/hstatic.net/jquery.validate.js' type='text/javascript'></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=2, user-scalable=no">
        <style>
            .inner {
                border: 1px solid #000; /* Định dạng đường viền */
                padding: 10px; /* Khoảng cách từ nội dung đến đường viền */
            }

            .contact-form {
                text-align: center; /* Canh giữa nội dung form */
            }

            .group-input {
                display: flex; /* Hiển thị các phần tử con theo chiều ngang */
                justify-content: center; /* Canh giữa theo chiều ngang */
            }

            input[type="email"] {
                width: 70%; /* Độ rộng của trường nhập email */
                padding: 10px; /* Khoảng cách bên trong trường nhập */
                border: 1px solid #ccc; /* Định dạng đường viền trường nhập */
            }

            button[type="submit"] {
                background-color: #007bff; /* Màu nền của nút gửi */
                color: #fff; /* Màu chữ trắng */
                padding: 10px 20px; /* Khoảng cách bên trong nút gửi */
                border: none; /* Loại bỏ đường viền */
                cursor: pointer; /* Biểu tượng con trỏ thay đổi khi di chuột qua */
            }

            .fa-paper-plane-o {
                font-size: 20px; /* Độ lớn của biểu tượng máy bay giấy */
            }
        </style>



        <script type="text/javascript">
            var toggleShowOrderSummary = false;
            $(document).ready(function () {
                var currentUrl = '';



                if ($('#reloadValue').val().length == 0)
                {
                    $('#reloadValue').val(currentUrl);
                    $('body').show();
                } else
                {
                    window.location = $('#reloadValue').val();
                    $('#reloadValue').val('');
                }

                $('body')
                        .on('click', '.order-summary-toggle', function () {
                            toggleShowOrderSummary = !toggleShowOrderSummary;

                            if (toggleShowOrderSummary) {
                                $('.order-summary-toggle')
                                        .removeClass('order-summary-toggle-hide')
                                        .addClass('order-summary-toggle-show');

                                $('.sidebar:not(".sidebar-second") .sidebar-content .order-summary')
                                        .removeClass('order-summary-is-collapsed')
                                        .addClass('order-summary-is-expanded');

                                $('.sidebar.sidebar-second .sidebar-content .order-summary')
                                        .removeClass('order-summary-is-expanded')
                                        .addClass('order-summary-is-collapsed');
                            } else {
                                $('.order-summary-toggle')
                                        .removeClass('order-summary-toggle-show')
                                        .addClass('order-summary-toggle-hide');

                                $('.sidebar:not(".sidebar-second") .sidebar-content .order-summary')
                                        .removeClass('order-summary-is-expanded')
                                        .addClass('order-summary-is-collapsed');

                                $('.sidebar.sidebar-second .sidebar-content .order-summary')
                                        .removeClass('order-summary-is-collapsed')
                                        .addClass('order-summary-is-expanded');
                            }
                        });
            });
        </script>

        <script>
//<![CDATA[
            (function (i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '/www.google-analytics.com/analytics.js', 'ga');
            ga('create', 'UA-97086989-1', 'auto');
            try {

            } catch (e) {
            }
            ;
            ga('send', 'pageview');

//]]>
        </script>
        <script>
            //<![CDATA[
            !function (f, b, e, v, n, t, s) {
                if (f.fbq)
                    return;
                n = f.fbq = function () {
                    n.callMethod ?
                            n.callMethod.apply(n, arguments) : n.queue.push(arguments)
                };
                if (!f._fbq)
                    f._fbq = n;
                n.push = n;
                n.loaded = !0;
                n.version = '2.0';
                n.queue = [];
                t = b.createElement(e);
                t.async = !0;
                t.src = v;
                s = b.getElementsByTagName(e)[0];
                s.parentNode.insertBefore(t, s)
            }(window,
                    document, 'script', '/prj302/assets/connect.facebook.net/fbevents.js');
            // Insert Your Facebook Pixel ID below. 
            fbq('init', '905600829489553');
            fbq('track', 'PageView');
            //]]>
        </script>
    <noscript><img height='1' width='1' style='display:none'
                   src='https://www.facebook.com/tr?id=905600829489553&amp;ev=PageView&amp;noscript=1'
                   /></noscript>
    <script type='text/javascript'>
        //<![CDATA[
        if ((typeof Haravan) === 'undefined') {
            Haravan = {};
        }
        Haravan.culture = 'vi-VN';
        Haravan.shop = 'happylive.myharavan.com';
        Haravan.theme = {"name": "Theme mặc định", "id": 1000229231, "role": "main"};
        Haravan.domain = 'happylive.vn';
        //]]>
    </script>
    <script>
        //<![CDATA[
        (function () {
            function asyncLoad() {
                var urls = ["/prj302/assets/hstatic.net/noname.js"];
                for (var i = 0; i < urls.length; i++) {
                    var s = document.createElement('script');
                    s.type = 'text/javascript';
                    s.async = true;
                    s.src = urls[i];
                    var x = document.getElementsByTagName('script')[0];
                    x.parentNode.insertBefore(s, x);
                }
            }
            window.attachEvent ? window.attachEvent('onload', asyncLoad) : window.addEventListener('load', asyncLoad, false);
        })();
        //]]>
    </script>
    <script type='text/javascript'>
        //<![CDATA[
        Haravan.checkout = '{"created_at":"2017-07-07T08:24:53.267Z","currency":"VND","customer_id":1004067765,"email":"abc@gmail.com","location_id":null,"order_id":1011727757,"requires_shipping":true,"reservation_time":null,"source_name":"web","source_identifier":null,"source_url":null,"taxes_included":false,"tax_exempt":false,"tax_lines":null,"token":"9da4ac7a14de46fdba068d4f8f789d15","updated_at":"0001-01-01T00:00:00","payment_due":null,"payment_url":null,"reservation_time_left":0,"subtotal_price":6194000.0,"total_price":6194000.0,"total_tax":0.0,"line_items":[{"id":0,"key":"0","product_id":1004862902,"variant_id":1012030836,"sku":"DHN68","vendor":"Happylive","title":"ĐỒNG HỒ NAM SKMEI KIM XANH DƯƠNG - Default Title","variant_title":"Default Title","taxable":false,"requires_shipping":true,"price":499000.0,"compare_at_price":700000.0,"line_price":2994000.0,"quantity":6,"grams":0.0},{"id":0,"key":"0","product_id":1004853557,"variant_id":1012006173,"sku":"DHN04","vendor":"Happylive","title":"ĐỒNG HỒ NAM TEVISE 1952 CHẠY CƠ CỰC CHẤT - Default Title","variant_title":"Default Title","taxable":false,"requires_shipping":true,"price":800000.0,"compare_at_price":1200000.0,"line_price":3200000.0,"quantity":4,"grams":0.0}],"shipping_rate":{"id":0,"barcode":null,"title":"Giao hàng tận nơi","price":0.0,"handle":"giao-hang-tan-noi-0"},"shipping_address":{"name":"sfsdf ","full_name":null,"first_name":null,"last_name":"sfsdf","company":null,"address1":"dfdsfsfs","address2":null,"zip":"70000","country":"Vietnam","province":"Bà Rịa - Vũng Tàu","country_id":241,"province_id":49,"district_id":548,"ward_id":null,"phone":"123131321","province_code":"BV","country_code":"VN"},"billing_address":{"name":"sfsdf ","full_name":"sfsdf","first_name":null,"last_name":"sfsdf","company":null,"address1":"dfdsfsfs","address2":null,"zip":"70000","country":"Vietnam","province":"Bà Rịa - Vũng Tàu","country_id":241,"province_id":49,"district_id":null,"phone":"123131321","billing_is_shipping":false,"note":null,"customeradd":0,"province_code":"BV","country_code":"VN"},"discount":{"amount":0.0,"code":null}}';
        //]]>
    </script>

</head>
<body>

    <input id="reloadValue" type="hidden" name="reloadValue" value="" />
    <div class="banner">
        <div class="wrap">
            <a href="http://happylive.vn" class="logo">
                <h1 class="logo-text">OxyWatch</h1>
            </a>
        </div>
    </div>
    <button class="order-summary-toggle order-summary-toggle-hide">
        <div class="wrap">
            <div class="order-summary-toggle-inner">
                <div class="order-summary-toggle-icon-wrapper">
                    <svg width="20" height="19" xmlns="http://www.w3.org/2000/svg" class="order-summary-toggle-icon"><path d="M17.178 13.088H5.453c-.454 0-.91-.364-.91-.818L3.727 1.818H0V0h4.544c.455 0 .91.364.91.818l.09 1.272h13.45c.274 0 .547.09.73.364.18.182.27.454.18.727l-1.817 9.18c-.09.455-.455.728-.91.728zM6.27 11.27h10.09l1.454-7.362H5.634l.637 7.362zm.092 7.715c1.004 0 1.818-.813 1.818-1.817s-.814-1.818-1.818-1.818-1.818.814-1.818 1.818.814 1.817 1.818 1.817zm9.18 0c1.004 0 1.817-.813 1.817-1.817s-.814-1.818-1.818-1.818-1.818.814-1.818 1.818.814 1.817 1.818 1.817z"></path></svg>
                </div>
                <div class="order-summary-toggle-text order-summary-toggle-text-show">
                    <span>Hiển thị thông tin đơn hàng</span>
                    <svg width="11" height="6" xmlns="http://www.w3.org/2000/svg" class="order-summary-toggle-dropdown" fill="#000"><path d="M.504 1.813l4.358 3.845.496.438.496-.438 4.642-4.096L9.504.438 4.862 4.534h.992L1.496.69.504 1.812z"></path></svg>
                </div>
                <div class="order-summary-toggle-text order-summary-toggle-text-hide">
                    <span>Ẩn thông tin đơn hàng</span>
                    <svg width="11" height="7" xmlns="http://www.w3.org/2000/svg" class="order-summary-toggle-dropdown" fill="#000"><path d="M6.138.876L5.642.438l-.496.438L.504 4.972l.992 1.124L6.138 2l-.496.436 3.862 3.408.992-1.122L6.138.876z"></path></svg>
                </div>
                <div class="order-summary-toggle-total-recap" data-checkout-payment-due-target="619400000">
                    <span class="total-recap-final-price">6,194,000₫</span>
                </div>
            </div>
        </div>
    </button>
    <div class="content content-second">
        <div class="wrap">
            <div class="sidebar sidebar-second">
                <div class="sidebar-content">
                    <div class="order-summary">
                        <div class="order-summary-sections">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="wrap">
            <div class="main">
                <div class="main-header">
                    <a href="http://happylive.vn" class="logo">
                        <h1 class="logo-text">OxyWatch</h1>
                    </a>
                </div>
                <div class="main-content">
                    <div >
                        <div class="section">
                            <div class="section-header os-header">
                                <svg width="50" height="50" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="#000" stroke-width="2" class="hanging-icon checkmark"><path class="checkmark_circle" d="M25 49c13.255 0 24-10.745 24-24S38.255 1 25 1 1 11.745 1 25s10.745 24 24 24z"></path><path class="checkmark_check" d="M15 24.51l7.307 7.308L35.125 19"></path></svg>
                                <div class="os-header-heading">
                                    <h2 class="os-header-title">
                                        Đặt hàng thành công
                                    </h2>
                                    <span class="os-description">
                                        Cám ơn bạn đã mua hàng!
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="thank-you-additional-content">
                            <!-- Google Code for Successful checkout Page -->
                            <script>
                                if (typeof ga != 'undefined') {
                                    ga('require', 'ecommerce');

                                    ga('ecommerce:addItem', {
                                        'id': '1004862902', // Transaction ID. Required.
                                        'name': 'ĐỒNG HỒ NAM SKMEI KIM XANH DƯƠNG', // Product name. Required.
                                        'sku': '', // SKU/code.
                                        'category': 'Đồng hồ nổi bật', // Category or variation.
                                        'price': '2994000', // Unit price.
                                        'quantity': '6' // Quantity.
                                    });

                                    ga('ecommerce:addItem', {
                                        'id': '1004853557', // Transaction ID. Required.
                                        'name': 'ĐỒNG HỒ NAM TEVISE 1952 CHẠY CƠ CỰC CHẤT', // Product name. Required.
                                        'sku': '', // SKU/code.
                                        'category': 'Đồng hồ nổi bật', // Category or variation.
                                        'price': '3200000', // Unit price.
                                        'quantity': '4' // Quantity.
                                    });


                                    ga('ecommerce:addTransaction', {
                                        'id': '#100010',
                                        'affiliation': '',
                                        'revenue': '6194000',
                                        'shipping': '',
                                        'tax': '',
                                        'currency': 'VND'  // local currency code.
                                    });
                                    ga('ecommerce:send');
                                }
                            </script>
                        </div>
                        <div class="step-footer">
                            <a href="product" class="step-footer-continue-btn btn">
                                <span class="btn-content">Tiếp tục mua hàng</span>
                            </a>
                            <p class="step-footer-info">
                            <div class="inner" border="1px">
                                <form accept-charset='UTF-8' action='/prj302/sendmail' class='contact-form' method='post'>
                                    <div class="group-input">    
                                        <input type="email" required="required" name="contactemail"/>
                                        <button type="submit"><i class="fa fa-paper-plane-o"></i></button>
                                    </div>
                                </form>               
                            </div>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="main-footer">
                </div>
            </div>
        </div>
    </div>
</body>
</html>


