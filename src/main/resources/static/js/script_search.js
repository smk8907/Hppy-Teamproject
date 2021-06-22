function filter() {

    var search = document.getElementById('category').value;

    var link = ""; // 페이지 링크 주소 넣을 공간

    if(search.indexOf("축구") != -1){
        link = "1";

    }else if(search.indexOf("야구") != -1){
        link = "2";

    }else if(search.indexOf("농구") != -1){
        link = "3";

    }else if(search.indexOf("배구") != -1){
        link = "4";

    }else if(search.indexOf("배드민턴") != -1){
        link = "5";

    }else if(search.indexOf("탁구") != -1){
        link = "6";

    }else if(search.indexOf("골프") != -1){
        link = "7";

    }else if(search.indexOf("테니스") != -1){
        link = "8";

    }else if(search.indexOf("스쿼시") != -1){
        link = "9";

    }else if(search.indexOf("볼링") != -1){
        link = "10";

    }else if(search.indexOf("유도") != -1){
        link = "11";

    }else if(search.indexOf("MMA") != -1){
        link = "12";

    }else if(search.indexOf("주짓수") != -1){
        link = "13";

    }else if(search.indexOf("복싱") != -1){
        link = "14";

    }else if(search.indexOf("무에타이") != -1){
        link = "15";

    }else if(search.indexOf("킥복싱") != -1){
        link = "16";

    }else if(search.indexOf("레슬링") != -1){
        link = "17";

    }else if(search.indexOf("러닝") != -1){
        link = "18";

    }else if(search.indexOf("등산") != -1){
        link = "19";

    }else if(search.indexOf("필라테스") != -1){
        link = "20";

    }else if(search.indexOf("요가") != -1){
        link = "21";

    }else if(search.indexOf("사이클") != -1){
        link = "22";

    }else if(search.indexOf("승마") != -1){
        link = "23";

    }else if(search.indexOf("서핑") != -1){
        link = "24";

    }else if(search.indexOf("페러글라이딩") != -1){
        link = "25";

    }else if(search.indexOf("다이빙") != -1){
        link = "26";

    }else if(search.indexOf("클라이밍") != -1){
        link = "27";

    }else if(search.indexOf("스케이트보드") != -1){
        link = "28";

    }else if(search.indexOf("스키") != -1){
        link = "29";

    }else if(search.indexOf("사격") != -1){
        link = "30";

    }else if(search.indexOf("낚시") != -1){
        link = "31";

    }else if(search.indexOf("캠핑") != -1){
        link = "32";

    }else if(search.indexOf("향수") != -1){
        link = "33";

    }else if(search.indexOf("비누") != -1){
        link = "34";

    }else if(search.indexOf("악세사리") != -1){
        link = "35";

    }else if(search.indexOf("목공") != -1){
        link = "36";

    }else if(search.indexOf("자수") != -1){
        link = "37";

    }else if(search.indexOf("가죽") != -1){
        link = "38";

    }else if(search.indexOf("유리") != -1){
        link = "39";

    }else if(search.indexOf("쥬얼리") != -1){
        link = "40";

    }else if(search.indexOf("프라모델") != -1){
        link = "41";

    }else if(search.indexOf("레진") != -1){
        link = "42";

    }else if(search.indexOf("레고") != -1){
        link = "43";

    }else if(search.indexOf("악기") != -1){
        link = "44";

    }else if(search.indexOf("작곡") != -1){
        link = "45";

    }else if(search.indexOf("디제잉") != -1){
        link = "46";

    }else if(search.indexOf("드로잉") != -1){
        link = "47";

    }else if(search.indexOf("사진") != -1){
        link = "48";

    }else if(search.indexOf("요리") != -1){
        link = "49";

    }else if(search.indexOf("홈카페") != -1){
        link = "50";

    }else if(search.indexOf("바리스타") != -1){
        link = "50";

    }else if(search.indexOf("베이킹") != -1){
        link = "51";
    }

    if(link == ""){
        alert("존재하지 않는 종목입니다.")
        return true;

    }else{
            document.categorysearch.target = "_self"; //링크 위치
            document.categorysearch.action = "/category/" + link; //링크 주소
            document.categorysearch.submit(); //링크 호출 (from) 실행
    }
}
