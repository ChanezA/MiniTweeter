TINY TWEETER
Chanez Amri-Alan Baron-Louis Questel-Alexis Pineau

Organisation des classes 
Nous avons choisi d�organiser nos classes de la mani�re suivante .

Utilisateur
La classe Utilisateur est compos�es d�un identifiant unique qui est le pseudo; ainsi que les attributs nom et pr�nom.
Nous avons annot� la classe avec @Index pour que ses attributs soient index� et par @Cache pour utiliser le service de Memcache qu�offre aussi app Engine afin de garder des utilisateurs en m�moire vive un certain temps et de gagner en performance.
 
Tweeter
La classe Tweeter est compos�e  du owner, c�est-�-dire la personne qui a tweet�. ce qui nous permet de pouvoir r�cup�rer rapidement tous les tweets d�une m�me personne en requ�tant sur cet attribut. elle est aussi compos�e d�un Htag. Dans notre cas, nous avons consid�r� que nous pouvions avoir qu�un seul Htag par tweet. Et enfin le message en lui m�me ainsi nous pouvons r�cup�rer tous les tweet contenant un hashtag pr�cis.. 
Cette classe a elle aussi la possibilit� d'�tre mise dans le cache gr�ce � @Cache et ses attributs sont index�s. 


Follower
Repr�sente un tableau d�utilisateurs, suivis par un  user qui est repr�sent� avec son pseudo ainsi celle-ci contient deux attributs le tableau de user et un String en identifiant unique  pour le pseudo 

Follow
Ressemble � Follower mais cette fois elle repr�sente les gens qui suivent un user .

Htag  
Contient le terme du Htag et la personne qui l�a publi�. Avec �a on peut r�cup�rer tous les Htags post�s par une personne pr�cise. Il est bon de noter que cette classe n�a pas �t� utilis�e par manque de temps.

    
Fonctionnalit�es
Nous avons impl�ment� l�ajout d�un Utilisateur, en choisissant le nombre de gens qu�il va suivre, ceux-ci  �tant g�n�r� al�atoirement. Ainsi que la publication d�un tweet � tous les utilisateur qui le suivent 


Tests
Nous avons effectu� les tests suivants:
Temps moyens pour envoyer un tweet � 100 followers : 1.5 ms 



Temps pour lire 10, 50 et 100 tweets en ms :
	10 tweets : 118.5 ms
	50 tweets : 118.3 ms
	100 tweets: 117.1 ms


Nous remarquons une fluctuation n�gligeable dans l�affichage des diff�rents nombres des tweets ainsi nous constatons que cela scale pour l�affichage de n tweets. 

A cause des limites impos�es par le google datastore, nous ne pouvions tester pour 1000 et 5000 followers. Nous ne pouvons donc savoir si �a scale par rapport au nombre de followers, mais nous savons que cela scale pour le nombre de tweets � afficher.
