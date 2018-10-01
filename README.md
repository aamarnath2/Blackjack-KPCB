# Blackjack-KPCB
Optional card game challenge for KPCB Fellows Engineering application

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Prerequisites
Create a clone of this repository on your local machine using the following terminal command:
```
git clone https://github.com/aamarnath2/Blackjack-KPCB.git
```

You will need the Java Development Kit in order to compile and run the files. You can download the JDK here
```
https://www.oracle.com/technetwork/java/javase/downloads/index.html
```
and you can find further instructions about downloading the JDK here
```
https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A
```

Apache Ant is used for building so you will need to have Ant installed in your environment. In case you do not have Ant installed in your environment already, you can find binary distributions here:
```
https://ant.apache.org/bindownload.cgi
```

## Compiling
After cloning, cd into the fetched repository
```
cd Blackjack-KPCB/
```

Initialize the directories using
```
ant init
```

In order to compile the .java files in src into .class files in bin use
'''
ant javac
'''


# Running the Game - Play Blackjack
cd into the bin directory 
```
cd bin/
```
Run 
```
java pckg.BlackJack
```

# Generating Documentation
You can generate javadoc documentation using the following command
```
ant javadoc
```

# Cleaning
Delete the build & doc directories using
```
ant clean
```

# Design Decisions
Due to the object oriented nature of desigining a card game, I chose between Java and C++ as the languages I wanted to use for this project. Ultimately, I ended up going with Java due to greater comfort. Additionally, since the game was relatively simple, I did not believe the benefits that C++ provides (namely increased memory flexibility and pointers) would be essential. Moreover, I am interested in potentially building an Android version of Blackjack in the future due to a recent urge to learn Android development, so using Java for this terminal based project would make things easier in the future.

I created three different Objects for this project: Card, Deck, and Player. Each deck is composed of cards and each player has some number of cards from a deck. I decided to make a Card and Deck class as these classes could be used in the future for other card based games.

The hardest part of this project would definitely be dealing with Aces accordingly. I was initially confused with how the rule on "soft aces" worked, so I had to be sure to clarify this prior to desigining. Even after clarification, running several test cases and having an avid blackjack player test the game (I pretended he was a customer and used his feedback accordingly) showed me that I still had incorrectly handled "soft aces." There were also many different edge cases to cover in regards to covering possible game ending scenarios. I tested these scenarios by initially identifying all possible game winning situations during the design stage.

# Built With
Ant - software tool for automating software build processes

# Authors 
Anjan Amarnath - [Github](https://github.com/aamarnath2/) [LinkedIn](https://www.linkedin.com/in/anjan-amarnath/)

# Acknowledgements
Jacob Friedman - Avid blackjack player who helped with testing



