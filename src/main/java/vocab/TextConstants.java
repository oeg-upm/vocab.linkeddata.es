/*
 * Copyright 2012-2013 Ontology Engineering Group, Universidad Politecnica de Madrid, Spain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package vocab;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Class for defining the constants
 * @author mpoveda, dgarijo
 */
public class TextConstants {
    
    public static final String header = "<!DOCTYPE html>\n" + 
			"<html lang=\"en\">\n" + 
			"  <head>\n" + 
			"    <meta charset=\"UTF-8\">\n" + 
			"    <title>vocab.linkeddata.es</title>\n" + 
			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
			"    <meta name=\"description\" content=\"This web provides a catalogue of ontologies useful for smart city data.\">\n" + 
			"    <meta name=\"languaje\" content=\"English\">\n" + 
			"    <meta name=\"keywords\" content=\"ontology, smart city, energy efficiency\">\n" + 
			"    <meta name=\"author\" content=\"Maria Poveda Villalon\">\n" + 
			"    \n" + 
			"    <script src=\"dist/js/jquery.js\"></script>\n" + 
			"    <link rel=\"stylesheet\" href=\"dist/themes/blue/style.css\" type=\"text/css\" media=\"print, projection, screen\" />\n" +
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
			"      <script src=\"dist/js/html5shiv.js\"></script>\n" + 
			"    <![endif]-->\n" + 
			"\n" + 
			"    <!-- Fav and touch icons -->\n" + 
//			"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"dist/ico/apple-touch-icon-144-precomposed.png\">\n" + 
//			"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"dist/ico/apple-touch-icon-114-precomposed.png\">\n" + 
//			"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"dist/ico/apple-touch-icon-72pcomposed.png\">\n" + 
//			"    <link rel=\"apple-touch-icon-precomposed\" href=\"dist/ico/apple-touch-icon-57-precomposed.png\">\n" + 
//			"    <link rel=\"shortcut icon\" href=\"dist/ico/favicon.png\">\n" + 
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
		    "        <li><a href=\"http://rohub.linkeddata.es\">Research Objects</a></li>\n" + 
		    "        <li><a href=\"./about.html\">About</a></li>\n" + 
		    "      </ul>\n" + 
		    "    </div><!--/.nav-collapse -->\n" + 
		    "  </div>\n" + 
		   " </div>\n" + 
		    
			"    <div class=\"container\">\n" + 
			"\n" + 
			"      <!-- Jumbotron -->\n" + 
			"      <div class=\"jumbotron\">\n" + 
			"        <h1>vocab.linkeddata.es</h1>\n" + 
			"        <p class=\"lead\">Here you can find the list of vocabularies that "
            + "the <a href=\"http://www.oeg-upm.net\">Ontology Engineering Group (OEG)</a> is "
            + "developing and publishing on the Web.</a></p>\n" +
			"      </div>\n" + 
			"      <hr>\n";
	
    public static final String colorCode = 
            "<p>Along the catalogue the following color code is used to represent different information. Furthermore, in addition to the color, each cell contains detailed information when available.</p>\n" + 
                    "<ul class=\"list-inline\">\n" + 
                    "	<li><span class=\"label label-success\">Green for open licenses</span></li>\n" + 
                    "	<li><span class=\"label label-warning\">Orange non-open</span></li>\n" + 
                    //"	<li><span class=\"label label-danger\">Red for negative indicators</span></li>\n" + 
                    "	<li><span class=\"label label-primary\">Blue for plain information</span></li>\n" + 
                    "	<li><span class=\"label label-default\">Grey for undefined fields</span></li>\n" + 
                    "</ul>\n";
//                    "<p>The first columnn of indicators shows whether the ontology is available online in " +
//                    "<a href=\"http://www.w3.org/TR/rdf11-primer/\" target=\"_blank\">RDF</a> and " +
//                    "<a href=\"http://www.w3.org/html/\" target=\"_blank\">HTML</a> formats. For each format, RDF or HTML, " +
//                    "we use the following colors and text tags: <span class=\"label label-success\">CN OK</span> " +
//                    "(for &ldquo;Content Negotiation OK&rdquo;) if the corresponding content can be retrieved in the given format " +
//                    "according to <a href=\"http://www.w3.org/TR/swbp-vocab-pub/\" target=\"_blank\">content negotiation best " +
//                    "practices for publishing RDF vocabularies</a>, <span class=\"label label-warning\">NO CN</span> " +
//                    "(for &ldquo;NO Content Negotiation&rdquo;) if the content can be retrieved even though no content negotiation " +
//                    "mechanisms are properly set up, and <span class=\"label label-danger\">Not Av</span> (for &ldquo;Not Available&rdquo;) " +
//                    "if the content can not be retrieved.</p>";

    public static final String end = "<hr>\n" +
                    "" +
                    "      <footer class=\"footer\">\n" +
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
                    "	        Latest revision "+(new SimpleDateFormat("MMMM", Locale.UK).format(new Date(Calendar.getInstance().getTimeInMillis())))+", "+new GregorianCalendar().get(Calendar.YEAR)+"\n" +
                    "           <br><p>&copy; Ontology Engineering Group</p>\n"+           
                    "        </div>\n" +			
                    "    	<div class=\"col-md-5\">\n" +
                    "    		<a href=\"http://www.oeg-upm.net/\" target=\"_blank\"><img src=\"http://smartcity.linkeddata.es/images/logoOEG.png\" alt=\"OEG logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>\n" +
                    "    	</div>\n" +
                    "      </div>\n" +
                    "" +
                    "      </footer>\n" +
                    "" +
                    "    </div> <!-- /container -->\n" +
//                    "    <!-- Le javascript\n" +
//                    "    ================================================== -->\n" +
//                    "    <!-- Placed at the end of the document so the pages load faster -->\n" +
//                    "    <script src=\"assets/js/bootstrap-transition.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-alert.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-modal.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-dropdown.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-scrollspy.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-tab.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-tooltip.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-popover.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-button.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-collapse.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-carousel.js\"></script>\n" +
//                    "    <script src=\"assets/js/bootstrap-typeahead.js\"></script>\n" +
                    "" ;
                    
    
    public static final String tableHead= 
                    "<div class=\"ui-widget\">\n"+
                    "<label for=\"tags\">Filter by domain: </label>\n"+
                    "<input class=\"form-control\" id=\"tags\">  <button id=\"remButt\" class=\"label label-default\" onclick=\"showRows();\" style=\"font-size: 75%; font-weight: bold; line-height: 1; display: none;\"><span class=\"submit glyphicon glyphicon-remove\"></span>  Remove filter</button>\n"+
                    "</div>\n"+
                    "<table id=\"tablesorter-demo\" class=\"tablesorter table table-hover\">\n"+
                    "<thead>\n"+
                    "<tr>\n"+
                    "<th>Ontology</th>\n"+
                    "<th>Serializations</th>\n"+
                    "<th>License</th>\n"+
                    "<th>Language</th>\n"+
                    "<th>Domain</th>\n"+
                    "<th>Description</th>\n"+
                    "</tr>\n"+
                    "</thead>\n"+
                    "<tbody>\n";
    
    public static final String tableEnd = "</tbody></table>\n";

    public static String getScriptForFilteringAndEndDocument(ArrayList<String> domains){
        String s = "<script>\n"+
		"$(function() {\n"+
		"var availableTags = [\n";
                if(!domains.isEmpty()){
                    s+="\""+domains.get(0)+"\"\n";
                    for (int i=1; i<domains.size();i++ ){
			s+=", \""+domains.get(i)+"\"";
                    }
                }
		s+="];\n"+"$( \"#tags\" ).autocomplete({\n"+
		"source: availableTags,\n"+
		"select: function(event, ui) {\n"+		
		"hideRows(ui.item.value);\n"+
		"}\n"+
		"});\n"+
		"});\n"+
		"</script>\n"+
		"<script>\n"+
		"function hideRows(text) {\n"+
		"index = 1;\n"+
		"tr = document.getElementById('tr'+index);\n"+
		"while (tr!=null){\n"+
		"valores = document.getElementById('inp'+index).value;\n"+
		"if (!valores.contains(text+'--')){\n"+
		"tr.style.display='none';\n"+
		"}\n"+
		"index++;\n"+
		"tr = document.getElementById('tr'+index);\n"+
		"}\n"+
		"document.getElementById('remButt').style.display='';\n"+
		"}\n"+
		"\n"+
		"function showRows() {	\n"+
		"index = 1;\n"+
		"tr = document.getElementById('tr'+index);\n"+
		"while (tr!=null){\n"+
		"tr.style.display='';\n"+		
		"index++;\n"+
		"tr = document.getElementById('tr'+index);\n"+
		"}\n"+
		"butt = document.getElementById('remButt').style.display='none';\n"+
		"}\n"+
		"</script>"+
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
        return s;
    }	
		
		
}
