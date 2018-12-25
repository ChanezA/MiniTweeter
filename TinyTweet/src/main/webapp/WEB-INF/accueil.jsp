<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>accueil</title>
    </head>
    <body>
        <p>Ceci est une page générée depuis une JSP.</p>
       <h1>Vous avez aimé mon site ? Dites-le dans le Datastore !</h1>
        <%
            Integer jourDuMois = (Integer) request.getAttribute( "jour" );
               out.println("Jour pair : " + jourDuMois);
            %>
          
            <form method="post" action="hello">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        <h1>Ils ont aimé :</h1>
    </body>
</html>