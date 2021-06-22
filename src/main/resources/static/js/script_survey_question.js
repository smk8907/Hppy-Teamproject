
  function btn() {
    var value = 0;
    for(var i = 1; i< 10; i++) {
      var radio_value = document.getElementsByName("q"+[i]).length;
      for(var j = 0 ; j<radio_value; j++) {
        if(document.getElementsByName("q"+[i])[j].checked == true) {
          value = value + Number(document.getElementsByName("q"+[i])[j].value);
        }
      }
    }
    console.log(value);

  }
