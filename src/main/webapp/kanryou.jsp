<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%
  	String email = (String) session.getAttribute("email");
	String userID  = (String) session.getAttribute("userID");
	String passWord  = (String) session.getAttribute("passWord");
	String sei  = (String) session.getAttribute("sei");
	String mei  = (String) session.getAttribute("mei");
	String seiKata  = (String) session.getAttribute("seiKata");
	String meiKata  = (String) session.getAttribute("meiKata");
%>
<%
  if (email != null 
  && userID != null 
  && passWord != null 
  && sei != null 
  && mei != null 
  && seiKata != null 
  && meiKata != null) {
    out.println("Thông tin đã được lưu vào cơ sở dữ liệu thành công.");
    out.println(email);
    out.println(userID);
    out.println(passWord);
    out.println(sei + "" + mei);
    out.println(seiKata + "" + meiKata);
  } else {
    out.println("Lỗi: Không thể lưu thông tin vào cơ sở dữ liệu.");
    out.println(email);
    out.println(userID);
    out.println(passWord);
    out.println(sei + mei);
    out.println(seiKata + meiKata);
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員登録画面</title>
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
    </div>
                    <!-- <table border="0" cellspacing="0" cellpadding="0" width="600" style="margin: 0 auto;">
                      <tbody>
                        <tr>
                          <td> -->
                            <div style="margin:1em 0 0 0;text-align:center;">
                              <em style="display:block;font-family:meiryo;font-size:20px;line-height:1.2;color:#4a4a4a;font-weight:bold;">楽天カード新規入会＆利用で<span style="font-family:meiryo; color: #bf0000; font-weight: bold; font-style: normal; font-size: 24px;display: inline; background: linear-gradient(transparent 56%, #fdf27b 0%); line-height: 1.6;">5,000ポイント</span>！</em>
                            </div>
                            <div id="contents">
                              <p style="text-align: center;">ご登録いただき、誠にありがとうございます。引き続き楽天のサービスをお楽しみください。</p>
                            </div>
                          <!-- </td>
                        </tr>
                      </tbody>
                    </table> -->
                    <div style="align-items: center;display: flex; justify-content: space-between; margin-top: 26px;">
                      <img src="https://image.card.jp.rakuten-static.com/card_corp/smart/common/panda-card.png" alt="" width="130" style="margin-right: 50px; margin-left: 150px; flex: 1; object-fit: none;">
                      <table border="0" cellspacing="0" cellpadding="0" width="500" style=" font-size: 18px; color: #4a4a4a; flex: 2;">
                        <tbody><tr>
                          <td style="border-top: none;"><span style="color: bf0000; font-family:meiryo; margin-right: 12px;">✔</span>年会費永年無料</td>
                        </tr>
                        <tr>
                          <td style="padding-top: 7px; border-top: none;"><span style="font-family:meiryo; color: bf0000; margin-right: 12px;">✔</span>ポイントがザクザクたまる</td>
                        </tr>
                        <tr>
                          <td style="padding-top: 7px; border-top: none;"><span style="font-family:meiryo; color: bf0000; margin-right: 12px;">✔</span>ポイントはマクドナルドやファミリーマートでも利用可能</td>
                        </tr>
                        <tr>
                          <td style="padding-top: 7px; border-top: none;"><span style="font-family:meiryo; color: bf0000; margin-right: 12px;">✔</span>カードデザインが豊富</td>
                        </tr>
                      </tbody></table>
                    </div>
                    <!-- <table border="0" cellspacing="0" cellpadding="0" width="300" style="margin: 12px auto 0px;">
                      <tbody><tr>
                        <td> -->
                          <!-- <a href="https://ad2.trafficgate.net/t/r/7281/1441/99636_99636/" target="_blank" style="display:block;padding:1em 0;margin:1em 0;background:#bf0000;border:none;border-radius:4px;font-family:meiryo; font-size:16px;color:white;box-shadow:0px 4px 6px -2px gray;font-weight:bold;text-align:center;text-decoration:none;" class="bt_main">楽天カードを今すぐチェック</a> -->
                        <!-- </td>
                      </tr>
                    </tbody></table> -->
                    
                    <div><hr size="1" style="display:block;">
                       <p style="text-align: center;"> © Rakuten Group, Inc.</p></div>   
</body>
</html>