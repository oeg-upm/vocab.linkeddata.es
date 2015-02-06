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
	
	public static final int shortDescLenght = 100;
    
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
			"    <script type=\"text/javascript\" src=\"dist/js/bootstrap.js\"></script>\n" +
			"    <link rel=\"stylesheet\" href=\"dist/css/jquery-ui.css\"></link>\n" +
			"    <script type=\"text/javascript\" id=\"js\">\n" +
			"	    $(document).ready(function() \n" +
			"		    { \n" +
			"		    	$(\"#tablesorter-demo\").tablesorter(); \n" +
			"		    	$(\"#tablesorter-demo\").stickyTableHeaders(); \n" +
			"		    	$('[data-toggle=\"tooltip\"]').tooltip(); \n" +

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
		    "        <li class=\"active\"><a href=\"#\">Vocabularies</a></li>\n" + 
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
                    "    	<div class=\"col-md-10\">\n" +
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
                    "    	<div class=\"col-md-2\">\n" +
                    "    		<a href=\"http://www.oeg-upm.net/\" target=\"_blank\"><img src=\"dist/logo.gif\" alt=\"OEG logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>\n" +
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
                    "<table id=\"tablesorter-demo\" class=\"tablesorter table table-hover table-responsive\">\n"+
                    "<thead>\n"+
                    "<tr>\n"+
                    "<th class=\"col-md-2\">Ontology</th>\n"+
                    "<th class=\"col-md-2\">Serialization</th>\n"+
                    "<th class=\"col-md-1\">License</th>\n"+
                    "<th class=\"col-md-1\">Language</th>\n"+
                    "<th class=\"col-md-2\">Domain</th>\n"+
                    "<th class=\"col-md-4\">Description</th>\n"+
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
    public static String getEvaluationText(String evaluationContent, Vocabulary v){
        String eval = "<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "  <head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <title>"+v.getTitle()+"</title>\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    <meta name=\"description\" content=\"Evaluation of the ontology with the OOPS tool.\">\n" +
        "    <meta name=\"Languaje\" content=\"English\">\n" +
        "    <meta name=\"Keywords\" content=\"ontology, smart city, energy efficiency\">\n" +
        "    \n" +
        "    <script src=\"oops/js/jquery-1.11.0.js\"></script>\n" +
        "    <script src=\"oops/js/bootstrap.min.js\"></script>\n" +
        "    <link rel=\"stylesheet\" href=\"oops/css/style.css\" type=\"text/css\" media=\"print, projection, screen\" />\n" +
        "    <script type=\"text/javascript\" src=\"oops/js/jquery.tablesorter.min.js\"></script>\n" +
        "    <script type=\"text/javascript\" id=\"js\">\n" +
        "	    $(document).ready(function() \n" +
        "		    { \n" +
        "		    	$(\"#tablesorter-demo\").tablesorter(); \n" +
        "		    	$('.collapse').collapse({ \n" +
        "		    	toggle: false\n" +
        "		    	});\n" +
        "		    } \n" +
        "	    ); \n" +
        "    </script>\n" +
        "\n" +
        "    <link href=\"oops/css/bootstrap.css\" rel=\"stylesheet\">\n" +
        "    <style type=\"text/css\">\n" +
        "      body {\n" +
        "        padding-top: 60px;\n" +
        "        padding-bottom: 40px;\n" +
        "      }\n" +
        "    </style>\n" +
        "    <link href=\"oops/css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" +
        "    \n" +
        "    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n" +
        "    <!--[if lt IE 9]>\n" +
        "      <script src=\"/dist/js/html5shiv.js\"></script>\n" +
        "    <![endif]-->\n" +
        "\n" +
        //"    <!-- Fav and touch icons -->\n" +
        //"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"../dist/ico/apple-touch-icon-144-precomposed.png\">\n" +
        //"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"../dist/ico/apple-touch-icon-114-precomposed.png\">\n" +
        //"    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"../dist/ico/apple-touch-icon-72pcomposed.png\">\n" +
        //"    <link rel=\"apple-touch-icon-precomposed\" href=\"dist/ico/apple-touch-icon-57-precomposed.png\">\n" +
        //"    <link rel=\"shortcut icon\" href=\"../dist/ico/favicon.png\">\n" +
        "  </head>\n"
        + "<div class=\"container\">\n" +
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
               "        <li><a href=\"../test.html\">Vocabularies</a></li>\n" + //cambiar por index o solo ./ si en el servidor hay redireccion al index
               "        <li><a href=\"http://rohub.linkeddata.es\">Research Objects</a></li>\n" + 
               "        <li><a href=\"./about.html\">About</a></li>\n" + 
               "      </ul>\n" + 
               "    </div><!--/.nav-collapse -->\n" + 
               "  </div>\n" + 
              " </div>\n" +
            "<h1> <a href=\""+v.getUri()+"\" target=\"_blank\">"+v.getTitle()+"</a></h1>\n" +
            "<br>\n" +
            "<dl class=\"dl-horizontal\">\n" +
            "<dt>Title</dt>\n" +
            "<dd><a href=\""+v.getUri()+"\" target=\"_blank\">"+v.getTitle()+"</a></dd>\n" +
            "<dt>URI</dt>\n" +
            "<dd><a href=\""+v.getUri()+"\" target=\"_blank\">"+v.getUri()+"</a></dd>\n" +
            "<dt>Description</dt>\n" +
            "<dd>"+v.getDescription()+"</dd>\n";
            //OPTIONAL METADATA
            if(v.getLicense()!=null){    
                eval+="<dt>License</dt>\n" +
                "<dd><a href=\""+v.getLicense()+"\" target=\"_blank\">"+v.getLicense()+"</a></dd>\n";
            }
            if(v.getCreationDate()!=null){
                eval+="<dt>Creation Date</dt>\n" +
                "<dd>"+v.getCreationDate()+"</dd>\n";
            }
            if(v.getLastModifiedDate()!=null){
                eval+="<dt>Last modified</dt>\n" +
                "<dd>"+v.getLastModifiedDate()+"</dd>\n";
            }
            if(v.getLovURI()!=null){
                eval+="<dt><a href=\"http://lov.okfn.org/dataset/lov\">LOV</a> page</dt>\n"
                        + "<dd><a href=\""+v.getLovURI()+"\">"+v.getLovURI()+"</a></dd>";
            }  
            eval+="</dl>"+
            "<p> The following evaluation results have been generated by the <a href = \"http://oops-ws.oeg-upm.net/\" target=\"_blank\">RESTFul web service</a> provided by <a href = \"http://www.oeg-upm.net/oops\" target=\"_blank\">OOPS! (OntOlogy Pitfall Scanner!)</a>.</p>" +
            "<p>\n" +
            "<a href=\"http://www.oeg-upm.net/oops\" target=\"_blank\"><img src=\"oops/logomini.png\" alt=\"OOPS! logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>"+
            "It is obvious that not all the pitfalls are equally important; their impact in the ontology " +
            "will depend on multiple factors. For this reason, each pitfall has an importance level " +
            "attached indicating how important it is. We have identified three levels:" +
            "</p>\n" +
            "\n" +
            "<dl class=\"dl-horizontal\">\n" +
            "<dt><span class=\"label label-danger\">Critical</span></dt>\n" +
            "<dd>It is crucial to correct the pitfall. Otherwise, it could affect the ontology consistency, reasoning, applicability, etc.</dd>\n" +
            "\n" +
            "<dt><span class=\"label label-warning\">Important</span></dt> <dd> Though not critical for ontology function, it is important to correct this type of pitfall.</dd>\n" +
            "\n" +
            "<dt><span class=\"label label-minor\">Minor</span></dt> <dd>It is not really a problem, but by correcting it we will make the ontology nicer.</dd>\n" +
            "</dl>"+
             evaluationContent+
            //references
            "<p>References:</p>\n"+
            "    <ul>\n"+
            "    <li>\n"+
            "    [1] Gómez-Pérez, A. Ontology Evaluation. Handbook on Ontologies. S. Staab and R. Studer Editors. Springer. International Handbooks on Information Systems. Pp: 251-274. 2004.\n"+
            "    </li> \n"+
            "    <li>\n"+
            "    [2] Noy, N.F., McGuinness. D. L. Ontology development 101: A guide to creating your first ontology. Technical Report SMI-2001-0880, Standford Medical Informatics. 2001.\n"+
            "    </li> \n"+
            "    <li>\n"+
            "    [3] Rector, A., Drummond, N., Horridge, M., Rogers, J., Knublauch, H., Stevens, R.,; Wang, H., Wroe, C. ''Owl pizzas: Practical experience of teaching owl-dl: Common errors and common patterns''. In Proc. of EKAW 2004, pp: 63–81. Springer. 2004.\n"+
            "    </li>\n"+
            "    <li>\n"+
            "    [4] Hogan, A., Harth, A., Passant, A., Decker, S., Polleres, A. Weaving the Pedantic Web. Linked Data on the Web Workshop LDOW2010 at WWW2010 (2010).\n"+
            "    </li>\n"+
            "     <li>\n"+
            "    [5] Archer, P., Goedertier, S., and Loutas, N. D7.1.3 – Study on persistent URIs, with identification of best practices and recommendations on the topic for the MSs and the EC. Deliverable. December 17, 2012.\n"+
            "    </li>\n"+
            "    <li>\n"+
            "    [6] Heath, T., Bizer, C.: Linked data: Evolving the Web into a global data space (1st edition). Morgan &amp; Claypool (2011).\n"+
            "    </li>\n"+
            "    </ul>\n"+    
            
            //copy footer here
            
            "     <hr>" +
            "      <footer>\n" +
            "      <div class=\"row\">\n" +
            "    	<div class=\"col-md-10\">\n" +
            "    		Evaluation results provided by <a href = \"http://purl.org/net/mpoveda\" target=\"_blank\">Mar&iacutea Poveda</a> and integrated with vocab by <a href=\"http://purl.org/net/dgarijo\">Daniel Garijo</a>\n" +
            "	        <br>\n" +
            "    	Built with <a target=\"_blank\" href=\"http://getbootstrap.com/\">Bootstrap</a>\n" +
//            "	        <br>\n" +
//            "           Integration with vocab by <a href=\"http://purl.org/net/dgarijo\">Daniel Garijo</a>"+
			"	        <br>\n" +
			"	        Latest revision "+(new SimpleDateFormat("MMMM", Locale.UK).format(new Date(Calendar.getInstance().getTimeInMillis())))+", "+new GregorianCalendar().get(Calendar.YEAR)+"\n" +
			"           <br><p>&copy; Ontology Engineering Group</p>\n"+              
            "        </div>\n" +
            "    	<div class=\"col-md-2\">\n" +
            "    		<a href=\"http://www.oeg-upm.net/\" target=\"_blank\"><img src=\"../dist/logo.gif\" alt=\"OEG logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>\n" +
            "    	</div>\n" +
//            "    	<div class=\"col-md-2\">\n" +
//            "		<p class=\"text-right\"> Developed with: </p>\n" +
//            "		<p class=\"text-right\">\n" +
//            "     		<a href=\"http://www.oeg-upm.net/oops/\" target=\"_blank\"><img src=\"oops/logomini.png\" alt=\"OOPS! logo\" class=\"img-rounded\" class=\"img-responsive\" /></a>\n" +
//            "    	</p>\n" +
//            "    	</div>\n" +
            "      </div>\n" +
            "      </footer>\n" +
            "    </div> <!-- /container -->\n";
        return eval;
    }
		
		
}
