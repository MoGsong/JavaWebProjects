<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>会诊室</title>
    <!-- Summernote css -->
    <link href="static/css/summernote-bs4.css" rel="stylesheet" type="text/css">
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
    <!-- Bootstrap Css -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Icons Css -->
    <link href="static/css/icons.min.css" rel="stylesheet" type="text/css">
    <!-- App Css-->
    <link href="static/css/app.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div class="col-auto d-flex w-sm-100">
        <button type="button" class="btn btn-primary btn-set-task w-sm-100" data-bs-toggle="modal"
            data-bs-target="#dep"><i class="icofont-plus-circle me-2 fs-6"></i>添加</button>
    </div>


    <div class="modal fade" id="dep" tabindex="-1" aria-hidden="true" style="background-color: #fff;">
        <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
            <div class="modal-content">
                
                    <div class="content">
                        <div class="item item-center"><span>昨天 12:35</span></div>
                        <div class="item item-center"><span>你已添加了凡繁烦，现在可以开始聊天了。</span></div>
                        <div class="item item-left">
                            <div class="avatar"><img
                                    src="https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=25668084,2889217189&fm=26&gp=0.jpg" />
                            </div>
                            <div class="bubble bubble-left">您好,我在武汉，你可以直接送过来吗，我有时间的话，可以自己过去拿<br />！！！<br />123</div>
                        </div>

                        <div class="item item-right">
                            <div class="bubble bubble-right">hello<br />你好呀</div>
                            <div class="avatar"><img
                                    src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3313909130,2406410525&fm=15&gp=0.jpg" />
                            </div>
                        </div>
                        <div class="item item-center"><span>昨天 13:15</span></div>
                        <div class="item item-right">
                            <div class="bubble bubble-right">刚刚不在，不好意思</div>
                            <div class="avatar"><img
                                    src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3313909130,2406410525&fm=15&gp=0.jpg" />
                            </div>
                        </div>
                        
                        <div class="item item-left">
                            <div class="avatar"><img
                                    src="https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=25668084,2889217189&fm=26&gp=0.jpg" />
                            </div>
                            <div class="bubble bubble-left">看到了<br />在下面</div>
                        </div>
                        <div class="item item-left">
                            <div class="avatar"><img
                                    src="https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=25668084,2889217189&fm=26&gp=0.jpg" />
                            </div>
                            <div class="bubble bubble-left">你发一个<br />刚刚网卡了</div>
                        </div>
                        <div class="item item-right">
                            <div class="bubble bubble-right">可以<br />一会儿再发给你</div>
                            <div class="avatar"><img
                                    src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3313909130,2406410525&fm=15&gp=0.jpg" />
                            </div>
                        </div>
                    </div>
                    <div class="input-area">
                        <textarea name="text" id="textarea"></textarea>
                        <div class="button-area">
                            <button id="send-btn" onclick="send()">发 送</button>
                        </div>
                       
                    </div>
                
            </div>
        </div>
    </div>




    <style>
        * {
            padding: 0;
            margin: 0;
        }

        body {
            height: 100vh;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            height: 760px;
            width: 900px;
            border-radius: 4px;
            border: 0.5px solid #e0e0e0;
            background-color: #f5f5f5;
            display: flex;
            flex-flow: column;
            overflow: hidden;
        }

        .content {
            width: calc(100% - 40px);
            padding: 20px;
            overflow-y: scroll;
            flex: 1;
        }

        .content:hover::-webkit-scrollbar-thumb {
            background: rgba(0, 0, 0, 0.1);
        }

        .bubble {
            max-width: 400px;
            padding: 10px;
            border-radius: 5px;
            position: relative;
            color: #000;
            word-wrap: break-word;
            word-break: normal;
        }

        .item-left .bubble {
            margin-left: 15px;
            background-color: #fff;
        }

        .item-left .bubble:before {
            content: "";
            position: absolute;
            width: 0;
            height: 0;
            border-left: 10px solid transparent;
            border-top: 10px solid transparent;
            border-right: 10px solid #fff;
            border-bottom: 10px solid transparent;
            left: -20px;
        }

        .item-right .bubble {
            margin-right: 15px;
            background-color: #9eea6a;
        }

        .item-right .bubble:before {
            content: "";
            position: absolute;
            width: 0;
            height: 0;
            border-left: 10px solid #9eea6a;
            border-top: 10px solid transparent;
            border-right: 10px solid transparent;
            border-bottom: 10px solid transparent;
            right: -20px;
        }

        .item {
            margin-top: 15px;
            display: flex;
            width: 100%;
        }

        .item.item-right {
            justify-content: flex-end;
        }

        .item.item-center {
            justify-content: center;
        }

        .item.item-center span {
            font-size: 12px;
            padding: 2px 4px;
            color: #fff;
            background-color: #dadada;
            border-radius: 3px;
            -moz-user-select: none;
            /*火狐*/
            -webkit-user-select: none;
            /*webkit浏览器*/
            -ms-user-select: none;
            /*IE10*/
            -khtml-user-select: none;
            /*早期浏览器*/
            user-select: none;
        }

        .avatar img {
            width: 42px;
            height: 42px;
            border-radius: 50%;
        }

        .input-area {
            border-top: 0.5px solid #e0e0e0;
            height: 150px;
            display: flex;
            flex-flow: column;
            background-color: #fff;
        }

        textarea {
            flex: 1;
            padding: 5px;
            font-size: 14px;
            border: none;
            cursor: pointer;
            overflow-y: auto;
            overflow-x: hidden;
            outline: none;
            resize: none;
        }

        .button-area {
            display: flex;
            height: 40px;
            margin-right: 10px;
            line-height: 40px;
            padding: 5px;
            justify-content: flex-end;
        }

        .button-area button {
            width: 80px;
            border: none;
            outline: none;
            border-radius: 4px;
            float: right;
            cursor: pointer;
        }

        /* 设置滚动条的样式 */
        ::-webkit-scrollbar {
            width: 10px;
        }

        /* 滚动槽 */
        ::-webkit-scrollbar-track {
            -webkit-box-shadow: inset006pxrgba(0, 0, 0, 0.3);
            border-radius: 8px;
        }

        /* 滚动条滑块 */
        ::-webkit-scrollbar-thumb {
            border-radius: 10px;
            background: rgba(0, 0, 0, 0);
            -webkit-box-shadow: inset006pxrgba(0, 0, 0, 0.5);
        }
    </style>


    <script type="text/javascript">
    window.οnlοad = send;
    function send() {
            let text = document.querySelector('#textarea').value;
            if (!text) {
                alert('请输入内容');
                return;
            }
            let item = document.createElement('div');
            item.className = 'item item-right';
            item.innerHTML = `<div class="bubble bubble-left">${text}</div><div class="avatar"><img src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3313909130,2406410525&fm=15&gp=0.jpg" /></div>`;
            document.querySelector('.content').appendChild(item);
            document.querySelector('#textarea').value = '';
            document.querySelector('#textarea').focus();
            //滚动条置底
            let height = document.querySelector('.content').scrollHeight;
            document.querySelector(".content").scrollTop = height;
        }

    </script>
    <!-- Jquery Core Js -->
    <script src="static/js/libscripts.bundle.js"></script>
    <!-- JAVASCRIPT -->
    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.bundle.min.js"></script>
    <script src="static/js/metisMenu.min.js"></script>
    <script src="static/js/simplebar.min.js"></script>
    <script src="static/js/waves.min.js"></script>

    <script src="static/js/bundle.js"></script>

    <!-- Summernote js -->
    <script src="static/js/summernote-bs4.min.js"></script>

    <!-- init js -->
    <script src="static/js/summernote.init.js"></script>

    <script src="static/js/app.js"></script>

    <!-- Plugin Js-->
    <script src="static/js/dataTables.bundle.js"></script>

    <!-- Jquery Page Js -->
    <script src="static/js/template.js"></script>
    <script>
        // project data table
        $(document).ready(function () {
            $('#myProjectTable')
                .addClass('nowrap')
                .dataTable({
                    responsive: true,
                    columnDefs: [
                        { targets: [-1, -3], className: 'dt-body-right' }
                    ]
                });
            $('.deleterow').on('click', function () {
                var tablename = $(this).closest('table').DataTable();
                tablename
                    .row($(this)
                        .parents('tr'))
                    .remove()
                    .draw();

            });
        });
    </script>
</body>

</html>