
## Exo RPG

### Créer un Enum "Race"

- name : string

* Races à créer :
    * Orc
    * Dwarf
    * Undead
    * NightElf


### Créer la classe "RpgEntity"

- hp : int
- hpMax : int 
- mana : int
- manaMax : int
- level : int

(PS : les float sont sur 2 chiffres après la virgule max)
- scoreCriticalStrike : float
- criticalDamage : float
- defense : float
- damageMin : float
- damageMax : float
     

### Ajout des Ability

* Il va falloir créer une classe Ability
  * damage : float (pas de gestion de min/max)
  * name : string
  * manaCost : int

* Une RpgEntity peut avoir une Ability (ou ne pas en avoir)


### Créer la classe "Hero"

- name : string
- race : Race
- strength : int
- agility : int
- intelligence : int

* Un Hero est un "RpgEntity"
* Par défaut :
    * tous les héros créés sont de niveau 1
    * scoreCriticalStrike : 11
    * criticalDamage : 150%

* Notes importante :
  * 1 strength => 19 hp
  * 1 intelligence => 17 mana
  * defense = agility / 6
  * Les dégâts d'un héro sont basés depuis sa caractéristique principale
    * damageMin = carac * 1.2
    * damageMiax = carac * 1.4
  * Le scoreCriticalStrike varie en fonction de la caractéristique principale : carac * 0.06


### Créer la classe "Monsters"

- Un "Monsters" est un "RpgEntity"


### Héro : Mage

* Un Mage est un Hero
* On doit pouvoir renseigner le nom du Mage à sa création
* On doit pouvoir renseigner la Race du Mage à sa création
* Un Mage est un héro Intelligence (caractéristique principale)
* Un Mage commence toujours avec ces caractéristiques :
  * 13 strength
  * 8 agility
  * 36 intelligence

### Héro : Warrior

* Un Warrior est un Hero
* On doit pouvoir renseigner le nom du Warrior à sa création
* On doit pouvoir renseigner la Race du Warrior à sa création
* Un Warrior est un héro Strength (caractéristique principale)
* Un Warrior commence toujours avec ces caractéristiques :
  * 26 strength
  * 12 agility
  * 14 intelligence

### Héro : Rogue

* Un Rogue est un Hero
* On doit pouvoir renseigner le nom du Rogue à sa création
* On doit pouvoir renseigner la Race du Rogue à sa création
* Un Rogue est un héro Agility (caractéristique principale)
* Un rogue a sa caractéristique criticalDamage de 175% au lieu de 150%
* Un Rogue commence toujours avec ces caractéristiques :
  * 12 strength
  * 30 agility
  * 11 intelligence


### Pour poursuivre

* Ajouter une fonction levelUp, elle permet de faire une montée de niveau, on augmente le niveau de 1
* Seul les Hero peuvent levelUp

#### Cependant...

* Un Mage qui levelUp gagne :
  * +2 Strength
  * +1 Agility
  * +6 Intelligence


* Un Warrior qui levelUp gagne :
  * +6 Strength
  * +2 Agility
  * +1 Intelligence


* Un Rogue qui levelUp gagne :
  * +2 Strength
  * +6 Agility
  * +1 Intelligence
  

/!\ Pensez que vos caractéristiques vont changer... Les dégâts aussi !

(PS : Lorsqu'un Hero monte de niveau, il ne regagne pas sa vie, et sa mana)


#### Pour la suite du TP - fonction setLevel (dans RpgEntity)

* L'idée est de faire une fonction setLevel, qui prenne en paramètre un entier, qui représentera le niveau à donner à notre héro
* Il faut gérer la modification des caractéristiques en fonction de son niveau


#### Créer les monstres


Les monstres ont leur stats qui varient en fonction de leur niveau

* Gobelin :
    * hp : 38 + 50 par level
    * mana : 38 + 50 par level
    * defense : 0.33 par level
    * damageMin : 3.32 par level
    * damageMax : 3.38 par level
    * scoreCriticalStrike : 1 + 0.25 par level

* Ogre :
    * hp : 70 + 83 par level
    * mana : 38 + 50 par level
    * defense : 2 + 0.48 par level
    * damageMin : 6.65
    * damageMax : 6.70
    * scoreCriticalStrike : 1 + 0.39 par level

* Dragon :
    * hp : 100 + 133 par level
    * mana : 50 + 70 par level
    * defense : 4 + 0.66 par level
    * damageMin : 8.89 par level
    * damageMax : 9 par level
    * scoreCriticalStrike : 1 + 0.50 par level
    * criticalDamage : 170%


#### Pour la suite du TP

* Faire une fonction qui fait qu'une RpgEntity attaque une autre RpgEntity
  * Un RpgEntity a une attaque qui varie entre ses damageMin et damageMax
  * Toutefois... Un RpgEntity peut effectuer des coups critiques ! C'est à dire que chaque RpgEntity a une chance d'effectuer un coup critique égale à **scoreCriticalStrike**) et ses dégâts seront multiplié par **criticalDamage**   
  * Un RpgEntity réduit les dégâts qu'il subit grâce a sa défense, qui n'est autre qu'un pourcentage (c'est à dire, qu'un mage level 2, a 1.5 de défense, il réduit les dégâts subit de 1.5%)
  * Une fois les dégâts réduit par la défense, le RpgEntity qui se fait attaquer peut perdre ses points de vie


#### Ability

* Il faudra prévoir de faire une fonction : useAbility(RpgEntity) (=> même fonctionnement que l'attaque). Sauf :

    * Une RpgEntity peut utiliser son Ability tous les 3 tours

    * Lorsqu'il le fait, il doit dépenser son mana (on retire le coût en mana de l'ability depuis le mana de la RpgEntity)

    * Si le héro n'a pas le mana nécessaire, il ne peut pas utiliser son Ability

    * Une Ability ne critique pas

    * Une Ability ne peut pas être réduite par la défense

    * Lorsqu'une RpgEntity utilise son Ability, on réduit directement les points de vie de la cible (si la RpgEntity a le mana nécessaire, bien sûr...)

(Ils auront toujours cette même capacité)
(Il faudra peut-être les créer à un endroit précis...)

* Mage : 
  * name : Fireball
  * coût : 110 mana
  * damage : caractéristique principale x 2 (Rappel : c'est l'intelligence)

* Warrior :
  * name : Skullsplitter
  * coût : 150 mana
  * damage : caractéristique principale x 1.8 (Rappel : c'est la force)

* Rogue :
  * name : Ambush
  * coût : 160 mana
  * damage : caractéristique principale x 2.1 (Rappel : c'est l'agilité)

* Dragon :
  * name : Fire Breathe
  * coût : 160 mana
  * damage : 48 + 10 * level


### Organisation des fichiers

Un package principal : 
    * rpg


Il contiendra Ability et RpgEntity
    
    
Deux packages dans "rpg" :
    * heros
    * monsters
    
    
    
### Suite...

* Créer un Spinner (de type dropdown) pour sélectionner les différentes classes disponibles dans le jeu
* Dans le onClick du SecondFragment, créer le hero adéquat en fonction du choix de l'utilisateur


### Améliorer HeroBattleFragment

* Lorsque l'on arrive sur HeroBattleFragment, on doit toujours voir les stats de notre hero (notre héro sera bien niveau 1)
* On doit pouvoir sélectionner un adversaire : pour se faire, on choisira dans un spinner (dropdown) quel Monstre on veut tuer,
   puis son level, par défaut, il sera de 1 
* Une fois le "formulaire" rempli, il se validera par un bouton "Battle" qui exécutera une fonction de combat, dans lequel : 
    - le 1er combattant à taper sera déterminé aléatoirement
    - Les 2 protagonistes continuent le combat tant qu'il n'y en a pas un de mort
    
* L'idée est :
 - Une fois le combat fini :
   * (Peut-être vous devrez modifier nos classes métiers)
   * Lorsque le Hero tue un Gobelin, il gagne 1 lvl
   * Lorsque le Hero tue un Ogre, il gagne 2 lvl
   * Lorsque le Hero tue un Dragon, il gagne 5 lvl
   * Il doit être possible de relancer autant de combats que l'on veut, tant que le Hero n'est pas mort
   * Entre chaque combat, il revient à son maximum d'HP
   * (Car on suppose que par la suite, il pourrait attaquer plusieurs monstres en même temps...)
    
    