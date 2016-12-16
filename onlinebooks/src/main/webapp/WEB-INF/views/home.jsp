<%@include file="header.jsp" %>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 30%;
      margin: auto;
  }
  </style>
  <style>
body{background: url('resources/images/bg1.jpg') no-repeat center center fixed;
     background-size: cover;
}
</style>

</head>
<body>
welcome ${info}
         <!-- <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li> -->
       
 <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/Book.jpg" alt="book" width="1500" height="500">
      </div>
      
      <div class="item">
        <img src="resources/images/book1.jpg" alt="book1" width="1500" height="500">
      </div>
    
      <div class="item">
        <img src="resources/images/book3.jpg" alt="book3" width="1500" height="500">
      </div>
    
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<br>
<br>


<tr><td><a href="comic.jpg"><img src="resources/images/comic.jpg" width="400" height="200"></a>
</td>

<td><a href="ent1.jpg"><img src="resources/images/ent1.jpg" width="500" height="200"></a>
</td>

<td><a href="bio.jpg"><img src="resources/images/bio.jpg" width="400" height="200"></a>
</td></tr>

</body>

</html>

