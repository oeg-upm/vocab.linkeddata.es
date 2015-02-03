package es.upm.oeg.smartcity;

public class HTMLblocksOntos {
	
	public static final String header = "<!DOCTYPE html>\n" + 
			"<html lang=\"en\">\n" + 
			"  <head>\n" + 
			"    <meta charset=\"UTF-8\">\n" + 
			"    <title>smartcity.linkeddata.es</title>\n" + 
			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
			"    <meta name=\"description\" content=\"This web provides a catalogue of ontologies useful for smart city data.\">\n" + 
			"    <meta name=\"Languaje\" content=\"English\">\n" + 
			"    <meta name=\"Keywords\" content=\"ontology, smart city, energy efficiency\">\n" + 
			"    <meta name=\"author\" content=\"Mar�a Poveda Villal�n\">\n" + 
			"    \n" + 
			"    <script src=\"dist/js/jquery.js\"></script>\n" + 
			"    <link rel=\"stylesheet\" href=\"themes/blue/style.css\" type=\"text/css\" media=\"print, projection, screen\" />\n" +
		    "    <script src=\"dist/js/jquery-1.11.0.js\"></script>\n" +
			"    <script type=\"text/javascript\" src=\"dist/js/jquery.tablesorter.min.js\"></script>\n" +
			"    <script type=\"text/javascript\" src=\"dist/js/jquery.stickytableheaders.js\"></script>\n" +
			"    <script type=\"text/javascript\" src=\"dist/js/jquery-ui.js\"></script>\n" +
			"    <link rel=\"stylesheet\" href=\"dist/css/jquery-ui.css\"></link>\n" +
			"    <script type=\"text/javascript\" id=\"js\">\n" +
			"	    $(document).ready(function() \n" +
			"		    { \n" +
			"		    	$(\"#tablesorter-demo\").tablesorter(); \n" +
			"		    	$(\"#tablesorter-demo\").stickyTableHeaders(); \n" +
			"		    } \n" +
			"	    ); \n" +
			"    </script>\n" +
			"\n" + 
			"    <!-- Le styles -->\n" + 
			"    <link href=\"dist/css/bootstrap.css\" rel=\"stylesheet\">\n" + 
			"    <style type=\"text/css\">\n" + 
			"      body {\n" + 
			"        padding-top: 60px;\n" + 
			"        padding-bottom: 40px;\n" + 
			"      }\n" + 
			"    </style>\n" + 
			"    <link href=\"dist/css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" + 
			"    \n" + 
			"    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n" + 
			"    <!--[if lt IE 9]>\n" + 
			"      <script src=\"../dist/js/html5shiv.js\"></script>\n" + 
			"    <![endif]-->\n" + 
			"\n" + 
			"    <!-- Fav and touch icons -->\n" + 
			"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"dist/ico/apple-touch-icon-144-precomposed.png\">\n" + 
			"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"dist/ico/apple-touch-icon-114-precomposed.png\">\n" + 
			"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"dist/ico/apple-touch-icon-72pcomposed.png\">\n" + 
			"    <link rel=\"apple-touch-icon-precomposed\" href=\"dist/ico/apple-touch-icon-57-precomposed.png\">\n" + 
			"    <link rel=\"shortcut icon\" href=\"dist/ico/favicon.png\">\n" + 
			"  </head>\n" + 
			"\n" + 
			"  <body>\n" + 
			"\n" + 
			
		    "<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n" + 
		    "  <div class=\"container\">\n" + 
		    "    <div class=\"navbar-header\">\n" + 
		    "      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" + 
		    "        <span class=\"sr-only\">Toggle navigation</span>\n" + 
		    "        <span class=\"icon-bar\"></span>\n" + 
		    "        <span class=\"icon-bar\"></span>\n" + 
		    "        <span class=\"icon-bar\"></span>\n" + 
		    "      </button>\n" + 
		    "    </div>\n" + 
		    "    <div class=\"collapse navbar-collapse\">\n" + 
		    "      <ul class=\"nav navbar-nav\">\n" + 
		    "        <li class=\"active\"><a href=\"#\">Ontologies</a></li>\n" + 
		    "        <li><a href=\"./datasets/index.html\">Datasets</a></li>\n" + 
		    "        <li><a href=\"./about.html\">About</a></li>\n" + 
		    "      </ul>\n" + 
		    "    </div><!--/.nav-collapse -->\n" + 
		    "  </div>\n" + 
		   " </div>\n" + 
		    
			"    <div class=\"container\">\n" + 
			"\n" + 
			"      <!-- Jumbotron -->\n" + 
			"      <div class=\"jumbotron\">\n" + 
			"        <h1>smartcity.linkeddata.es</h1>\n" + 
			"        <p class=\"lead\">On the Semantic Web, ontologies define the concepts and relationships used to describe " +
			"a given domain and annotate data about it. In the <a href = \"http://www.ready4smartcities.eu/\" target=\"_blank\">READY4SmartCities FP7 CSA </a> " +
			"we are collecting ontologies about smart cities, energy and other related fields. Here you can find the list of " +
			"ontologies we have identified so far. You can also propose ontologies to be included in the catalogue, either " +
			"<a href = \"https://docs.google.com/forms/d/1kTrNUKRnAlN5bBnOwTzQjWwQLinKFQcW4EqXDOYbFsQ/viewform\" target=\"_blank\">through a detailed form</a> " +
			"if you have more time to fill the required data or " +
			"<a href = \"http://survey.ready4smartcities.eu/index.php/638667/\" target=\"_blank\">through a very short form.</a></p>\n" +
			"      </div>\n" + 
			"\n" + 
			"      <hr>\n";
	
	public static final String colorCode = "<p>Along the catalogue the following color code is used to represent different information. Furthermore, in addition to the color, each cell contains detailed information when available.</p>\n" + 
			"<ul class=\"list-inline\">\n" + 
			"	<li><span class=\"label label-success\">Green for positive indicators</span></li>\n" + 
			"	<li><span class=\"label label-warning\">Orange for intermediate indicators</span></li>\n" + 
			"	<li><span class=\"label label-danger\">Red for negative indicators</span></li>\n" + 
			"	<li><span class=\"label label-primary\">Blue for plain information</span></li>\n" + 
			"	<li><span class=\"label label-default\">Grey for unknown fields</span></li>\n" + 
			"</ul>\n" +
			"<p>The first columnn of indicators shows whether the ontology is available online in " +
			"<a href=\"http://www.w3.org/TR/rdf11-primer/\" target=\"_blank\">RDF</a> and " +
			"<a href=\"http://www.w3.org/html/\" target=\"_blank\">HTML</a> formats. For each format, RDF or HTML, " +
			"we use the following colors and text tags: <span class=\"label label-success\">CN OK</span> " +
			"(for &ldquo;Content Negotiation OK&rdquo;) if the corresponding content can be retrieved in the given format " +
			"according to <a href=\"http://www.w3.org/TR/swbp-vocab-pub/\" target=\"_blank\">content negotiation best " +
			"practices for publishing RDF vocabularies</a>, <span class=\"label label-warning\">NO CN</span> " +
			"(for &ldquo;NO Content Negotiation&rdquo;) if the content can be retrieved even though no content negotiation " +
			"mechanisms are properly set up, and <span class=\"label label-danger\">Not Av</span> (for &ldquo;Not Available&rdquo;) " +
			"if the content can not be retrieved.</p>";
	
	public static final String end = "<hr>\n" +
			"" +
			"      <footer>\n" +
			"      " +
			"      <div class=\"row\">\n" +
			"    	<div class=\"col-md-7\">\n" +
			"    		Developed by " +
			"	        <a href = \"http://oeg-upm.net\" target=\"_blank\">Ontology Engineering Group</a>\n" +
//			"	        <br>\n" +
//			"	        Contact email: mpoveda(at)fi.upm.es\n" +
			"	        <br>\n" +
			"    	Built with <a target=\"_blank\" href=\"http://getbootstrap.com/\">Bootstrap</a>\n" +
			"    	Icons from <a target=\"_blank\" href=\"http://glyphicons.com/\">Glyphicons</a>\n " +			
			"	        <br>\n" +
			"	        Latest revision June 2014\n" +
			"        </div>\n" +			
			"    	<div class=\"col-md-5\">\n" +
			"		<p class=\"text-center\"> Supported by: </p>\n" +
			"		<p class=\"text-right\">\n" +
			"    		<a href=\"http://www.ready4smartcities.eu\" target=\"_blank\"><img src=\"images/logoReadySmall.jpg\" alt=\"Ready4SmartCities logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>\n " +
			"    		<a href=\"http://www.oeg-upm.net/\" target=\"_blank\"><img src=\"images/logoOEG.png\" alt=\"OEG logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>\n" +
			"    	</p>\n" +
			"    	</div>\n" +
			"      </div>\n" +
			"" +
			"      </footer>\n" +
			"" +
			"    </div> <!-- /container -->\n" +
			"" +
			"    <!-- Le javascript\n" +
			"    ================================================== -->\n" +
			"    <!-- Placed at the end of the document so the pages load faster -->\n" +
			"    <script src=\"assets/js/bootstrap-transition.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-alert.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-modal.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-dropdown.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-scrollspy.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-tab.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-tooltip.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-popover.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-button.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-collapse.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-carousel.js\"></script>\n" +
			"    <script src=\"assets/js/bootstrap-typeahead.js\"></script>\n" +
			"" +
			"<script>\n" +
			"(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){ (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
			"m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
			"})(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" +
			"ga('create', 'UA-48904250-1', 'linkeddata.es');\n" +
			"ga('send', 'pageview');\n" +
			"</script>\n" +
			"" +
			"  </body>\n" +
			"</html>\n";

}
