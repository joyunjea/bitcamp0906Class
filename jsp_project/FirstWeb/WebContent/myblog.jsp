<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>yj Blog</title>
    <link rel="stylesheet" href="css/blog.css" />
    <style>
    /* 웹폰트 */
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR&display=swap');
*{
    margin: 0;
    padding: 0;
    /* 다른브라우저를 가도 똑같이 볼 수 있도록 지정 */
    font-family: 'Noto Sans KR', sans-serif;
    


}
body{
    background-color: #eee;
}
.font_gray{
    color: #666;
}
.margin_tb_5{
    margin-top: 5px;
    margin-bottom: 5px;
}

.lineheight_180per{
    line-height: 180%;
}
/* 타이틀 폰트 */
.title_font{
    font-family: 'Jua', sans-serif;
}
/* main_wrap 설정 */
#main_wrap{
    background-color: white;

    width: 778px;
    /* height: 300px; */

    padding: 10px;

    border: 1px solid #ccc;
    border-radius: 5px;

    margin: 10px auto;

    box-shadow: 3px 3px 10px #ccc;
}
/* header 설정 */
header{
    padding: 30px;
}
/* 네비게이{션 설정 */
nav{
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;

    overflow: hidden;
}
nav>ul{
    float: left;
    list-style: none;
}
nav>ul>li{
    float: left;
    padding: 5px 15px;
}
nav>div{
    float: right;
}
/* 검색 영역 */
nav input{
    border: 1px solid #ccc;
    padding: 3px 20px;

    margin-top: 3px;
} 

nav input[type=text]{
    width: 100px;
    border-radius: 20px 0 0 20px;
}
nav input[type=button]{
    border-radius: 0 20px 20px 0;

    margin-left: -1px;
    margin-right: 5px;
}
/* Contents 영역 설정121212123131231231321231231231231231123 */
#contents_wrap{
    overflow: hidden;
}
#contents_wrap>section{
    width: 600px;
    float: left;
}
#contents_wrap>aside{
    width: 170px;
    float: right;
}
#contents_wrap>section>article{
    padding: 25px;

    border-bottom: 1px solid #ccc;

}

#contents_wrap>section>article>img{
    width: 200px;
}

/* aside 영역 설정 */
/* #contents_wrap>aside>{
    padding-top: 30px;
} */
#contents_wrap>aside>h3{
    margin-top: 30px;
}
#contents_wrap>aside>ul>li{
    list-style: none;
    padding-left: 10px;
}
/* footer 설정 */
footer{
    height: 30px;
    text-align: center;
    line-height: 30px;
}
    </style>
  </head>
  <body>
    <!--전체 리스트를 감싸는 블록,가운데정렬, 보더, 쉐도우
    -->
    <div id="main_wrap">
      <!-- header 시작-->
      <header>
              <%@ include file="myblog/header.jsp" %>

      </header>
      <!--header종료-->
      <!-- 네비게이션 시작-->
           <%@ include file="myblog/nav.jsp" %>
     
      <!-- 네비게이션 종료-->

      <!-- Contents 영역 시작-->
      <div id="contents_wrap">
        <!-- 게시물 영역 시작-->
        <section>
          <article>
            <h3 class="title_font margin_tb_5">
              '스파이더맨: 노 웨이 홈' MCU 페이즈4 핵심 멀티버스 세계관 다룬다
            </h3>
            <div class="margin_tb_5">기사입력 2021-11-19 08:36:03</div>
            <img src="blog/img/스파이더맨.jpg" class="margin_tb_5" />
            <p class="margin_tb_5">
              '스파이더맨: 노 웨이 홈'이 본격적으로 다룰 멀티버스는 다른 차원의
              우주를 의미하며, 서로 중첩될 일이 없는 세계관을 말한다멀티버스는
              '닥터 스트레인지' '스파이더맨: 파 프롬 홈' 등에서는 잠깐
              언급됐으나 이를 중점적으로 다루는 영화는 '스파이더맨: 노 웨이
              홈'이 처음이라는 점에서 관심을 모으고 있다.
            </p>
          </article>

          <article>
            <h3 class="title_font margin_tb_5">
              '스파이더맨: 노 웨이 홈' MCU 페이즈4 핵심 멀티버스 세계관 다룬다
            </h3>
            <div class="margin_tb_5">기사입력 2021-11-19 08:36:03</div>
            <img src="blog/img/스파이더맨.jpg" class="margin_tb_5" />
            <p class="margin_tb_5">
              '스파이더맨: 노 웨이 홈'이 본격적으로 다룰 멀티버스는 다른 차원의
              우주를 의미하며, 서로 중첩될 일이 없는 세계관을 말한다멀티버스는
              '닥터 스트레인지' '스파이더맨: 파 프롬 홈' 등에서는 잠깐
              언급됐으나 이를 중점적으로 다루는 영화는 '스파이더맨: 노 웨이
              홈'이 처음이라는 점에서 관심을 모으고 있다.
            </p>
          </article>
        </section>
        <!-- 게시물 종료-->
        <!-- aside 시작-->
            <%@ include file="myblog/aside.jsp" %>
      
        <!-- aside 종료-->
      </div>
      <!-- Contents 영역 종료-->
      <!-- footer 시작-->
      <%@ include file="myblog/footer.jsp" %>
      
      <!-- footer 종료-->
    </div>
  </body>
</html>
