<%@ page contentType="text/html; charset=iso-8859-1" language="java"  import="java.util.*,  java.text.SimpleDateFormat, parseVocabs.*"%>

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
      
		<%
		
		ProcessVocabs processVocabs = new ProcessVocabs();
		ArrayList<Vocabulary> vocabularies = processVocabs.getVocabularies();
		
		for (int i = 0; i < vocabularies.size() ; i++){
			//print 1 row for each 3 vocabs
			
			Vocabulary currentVocab = vocabularies.get(i);
			
			if (i % 3 == 0){ //if it is th first vocabulary of the row open it
				out.println("<div class=\"row\">");
			}
			
			//print the vocabulary at any case
			%>
			<div class="span4">
	          <h2><a href="<%out.print(currentVocab.uri); %>" target="_blank"><%out.print(currentVocab.title); %></a></h2>
	          <p><% if (currentVocab.description == null) {
	        	  		out.print("Can't believe you didn't include a dcterms:description or dcelements:description");
					}
			        else{
			        	String desc = currentVocab.description;
			        	if (desc.length() > 360){
			        		int nextSpace = desc.indexOf(" ", 360);
			        		desc = currentVocab.description.substring(0, nextSpace) + "...";
			        	}
			        	out.print(desc);
			        }
	          
	          		if (currentVocab.isInLOV) {
	          			out.println("</p>");
	          			out.println("<p>");
      	  				out.print("See the <a href = \"" + currentVocab.webpageInLOV + "\" target=\"_blank\"> LOV page for this vocab (" + currentVocab.prefixInLOV + ")</a>.");
					}
	          		 %></p>
	         <!--  <p> if (currentVocab.cnRDF && currentVocab.cnHTML){
	        	  		String rdfURI = currentVocab.uriVapourRDF;
	        	  		String htmlURI = currentVocab.uriVapourHTML;
	        	  		out.print("Best practices for content negotiation implemented for <strong>RDF</strong> and <strong>HTML</strong> formats.");
	        	  		//out.print("Content negotiation enabled for <a href = \"" + rdfURI + "\" target=\"_blank\"><strong>RDF</strong></a> and <a href = \"" + htmlURI + "\" target=\"_blank\"><strong>HTML</strong></a> formats.");
	          		}
	          		else if (currentVocab.cnRDF && !currentVocab.cnHTML){
	          			String rdfURI = currentVocab.uriVapourRDF;
	          			out.print("Best practices for content negotiation implemented for <strong>RDF</strong> format.");
	          			//out.print("Content negotiation enabled for <a href = \"" + rdfURI + "\" target=\"_blank\"><strong>RDF</strong></a> format.");
	          		}
					else if (!currentVocab.cnRDF && currentVocab.cnHTML){
						String htmlURI = currentVocab.uriVapourHTML;
						out.print("Best practices for content negotiation implemented for <strong>RDF</strong> format.");
						//out.print("Content negotiation enabled for <a href = \"" + htmlURI + "\" target=\"_blank\"><strong>RDF</strong></a> format.");
	          		}
					else {}
	          		%></p>
	          <p><a class="btn" href="out.print(currentVocab.uri); %>">Query vocab &raquo;</a></p> -->
	        </div>
			<%
			
			if ((i % 3 == 2) || ( i == vocabularies.size()-1)){ //if it is the third or last vocabulary close the row
				out.println("</div>");
			}
 		}
		
		%>
 
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
	        Built with <a target="_blank" href="http://getbootstrap.com/">Bootstrap</a>
	        <br>
	        <% Date d = new java.util.Date(Calendar.getInstance().getTimeInMillis());%>
	        Latest revision <% out.print(new SimpleDateFormat("MMMM").format(d)); %> <%out.print(new GregorianCalendar().get(Calendar.YEAR)); %>
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
