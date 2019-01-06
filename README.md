# TINY TWEETER
Chanez Amri-Alan Baron-Louis Questel-Alexis Pineau

# Organisation des classes 
Nous avons choisi d’organiser nos classes de la manière suivante .

# Utilisateur
La classe Utilisateur est composées d’un identifiant unique qui est le pseudo; ainsi que les attributs nom et prénom.
Nous avons annoté la classe avec @Index pour que ses attributs soient indexé et par @Cache pour utiliser le service de Memcache qu’offre aussi app Engine afin de garder des utilisateurs en mémoire vive un certain temps et de gagner en performance.
 
# Tweeter
La classe Tweeter est composée  du owner, c’est-à-dire la personne qui a tweeté. ce qui nous permet de pouvoir récupérer rapidement tous les tweets d’une même personne en requêtant sur cet attribut. elle est aussi composée d’un Htag. Dans notre cas, nous avons considéré que nous pouvions avoir qu’un seul Htag par tweet. Et enfin le message en lui même ainsi nous pouvons récupérer tous les tweet contenant un hashtag précis.. 
Cette classe a elle aussi la possibilité d'être mise dans le cache grâce à @Cache et ses attributs sont indexés. 


# Follower
Représente un tableau d’utilisateurs, suivis par un  user qui est représenté avec son pseudo ainsi celle-ci contient deux attributs le tableau de user et un String en identifiant unique  pour le pseudo 

# Follow
Ressemble à Follower mais cette fois elle représente les gens qui suivent un user .

# Htag  
Contient le terme du Htag et la personne qui l’a publié. Avec ça on peut récupérer tous les Htags postés par une personne précise. Il est bon de noter que cette classe n’a pas été utilisée par manque de temps.

    
# Fonctionnalitées
Nous avons implémenté l’ajout d’un Utilisateur, en choisissant le nombre de gens qu’il va suivre, ceux-ci  étant généré aléatoirement. Ainsi que la publication d’un tweet à tous les utilisateur qui le suivent 


# Tests
Nous avons effectué les tests suivants:
Temps moyens pour envoyer un tweet à 100 followers : 1.5 ms 

<img src="https://user-images.githubusercontent.com/30860866/50741460-a25e5500-11fd-11e9-908a-e1db4b6e4275.png" width="45%"></img>

# Temps pour lire 10, 50 et 100 tweets en ms. 
10 tweets :118.5 ms

50 tweets : 118.3 ms

100 tweets: 117.1 ms


Nous remarquons une fluctuation négligeable dans l’affichage des différents nombres des tweets ainsi nous constatons que cela scale pour l’affichage de n tweets. 

A cause des limites imposées par le google datastore, nous ne pouvions tester pour 1000 et 5000 followers. Nous ne pouvons donc savoir si ça scale par rapport au nombre de followers, mais nous savons que cela scale pour le nombre de tweets à afficher.
