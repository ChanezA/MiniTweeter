<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Initialisation</title>
</head>
<body>
<p>Si j'existe en tant que user je suis rediriger vers la page ou j'ai le choic de faire la requete que je veux sinon vers un fomulaire d'inscripetion<p>
 <h1>Entrez votre pseudo</h1>
       
       <form method="post" action="initialisation">
            <fieldset>
                <legend>New Tweet</legend>
                <label for="pseudo">pseudo de l utilisateur</label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
                <br />
                <label for="name">prenom d utilisateur</label>
                <input type="text" id="name" name="name" value="" size="20" maxlength="20" />
                <br />
                <label for="firstname">nom d utilisateur</label>
                <input type="text" id="firstname" name="firstname" value="" size="20" maxlength="20" />
                <br />
                <input type="submit" value="se connecter" class="sansLabel" />
                <br />
            </fieldset>
        </form>
</body>
</html> 