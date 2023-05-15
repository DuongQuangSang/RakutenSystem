<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%
String email = request.getParameter("email");
String userID  = request.getParameter("userID");
String passWord  = request.getParameter("passWord");
String sei  = request.getParameter("sei");
String mei  = request.getParameter("mei");
String seiKata  = request.getParameter("seiKata");
String meiKata  = request.getParameter("meiKata");
session.setAttribute("email", email);
session.setAttribute("userID", userID);
session.setAttribute("passWord", passWord);
session.setAttribute("sei", sei);
session.setAttribute("mei", mei);
session.setAttribute("seiKata", seiKata);
session.setAttribute("meiKata", meiKata);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員確認画面</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class="header-right">
            <img src="./images/Rakuten_pc_32px@2x_wm.png" alt="logo">
        </div>
        <div class="header-left">
            <ul>
                <li><a href="https://www.rakuten.co.jp/">楽天市場</a></li>
                <li><a href="https://ichiba.faq.rakuten.net/">ヘルプ</a></li>
            </ul>
        </div>
    </header>
    <div id="container">
        <div id="language">
            <a href="">日本語|</a>
            <a href="">English|</a>
            <a href="">简体中文</a>
        </div>
        <div id="contents">
            <h2>楽天会員登録</h2>
            <form name="RegistForm" action="kakunin" method="post">
                <div id="step2" class="step">
                    <ul>
                        <li style="color: #BF0000;">会員情報の入力</li>
                        <li style="color: white;">入力内容の確認</li>
                        <li style="color: #BF0000;">登録完了</li>
                    </ul>
                </div>
                <h3 class="circle">メールアドレス/ユーザーID/パスワード</h3>
                <table class="address">
                    <tbody>
                        <tr>
                            <th class="yel head">メールアドレス
                                <td>
                                    <em id="emailShow"><%= request.getAttribute("email") %>
                                    </em>
                                </td>
                                <td class="end"><a href=""></a></td>
                            </th>
                        </tr>

                        <tr>
                            <th class="yel head">ユーザID
                                <td>
                                    <em id="userIdShow"><br>
                                        <%= request.getAttribute("userID") %>
                                    </em>
                                </td>
                                <td class="end"><a href=""></a></td>
                            </th>
                        </tr>

                        <tr>
                            <th class="yel head">パスワード
                                <td>
                                    <em>セキュリティ保護のため、表示していません。
                                    </em>
                                </td>
                                <td class="end"><a href=""></a></td>
                            </th>
                        </tr>
                    </tbody>             
                </table>
                <h3 class="circle">お客様の基本情報</h3>
                <table class="address">
                    <tbody>
                        <tr>
                            <th class="yel head">氏名
                                <td>
                                    <em id="seiMei"><%= request.getAttribute("sei") + " " + request.getAttribute("mei")%>
                                    </em>
                                </td>
                                <td class="end"><a href=""></a></td>
                            </th>
                        </tr>

                        <tr>
                            <th class="yel head">氏名（フリガナ）
                                <td>
                                    <em id="seiMeiKata"><%= request.getAttribute("seiKata") + " " + request.getAttribute("meiKata")%>
                                    </em>
                                </td>
                                <td class="end"><a href=""></a></td>
                            </th>
                        </tr>
                    </tbody>             
                </table>
                <p>
                    <input type="submit" name="execMethod" value="<<入力画面に戻って変更する">
                </p>
                <div class="tbl">
                    <p><img src="./images/icn_mail.gif" alt=""> <b>楽天会員ニュース（週1回～2回配信）</b><br>
                        楽天会員ニュースは、楽天グループのキャンペーンやイベント情報などをご案内するメールマガジンです。<span style="color: #bf0000;"><b>楽天会員情報にご登録されたメールアドレス宛</b></span> に楽天グループ株式会社よりお送りいたします。<br>
                        <br>
                        ※「購読する」をチェック頂いた方には、ご自身のポイント獲得状況が確認できる「ポイント獲得実績のお知らせ」もお届けします。<br>
                        ※楽天会員ニュース・ポイント獲得実績のお知らせは購読管理ページからいつでも配信停止/再開できます。<br>
                        <br>
                        購読を希望されない場合は<span style="color: #bf0000;"><b>「購読する」のチェックを外してください。</b></span></p>
                        <input type="checkbox" checked><b> 購読する</b>
                </div>
                <p class="sub">
                    上記の情報に間違いがなければ、「登録する」ボタンを押して、登録を完了してください。<br>
    「入力画面に戻って変更する」ボタンを押すと、入力画面に戻ります。<br>
                    </p>
                    <p class="submit">
                        <input type="submit" name="execMethod" value="登録する">  <!-- <onclick="kanryouFunc()" -->
                    </p>
                <p style="text-align: center;">
                    <a href="https://privacy.rakuten.co.jp/" target="_blank">個人情報保護方針</a>
                </p>
            </form>
            
        </div>
    </div>
    <div><hr size="1" style="display:block;">
       <p style="text-align: center;"> © Rakuten Group, Inc.</p>
    </div>
    <script src="js/script.js"></script>
</body>
</html>