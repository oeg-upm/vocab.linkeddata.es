<%@ page contentType="text/html; charset=iso-8859-1" language="java"  import="java.util.*, parseVocabs.*"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>vocab.linkeddata.es</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <script src="assets/js/jquery.js"></script>

    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72pcomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="assets/ico/favicon.png">
  </head>

  <body>

    <div class="container">

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>vocab.linkeddata.es</h1>
        <p class="lead">Here you can find the list of vocabularies that the <a href = "http://www.oeg-upm.net" target="_blank">Ontology Engineering Group (OEG)</a> is developing and publishing on the Web.</p>
      </div>

      <hr>
      
<div class="accordion" id="accordion2">

The Linked Data Rights ontology provides the vocabulary for creating rights expressions for Linked Data resources.
 Linked Data assets (RDF triples, graphs, datasets, mappings...) can be object of protection by the intellectual 
 property law, the database law or its access or publication be restricted by other legal reasons (personal data 
 pro- tection, security reasons, etc.). Publishing a rights expression along with the digital asset, allows the 
 rightsholder waiving some or all of the IP and database rights (leaving the work in the public domain), 
 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">See more...</a>

<div id="collapseOne" class="accordion-body collapse">
permitting some operations if certain conditions are satisfied (like giving attribution to the author) or simply 
reminding the audience that some rights are reserved.
</div>

</div>
 
      <hr>

      <footer>
      
      <div class="row">
    	<div class="span10">
    		Team: 
	        <a href = "http://delicias.dia.fi.upm.es/members/dgarijo/" target="_blank">Daniel Garijo</a> -
	        <a href = "http://delicias.dia.fi.upm.es/members/mpoveda/" target="_blank">María Poveda</a> -
	        <a href = "http://delicias.dia.fi.upm.es/members/isantana/" target="_blank">Idafen Santana</a>
	        <br>
	        Contact email: vocab(at)listas.fi.upm.es
	        <br>
	        Latest revision October 2013
        </div>
    	<div class="span2">
    		<a href="http://www.oeg-upm.net/" target="_blank"><img src="images/logoOEG.png" alt="OEG logo" /></a>
    	</div>
      </div>

      </footer>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/bootstrap-transition.js"></script>
    <script src="assets/js/bootstrap-alert.js"></script>
    <script src="assets/js/bootstrap-modal.js"></script>
    <script src="assets/js/bootstrap-dropdown.js"></script>
    <script src="assets/js/bootstrap-scrollspy.js"></script>
    <script src="assets/js/bootstrap-tab.js"></script>
    <script src="assets/js/bootstrap-tooltip.js"></script>
    <script src="assets/js/bootstrap-popover.js"></script>
    <script src="assets/js/bootstrap-button.js"></script>
    <script src="assets/js/bootstrap-collapse.js"></script>
    <script src="assets/js/bootstrap-carousel.js"></script>
    <script src="assets/js/bootstrap-typeahead.js"></script>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-44835745-1', 'linkeddata.es');
  ga('send', 'pageview');

</script>

  </body>
</html>
